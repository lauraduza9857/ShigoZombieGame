package Main;

import processing.core.PApplet;

public class Bullet extends Personaje {

	private int x,y;
	private int vel;
	private int rad;
	private boolean isAlive = true;
	private PApplet app;

	public Bullet(PApplet app, int x, int y) {
		super(app, x, y);
		// TODO Auto-generated constructor stub
		this.app = app;
		this.x = x;
		this.y = y;
		this.rad = 50;
		this.vel = 6;
		
	}

	public void show() {
		app.fill(255,0,255);
		app.ellipse(x, y, rad/2, rad/2);
	}

	public void dead() {
		if(x > app.width+rad) {
			isAlive = false;
		}
	}
	
	public void move() {
		x+=vel;
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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}	

	
}
