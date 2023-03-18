import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SampleCode{
    public static void main(String[] args) throws IOException {

        // 当ブログのトップページにGETリクエストを送る
        Document doc = Jsoup.connect("https://uha-blog.com/").get();
		
        // トップページのh2要素を取得する
        Elements elements = doc.select("h2");
		
        // 取得した要素を順番に取得する
        for (Element element: elements) {
			
            // 取得した要素を出力する
            System.out.println(element.text());
        }
    }
}