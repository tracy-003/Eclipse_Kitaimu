import java.time.LocalTime;

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
		BusTimes busTimes = new BusTimes();
		busTimes.setAllDatas(this.url);
		busTimes.fastAct();
		screen.UpdateWaitTime(busTimes.getWaitList());
		// 繰り返し実行するテキスト
        while (true) {
        	//System.out.println("test");
            LocalTime time = LocalTime.now();
            String hour = String.format("%02d", time.getHour());
            String minute = String.format("%02d", time.getMinute());
            String second = String.format("%02d", time.getSecond());
            screen.UpdateNowTime(hour + ":" + minute + ":" + second);
            if(second == ""){
            	if(juageOver(time, busTimes.getLatest().get_dep())) {
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
