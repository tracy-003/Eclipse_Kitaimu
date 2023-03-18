import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


// 時間に関する管理です。できること
// 現在の時刻を分けて、返却する

public class MainTime {
	public MainTime() {
	}
	
	public String[] returnTimes() {
		// 現在の時間を取得する
		LocalTime time = LocalTime.now();
		String data[] = new String[3];
		// フォーマットに変換
        String hour = String.format("%02d", time.getHour());
        String minute = String.format("%02d", time.getMinute());
        String second = String.format("%02d", time.getSecond());
        // 値を代入
        data[0] = hour;
        data[1] = minute;
        data[2] = second;
        return data;
	}
	
	public void getTimes() throws IOException {
		// urlの取得
		Document document = Jsoup.parse(new File("src/times.html"), "UTF-8");
		// バス時間セットの取得
		Elements elements = document.getElementsByClass("time-detail");
		// 取得した要素を順番に取得する
		for (Element element : elements) {
			// 取得した要素から必要な者を取り出す
			// 出発時刻
			Elements elements_time_dep = element.getElementsByClass("time dep");
			// 到着時刻
			Elements elements_time_arr = element.getElementsByClass("time arr");
			// 取得した要素を出力する
			// System.out.println(elements_time_dep.text());
			// System.out.println(elements_time_arr.text());
			// System.out.println(elements_time_dif.text());
			String txt_time_dep = elements_time_dep.text();
			String txt_time_arr = elements_time_arr.text();
			update_List(txt_time_dep, txt_time_arr);
		}
	}
	
	private void update_List(String dep, String arr) {
		
	}
}
