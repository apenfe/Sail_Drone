package agente;

import java.util.ArrayList;
import entorno.Entorno;

public class Barco{
	
	private int id;
	private double[] cromosomas = new double[0];
	private Entorno entorno;
	
	private double fitness = -1;
	private int sensorChoque;
	private double pasos;
	private final double HORIZONTE = 15;
	private double x;
	private double y;
	private ArrayList<Double[]> camino = new ArrayList<>();
	private double direccion;
	
	
	public ArrayList<Double[]> getCamino() {
		return camino;
	}

	public void setCamino(ArrayList<Double[]> camino) {
		this.camino = camino;
	}

	public Barco(int id, Entorno entorno) {
		
		this.id = id;
		this.entorno = entorno;
		this.x = entorno.getEntradaX();
		this.y = entorno.getEntradaX();
		this.direccion = Math.random()*360;
		//this.direccion = 42;
		
		Double[] posicion= new Double[2];
		posicion[0]=x;
		posicion[1]=y;
		camino.add(posicion);
		pasos++;
		
	}
	
	public void acciones(double[] movimientos) { // que pasa si recibo 1 -1 o 0 1??
		
		double max = Double.MIN_VALUE;
		
		for (int i = 0; i < movimientos.length; i++) {
			
			if(movimientos[i]>max) {
				max=movimientos[i];
			}
			
		}
		
		if(movimientos[0]==max) {
			
			girarDerecha();
			avanzar();
			
		}else if(movimientos[2]==max){
			
			girarIzquierda();
			avanzar();
			
		}else {
			
			avanzar();
			
		}
		
		fin();
		
	}
	
	private void avanzar() {

		double anguloRadianes = Math.toRadians(direccion);

		x = x + entorno.getPaso() * Math.cos(anguloRadianes);
		y = y + entorno.getPaso() * Math.sin(anguloRadianes);
		pasos++;
		
		Double[] posicion= new Double[2];
		posicion[0]=x;
		posicion[1]=y;
		
		camino.add(posicion);

	}
	
	private void girarDerecha() {
		
		this.direccion=obtenerAngulo(entorno.getPaso()*9);
		Double[] posicion= new Double[2];
		posicion[0]=x;
		posicion[1]=y;
		
		camino.add(posicion);
		this.pasos++;
	}
	
	private void girarIzquierda() {
		
		this.direccion=obtenerAngulo(-9*(entorno.getPaso()));
		Double[] posicion= new Double[2];
		posicion[0]=x;
		posicion[1]=y;
		
		camino.add(posicion);
		this.pasos++;
	}

	public double[] sensores() {
		
		double[] sensor = new double[13];
		
		sensor[0] = delante();
		sensor[1] = costado_izquierdo();
		sensor[2] = costado_derecho();
		sensor[3] = amura_izquierda();
		sensor[4] = amura_derecha();
		sensor[5] = distanciaAsalida();
		sensor[6] = distanciaAentrada();
		sensor[7] = direccionActual();
		sensor[8] = seccion_derecha();
		sensor[9] = seccion_izquierda();
		sensor[10] = seccion_frontal();
		sensor[11] = posY();
		sensor[12] = posX();

		return sensor;

	}
	
	private int delante() {

		// Convertir el ángulo a radianes
		double anguloRadianes = Math.toRadians(obtenerAngulo(0));

		// Calcular las coordenadas del punto extremo
		double xExtremo = x + HORIZONTE * Math.cos(anguloRadianes);
		double yExtremo = y + HORIZONTE * Math.sin(anguloRadianes);
		
		if(entorno.fueraLimites(xExtremo, yExtremo)) {
			this.sensorChoque++;
			return 1;
		}else {
			return -1;
		}

	}

	private int costado_izquierdo() {

		// Convertir el ángulo a radianes
		double anguloRadianes = Math.toRadians(obtenerAngulo(-90));

		// Calcular las coordenadas del punto extremo
		double xExtremo = x + HORIZONTE * Math.cos(anguloRadianes);
		double yExtremo = y + HORIZONTE * Math.sin(anguloRadianes);
		
		if(entorno.fueraLimites(xExtremo, yExtremo)) {
			this.sensorChoque++;
			return 1;
			
		}else {
			return -1;
		}

	}

	private int costado_derecho() {

		// Convertir el ángulo a radianes
		double anguloRadianes = Math.toRadians(obtenerAngulo(90));

		// Calcular las coordenadas del punto extremo
		double xExtremo = x + HORIZONTE * Math.cos(anguloRadianes);
		double yExtremo = y + HORIZONTE * Math.sin(anguloRadianes);
		
		if(entorno.fueraLimites(xExtremo, yExtremo)) {
			this.sensorChoque++;
			return 1;
		}else {
			return -1;
		}

	}

	private int amura_izquierda() {

		// Convertir el ángulo a radianes
		double anguloRadianes = Math.toRadians(obtenerAngulo(-45));

		// Calcular las coordenadas del punto extremo
		double xExtremo = x + HORIZONTE * Math.cos(anguloRadianes);
		double yExtremo = y + HORIZONTE * Math.sin(anguloRadianes);
		
		if(entorno.fueraLimites(xExtremo, yExtremo)) {
			this.sensorChoque++;
			return 1;
		}else {
			return -1;
		}

	}

	private int amura_derecha() {

		// Convertir el ángulo a radianes
		double anguloRadianes = Math.toRadians(obtenerAngulo(45));

		// Calcular las coordenadas del punto extremo
		double xExtremo = x + HORIZONTE * Math.cos(anguloRadianes);
		double yExtremo = y + HORIZONTE * Math.sin(anguloRadianes);
		
		if(entorno.fueraLimites(xExtremo, yExtremo)) {
			this.sensorChoque++;
			return 1;
		}else {
			return -1;
		}

	}
	
	private int seccion_derecha() {

		if(amura_derecha()==1&&costado_derecho()==1) {
			return 1;
		}else {
			return -1;
		}

	}
	
	private int seccion_izquierda() {

		if(amura_izquierda()==1&&costado_izquierdo()==1) {
			return 1;
		}else {
			return -1;
		}

	}
	
	private int seccion_frontal() {

		if(amura_izquierda()==1&&amura_derecha()==1&&delante()==1) {
			return 1;
		}else {
			return -1;
		}

	}

	private double distanciaAsalida() {
		
		double distMin=0;
		double distMax = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		double distancia = entorno.distanciaSalida(x, y);
		
		return normalizar(distancia,distMin,distMax);

	}
	
	private double direccionActual() {
		
		return normalizar(direccion,0,360);

	}
	
	private double distanciaAentrada() {
		
		double distMin=0;
		double distMax = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		double distancia = entorno.distanciaEntrada(x, y);
		
		return normalizar(distancia,distMin,distMax);

	}
	
	private double posX() {
		
		return normalizar(x,0,entorno.getAncho());

	}
	
	private double posY() {
		
		return normalizar(y,0,entorno.getAlto());

	}	
	
	public double normalizar(double value, double min, double max) {
        // Normalizar el valor dentro del rango [0, 1]
        double normalizedValue = (value - min) / (max - min);
        
        // Normalizar el valor dentro del rango [-1, 1]
        normalizedValue = normalizedValue * 2 - 1;
        
        return normalizedValue;
    }
	
	public void calculateFitness() {
        
        double distanciaSalida = entorno.distanciaSalida(x, y)*12;
        double penalizacionChoque = sensorChoque*2;
        double stepPenalty = pasos;

        double premioLlegada = 0;
      
        if (entorno.esSalida(x, y)) {
            premioLlegada = 1000000;
        }

        fitness = distanciaSalida - penalizacionChoque - stepPenalty + premioLlegada;
        
    }
	
 	private double obtenerAngulo(double grados) {

		double angulo = direccion + grados;
	    
	    angulo = (angulo % 360 + 360) % 360;
	    
	    return angulo;
		
	}
	
	public boolean fin() {
		
		if(entorno.esSalida(x, y)) {
			//puntos+=20000;
			return true;
		}
		
		if(entorno.fueraLimites(x, y)) {
			//puntos-=10000;
			return true;
		}
		
		return false;
		
	}
	
	public boolean win() {
		
		if(entorno.esSalida(x, y)) {
			//puntos+=20000;
			return true;
		}
		
		return false;
		
	}
	
	public boolean lose() {
		
		if(entorno.fueraLimites(x, y)) {
			//puntos-=10000;
			return true;
		}
		
		return false;
		
	}

	public double getPuntos() {
		return fitness;
	}

	public void setPuntos(double puntos) {
		this.fitness = puntos;
	}

	public double[] getAdn() {
		return cromosomas;
	}

	public void setAdn(double[] cromosomas) {
		this.cromosomas = cromosomas;
	}
		
	public float[][] caminoFloat() {
		
		int numRows = camino.size();
        float[][] resultado = new float[numRows][];

        for (int i = 0; i < numRows; i++) {
            Double[] fila = camino.get(i);
            int numCols = fila.length;
            resultado[i] = new float[numCols];

            for (int j = 0; j < numCols; j++) {
                resultado[i][j] = fila[j].floatValue();
            }
        }
        
        return resultado;
	    
	}

	public double getPasos() {
		return pasos;
	}

	public void setPasos(double pasos) {
		this.pasos = pasos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}