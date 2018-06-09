package com.neuedu.solar.core;

import java.awt.Color;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neuedu.solar.constant.Constant;

public class MyFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * set the Frame
	 */
	public void lauchFram() {
		setTitle("̫��ϵ�˴�����");
		setSize(Constant.Game_WIDTH,Constant.Game_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		//�رմ���
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
		new MyThread().start();
	}
	
	//��˫����ķ������ͼƬ��˸����
	Image backImg = null;
	
	//��дupdate()�������ڴ��ڵ�������һ�������ͼƬ
	@Override
	public void update(Graphics g) {
		if (backImg == null) {
			//�������ͼƬ�����ڣ�����һ���ʹ���һ����С��ͼƬ
			backImg = createImage(Constant.Game_WIDTH,Constant.Game_HEIGHT);
		}
		//��ȡ������ͼƬ�Ļ���
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.BLACK);
		backg.fillRect(0, 0, Constant.Game_WIDTH, Constant.Game_HEIGHT);
		backg.setColor(c);
		//��������ͼƬ��paint����������ÿ50msˢ��һ��
		paint(backg);
		g.drawImage(backImg, 0, 0, null);
	}
	
	/**
	 * ��ִͣ��paint�����������߳��ڲ���
	 */
	class MyThread extends Thread{
		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
