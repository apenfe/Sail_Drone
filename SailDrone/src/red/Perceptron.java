package red;

public class Perceptron {
	
	private double bias;
	private int funcion;
	private double[] pesosSinapticos = new double[0];
	private int entradas;
	
	public Perceptron(int funcion, int entradas) {
		
		this.entradas = entradas;
		this.funcion = funcion;
		this.bias = 0;
		this.pesosSinapticos = new double[this.entradas];
		
		for (int i = 0; i < this.entradas; i++) {
		
			this.pesosSinapticos[i] = Math.random() * 11 - 5;	
				
		}
		
	}
	
	public double calcularNeta(double[] entradas) {
		
		double neta = 0;
		
		for (int i = 0; i < entradas.length; i++) {
			
			neta += entradas[i] * this.pesosSinapticos[i];
			
		}
		
		neta += bias;
		
		return neta;
		
	}

	public double activate(double neta) {
		
		if(this.funcion==0) {
			
			return (neta >= 0) ? 1.0 : -1.0; // Funcion signo {-1,1}

		}else if(this.funcion==1){
			
			return neta; // Funcion Adaline
			
		}else if(this.funcion==2){
			
			return (neta >= 0) ? 0 : 1; // Funcion escalon {0,1}
			
		}else if(this.funcion==3){
			
			return (1/(1+Math.pow(Math.E, -neta))); // Funcion Sigmoide
			
		}else if(this.funcion==4){
			
			return ((Math.pow(Math.E, neta)-Math.pow(Math.E, -neta))/(Math.pow(Math.E, neta)+Math.pow(Math.E, -neta))); // Funcion Tangente Hiperbolica
			
		}else if(this.funcion==5){ // FUNCION RELU
			
			if(neta<0) {
				return 0;
			}else {
				return neta;
			}
			
		}else if(this.funcion==6){ // FUNCION LEAKY RELU
			
			if(neta<0) {
				return 0.1*neta;
			}else {
				return neta;
			}
			
		}else {
			
			return 0.0;
			
		}
		
	}
	
	public double probar(double[] entradas) {
	
		double neta = calcularNeta(entradas);
		return activate(neta);
		
	}

	public double[] getPesosSinapticos() {
		return pesosSinapticos;
	}

	public void setPesosSinapticos(double[] pesosSinapticos) {
		this.pesosSinapticos = pesosSinapticos;
	}

	public int getFuncion() {
		return funcion;
	}

	public void setFuncion(int funcion) {
		this.funcion = funcion;
	}

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}

	public int getEntradas() {
		return entradas;
	}

	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	
}