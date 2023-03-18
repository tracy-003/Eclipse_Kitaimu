import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// public class BusTimetableScraper  {
//     public static void main(String[] args) {
//         String departureCode = "00551329"; // 出発地のコード
//         String arrivalCode = "00551334"; // 到着地のコード
//         String lineCode = "00085100"; // 路線のコード

//         // URLを作成する
//         String url = String.format("https://www.navitime.co.jp/bus/diagram/timelist?departure=%s&arrival=%s&line=%s",
//                                    departureCode, arrivalCode, lineCode);

//         // Webページから情報を取得する
//         try {
//             Document doc = Jsoup.connect(url).get();
//             Element table = doc.select("table.tblDg").first(); // バスの時刻表が含まれるテーブルを取得する
//             Elements rows = table.select("tr"); // テーブルの行を取得する
//             for (int i = 1; i < rows.size(); i++) { // ヘッダー行を除いて、各行を処理する
//                 Element row = rows.get(i);
//                 Elements cols = row.select("td");
//                 String time = cols.get(0).text(); // 時刻を取得する
//                 System.out.println(time); // コンソールに出力する
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         System.out.println("終了");
//     }
// }