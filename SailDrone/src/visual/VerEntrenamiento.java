package visual;

import processing.core.PApplet;

public class VerEntrenamiento extends PApplet {

	int generacion = 0;
	int startTime;
	int numAgentes;

	float[] fitness;
	double maxFitness = Double.MAX_VALUE;
	int maxHistory = 300;
	int[] history;

	public VerEntrenamiento(int numAgentes) {

		this.numAgentes = numAgentes;
	}

	public void updateGeneracion(int generacion) {

		this.generacion = generacion;
	}

	public void addFitness(double fitness, int indice) {

		this.fitness[indice] = (float) fitness;
	}

	public void setup() {

		fitness = new float[numAgentes];
		history = new int[maxHistory];
		startTime = millis();
		frameRate(30);
	}

	public void settings() {

		size(800, 400);
	}

	public void draw() {

		background(255);

		float sumFitness = 0;
		int simulados = 0;
		
		for (int i = 0; i < numAgentes; i++) {

			if (fitness[i] != 0) {
				
				simulados++;
				sumFitness += fitness[i];

			}

		}

		float averageFitness=0;
		
		if(simulados!=0) {
			averageFitness = sumFitness / simulados;
		}
		//float averageFitness = sumFitness / simulados;

		// Agregar el promedio de fitness al historial
		if (generacion < maxHistory) {
			history[generacion] = (int) map(averageFitness, 0,(int) maxFitness, 100, 0); // Mapear el fitness a un porcentaje
																					// entre 100 y 0
		} else {
			for (int i = 1; i < maxHistory; i++) {
				history[i - 1] = history[i];
			}
			history[maxHistory - 1] = (int) (map(averageFitness, 0, (int)maxFitness, 100, 0));
		}

		// generacion++;

		// Dibujar la gráfica del historial de fitness
		stroke(255,0,0);
		noFill();
		beginShape();
		
		for (int i = 0; i < min(generacion, maxHistory); i++) {
			
			float x = map(i, 0, maxHistory, 50, width - 50); // Ajustar el rango de X para dejar espacio para los ejes
			float y = map(history[i], 0, 100, height - 50, 50); // Mapear el porcentaje a la altura de la ventana
			vertex(x, y);
			
		}
		
		endShape();

		// Dibujar ejes
		stroke(0);
		line(50, height - 50, width - 50, height - 50); // Eje X
		line(50, height - 50, 50, 50); // Eje Y

		int inicio = 50;
		for (int i = 0; i < 10; i++) {

			inicio += 30;
			line(50, height - inicio, width - 50, height - inicio); // Eje X

		}

		// Mostrar etiquetas de ejes
		fill(0);
		textAlign(RIGHT, CENTER);
		text("0%", 40, height - 50);
		text("100%", 40, 50);
		textAlign(CENTER, TOP);
		text("Time (minutes)", width / 2, height - 20);

		// Mostrar la generación actual y el promedio de fitness
		textAlign(LEFT, TOP);
		text("Generation: " + generacion, 10, 10);
		text("Average Fitness: " + nf(averageFitness, 0, 2), 10, 30);
	}

	@Override
	public void exit() {

		noLoop();

	}

}