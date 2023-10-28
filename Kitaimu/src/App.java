import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App implements Runnable {

	private String url = "https://www.navitime.co.jp/bus/diagram/timelist?departure=00551329&arrival=00551334&line=00085100";
	
	// �e�I�u�W�F�N�g�̏�����
	private Screen screen;
	private Timer timer;
	private BusTimes busTimes;

	public static void main(String[] args) {
		App app = new App();
		Thread thread = new Thread(app);
		thread.start();
	}

	@Override
    public void run() {
		//��ʂ�ݒ肷��
		try {
			this.screen = new Screen();
			// �����\�̃N���[���A�b�v
			this.timer = new Timer();
			this.busTimes = new BusTimes();
			this.busTimes.setAllDatas(this.url);
			this.busTimes.fastAct();
			screen.UpdateWaitTime(this.busTimes.getWaitList());
		}catch(Exception e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, e);
			// �������擾�ł��Ȃ������肵����A�A�v���̏I��
			System.exit(0);
		}

		// �J��Ԃ����s����e�L�X�g
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
	            	// System.out.println(juageOver(time, this.busTimes.getLatest().get_dep()));
	            	if(busTimes.size() != 0) {
	            		 if(juageOver(time, busTimes.getLatest().get_dep())) {
	            			 busTimes.remove(0);
	            			 busTimes.fastAct();
	            			 screen.UpdateWaitTime(busTimes.getWaitList());
	            		 }
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
