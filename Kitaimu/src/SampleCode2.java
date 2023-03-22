import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SampleCode2 {
	public static void main(String[] args) throws IOException {

		// 当ブログのトップページにGETリクエストを送る
		// Document document = Jsoup.connect("https://uha-blog.com/").get();
		Document document = Jsoup.parse(new File("src/times.html"), "UTF-8");

		// トップページのh2要素を取得する
		// Elements elements = document.select("h2");

		// System.out.println(elements.size());

		Elements elements = document.getElementsByClass("time-detail");
		// System.out.println(elements.outerHtml());

		// Elements elements = document.select("#hoge ul .error");
		// for (Element element : elements) {
		// System.out.println(element.outerHtml());
		// }
		//
		// 取得した要素を順番に取得する
		for (Element element : elements) {
			// System.out.println("====表示====");
			// 取得した要素から必要な者を取り出す
			// 出発時刻
			Elements elements_time_dep = element.getElementsByClass("time dep");
			// 到着時刻
			Elements elements_time_arr = element.getElementsByClass("time arr");
			// 乗車時間
			//Elements elements_time_dif = element.getElementsByClass("diff-time");

			// 取得した要素を出力する
			System.out.println(elements_time_dep.text());
			System.out.println(elements_time_arr.text());
			//System.out.println(elements_time_dif.text());
		}
	}
}