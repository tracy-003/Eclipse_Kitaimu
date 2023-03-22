import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SampleCode{
    public static void main(String[] args) throws IOException {

        // ���u���O�̃g�b�v�y�[�W��GET���N�G�X�g�𑗂�
        Document doc = Jsoup.connect("https://uha-blog.com/").get();
		
        // �g�b�v�y�[�W��h2�v�f���擾����
        Elements elements = doc.select("h2");
		
        // �擾�����v�f�����ԂɎ擾����
        for (Element element: elements) {
			
            // �擾�����v�f���o�͂���
            System.out.println(element.text());
        }
    }
}