package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Enemy {

	private int x, y;
	private int vel;
	private int rad = 50;
	private PApplet app;
	private int lives = 3;
	private boolean isAlive = true;

	public Enemy(PApplet app) {
		// TODO Auto-generated constructor stub}
		this.app = app;
		this.x = (int) app.random(app.width+60, app.width+150);
		this.y = (int) app.random(25, app.height-25);
		vel = 2;

	}

	public void show() {
		app.fill(255,0,0);
		app.rect(x, y, 50, 50);
	}

	public void move() {
		if (app.frameCount%3 == 0) {
			x-= vel;			
		}
		
	}
	
	public void dead() {
		if (lives <= 0) {
			isAlive = false;
		}
	}
	
	public void losingLives() {
		lives-=1;
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

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
