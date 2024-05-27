package visual;

import processing.core.PApplet;

public class VerRed extends PApplet {
	
	NeuralNetwork nn;
/*
	void setup() {
	  size(800, 400);
	  nn = new NeuralNetwork();
	  nn.setupNeuralNetwork();
	}

	void draw() {
	  background(255);
	  nn.updateNeuralNetwork();
	  nn.drawNeuralNetwork();
	}
*/
	class NeuralNetwork {
	  int[] layers = {3, 5, 4, 2}; // Número de neuronas en cada capa
	  float nodeSize = 20; // Tamaño de los nodos
	  float layerSpacing;
	  float nodeSpacing;
	  float[][] nodeActivation; // Activación de las neuronas
	  float[][][] synapticStrength; // Fuerza de las conexiones sinápticas

	  void setupNeuralNetwork() {
	    layerSpacing = width / (layers.length + 1);
	    nodeSpacing = height / (maxNeuronsInLayer() + 1);
	    // Inicializar matrices de activación y fuerza sináptica
	    nodeActivation = new float[layers.length][];
	    synapticStrength = new float[layers.length - 1][][];
	    for (int i = 0; i < layers.length; i++) {
	      nodeActivation[i] = new float[layers[i]];
	    }
	    for (int i = 0; i < layers.length - 1; i++) {
	      synapticStrength[i] = new float[layers[i]][layers[i + 1]];
	    }
	  }

	  void updateNeuralNetwork() {
	    // Simular datos de entrada aleatorios
	    for (int i = 0; i < layers[0]; i++) {
	      nodeActivation[0][i] = random(0, 1);
	    }
	    // Simular fuerza sináptica aleatoria
	    for (int i = 0; i < layers.length - 1; i++) {
	      for (int j = 0; j < layers[i]; j++) {
	        for (int k = 0; k < layers[i + 1]; k++) {
	          synapticStrength[i][j][k] = random(0, 1);
	        }
	      }
	    }
	  }

	  void drawNeuralNetwork() {
	    for (int i = 0; i < layers.length; i++) {
	      float x = (i + 1) * layerSpacing;
	      for (int j = 0; j < layers[i]; j++) {
	        float y = (j + 1) * nodeSpacing;
	        float activation = nodeActivation[i][j];
	        drawNode(x, y, activation, i);
	        if (i < layers.length - 1) {
	          for (int k = 0; k < layers[i + 1]; k++) {
	            float nextX = (i + 2) * layerSpacing;
	            float nextY = (k + 1) * nodeSpacing;
	            float strength = synapticStrength[i][j][k];
	            drawConnection(x, y, nextX, nextY, strength);
	          }
	        } else {
	          // Si es la última capa, agregar valor numérico de salida
	          textSize(14);
	          fill(0);
	          textAlign(CENTER, CENTER);
	          text(nf(activation, 1, 2), x, y);
	        }
	      }
	    }
	  }

	  void drawNode(float x, float y, float activation, int layerIndex) {
	    float size = map(activation, 0, 1, nodeSize / 2, nodeSize);
	    if (layerIndex == 0) {
	      fill(0, 0, 255); // Capa de entrada: Azul
	    } else if (layerIndex == layers.length - 1) {
	      fill(255, 0, 0); // Capa de salida: Rojo
	    } else {
	      fill(0, 255, 0); // Capas ocultas: Verde
	    }
	    ellipse(x, y, size, size);
	  }

	  void drawConnection(float x1, float y1, float x2, float y2, float strength) {
	    float thickness = map(strength, 0, 1, 1, 5); // Grosor de la conexión
	    float colorValue = map(strength, 0, 1, 0, 255); // Valor de color
	    stroke(colorValue, 150, 150); // Cambiar color basado en la fuerza de conexión
	    strokeWeight(thickness); // Cambiar grosor basado en la fuerza de conexión
	    line(x1, y1, x2, y2);
	  }

	  int maxNeuronsInLayer() {
	    int maxNeurons = 0;
	    for (int i = 0; i < layers.length; i++) {
	      if (layers[i] > maxNeurons) {
	        maxNeurons = layers[i];
	      }
	    }
	    return maxNeurons;
	  }
	}
	
	
	
	@Override
	public void exit() {
		
		noLoop();

	}
}
