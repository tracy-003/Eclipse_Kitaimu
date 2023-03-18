import java.time.LocalTime;

public class App implements Runnable {
	
	public static void main(String[] args) {
		App app = new App();
        Thread thread = new Thread(app);
        thread.start();
    }
	
	@Override
    public void run() {
		// �X�N���[���̃Z�b�g�A�b�v
		Screen screen = new Screen();
		// �����\�̃N���[���A�b�v
		BusTimes busTimes = new BusTimes();
		busTimes.fastAct();
		// �J��Ԃ����s����e�L�X�g
        while (true) {
        	//System.out.println("test");
            LocalTime time = LocalTime.now();
            String hour = String.format("%02d", time.getHour());
            String minute = String.format("%02d", time.getMinute());
            String second = String.format("%02d", time.getSecond());
            screen.UpdateNowTime(hour + ":" + minute + ":" + second);
            screen.UpdateWaitTime(busTimes.getWaitList());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
