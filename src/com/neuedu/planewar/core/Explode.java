package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.util.ImageUtil;

public class Explode extends PlaneWarObject{

	Image[] img = new Image[9];
	
	int index = 0;
	
	public Explode(int x,int y,PlaneWarClient pwc) {
		init(x,y,pwc);
	}
	
	private void init(int x,int y,PlaneWarClient pwc) {
		setX(x);
		setY(y);
		this.pwc = pwc;
		for (int i = 0; i < img.length; i++) {
			img[i] = ImageUtil.imgs.get(String.valueOf(i + 1));
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img[index++], getX(), getY(), null);
		if(index == 9) {
			index = 0;
			pwc.explodeList.remove(this);
		}
	}
	
}
