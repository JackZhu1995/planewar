package com.neuedu.planewar.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.neuedu.planewar.client.PlaneWarClient;

public class PlaneWarObject implements Moveable,Drawable{

	public PlaneWarClient pwc;

	private int speed;
	private int x;
	private int y;
	@Override
	public void draw(Graphics g) {
		
	}
	@Override
	public void move() {
		
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getRectangle() {return null;}
	
}
