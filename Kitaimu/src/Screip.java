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
		// �����\�T�C�g�ɂ�GET���N�G�X�g�𑗂�
		Document document = Jsoup.connect(this.url).get();
		// �����̏ڍ׃I�u�W�F�N�g���擾����
		this.elements = document.getElementsByClass("time-detail");
		//System.out.println("�����Ńf�[�^���Z�b�g���܂��B");
	}
	
	public int getSize() {
		return this.elements.size();
	} 
	
	public String[] get_times(int i) {
	// �擾�����v�f����A���ԂɎ������擾����
		Element element = this.elements.get(i);
		// �o������
		Elements elements_time_dep = element.getElementsByClass("time dep");
		// ��������
		Elements elements_time_arr = element.getElementsByClass("time arr");
		// ��Ԏ���
		// Elements elements_time_dif = element.getElementsByClass("diff-time");
		//�@�����̔z����쐬
		String[] datas = {elements_time_dep.text(), elements_time_arr.text()};
		return datas;
	}
}