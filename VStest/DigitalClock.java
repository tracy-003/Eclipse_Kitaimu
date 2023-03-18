import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalTime;

import java.awt.Graphics;

// ?w?i?????
// ??????

public class DigitalClock implements Runnable {

    private JLabel timeLabel;

    public DigitalClock() {
        // �������ɂ��� >> http://urushiba.blog.jp/archives/1194113.html
        JFrame frame = new JFrame();

        // JFrame frame = new JFrame() {
        //     protected void paintComponent(Graphics g) {
        //         // super.paintComponent(g);
        //         g.setColor(new Color(100, 50, 50, 100));
        //         g.fillRect(0, 0, getWidth(), getHeight());
        //     }
        // };
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,255,100));
        //frame.setUndecorated(false);
        //frame.setSize(400, 300);
        //frame.setVisible(true);

        frame.setTitle("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(false);
        //frame.setBackground(new Color(0,0,0,0));
        // ���ꂾ�Ƃ��񂾂�Â��Ȃ��Ă���
        // frame.getContentPane().setBackground(new Color(0, 0, 0, 122));;

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("MS�S�V�b�N", Font.PLAIN, 30));
        //timeLabel.setForeground(Color.BLACK);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.TOP);
        frame.getContentPane().add(timeLabel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true); // ��ʂ͏�ɍőO�ʂɂ����Ԃɂ���
        frame.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            LocalTime time = LocalTime.now();
            String hour = String.format("%02d", time.getHour());
            String minute = String.format("%02d", time.getMinute());
            String second = String.format("%02d", time.getSecond());
            timeLabel.setText("���݂̎����@" + hour + ":" + minute + ":" + second);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DigitalClock clock = new DigitalClock();
        Thread thread = new Thread(clock);
        thread.start();
    }
}