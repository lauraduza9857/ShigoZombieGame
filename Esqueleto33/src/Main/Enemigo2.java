package Main;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemigo2 extends Enemigo {
	
	PImage Zombie2;

	public Enemigo2(PApplet app) {
		// TODO Auto-generated constructor stub}
		super(app);
		vel =5;
		lives= 5; 
		Zombie2 = app.loadImage("Zombie2.png");
	}

	public void show() {
		
		app.image(Zombie2, x, y);
		//app.fill(0);
		//app.rect(x, y, 50, 50);
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
