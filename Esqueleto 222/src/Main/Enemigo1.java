package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Enemigo1 extends Enemigo {
	
	public Enemigo1(PApplet app) {
		// TODO Auto-generated constructor stub}
		super(app);
		vel = 2;
		lives= 3; 
	}

	public void show() {
		app.fill(255,0,0);
		app.rect(x, y, 50, 50);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void move() {
		if (app.frameCount%3 == 0) {
			x-= vel;			
		}
		
	}
	
	public void dead() {
		if (lives <= 0) {
			isAlive = false;
		} else if (x <= -150) {
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
