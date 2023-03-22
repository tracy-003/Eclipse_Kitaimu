import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class App implements Runnable {

	private String url = "https://www.navitime.co.jp/bus/diagram/timelist?departure=00551329&arrival=00551334&line=00085100";

	public static void main(String[] args) {
		App app = new App();
		Thread thread = new Thread(app);
		thread.start();
	}

	@Override
    public void run() {
		// スクリーンのセットアップ
		Screen screen = new Screen();
		// 時刻表のクリーンアップ
		Timer timer = new Timer();
		BusTimes busTimes = new BusTimes();
		busTimes.setAllDatas(this.url);
		busTimes.fastAct();
		screen.UpdateWaitTime(busTimes.getWaitList());
		// 繰り返し実行するテキスト
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				//System.out.println("test");
	            LocalTime time = LocalTime.now();
	            String hour = String.format("%02d", time.getHour());
	            String minute = String.format("%02d", time.getMinute());
	            String second = String.format("%02d", time.getSecond());
	            screen.UpdateNowTime(hour + ":" + minute + ":" + second);
	            //System.out.println(hour + ":" + minute + ":" + second);
	            if(second.equals("00")){
	            	// System.out.println(juageOver(time, busTimes.getLatest().get_dep()));
	            	if(juageOver(time, busTimes.getLatest().get_dep())) {
	            		busTimes.remove(0);
	            		busTimes.fastAct();
	            		screen.UpdateWaitTime(busTimes.getWaitList());
	            	}
	            } 
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			}
		}, 0, 1000);
    }

	public boolean juageOver(LocalTime nowTime, String targetTime) {
		LocalTime targetTime_LocalTime= LocalTime.parse(targetTime);
		if (targetTime_LocalTime.isBefore(nowTime)) {
			return true;
		}else {
			return false;
		}
	}
}
