package com.neuedu.planewar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusiceUtil extends Thread{

	Player player;
	File musicFile;
	
	public MusiceUtil(String musicPath) {
		musicFile = new File(musicPath);
	}
	
	@Override
	public void run() {
		play();
	}
	
	public void play() {
		try {
			InputStream in = new FileInputStream(musicFile);
			player = new Player(in);
			player.play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MusiceUtil("src/music/1.mp3").start();
	}
}
