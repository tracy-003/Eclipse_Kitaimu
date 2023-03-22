import javax.swing.*;

public class TestScreen extends JFrame {
    public TestScreen() {
        // JFrame�̐ݒ�
        setTitle("Multiple Labels Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ���x���̍쐬�ƒǉ�
        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JLabel label3 = new JLabel("Label 3");
        add(label1);
        add(label2);
        add(label3);

        // ���C�A�E�g�}�l�[�W���[�̐ݒ�
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public static void main(String[] args) {
    	TestScreen labels = new TestScreen();
        labels.setVisible(true);
    }
}

