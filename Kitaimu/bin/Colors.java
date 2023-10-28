import java.awt.Color;
import java.util.Queue;
import java.util.ArrayDeque;

// �F�̔z��F�L���[�Ƃ��Ď��������܂��B
public class Colors {
	private Queue<Color> colors = new ArrayDeque<Color>();
	
	// �R���X�g���N�^�ŏ�����
	public Colors() {
		this.colors.add(new Color(0, 255, 0, 100));
		this.colors.add(new Color(255, 0, 0, 100));
		this.colors.add(new Color(204, 255, 255, 100));
		this.colors.add(new Color( 255, 128, 128, 100));
		this.colors.add(new Color( 255, 255, 204, 100));
		this.colors.add(new Color(0, 0, 255, 100));
	}

	public Color getColor() {
		// �F�����o���āA�܂��߂�
		Color return_color = this.colors.poll();
		this.colors.add(return_color);
		return return_color;
	}

}
