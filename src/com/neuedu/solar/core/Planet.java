package com.neuedu.solar.core;

import java.awt.Color;

import java.awt.Graphics;

import com.neuedu.solar.util.Gameutil;

public class Planet extends Star {

	/**
	 * �볤��
	 */
	double longAxis;
	double shortAxis;
	double theta;
	/**
	 * ���е�����
	 */
	Star center;
	
	boolean satellite;
	
	public Planet(Star center,String imgPath,int day,double au,double e) {
		this.center = center;
		this.img = Gameutil.getImage(imgPath);
		this.longAxis = getLongAxis(au);
		this.shortAxis = getShortAxis(e)/4;
		this.x = (int) (center.x + longAxis - this.img.getWidth(null)/2);
		this.y = center.y - this.img.getHeight(null)/2;
		this.speed = getSpeed(day);
	}
	
	/**
	 * 
	 * @param center
	 * @param imgPath
	 * @param day ��ת����
	 * @param au  1���ĵ�λ  1au = 1.49�ڹ���
	 * @param e ���������
	 */
	
	public Planet(Star center,String imgPath,int day,double au,double e,boolean satellite) {
		this(center, imgPath, day, au, e);
		this.satellite = satellite;
	}
	
	private double getLongAxis(double au) {
		return au * 200;
	}

	public static double getSpeed(int day) {
		return (365d/day) * 0.1;
	}

	public int getShortAxis(double e) {
		
		return (int)(longAxis * Math.sqrt(1 - e * e));
		
	}
	
	@Override
	public void move() {
		x =center.x + center.img.getWidth(null)/2 - this.img.getWidth(null)/2  + (int)(longAxis * Math.cos(theta));
		y = center.y + center.img.getHeight(null)/2 -this.img.getHeight(null)/2  + (int)(shortAxis * Math.sin(theta));
		theta += speed;
	}
	
	@Override
	public void draw(Graphics g) {
		if(!satellite) {
			drawTrace(g);
		}
		super.draw(g);
	}
	
	/**
	 * ���е���Բ���
	 */
	public void drawTrace (Graphics g) {
		//����Բ�ķ���
		int o_x = (int) (center.x + center.img.getWidth(null)/2 - longAxis);
		int o_y = (int) (center.y + center.img.getHeight(null)/2 - shortAxis);
		int width = (int) (2 * longAxis);
		int height = (int) (2 * shortAxis);
		//�޸���ɫ
		Color c =g.getColor();
		g.setColor(Color.WHITE);
		g.drawOval(o_x, o_y, width, height);
		g.setColor(c);
	}

}
