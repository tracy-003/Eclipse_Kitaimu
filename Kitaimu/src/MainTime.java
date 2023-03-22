import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


// ���ԂɊւ���Ǘ��ł��B�ł��邱��
// ���݂̎����𕪂��āA�ԋp����

public class MainTime {
	public MainTime() {
	}
	
	public String[] returnTimes() {
		// ���݂̎��Ԃ��擾����
		LocalTime time = LocalTime.now();
		String data[] = new String[3];
		// �t�H�[�}�b�g�ɕϊ�
        String hour = String.format("%02d", time.getHour());
        String minute = String.format("%02d", time.getMinute());
        String second = String.format("%02d", time.getSecond());
        // �l����
        data[0] = hour;
        data[1] = minute;
        data[2] = second;
        return data;
	}
	
	public void getTimes() throws IOException {
		// url�̎擾
		Document document = Jsoup.parse(new File("src/times.html"), "UTF-8");
		// �o�X���ԃZ�b�g�̎擾
		Elements elements = document.getElementsByClass("time-detail");
		// �擾�����v�f�����ԂɎ擾����
		for (Element element : elements) {
			// �擾�����v�f����K�v�Ȏ҂����o��
			// �o������
			Elements elements_time_dep = element.getElementsByClass("time dep");
			// ��������
			Elements elements_time_arr = element.getElementsByClass("time arr");
			// �擾�����v�f���o�͂���
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
