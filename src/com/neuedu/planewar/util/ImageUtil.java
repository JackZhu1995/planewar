package com.neuedu.planewar.util;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.neuedu.planewar.constant.Constant;

public class ImageUtil {

	public static final Map<String, Image> imgs = new HashMap<>();
	
	public static Image getImage(String path) {
		URL url = ImageUtil.class.getClassLoader().getResource(path);
		Image image = null;
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	static {
		imgs.put("plane01", getImage(Constant.GAME_IMGPATH + "plane/01.png"));
		imgs.put("plane02", getImage(Constant.GAME_IMGPATH + "plane/02.png"));
		imgs.put("plane03", getImage(Constant.GAME_IMGPATH + "plane/03.png"));
		imgs.put("bg", getImage(Constant.GAME_IMGPATH + "bg01.png"));
		imgs.put("enemy01", getImage(Constant.GAME_IMGPATH + "enemy/01.png"));
		imgs.put("enemy02", getImage(Constant.GAME_IMGPATH + "enemy/02.png"));
		imgs.put("enemy03", getImage(Constant.GAME_IMGPATH + "enemy/03.png"));
		imgs.put("enemy04", getImage(Constant.GAME_IMGPATH + "enemy/04.png"));
		imgs.put("enemy05", getImage(Constant.GAME_IMGPATH + "enemy/05.png"));
		imgs.put("enemy06", getImage(Constant.GAME_IMGPATH + "enemy/06.png"));
		imgs.put("enemy07", getImage(Constant.GAME_IMGPATH + "enemy/07.png"));
		imgs.put("enemy08", getImage(Constant.GAME_IMGPATH + "enemy/08.png"));
		imgs.put("bullet1", getImage(Constant.GAME_IMGPATH + "bullet/myBullet_01.png"));
		imgs.put("bullet2", getImage(Constant.GAME_IMGPATH + "bullet/enemyBullet_01.png"));

		imgs.put("1", getImage(Constant.GAME_IMGPATH + "explode/1.png"));
		imgs.put("2", getImage(Constant.GAME_IMGPATH + "explode/2.png"));
		imgs.put("3", getImage(Constant.GAME_IMGPATH + "explode/3.png"));
		imgs.put("4", getImage(Constant.GAME_IMGPATH + "explode/4.png"));
		imgs.put("5", getImage(Constant.GAME_IMGPATH + "explode/5.png"));
		imgs.put("6", getImage(Constant.GAME_IMGPATH + "explode/6.png"));
		imgs.put("7", getImage(Constant.GAME_IMGPATH + "explode/7.png"));
		imgs.put("8", getImage(Constant.GAME_IMGPATH + "explode/8.png"));
		imgs.put("9", getImage(Constant.GAME_IMGPATH + "explode/9.png"));
	}
	
}
