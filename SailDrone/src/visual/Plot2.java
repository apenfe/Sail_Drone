package visual;

import agente.Barco;
import processing.core.PApplet;

public class Plot2 extends PApplet {
	
	Barco[] barcos = new Barco[0];
	float[][] puntos = new float[0][0];
	int x, y;
	double xE, yE, xS, yS;
	int currentPoint = 0; // Track the current point to draw
	int speed = 5; // Number of points to draw per frame
	
	public Plot2() {
		
	}
	
	public void setBarcos(Barco[] barcos) {
		this.barcos = barcos;
	}

	public void setPuntos(float[][] puntos) {
		this.puntos = puntos;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setInOut(double xE, double yE, double xS, double yS) {
		this.xE = xE;
		this.yE = yE;
		this.xS = xS;
		this.yS = yS;
	}

	// Method to configure the window
	public void settings() {
		size(x + 20, y + 20); // offset of 20 per axis
	}

	// Method to draw on the canvas
	public void draw() {
		background(200);

		// Draw borders
		stroke(0, 0, 255);
		line(10, 10, 10, y + 10);
		line(10, 10, x + 10, 10);
		line(x + 10, y + 10, 10, y + 10);
		line(x + 10, y + 10, x + 10, 10);

		// Draw entry and exit points
		fill(150, 0, 0);
		ellipse((float) xE + 10, (float) yE + 10, 20, 20);
		fill(255, 0, 0);
		ellipse((float) xE + 10, (float) yE + 10, 10, 10);
		fill(0, 150, 0);
		ellipse((float) xS + 10, (float) yS + 10, 20, 20);
		fill(0, 255, 0);
		ellipse((float) xS + 10, (float) yS + 10, 10, 10);

		// Draw the points progressively
		stroke(0, 0, 200);
		noFill();
		
	

		if (currentPoint < puntos.length - 1) {
			beginShape();
			for (int i = 0; i <= currentPoint; i++) {
				vertex(puntos[i][1] + 10, puntos[i][0] + 10);
			}
			endShape();
			
			currentPoint += speed; // Increase by speed
			if (currentPoint >= puntos.length) {
				currentPoint = puntos.length - 1; // Ensure we don't go out of bounds
			}
			
		}
	}
	
	@Override
	public void exit() {
		
		noLoop();

	}
}
