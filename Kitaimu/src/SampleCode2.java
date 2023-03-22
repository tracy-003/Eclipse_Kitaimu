import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SampleCode2 {
	public static void main(String[] args) throws IOException {

		// ���u���O�̃g�b�v�y�[�W��GET���N�G�X�g�𑗂�
		// Document document = Jsoup.connect("https://uha-blog.com/").get();
		Document document = Jsoup.parse(new File("src/times.html"), "UTF-8");

		// �g�b�v�y�[�W��h2�v�f���擾����
		// Elements elements = document.select("h2");

		// System.out.println(elements.size());

		Elements elements = document.getElementsByClass("time-detail");
		// System.out.println(elements.outerHtml());

		// Elements elements = document.select("#hoge ul .error");
		// for (Element element : elements) {
		// System.out.println(element.outerHtml());
		// }
		//
		// �擾�����v�f�����ԂɎ擾����
		for (Element element : elements) {
			// System.out.println("====�\��====");
			// �擾�����v�f����K�v�Ȏ҂����o��
			// �o������
			Elements elements_time_dep = element.getElementsByClass("time dep");
			// ��������
			Elements elements_time_arr = element.getElementsByClass("time arr");
			// ��Ԏ���
			//Elements elements_time_dif = element.getElementsByClass("diff-time");

			// �擾�����v�f���o�͂���
			System.out.println(elements_time_dep.text());
			System.out.println(elements_time_arr.text());
			//System.out.println(elements_time_dif.text());
		}
	}
}