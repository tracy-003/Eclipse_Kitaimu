import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Screip {
	private String url;
	private Elements elements;
	
	public Screip(String url) {
		this.url = url;
	}

	public void setElements() throws IOException{
		// 時刻表サイトににGETリクエストを送る
		Document document = Jsoup.connect(this.url).get();
		// 時刻の詳細オブジェクトを取得する
		this.elements = document.getElementsByClass("time-detail");
		//System.out.println("ここでデータをセットします。");
	}
	
	public int getSize() {
		return this.elements.size();
	} 
	
	public String[] get_times(int i) {
	// 取得した要素から、順番に時刻を取得する
		Element element = this.elements.get(i);
		// 出発時刻
		Elements elements_time_dep = element.getElementsByClass("time dep");
		// 到着時刻
		Elements elements_time_arr = element.getElementsByClass("time arr");
		// 乗車時間
		// Elements elements_time_dif = element.getElementsByClass("diff-time");
		//　時刻の配列を作成
		String[] datas = {elements_time_dep.text(), elements_time_arr.text()};
		return datas;
	}
}