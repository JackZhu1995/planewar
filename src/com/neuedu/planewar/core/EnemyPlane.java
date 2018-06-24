package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.constant.Constant;
import com.neuedu.planewar.util.ImageUtil;

public class EnemyPlane extends PlaneWarObject{

	Image[] img = new Image[8];
	int index = 0;

	public int type = 1;
	
	static Random r = new Random();
	
	public EnemyPlane(int x,int y,PlaneWarClient pwc) {
		init(x,y,pwc);
	}
	
	private void init(int x,int y,PlaneWarClient pwc) {
		setX(x);
		setY(y);
		this.pwc = pwc;
		setSpeed(10);
		for (int i = 0; i < img.length; i++) {
			img[i] = ImageUtil.imgs.get("enemy0" + (i + 1));
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img[index++], getX(), getY(), null);
		if(index == 8) {
			index = 0;
		}
		fire();
		move();
	}
	
	public void fire() {
		if(r.nextInt(1000) > 985) {
			EnemyBullet eb = new EnemyBullet(getX() - ImageUtil.imgs.get("bullet2").getWidth(null), getY() + (img[0].getHeight(null) / 2) - 20, pwc);
			pwc.enemyBulletList.add(eb);
		}
	}
	
	@Override
	public void move() {
		if(type == 1) {
			move1();
		}
		if(type == 2) {
			move2();
		}
		
		
	}
	
	public void move1() {
		setX(getX() - getSpeed());
		if(getX() < 0) {
			pwc.enemyList.remove(this);
		}
	}

	boolean isup = true;
	
	public void move2() {
		if(isup) {
			setX(getX() - getSpeed());
			setY(getY() - getSpeed());
			if(getY() < 30) {
				isup = false;
			}
		}else {
			setX(getX() - getSpeed());
			setY(getY() + getSpeed());
			if(getY() > Constant.GAME_HEIGHT - img[0].getHeight(null)) {
				isup = true;
			}
		}
		if(getX() < 0) {
			pwc.enemyList.remove(this);
		}
	}
	
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), img[0].getWidth(null), img[0].getHeight(null));
	}
	
}
