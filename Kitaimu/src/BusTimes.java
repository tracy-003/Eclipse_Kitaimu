import java.util.ArrayList;
import java.time.LocalTime;

import java.util.Arrays;

public class BusTimes {
	private ArrayList<BusTime> timeArrayList;
	public BusTimes() {
		this.timeArrayList = new ArrayList<BusTime>();
	}
	public void add(BusTime object) {
		this.timeArrayList.add(object);
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
	
	// 最初に行う操作。現在時刻と一致させる
	public void fastAct() {
		 // 現在時刻を取得
        LocalTime currentTime = LocalTime.now();
        // 目標時間と比較
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
	        	//System.out.println("時刻は、" + textBusTime + "です。");
	        	// 最初のはまだ時間がたってないので、元に戻す。
	        	this.timeArrayList.add(0, target);
	        	break;
	        }
			
		}
	}
	
	// 3個分を表示
	public String[] getWaitList() {
		String[] data = {"", "", ""};
		int cnt = 0;
		while (cnt < 3) {
			// もしなくなったら
			if (cnt >= this.size()) {
				data[cnt] = "もうバスがありません";
			}else {
				BusTime busTime = this.timeArrayList.get(cnt);
				data[cnt] = busTime.get_dep();
			}
			cnt++;
		}
		return data;
	}
	
}
