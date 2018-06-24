package com.neuedu.planewar.constant;

import java.io.IOException;
import java.util.Properties;

public class Constant {

	private static Properties properties = new Properties();

	static {
		try {
			properties.load(Constant.class.getClassLoader().getResourceAsStream("game.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final int GAME_WIDTH = Integer.parseInt(properties.getProperty("GAME_WIDTH","0"));
	public static final int GAME_HEIGHT = Integer.parseInt(properties.getProperty("GAME_HEIGHT","0"));
	public static final String GAME_TITLE = properties.getProperty("GAME_TITLE");
	public static final String GAME_IMGPATH = properties.getProperty("GAME_IMGPATH");
	
}
