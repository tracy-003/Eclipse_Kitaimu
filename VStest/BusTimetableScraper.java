import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// public class BusTimetableScraper  {
//     public static void main(String[] args) {
//         String departureCode = "00551329"; // �o���n�̃R�[�h
//         String arrivalCode = "00551334"; // �����n�̃R�[�h
//         String lineCode = "00085100"; // �H���̃R�[�h

//         // URL���쐬����
//         String url = String.format("https://www.navitime.co.jp/bus/diagram/timelist?departure=%s&arrival=%s&line=%s",
//                                    departureCode, arrivalCode, lineCode);

//         // Web�y�[�W��������擾����
//         try {
//             Document doc = Jsoup.connect(url).get();
//             Element table = doc.select("table.tblDg").first(); // �o�X�̎����\���܂܂��e�[�u�����擾����
//             Elements rows = table.select("tr"); // �e�[�u���̍s���擾����
//             for (int i = 1; i < rows.size(); i++) { // �w�b�_�[�s�������āA�e�s����������
//                 Element row = rows.get(i);
//                 Elements cols = row.select("td");
//                 String time = cols.get(0).text(); // �������擾����
//                 System.out.println(time); // �R���\�[���ɏo�͂���
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         System.out.println("�I��");
//     }
// }