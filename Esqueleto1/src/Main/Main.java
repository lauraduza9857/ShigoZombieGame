package Main;
import processing.core.PApplet;

public class Main extends PApplet {

	//Variables
	private Logica log;
	
	public Main() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main.Main");
	}
	
	public void settings() {
		size(1200,700);
		
	}
	
	public void setup() {
		log= new Logica(this);
		rectMode(CENTER);
		imageMode(CENTER);
		ellipseMode(CENTER);
	}
	
	public void draw() {
		log.show();
	}
	
	public void keyPressed() {
		log.keyboardPressed();
	}
	
	public void keyReleased() {
		log.keyboardReleased();
	}

}
