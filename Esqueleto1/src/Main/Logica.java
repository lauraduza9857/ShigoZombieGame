package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	// Variables
	private PApplet app;
	private Personaje personaje;
	private ArrayList<Enemy> enemies;


	public Logica(PApplet app) {
		this.app = app;
		// TODO Auto-generated constructor stub
		personaje = new Personaje(app, 50, 50);
		enemies = new ArrayList<>();
	}

	public void show() {
		app.background(255);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).show();
			enemies.get(i).move();
			enemies.get(i).dead();
		}
		personaje.show();
		personaje.evaluateCollisionBullet(enemies);		
		//se eliminan 
		for (int i = 0; i < enemies.size(); i++) {
			if (!enemies.get(i).isAlive()) {
				enemies.remove(i);
			}
		}
		//se crean
		generateEnemies();
	}
	
	public void generateEnemies() {
		if (app.frameCount%105 == 0) {
			enemies.add(new Enemy(app));
		}
	}
	
	public void keyboardPressed() {
		personaje.move();
	}

	public void keyboardReleased() {
		if (app.key == ' ') {
			personaje.shoot();	
			}	
		}
}
