package com.neuedu.planewar.util;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neuedu.planewar.constant.Constant;

public class MyFrame extends Frame{

	private static final long serialVersionUID = -642945310426180826L;

	public MyFrame() {
		
	}

	public void loadFrame() {
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setTitle(Constant.GAME_TITLE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		new Timer().start();
	}
	

	private Image backimage;
	@Override
	public void update(Graphics g) {
		if(backimage == null) {
			backimage = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		}
		Graphics backg = backimage.getGraphics();
		backg.setColor(Color.BLACK);
		backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		paint(backg);
		g.drawImage(backimage, 0, 0, null);
	}
	
	class Timer extends Thread{
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
