package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Personaje {

	// variables
	private int x, y;
	private int vel;
	private int rad = 50;
	private PApplet app;
	private ArrayList<Bullet> bullets;
	private int lives = 3;

	public Personaje(PApplet app, int x, int y) {
		// TODO Auto-generated constructor stub}
		this.app = app;
		this.x = x;
		this.y = y;
		vel = 4;
		bullets = new ArrayList<>();

	}

	public void show() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).show();
			bullets.get(i).move();
			bullets.get(i).dead();
		}
		app.fill(155, 155, 0);
		app.rect(x, y, 50, 50);
		for (int i = 0; i < bullets.size(); i++) {
			if (!bullets.get(i).isAlive()) {
				bullets.remove(i);
				return;
			}
			
		}
	}

	public void move() {
		if (app.keyCode == app.UP) {
			y -= vel;
		}
		if (app.keyCode == app.DOWN) {
			y += vel;
		}
		if (app.keyCode == app.LEFT) {
			x -= vel;
		}
		if (app.keyCode == app.RIGHT) {
			x += vel;
		}
	}
	
	public void shoot() {
		bullets.add(new Bullet(app,x,y));
	}

	public void evaluateCollisionBullet(ArrayList<Enemigo> enemies) {

		for (int i = 0; i < enemies.size(); i++) {
			Enemigo e = enemies.get(i);
			for (int j = 0; j < bullets.size(); j++) {
				Bullet b = bullets.get(j);
				if (app.dist(e.getX(), e.getY(), b.getX(), b.getY())< rad) {
					bullets.remove(j);
					e.losingLives();
					return;
				}
			}
		}
		
	}

	public void evaluateCollisionCharacter(ArrayList<Enemigo> enemies) {
		for (int i = 0; i < enemies.size(); i++) {
			Enemigo e = enemies.get(i);
				if (app.dist(e.getX(), e.getY(), x,y)< rad) {
					lives -=1;
					enemies.remove(i);
				}
		}
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
			

}
