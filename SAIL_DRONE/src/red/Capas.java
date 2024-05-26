package red;

import java.util.Arrays;

public class Capas {

	private int numNeuronas;
	private int numNeuronasCapaAnterior;
	private int funcion;
	private Perceptron[] perceptrones = new Perceptron[0];
	
	public Capas(int numeroNeuronas, int funcion, int numNeuronasCapaAnterior) {
		
		this.numNeuronasCapaAnterior=numNeuronasCapaAnterior;
		this.funcion=funcion;
		this.numNeuronas = numeroNeuronas;
		this.perceptrones = new Perceptron[numeroNeuronas];

		for (int i = 0; i < numeroNeuronas; i++) { // -1?

			this.perceptrones[i] = new Perceptron(funcion, this.numNeuronasCapaAnterior); 
															
		}

	}
	
	public Capas(int numeroNeuronas, double[] bias, int funcion, double[] pesosDeLaCapa) {
		
		this.numNeuronasCapaAnterior=pesosDeLaCapa.length/numeroNeuronas;
		this.funcion=funcion;
		this.numNeuronas = numeroNeuronas;
		this.perceptrones = new Perceptron[numeroNeuronas];

		for (int i = 0; i < numeroNeuronas; i++) {

			this.perceptrones[i] = new Perceptron(funcion, this.numNeuronasCapaAnterior); 
															
		}
		
		this.establecerPesosNeuronas(pesosDeLaCapa);
		this.establecerBiasNeuronas(bias);

	}

	public double[] probarCapa(double[] entradas) {
		
		double[] exit = new double[this.numNeuronas];

		for (int i = 0; i < this.numNeuronas; i++) {

			exit[i] = perceptrones[i].probar(entradas);

		}

		return exit;

	}
	
	public void actualizarCapa(double[] pesosDeLaCapa, double[] bias) {
		
		this.establecerPesosNeuronas(pesosDeLaCapa);
		this.establecerBiasNeuronas(bias);
		
	}
	
	public double[] obtenerDatosCapa(boolean dato) {
		
		double[] salida = new double[0];
		
		if(dato) {
			
	        salida = new double[numNeuronas * perceptrones[0].getEntradas()];
			
			int index = 0;
			
	        for (int i = 0; i < perceptrones.length; i++) {
	        	
	            double[] pesos = perceptrones[i].getPesosSinapticos();
	            
	            for (int j = 0; j < pesos.length; j++) {
	            	
	                salida[index++] = pesos[j];
	                
	            }
	            
	        }
			
		}else {
			
			salida = new double[this.numNeuronas];
			
			for (int i = 0; i < perceptrones.length; i++) {
				
				salida[i]=perceptrones[i].getBias();
				
			}
			
		}
		
		return salida;
		
	}
	
	private void establecerPesosNeuronas(double[] pesosDeLaCapa) {
		
		int pesosPorNeurona = pesosDeLaCapa.length/this.numNeuronas;
		
		for (int i = 0; i < this.numNeuronas; i++) {
			
			int inicio = i * pesosPorNeurona;
	        int fin = (i + 1) * pesosPorNeurona;
			this.perceptrones[i].setPesosSinapticos(Arrays.copyOfRange(pesosDeLaCapa,inicio,fin));
			
		}
		
	}
	
	private void establecerBiasNeuronas(double[] bias) {
		
		for (int i = 0; i < this.numNeuronas; i++) {
			
			this.perceptrones[i].setBias(bias[i]);
			
		}
		
	}

	public Perceptron[] getPerceptrones() {
		
		return this.perceptrones;
		
	}

	public void setPerceptrones(Perceptron[] perceptrones) {
		
		this.perceptrones = perceptrones;
		
	}

	public int getNumNeuronas() {
		
		return this.numNeuronas;
		
	}

	public void setNumNeuronas(int numNeuronas) {
		
		this.numNeuronas = numNeuronas;
		
	}

	public int getNumNeuronasCapaAnterior() {
		return numNeuronasCapaAnterior;
	}

	public void setNumNeuronasCapaAnterior(int numNeuronasCapaAnterior) {
		this.numNeuronasCapaAnterior = numNeuronasCapaAnterior;
	}

	public int getFuncion() {
		return funcion;
	}

	public void setFuncion(int funcion) {
		this.funcion = funcion;
	}
	
}