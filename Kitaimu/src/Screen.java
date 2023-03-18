
//import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalTime;

public class Screen implements MouseMotionListener {
	private JLabel timeLabel;
	private JLabel[] waitLabels = new JLabel[3];
	private JFrame frame;
	private int mouseX, mouseY;

	public Screen() {
		//System.out.println("ここを通ります");
		this.frame = new JFrame("Kitataimu");
		this.frame.setUndecorated(true);
		
		for(int i = 0; i < 3; i++) {
			waitLabels[i] = new JLabel();
			waitLabels[i].setHorizontalAlignment(JLabel.CENTER);
			waitLabels[i].setVerticalAlignment(JLabel.TOP);
		}
		
		// frame.setUndecorated(true);
		// frame.setBackground(new Color(0,0,255,100));
		// 5列作成する
		frame.setLayout(new GridLayout(6, 1));
		frame.setLocationRelativeTo(null); // ウィンドウを画面中央に表示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true); // タイトルバーを非表示にする
		frame.setBackground(new Color(0, 255, 0, 100)); // 背景色を透明にする
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		frame.addMouseMotionListener(this);
		frame.setVisible(true);

		JLabel txt = new JLabel("現在の時刻");
		txt.setFont(new Font("MSゴシック", Font.PLAIN, 25));
		txt.setHorizontalAlignment(JLabel.CENTER);
		txt.setVerticalAlignment(JLabel.TOP);
		this.frame.getContentPane().add(txt);
		
		// 現在の時刻
		timeLabel = new JLabel("初期状態");
		timeLabel.setFont(new Font("MSゴシック", Font.PLAIN, 30));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setVerticalAlignment(JLabel.TOP);
		this.frame.getContentPane().add(timeLabel);

		// 候補１
		for(int i = 0 ; i < 3; i++) {
			JLabel waitLabel = waitLabels[i];
			waitLabel.setFont(new Font("MSゴシック", Font.PLAIN, 20));
			//timeLabel1.setHorizontalAlignment(JLabel.CENTER);
			// timeLabel1.setVerticalAlignment(JLabel.BOTTOM);
			this.frame.getContentPane().add(waitLabel);
			waitLabel.setText("候補です" + i);
		}
		// レイアウトマネージャーの設定
		// this.frame.setLayout(new BoxLayout(this.frame.getContentPane(),
		// BoxLayout.Y_AXIS));
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setAlwaysOnTop(true); // 画面は常に最前面にある状態にする
		this.frame.setVisible(true);
		frame.setSize(300, 250);
		
	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		frame.setLocation(x - mouseX, y - mouseY);
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void UpdateNowTime(String txt) {
		//System.out.println("更新後" + txt);
		this.timeLabel.setText(txt);
	}

	// 3つの配列
	public void UpdateWaitTime(String[] datas) {
		for(int i = 0; i < 3; i++) {
			JLabel label = waitLabels[i];
			String data = datas[i];
			label.setText(data);
		}
	}

	public void test() {

		frame.setBackground(new Color(0, 0, 255, 100));

	}
}
