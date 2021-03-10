package Main;

import processing.core.PApplet;

public abstract class Enemigo {

	protected int x, y;
	protected int vel;
	protected int rad = 50;
	protected PApplet app;
	protected int lives;
	protected boolean isAlive = true;

	public Enemigo(PApplet app) {
		// TODO Auto-generated constructor stub}
		this.app = app;
		this.x = (int) app.random(app.width+60, app.width+300);
		this.y = (int) app.random(25, app.height-25);

	}

	public abstract void show();

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
