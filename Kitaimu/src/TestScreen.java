import javax.swing.*;

public class TestScreen extends JFrame {
    public TestScreen() {
        // JFrameの設定
        setTitle("Multiple Labels Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ラベルの作成と追加
        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JLabel label3 = new JLabel("Label 3");
        add(label1);
        add(label2);
        add(label3);

        // レイアウトマネージャーの設定
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public static void main(String[] args) {
    	TestScreen labels = new TestScreen();
        labels.setVisible(true);
    }
}

