package ga;

import java.util.Arrays;
import java.util.Comparator;

import agente.Agente;
import entorno.Entorno;

public class Poblacion {
	
	private Agente poblacion[];
	private double fitnessPoblacion = -1;

	public Poblacion(int numeroIndividuos) {
		
		this.poblacion = new Agente[numeroIndividuos];
		
	}

	public Poblacion(int tamanoPoblacion, int numeroCromosomas,Entorno entorno) {
		
		this.poblacion = new Agente[tamanoPoblacion];
		
		for (int i = 0; i < tamanoPoblacion; i++) {
			
			Agente agente = new Agente(numeroCromosomas,entorno);
			this.poblacion[i] = agente;
			
		}
		
	}

	public Agente[] getIndividuals() {
		
		return this.poblacion;
		
	}

	public Agente getFittest(int indice) {
		
		Arrays.sort(this.poblacion, new Comparator<Agente>() {
			
			@Override
			public int compare(Agente agente1, Agente agente2) {
				if (agente1.getFitness() > agente2.getFitness()) {
					return -1;
				} else if (agente1.getFitness() < agente2.getFitness()) {
					return 1;
				}
				return 0;
				
			}
			
		});
		
		return this.poblacion[indice];
		
	}

	public void setPopulationFitness(double fitness) {
		
		this.fitnessPoblacion = fitness;
		
	}

	public double getPopulationFitness() { // ver
		
		int max = poblacion.length;
		
		return (this.fitnessPoblacion/max)*100;
		
	}

	public int size() {
		
		return this.poblacion.length;
		
	}

	public Agente setIndividual(int indice, Agente agente) {
		
		return poblacion[indice] = agente;
		
	}

	public Agente getIndividual(int indice) {
		
		return poblacion[indice];
		
	}
	
}