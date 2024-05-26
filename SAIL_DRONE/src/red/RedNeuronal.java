package red;

import java.util.ArrayList;
import java.util.Arrays;

import agente.Agente;
import clases.DAO;
import ga.Poblacion;

public class RedNeuronal{
	
	private String nombre;
	private int entradas;
	private int salidas;
	private int numCapas;
	private int numNeuronas;
	private Capas[] capas = new Capas[0];
	
	public RedNeuronal(String nombre_simulacion, int numeroCapas, int[] numeroNeuronas, int[] funcion) {
		
		this.entradas=numeroNeuronas[0];
		this.salidas=numeroNeuronas[numeroNeuronas.length-1];
		this.numCapas=numeroCapas;
		this.nombre=nombre_simulacion;
		this.capas = new Capas[numeroCapas];
		
		for (int i = 0; i < capas.length; i++) {
			
			if(i==0) {
				capas[i]= new Capas(numeroNeuronas[i], funcion[i], this.entradas); 
			}else {
				capas[i]= new Capas(numeroNeuronas[i], funcion[i], capas[i-1].getNumNeuronas()); 
			}
			
		}
		
		this.numNeuronas = getNumNeuronas();
		
	}
	
	public RedNeuronal() {
		
	}
	
	private double[] probarRedV2(double[] entradas) {
		
		double[] anterioresentradas = entradas;
	    
	    for (int i = 0; i < capas.length; i++) {
	        anterioresentradas = capas[i].probarCapa(anterioresentradas);
	    }
	    
	    return anterioresentradas;

	}
	
	private int getNumNeuronas() {
		
		int neuronas = 0;
		
		for (int i = 0; i < capas.length; i++) {
			
			neuronas += capas[i].getNumNeuronas();
			
		}
		
		return neuronas;
		
	}
	
	// -----------------------------------  METODOS PARA METER Y SACR GENES --------------------------------------------------------------------
	
	public double[] getParametros() {
		
		ArrayList<Double> pesos = new ArrayList<Double>();
		ArrayList<Double> bias = new ArrayList<Double>();
		
		for (int i = 0; i < capas.length; i++) {
			
			double[] actualBias = capas[i].obtenerDatosCapa(false);
			double[] actualPesos = capas[i].obtenerDatosCapa(true);
			
			for (int j = 0; j < actualPesos.length; j++) {
				
				pesos.add(actualPesos[j]);
				
			}
			
			for (int j = 0; j < actualBias.length; j++) {
				
				bias.add(actualBias[j]);
				
			}
			
		}
		
		ArrayList<Double> total = new ArrayList<Double>();
		
		for (int j = 0; j < pesos.size(); j++) {
			
			total.add(pesos.get(j));
			
		}
		
		for (int j = 0; j < bias.size(); j++) {
			
			total.add(bias.get(j));
			
		}
		
		double[] salida = new double[total.size()];
		
		for (int i = 0; i < salida.length; i++) {
			
			salida[i]=total.get(i).doubleValue();
			
		}
		
		return salida;

	}
	
	public void setParametros(double[] parametros) {
		
		double[] pesosSinapticos = separarBiasPesos(true,parametros);
		double[] bias = separarBiasPesos(false,parametros);
		
		int item1 = -1;
		int item2 = -1;
		double[] pesosParaCapa;
		double[] biasParaCapa;
		
		for (int i = 0; i < capas.length; i++) {
			
			if(i==0) {
				
				pesosParaCapa = new double[this.entradas*capas[i].getNumNeuronas()];
				biasParaCapa = new double[capas[i].getNumNeuronas()];
				
			}else {
				
				pesosParaCapa = new double[capas[i-1].getNumNeuronas()*(capas[i].getNumNeuronas())];
				biasParaCapa = new double[capas[i].getNumNeuronas()];
				
			}
			
			for (int j = 0; j < pesosParaCapa.length; j++) {
				
				item1++;
				pesosParaCapa[j]=pesosSinapticos[item1];
				
			}
			
			for (int j = 0; j < biasParaCapa.length; j++) {
				
				item2++;
				biasParaCapa[j]=bias[item2];
				
			}
			
			capas[i].actualizarCapa(pesosParaCapa,biasParaCapa);
			
		}
		
	}
	
	private double[] separarBiasPesos(boolean pesos, double[] datos) {
		
		if(pesos) {
			
			double[] pesosSinapticos = new double[(datos.length)-this.numNeuronas];
			
			for (int i = 0; i < pesosSinapticos.length; i++) {
				
				pesosSinapticos[i]=datos[i];
				
			}
			
			return pesosSinapticos;
			
		}else {
			
			double[] bias = new double[this.numNeuronas];
			
			for (int i = 0; i < this.numNeuronas; i++) {
				
	            bias[i] = datos[datos.length - this.numNeuronas + i];
	            
	        }
			
			return bias;
			
		}
		
	}

	@Override
	public String toString() {
		return "RedNeuronal [nombre=" + nombre + ", entradas=" + entradas + ", salidas=" + salidas + ", numCapas="
				+ numCapas + ", numNeuronas=" + numNeuronas + ", capas=" + Arrays.toString(capas) + "]";
	}
	
	public boolean guardarRed() {
		
		DAO db = new DAO();
		
		return db.guardarRed(this);
		
	}
	
	public void probarPoblacion(Poblacion poblacion) {
		
		for (int i = 0; i < poblacion.size(); i++) {
			
			this.setParametros(poblacion.getIndividual(i).getCromosomas());
			
			do {

				poblacion.getIndividual(i).acciones(this.probarRedV2(poblacion.getIndividual(i).sensores()));

				if (poblacion.getIndividual(i).win() || poblacion.getIndividual(i).lose() || poblacion.getIndividual(i).getPasos() > poblacion.getIndividual(i).getMaxPasos()) {
					
					if(poblacion.getIndividual(i).win()) {
						System.err.print("-");
					}else {
						System.out.print("-");
					}
					
					break;
				}

			} while (true);
			
		}
	}
	
	public void probarPoblacion(Agente[] agentes) {
		
		for (int i = 0; i < agentes.length; i++) {
			
			this.setParametros(agentes[i].getCromosomas());
			
			do {

				agentes[i].acciones(this.probarRedV2(agentes[i].sensores()));

				if (agentes[i].win() || agentes[i].lose() || agentes[i].getPasos() > agentes[i].getMaxPasos()) {
					
					if(agentes[i].win()) {
						System.err.print("-");
					}else {
						System.out.print("-");
					}
					
					break;
				}

			} while (true);
			
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEntradas() {
		return entradas;
	}

	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}

	public int getSalidas() {
		return salidas;
	}

	public void setSalidas(int salidas) {
		this.salidas = salidas;
	}

	public int getNumCapas() {
		return numCapas;
	}

	public void setNumCapas(int numCapas) {
		this.numCapas = numCapas;
	}

	public Capas[] getCapas() {
		return capas;
	}

	public void setCapas(Capas[] capas) {
		this.capas = capas;
	}

	public void setNumNeuronas(int numNeuronas) {
		this.numNeuronas = numNeuronas;
	}
		
}