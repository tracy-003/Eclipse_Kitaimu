import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;


public class Screen implements MouseMotionListener{
	private JLabel timeLabel;
	private JLabel[] waitLabels = new JLabel[3];
	private JFrame frame;
	private int mouseX, mouseY;
	private Colors colors = new Colors();

	public Screen() {
		this.frame = new JFrame("Kitataimu");
		this.frame.setUndecorated(true);
		
		for(int i = 0; i < 3; i++) {
			waitLabels[i] = new JLabel();
			waitLabels[i].setHorizontalAlignment(JLabel.CENTER);
			waitLabels[i].setVerticalAlignment(JLabel.TOP);
		}
		
		// frame.setUndecorated(true);
		// 5��쐬����
		frame.setLayout(new GridLayout(5, 1));
		frame.setLocationRelativeTo(null); // �E�B���h�E����ʒ����ɕ\��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true); // �^�C�g���o�[���\���ɂ���
		frame.setBackground(this.colors.getColor()); // �w�i�F�𓧖��ɂ���
		
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		frame.addMouseMotionListener(this);
		frame.addKeyListener(new MyKeyboardListener());
		
		frame.setVisible(true);

		JLabel txt = new JLabel("���݂̎���");
		txt.setFont(new Font("MS�S�V�b�N", Font.PLAIN, 25));
		txt.setHorizontalAlignment(JLabel.CENTER);
		txt.setVerticalAlignment(JLabel.TOP);
		this.frame.getContentPane().add(txt);
		
		// ���݂̎���
		timeLabel = new JLabel("�N�����ł��B");
		timeLabel.setFont(new Font("MS�S�V�b�N", Font.PLAIN, 30));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setVerticalAlignment(JLabel.TOP);
		this.frame.getContentPane().add(timeLabel);

		// ���P
		for(int i = 0 ; i < 3; i++) {
			JLabel waitLabel = waitLabels[i];
			waitLabel.setFont(new Font("MS�S�V�b�N", Font.PLAIN, 20));
			//timeLabel1.setHorizontalAlignment(JLabel.CENTER);
			// timeLabel1.setVerticalAlignment(JLabel.BOTTOM);
			this.frame.getContentPane().add(waitLabel);
			waitLabel.setText("");
		}
		// ���C�A�E�g�}�l�[�W���[�̐ݒ�
		// this.frame.setLayout(new BoxLayout(this.frame.getContentPane(),
		// BoxLayout.Y_AXIS));
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setAlwaysOnTop(true); // ��ʂ͏�ɍőO�ʂɂ����Ԃɂ���
		this.frame.setVisible(true);
		frame.setSize(300, 200);
		
	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		frame.setLocation(x - mouseX, y - mouseY);
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void UpdateNowTime(String txt) {
		this.timeLabel.setText(txt);
	}

	// 3�̔z��
	public void UpdateWaitTime(String[] datas) {
		for(int i = 0; i < 3; i++) {
			JLabel label = waitLabels[i];
			String data = datas[i];
			label.setText(data);
		}
	}

	public void Change_Color() {
		frame.setBackground(this.colors.getColor());
	}

	public class MyKeyboardListener implements KeyListener{
		private boolean convertKeyPressed = false;
		@Override
		public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_CONVERT) {
	            convertKeyPressed = true;
	        } else if (convertKeyPressed && e.getKeyCode() == KeyEvent.VK_C) {
	        	// System.out.println("�ϊ� + C �������܂���");
	        	Change_Color();
	        } else if (convertKeyPressed && e.getKeyCode() == KeyEvent.VK_W) {
	        	// �V�X�e���̏I��
	        	System.exit(0);
	        }
	    }
		@Override
		public void keyReleased(KeyEvent e) {
			// �L�[��������Ȃ��Ȃ����Ƃ�
			//			System.out.print("keyReleased");
			//			System.out.println(e.getKeyCode());
			//			System.out.println(e.getExtendedKeyCode());
			if (e.getKeyCode() == KeyEvent.VK_CONVERT) {
	            convertKeyPressed = false;
	        }
		}
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
	}
}
