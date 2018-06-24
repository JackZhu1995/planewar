package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.constant.Constant;
import com.neuedu.planewar.util.ImageUtil;

public class Plane extends PlaneWarObject{

	Image[] img = new Image[3];
	int index = 0;

	boolean live;

	boolean left,right,up,down;
	Direction dir;

	boolean fire = false;
	
	public Plane(PlaneWarClient pwc) {
		this.pwc = pwc;
		init();
	}

	private void init() {
		setX(0);
		setY(30);
		setSpeed(30);
		live = true;
		for (int i = 0; i < img.length; i++) {
			img[i] = ImageUtil.imgs.get("plane0" + (i + 1));
		}
	}
	
	@Override
	public void draw(Graphics g) {
		if(live) {
			g.drawImage(img[index++], getX(), getY(), null);
			if(index == 3) {
				index = 0;
			}
			fire();
			move();
		}
		
	}
	
	public void move() {
		if(left && !up && !right && !down) {
			setX(getX() - getSpeed());
		}else if(left && up && !right && !down) {
			setX(getX() - getSpeed());
			setY(getY() - getSpeed());
		}else if(!left && up && !right && !down) {
			setY(getY() - getSpeed());
		}else if(!left && up && right && !down) {
			setX(getX() + getSpeed());
			setY(getY() - getSpeed());
		}else if(!left && !up && right && !down) {
			setX(getX() + getSpeed());
		}else if(!left && !up && right && down) {
			setX(getX() + getSpeed());
			setY(getY() + getSpeed());
		}else if(!left && !up && !right && down) {
			setY(getY() + getSpeed());
		}else if(left && !up && !right && down) {
			setX(getX() - getSpeed());
			setY(getY() + getSpeed());
		}
		outBounds();
	}

	public void outBounds() {
		if(getX() < 0) {
			setX(0);
		}
		if(getX() + img[0].getWidth(null) > Constant.GAME_WIDTH) {
			setX(Constant.GAME_WIDTH - img[0].getWidth(null));
		}
		if(getY() < 30) {
			setY(30);
		}
		if(getY() + img[0].getHeight(null) > Constant.GAME_HEIGHT) {
			setY(Constant.GAME_HEIGHT - img[0].getHeight(null));
		}
	}
	
	public void fire(){
		if(fire) {
			Bullet bullet = new Bullet(getX() + img[0].getWidth(null), getY() + img[0].getHeight(null) / 2 - 8,pwc);
			pwc.bulletList.add(bullet);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = true;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			left = true;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			down = true;
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			right = true;
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			fire = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			fire = false;
		}
		
	}
	
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), img[0].getWidth(null), img[0].getHeight(null));
	}
	
}
