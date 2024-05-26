package visual;

import agente.Agente;
import processing.core.PApplet;
import processing.core.PImage;

public class Plot5Agent extends PApplet {
	
	PImage fondo;
	Agente[] agentes = new Agente[0];
	float[][] puntos = new float[0][0];
	int x, y;
	double xE, yE, xS, yS;
	int[] currentPoint = new int[0]; // Track the current point to draw
	int speed = 15; // Number of points to draw per frame
	int[] color; // Array to store colors for each barco
	
	public Plot5Agent() {

	}
	
	public void setBarcos(Agente[] agentes) {
		this.agentes = agentes;
		this.currentPoint=new int[agentes.length];
		
	}
	
	public void setup() {
		//frameRate(20); // Set the frame rate to 30 FPS to slow down the animation
		this.fondo = loadImage("\\mapas\\mapa_1.png"); // Reemplaza con la ruta de tu imagen
	}

	public void setPuntos(Agente b) {
        
		this.puntos = b.caminoFloat();
	}
	
	public void setColor(Agente b) { // no tienen id
        
		this.color=new int[3];
		
		if(b.win()) {
			
			this.color[0]=0;
			this.color[1]=255;
			this.color[2]=0;
			
		}else if(b.lose()) {
			
			this.color[0]=255;
			this.color[1]=0;
			this.color[2]=0;
			
		}else {
			
			this.color[0]=0;
			this.color[1]=0;
			this.color[2]=255;
			
		}
		
	}
//********************************************	
	// Method to draw an arrow
	
		public void drawArrow(float x, float y, float angle) {
			
			pushMatrix();
			translate(x, y);
			rotate(radians(angle));
			stroke(color[0],color[1],color[2]);
			fill(255, 0, 0,0);
			beginShape();
			vertex(-10, -5);
			vertex(0, -5);
			vertex(0, -10);
			vertex(10, 0);
			vertex(0, 10);
			vertex(0, 5);
			vertex(-10, 5);
			endShape(CLOSE);
			popMatrix();
		}
//***********************************
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setInOut(double xE, double yE, double xS, double yS) {
		this.xE = yE;
		this.yE = xE;
		this.xS = yS;
		this.yS = xS;
	}

	// Method to configure the window
	public void settings() {
		//size(x + 20, y + 20); // offset of 20 per axis
		size(x , y ); // offset of 20 per axis
	}

	// Method to draw on the canvas
	public void draw() {
		
		background(fondo);

		// Draw borders
		stroke(255, 255, 255);
		line(10, 10, 10, y + 10);
		line(10, 10, x + 10, 10);
		line(x + 10, y + 10, 10, y + 10);
		line(x + 10, y + 10, x + 10, 10);

		// Draw entry and exit points
		fill(150, 0, 0);
		ellipse((float) xE + 10, (float) yE + 10, 20, 20);
		fill(255, 0, 0);
		ellipse((float) xE + 10, (float) yE + 10, 10, 10);
		
		fill(0, 255, 0);
		ellipse((float) xS+10 , (float) yS+10, (float)agentes[0].getEntorno().getAreaAprox()*2, (float)agentes[0].getEntorno().getAreaAprox()*2);
		fill(0, 150, 0);
		ellipse((float) xS + 10, (float) yS + 10, 20, 20);
		
		// Draw the points progressively
		stroke(0, 0, 200);
		noFill();
		
		for (int j = 0; j < agentes.length; j++) {
			
		//	stroke(r, g, b);
			
			setPuntos(agentes[j]);
			setColor(agentes[j]);
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
			
			// Update and draw the arrow
			float xPos = puntos[currentPoint[j]][1] + 10;
			float yPos = puntos[currentPoint[j]][0] + 10;
			float angle = 0; // Calculate the angle based on the next point if available
			if (currentPoint[j] < puntos.length - 1) {
				float nextX = puntos[currentPoint[j] + 1][1] + 10;
				float nextY = puntos[currentPoint[j] + 1][0] + 10;
				angle = atan2(nextY - yPos, nextX - xPos);
			}
			drawArrow(xPos, yPos, degrees(angle));
			
		}
	
	}
	
	@Override
	public void exit() {
		
		noLoop();

	}
}