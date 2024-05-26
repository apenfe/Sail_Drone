package visual;

import agente.Barco;
import processing.core.PApplet;

public class Plot4 extends PApplet {
	
	Barco[] barcos = new Barco[0];
	float[][] puntos = new float[0][0];
	int x, y;
	double xE, yE, xS, yS;
	int[] currentPoint = new int[0]; // Track the current point to draw
	int speed = 20; // Number of points to draw per frame
	int[] color; // Array to store colors for each barco
	
	public Plot4() {
		
	}
	
	public void setBarcos(Barco[] barcos) {
		this.barcos = barcos;
		this.currentPoint=new int[barcos.length];
		
	}
	
	public void setup() {
		//frameRate(20); // Set the frame rate to 30 FPS to slow down the animation
	}

	public void setPuntos(Barco b) {
        
		this.puntos = b.caminoFloat();
	}
	
	public void setColor(Barco b) {
        
		this.color=new int[3];
		
		if(b.getId()<=100) {
			
			this.color[0]=b.getId();
			this.color[1]=b.getId();
			this.color[2]=b.getId()+20;
			
		}else if(b.getId()>100 && b.getId()<=200) {
			
			this.color[0]=b.getId();
			this.color[1]=b.getId()+20;
			this.color[2]=b.getId();
			
		}else if(b.getId()>200 && b.getId()<=300) {
			
			this.color[0]=b.getId()+20;
			this.color[1]=b.getId();
			this.color[2]=b.getId();
			
		}else {
			
			this.color[0]=b.getId();
			this.color[1]=b.getId();
			this.color[2]=b.getId();
			
		}
		
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
		
		for (int j = 0; j < barcos.length; j++) {
			
		//	stroke(r, g, b);
			
			setPuntos(barcos[j]);
			setColor(barcos[j]);
			stroke(color[0],color[1],color[2]);
			
			if (currentPoint[j] < puntos.length - 1) {
				
				beginShape();
				for (int i = 0; i <= currentPoint[j]; i++) {
					vertex(puntos[i][1] + 10, puntos[i][0] + 10);
				}
				endShape();
				
				currentPoint[j] += speed; // Increase by speed
				if (currentPoint[j] >= puntos.length) {
					currentPoint[j] = puntos.length - 1; // Ensure we don't go out of bounds
				}
				
			}
			
		}
	
	}
	
	@Override
	public void exit() {
		
		noLoop();

	}
}