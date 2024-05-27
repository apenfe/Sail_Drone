package visual;

import agente.Agente;
import processing.core.PApplet;
import processing.core.PImage;


public class Plot6Agent extends PApplet {
	
	PImage fondo;
	Agente[] agentes = new Agente[0];
	float[][] puntos = new float[0][0];
	int x, y;
	double xE, yE, xS, yS;
	int[] currentPoint = new int[0]; // Track the current point to draw
	int speed = 25; // Number of points to draw per frame antes 15
	int[] color; // Array to store colors for each barco
	int generacion;
	double maxFitness;
	String mapa;
	
	public Plot6Agent(int generacion, double maxFitness,String mapa) {
		this.generacion=generacion;
		this.maxFitness=maxFitness;
		this.mapa=mapa;
	}
	
	public void setBarcos(Agente[] agentes) {
		this.agentes = agentes;
		this.currentPoint=new int[agentes.length];
		
		for (int i = 0; i < agentes.length; i++) {
			
			if(agentes[i].getFitness()>maxFitness) {
				this.maxFitness=agentes[i].getFitness();
			}
		}
		
		//this.speed = 15*agentes.length;
		
	}
	
	public void setup() {
		
		this.fondo = loadImage(mapa);
		
	}

	public void setPuntos(Agente b) {
        
		this.puntos = b.caminoFloat();
	}
	
	public void setColor(Agente b) { // no tienen id
        
		this.color=new int[3];
		
		if(b.getFitness()>=maxFitness) {
			this.color[0]=0;
			this.color[1]=0;
			this.color[2]=0;
			return;
		}
		
		if(b.win()) {
			
			this.color[0]=0;
			this.color[1]=255;
			this.color[2]=0;
			
		}else if(b.lose()) {
			
			this.color[0]=255;
			this.color[1]=0;
			this.color[2]=0;
			
		}else {
			
			this.color[0]=255;
			this.color[1]=255;
			this.color[2]=255;
			
		}
		
	}
	
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

	public void settings() {

		size(x,y);
	}

	// Method to draw on the canvas
	public void draw() {
		
		background(fondo);
		
		fill(255, 255, 255, 200); // Color blanco con transparencia (alfa de 200)
        rect(0, 0, 200, 60); // Fondo blanco semitransparente para el texto
        fill(0); // Color negro para el texto
        textAlign(LEFT, TOP); // Alinear el texto en la parte superior izquierda
        text("GENERACION: "+generacion, 5, 5);
        text("Nº AGENTES: "+agentes.length, 5, 20);
        text("FITNESS MAXIMO: "+maxFitness, 5, 35);

		fill(150, 0, 0);
		ellipse((float) xE ,(float) yE , 20, 20);
		fill(255, 0, 0);
		ellipse((float) xE , (float) yE , 10, 10);
		
		fill(0, 255, 0);
		ellipse((float) xS , (float) yS, (float)agentes[0].getEntorno().getAreaAprox()*2, (float)agentes[0].getEntorno().getAreaAprox()*2);
		fill(0, 150, 0);
		ellipse((float) xS , (float) yS , 20, 20);
		
		// Dibujar los puntos prograsivamente
		stroke(0, 0, 200);
		noFill();
		
		for (int j = 0; j < agentes.length; j++) {
		
			setPuntos(agentes[j]);
			setColor(agentes[j]);
			stroke(color[0],color[1],color[2]);
			
			if (currentPoint[j] < puntos.length - 1) {
				
				beginShape();
				for (int i = 0; i <= currentPoint[j]; i++) {
					vertex(puntos[i][1] , puntos[i][0] );
				}
				endShape();
				
				currentPoint[j] += speed; // Increase by speed
				if (currentPoint[j] >= puntos.length) {
					currentPoint[j] = puntos.length - 1; // Ensure we don't go out of bounds
				}
				
			}
			
			// Update and draw the arrow
			float xPos = puntos[currentPoint[j]][1] ;
			float yPos = puntos[currentPoint[j]][0] ;
			float angle = 0; // Calculate the angle based on the next point if available
			if (currentPoint[j] < puntos.length - 1) {
				float nextX = puntos[currentPoint[j] + 1][1] ;
				float nextY = puntos[currentPoint[j] + 1][0] ;
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