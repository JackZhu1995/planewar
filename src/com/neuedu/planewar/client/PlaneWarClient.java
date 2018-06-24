package com.neuedu.planewar.client;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.neuedu.planewar.constant.Constant;
import com.neuedu.planewar.core.Background;
import com.neuedu.planewar.core.Bullet;
import com.neuedu.planewar.core.EnemyBullet;
import com.neuedu.planewar.core.EnemyPlane;
import com.neuedu.planewar.core.Explode;
import com.neuedu.planewar.core.Plane;
import com.neuedu.planewar.util.ImageUtil;
import com.neuedu.planewar.util.MusiceUtil;
import com.neuedu.planewar.util.MyFrame;

public class PlaneWarClient extends MyFrame{

	private static final long serialVersionUID = 3666289786814025750L;

	Random r = new Random();

	public int enemyCount = 0;

	public Plane myplane = new Plane(this);

	Background bg = new Background();

	public List<EnemyPlane> enemyList = new ArrayList<>();

	public List<Bullet> bulletList = new ArrayList<>();
	
	public List<EnemyBullet> enemyBulletList = new ArrayList<>();
	
	public List<Explode> explodeList = new ArrayList<>();
	
	@Override
	public void loadFrame() {
		super.loadFrame();

		enemyList.add(new EnemyPlane(1300, 30,this)); 
		enemyList.add(new EnemyPlane(830, 180,this)); 
		enemyList.add(new EnemyPlane(900, 330,this)); 
		enemyList.add(new EnemyPlane(1100, 480,this)); 
		enemyList.add(new EnemyPlane(1200, 630,this));
		enemyCount += 5;
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				myplane.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				myplane.keyPressed(e);
			}
		});

		new MusiceUtil("src/music/1.mp3").start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		bg.draw(g);
		myplane.draw(g);
		for (int i = 0; i < enemyList.size(); i++) {
			EnemyPlane ep = enemyList.get(i);
			ep.draw(g);
		}
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.draw(g);
			bullet.hind(enemyList);
		}
		for (int i = 0; i < enemyBulletList.size(); i++) {
			EnemyBullet eb = enemyBulletList.get(i);
			eb.draw(g);
			eb.hind(myplane);
		}
		for (int i = 0; i < explodeList.size(); i++) {
			Explode explode = explodeList.get(i);
			explode.draw(g);
		}
		addEnemy();
		if(enemyCount >= 20) {

		}
	}

	public void addEnemy() {
		if(enemyList.size() == 0) {
			int count = r.nextInt(4) + 1;
			for (int i = 0; i < count; i++) {
				EnemyPlane ep = new EnemyPlane(Constant.GAME_WIDTH, r.nextInt(Constant.GAME_HEIGHT - ImageUtil.imgs.get("enemy01").getWidth(null) - 30) + 30, this);
				ep.type = r.nextInt(2) + 1;
				enemyList.add(ep);
				enemyCount++;
			}
			
		}
	}
	
	public static void main(String[] args) {
		new PlaneWarClient().loadFrame();
	}
	
}
