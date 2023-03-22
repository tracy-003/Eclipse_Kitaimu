import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalTime;

public class BusTimes {
	private ArrayList<BusTime> timeArrayList;
	public BusTimes() {
		this.timeArrayList = new ArrayList<BusTime>();
	}
	public void add(BusTime object) {
		this.timeArrayList.add(object);
	}
	
	public BusTime getLatest() {
		BusTime busTime = this.timeArrayList.get(0);
		return busTime;
	}
	
	public BusTime remove(int index) {
		BusTime busTime = this.timeArrayList.remove(index);
		return busTime;
	}
	public int size() {
		return this.timeArrayList.size();
	}
	
	public BusTime get(int i) {
		return this.timeArrayList.get(i);
	}
	
	public void setAllDatas(String url) {
		Screip screip = new Screip(url);
		try {
			screip.setElements();
			//System.out.println("���̌��̃f�[�^���Z�b�g���܂�" + size());
			for(int i = 0; i < screip.getSize(); i++) {
				String[] txts = screip.get_times(i);
				this.add(new BusTime(txts[0], txts[1]));
			}
		}catch(IOException e) {
		    // ��O�����������Ƃ��̏���������
		    e.printStackTrace();
		}
	}
	
	// �ŏ��ɍs������B���ݎ����ƈ�v������
	public void fastAct() {
		 // ���ݎ������擾
        LocalTime currentTime = LocalTime.now();
        // �ڕW���ԂƔ�r
        int length = size();
		for(int i = 0; i < length ;i++) {
			//String textBusTime = get(i).get_dep();
			BusTime target = this.timeArrayList.remove(0);
			String textBusTime = target.get_dep();
			LocalTime targetTime = LocalTime.parse(textBusTime);
			if (targetTime.isBefore(currentTime)) {
	            // this.timeArrayList.remove(0);
				continue;
	        }else {
	        	//System.out.println("�����́A" + textBusTime + "�ł��B");
	        	// �ŏ��̂͂܂����Ԃ������ĂȂ��̂ŁA���ɖ߂��B
	        	this.timeArrayList.add(0, target);
	        	break;
	        }
			
		}
	}
	
	// 3����\��
	public String[] getWaitList() {
		String[] data = {"", "", ""};
		int cnt = 0;
		while (cnt < 3) {
			// �����Ȃ��Ȃ�����
			if (cnt >= this.size()) {
				data[cnt] = "�����o�X������܂���";
			}else {
				BusTime busTime = this.timeArrayList.get(cnt);
				data[cnt] = busTime.get_dep() + " �` " + busTime.get_arr();
			}
			cnt++;
		}
		return data;
	}
	
}
