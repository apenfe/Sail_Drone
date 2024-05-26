import clases.Entradas;
import clases.Simulacion;

public class Principal{
	
	/*
	 * ENTORNO GRAFICO
	 * AÑADIR GRAFICAS DE ENTRENAMIENTO Y VISUALIZACION DE AGENTES
	 * AÑADIR MEJORAS AL ENTORNO
	 * LIMITACION DE PASOS EN EJECUCION, VISUALIZAR DATOS DURANTE SIMULACION
	 * HACER FUNCION FITNES BUENA, BUSCAR FORMA DE ESTANDARIZAR
	 * MEJORAR CRUCE
	 * AÑADIR ENTORNOS COMPLEJOS
	 * REVISAR EXCEPCIONES
	 * MEJORAS EN REPRESENTACION DE AGENTES, FORMA Y COLORES DE GANADORES Y LOS MAS FITNES/ ELITE
	 * VISUALIZACION DE RED NEURONAL EN FUNCIONAMIENTO, GAMAS DE COLORES EN ENTRADAS Y SALIDAS
	 * AÑADIR ID A AGENTE EN VISUAL Y CODIGO.
	 * ENTRENAMIENTOS CON POSIBILIDAD DE USAR POSICIONES ALEATORIAS Y ESPECIFICAR RANGOS DE AREA MAXIMA
	 * AÑADIR MULTIHILO EN PRUEBAS DE ADN Y RANDOM POSTERIORMENTE EN ENTRENAMIENTOS
	 * AÑADIR PROFUNDIDADES SEGUN COLOR DEL AGUA
	 * AÑADIR SENSORES DE DIRECCION A SALIDA
	 * AÑADIR SENSOR DE PROFUNDIDAD
	 * SIMPLIFICAR CLASE AGENTE
	 * EVITAR BORRADO DE TRAYECTORIAS EN REPRESENTACION O BIEN GUARGAR AUTOMATICAMENTE VIDEO
	 */
	
	public static Simulacion simulacionActual;
	
	public static void main(String[] args) {
		
		menuPrincipal();
		
	}
	
	public static void menuPrincipal() {
		
		do {
			
			System.out.println("\n--- SIMULACION COLREG IA ---");
			System.out.println("1 ---> CARGAR RED Y ENTORNO");
			System.out.println("2 ---> CREAR NUEVA RED Y ENTORNO");
			System.out.println("3 ---> ENTRENAR_RED_DESDE_CERO");
			System.out.println("4 ---> PRUEBA RAPIDA AGENTES_RANDOM");
			System.out.println("5 ---> VER DATOS RED ACTUAL");
			System.out.println("6 ---> PRUEBA RAPIDA AGENTES_ADN");
			System.out.println("7 ---> CONTINUAR ENTRENANDO RED");
			System.out.println("0 ---> SALIR");
			int opcion = Entradas.entero("SELECCIONE UNA OPCION [0-7]: ");
			
			if(opcion == 1) {
				
				cargarSimulacion();
				
			}else if(opcion == 2) {
				
				crearSimulacion();
				
			}else if(opcion == 3) {
				
				if(simulacionActual==null) {
					System.err.println("\nDebe cargar o crear una simulacion");
				}else {
					entrenamiento();
				}
				
			}else if(opcion == 4) {
				
				if(simulacionActual==null) {
					System.err.println("\nDebe cargar o crear una simulacion");
				}else {
					
					pruebaRapida();
				}
				
			}else if(opcion == 5) {
				
				if(simulacionActual==null) {
					System.err.println("\nDebe cargar o crear una simulacion");
				}else {
					
					verSimulacion();
				}
				
			}else if(opcion == 6) {
				
				if(simulacionActual==null) {
					System.err.println("\nDebe cargar o crear una simulacion");
				}else {
					
					pruebaRapidaADN();
				}
				
			}else if(opcion == 7) {
				
				if(simulacionActual==null) {
					System.err.println("\nDebe cargar o crear una simulacion");
				}else {
					
					continuarEntrenamiento();
				}
				
			}else if(opcion == 0) {
				
				System.err.println("\nSaliendo del programa...");
				return;
				
			}else {
				
				System.err.println("\nSeleccione una opción entre [0-4]");
				
			}
			
		}while(true);
		
	}
	
	public static void verSimulacion() {
		
		System.out.println(simulacionActual.toString());
		
	}
	
	public static void cargarSimulacion() {
		
		simulacionActual= new Simulacion();
		
		String nombreRed = Entradas.texto("Inserte el nombre de la red a cargar: ");
		
		if(simulacionActual.cargarRed(nombreRed)) {
			System.out.println("Red cargada correctamente");
		}else {
			System.out.println("Error al cargar la red");
		}
		
		String nombreEntorno = Entradas.texto("Inserte el nombre del entorno a cargar: ");
		
		if(simulacionActual.cargarEntorno(nombreEntorno)) {
			
			System.out.println("Entorno cargado correctamente");
			
		}else {
			
			System.out.println("Error al cargar el entorno");
		}
		
		String nombreMapa = Entradas.texto("Inserte el nombre del mapa: ");
		
		simulacionActual.getEntorno().setCarta("mapas\\"+nombreMapa+".png");
		
	}
	
	public static void crearSimulacion() {
		
		boolean entorno=false;
		
		String respuesta = Entradas.texto("¿Desea crear un entorno? S - SI ");
		
		if(respuesta.equalsIgnoreCase("S")) {
			
			entorno=true;
			
		}
		
		simulacionActual= new Simulacion(entorno);
		
		if(entorno) {
			
			respuesta = Entradas.texto("¿Desea guardar el entorno? S - SI ");
			
			if(respuesta.equalsIgnoreCase("S")) {
				
				if(simulacionActual.getEntorno().guardarEntorno()) {
					System.out.println("ENTORNO GUARDADO");
				}else {
					System.err.println("ERROR AL GUARDAR ENTORNO");
				}	
				
			}
			
		}
		
		respuesta = Entradas.texto("¿Desea guardar la red neuronal? S - SI ");
		
		if(respuesta.equalsIgnoreCase("S")) {
			
			if(simulacionActual.getRed().guardarRed()) {
				System.out.println("RED GUARDADA");
			}else {
				System.err.println("ERROR AL GUARDAR RED");
			}	
			
		}
		
	}
	
	public static void entrenamiento() {
		
		simulacionActual.entrenarDesdeCeroAlgoritmogenetico();
	
	}
	
	public static void pruebaRapida() {
		
		simulacionActual.probarRandom();
	
	}
	
	public static void pruebaRapidaADN() {
		
		simulacionActual.probarADN();
	
	}
	
	public static void continuarEntrenamiento() {
		
		simulacionActual.continuarEntrenamiento();
	
	}
	
}