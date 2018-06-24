package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.constant.Constant;
import com.neuedu.planewar.util.ImageUtil;

public class Bullet extends PlaneWarObject{

	Image img;
	
	public Bullet(int x, int y,PlaneWarClient pwc) {
		init(x,y,pwc);
	}
	
	private void init(int x,int y,PlaneWarClient pwc) {
		setX(x);
		setY(y);
		this.pwc = pwc;
		setSpeed(50);
		img = ImageUtil.imgs.get("bullet1");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, getX(), getY(), null);
		move();
	}
	
	@Override
	public void move() {
		setX(getX() + getSpeed());
		outBounds();
	}
	
	public void outBounds() {
		if(getX() > Constant.GAME_WIDTH) {
			pwc.bulletList.remove(this);
		}
	}
	
	public void hind(List<EnemyPlane> enemyList) {
		for (int i = 0; i < enemyList.size(); i++) {
			EnemyPlane ep = enemyList.get(i);
			if(this.getRectangle().intersects(ep.getRectangle())) {
				pwc.enemyList.remove(ep);
				pwc.bulletList.remove(this);
				Explode explode = new Explode(ep.getX() - 50, ep.getY() - 35,pwc);
				pwc.explodeList.add(explode);
			}
		}
	}
	
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), img.getWidth(null), img.getHeight(null));
	}
	
}
