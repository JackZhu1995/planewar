package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.util.ImageUtil;

public class EnemyBullet extends PlaneWarObject{

	Image img;
	
	public EnemyBullet(int x, int y,PlaneWarClient pwc) {
		init(x,y,pwc);
	}
	
	private void init(int x,int y,PlaneWarClient pwc) {
		setX(x);
		setY(y);
		this.pwc = pwc;
		setSpeed(50);
		img = ImageUtil.imgs.get("bullet2");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, getX(), getY(), null);
		move();
	}
	
	@Override
	public void move() {
		setX(getX() - getSpeed());
		outBounds();
	}
	
	public void outBounds() {
		if(getX() + img.getWidth(null) < 0) {
			pwc.enemyBulletList.remove(this);
		}
	}

	public void hind(Plane myPlane) {
		if(pwc.myplane.live && this.getRectangle().intersects(myPlane.getRectangle())) {
			pwc.myplane.live = false;
			pwc.enemyBulletList.remove(this);
			Explode explode = new Explode(pwc.myplane.getX() - 50, pwc.myplane.getY() - 35,pwc);
			pwc.explodeList.add(explode);
		}
	}
	
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), img.getWidth(null), img.getHeight(null));
	}
	
}
