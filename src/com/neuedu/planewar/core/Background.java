package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neuedu.planewar.util.ImageUtil;

public class Background extends PlaneWarObject{

	Image img;
	
	public Background() {
		init();
	}

	private void init() {
		setX(0);
		setY(0);
		setSpeed(1);
		img = ImageUtil.imgs.get("bg");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, getX(), getY(), null);
		move();
	}
	
	@Override
	public void move() {
		setX(getX() - getSpeed());
	}
	
}
