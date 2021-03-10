package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	// Variables
	private PApplet app;
	private Personaje personaje;
	private ArrayList<Enemigo> enemies;
	private int pantalla;
	private int numeroDeEnemigos;
	private int enemigosAsesinados;
	private String tiempo;
	private int numeroDeEnemigos2;

	public Logica(PApplet app) {
		this.app = app;
		// TODO Auto-generated constructor stub
		personaje = new Personaje(app, 50, 50);
		enemies = new ArrayList<>();
		numeroDeEnemigos = 1;
		numeroDeEnemigos2 = 0;
		enemigosAsesinados = 0;
		tiempo = "0";
	}

	public void show() {

		switch (pantalla) {
		case 0:
			app.background(0);
			app.rect(app.width / 2, app.height - 150, app.width / 4, app.height / 7);
			break;

		case 1:
			app.background(0, 0, 255);
			app.rect(app.width / 2, app.height - 150, app.width / 4, app.height / 7);
			break;

		case 2:
			app.background(255);
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).show();
				enemies.get(i).move();
				enemies.get(i).dead();
			}
			personaje.show();
			personaje.evaluateCollisionBullet(enemies);
			personaje.evaluateCollisionCharacter(enemies);
			// se eliminan
			for (int i = 0; i < enemies.size(); i++) {
				if (!enemies.get(i).isAlive()) {
					if (enemies.get(i).getLives() <= 0) {
						enemigosAsesinados++;
					}
					enemies.remove(i);
				}
			}

			if (personaje.getLives() <= 0) {
				tiempo = app.minute() + " : " + app.second();
				pantalla = 3;
			}
			// se crean
			generateEnemies();
			app.fill(60);
			app.textSize(20);
			app.text("vidas:  " + personaje.getLives(), 25, 25);
			break;

		case 3:
			app.background(150, 0, 150);
			app.fill(255);
			app.textSize(40);
			app.text("Duraste:  " + tiempo, app.width / 4, 150);
			app.textSize(40);
			app.text("Enemigos Eliminados:  " + enemigosAsesinados, app.width / 4, 250);

			break;

		}
	}

	public void generateEnemies() {
		if (app.frameCount % 500 == 0) {
			for (int i = 0; i < numeroDeEnemigos; i++) {
				enemies.add(new Enemigo1(app));
			}
		}
		if (app.frameCount % 1000 == 0) {
			numeroDeEnemigos++;
		}
		if (app.frameCount % 1500 == 0) {
			numeroDeEnemigos2++;
		}
		if (app.frameCount % 2000 == 0) {
			for (int i = 0; i < numeroDeEnemigos2; i++) {
				enemies.add(new Enemigo2(app));
			}
		}
	}

	public void mouseR() {
		switch (pantalla) {
		case 0:

			if (app.mouseX > 450 && app.mouseY < 750 && app.mouseY > 500 && app.mouseY < 600) {
				pantalla = 1;
			}
			break;
		case 1:
			if (app.mouseX > 450 && app.mouseY < 750 && app.mouseY > 500 && app.mouseY < 600) {
				pantalla = 2;
				numeroDeEnemigos = 1;
			}
			break;
		case 3:

			break;

		default:
			break;
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
