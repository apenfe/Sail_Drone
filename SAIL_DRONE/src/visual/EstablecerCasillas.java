package visual;

import processing.core.PApplet;
import processing.core.PImage;

public class EstablecerCasillas extends PApplet {
	
	int leftX = 0, leftY = 0; // Coordenadas para entrada
	int rightX = 0, rightY = 0; // Coordenadas para salida
	PImage fondo;
	int x, y;
	String mapa;
	
	public EstablecerCasillas(String mapa) {
		this.mapa=mapa;
	}
	
	public void setup() {
		
		this.fondo = loadImage(mapa);
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double[] getInOut() {
		
		double[] inout = new double[4];
		
		inout[0]=leftX;
		inout[1]=leftY;
		inout[2]=rightX;
		inout[3]=rightY;
		
		return inout;
	}

	public void settings() {

		size(x,y); // offset of 20 per axis
	}

	public void draw() {
		
		background(fondo);
		
		fill(255, 255, 255, 200); // Color blanco con transparencia (alfa de 200)
        rect(0, 0, 200, 60); // Fondo blanco semitransparente para el texto
        fill(0); // Color negro para el texto
        textAlign(LEFT, TOP); // Alinear el texto en la parte superior izquierda
        text("MAPA: "+mapa, 5, 5);
        text("Entrada (Clic izquierdo) x: "+leftX+", y: "+leftY, 5, 20);
        text("Salida (Clic Derecho) x: "+rightX+", y: "+rightY, 5, 35);

		 // Dibujar las marcas si hay coordenadas válidas
		  if (leftX != 0 && leftY != 0) {
		    fill(255, 0, 0);
		    ellipse(leftX, leftY, 10, 10); // Marca azul para el clic izquierdo
		 // Dibujar el texto
		    fill(0);  // Color negro para el texto
		    textAlign(CENTER+35, CENTER+35); // Alinear el texto al centro
		    text("Punto (" + leftX + ", " + leftY + ")", leftX, leftY); // Texto en la posición del ratón
		    
		    stroke(200,0,0);  // Color rojo
		    line(0, leftY, x, leftY); // Línea horizontal
		    line(leftX, 0, leftX, y); // Línea vertical
		  }
		  
		  if (rightX != 0 && rightY != 0) {
			  
			  stroke(0,200,0);  // Color rojo
			    line(0, rightY, x, rightY); // Línea horizontal
			    line(rightX, 0, rightX, y); // Línea vertical
			    
			// Dibujar el texto
			    fill(0);  // Color negro para el texto
			    textAlign(CENTER+35, CENTER+35); // Alinear el texto al centro
			    text("Punto (" + rightX + ", " + rightY + ")", rightX, rightY); // Texto en la posición del ratón
		    fill(0, 255, 0);
		    ellipse(rightX, rightY, 10, 10); // Marca roja para el clic derecho
		  }
		  
		  if (leftX != 0 && leftY != 0 && rightX != 0 && rightY != 0) {
			    
			    stroke(0);  // Color rojo
			    line(leftX, leftY, rightX, rightY); // Línea horizontal
			
			  }
	
	}
	
	public void mousePressed() {
		  if (mouseButton == LEFT) {
		    
		    leftX = mouseX;
		    leftY = mouseY;
		  } else if (mouseButton == RIGHT) {
		    
		    rightX = mouseX;
		    rightY = mouseY;
		  }
		}
	
	@Override
	public void exit() {
		
		noLoop();

	}
}