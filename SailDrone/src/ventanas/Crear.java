package ventanas;

import javax.swing.*;

import clases.Entradas;
import clases.Simulacion;
import entorno.Entorno;
import red.RedNeuronal;

import java.awt.*;
import java.awt.event.*;

public class Crear extends JFrame implements ActionListener{
	
	private Index indice;
	private Simulacion simulacion;
	private Container contenedor;
	private JLabel icon, labelInfoRed, labelInfoEntorno, nombreEntorno, entradaX, entradaY, salidaX, salidaY, paso, area,capas, labelInfoCapas, labelInfoNeuronas, labelInfoFuncion, funcionActivacion, descripcionRed,nombreRed;
	private JTextField campoNombreEntorno, campoEntradaX, campoEntradaY, campoSalidaX, campoSalidaY, campoPaso, campoArea, campoNombreRed,campoDescripcionRed;
	private JButton crearRed, crearEntorno, volver, limpiar, cargarCapa, cargarNeuronas, cargarFuncion;
	private JLabel titulo, titulo2, titulo3;
	private JSpinner cantidadCapas, cantidadNeuronas, seleccionarFuncion;
	private int numCapas;
	private int[] numeroNeuronas = new int[0];
	private int[] funciones = new int[0];
	private int contadorNeuronas = 1, contadorFunciones = 1;
	
	public Crear(Index indice, Simulacion simulacion) {
		
		this.indice=indice;
		this.simulacion=simulacion;
		this.setTitle("___Sail Drone___");
		this.setBounds(300,80,1280,800);
		
        this.setIconImage(new ImageIcon("files\\GUI\\icono.png").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.contenedor=this.getContentPane();
		this.contenedor.setLayout(null);
		this.contenedor.setBackground(Color.black);
		
		this.titulo();
		this.labelsRed();
		this.labelsEntorno();
		this.botones();
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.crearEntorno) {
			
			this.crearEntorno();
			
		}else if(e.getSource()==this.limpiar) {
			
			this.limpiar();

		}else if(e.getSource()==this.volver) {
			
			this.volver();

		}else if(e.getSource()==this.crearRed) {
			
			this.crearRed();

		}else if(e.getSource()==this.cargarCapa) {
			
			this.addCapa();

		}else if(e.getSource()==this.cargarNeuronas) {
			
			this.addNeuronas();

		}else if(e.getSource()==this.cargarFuncion) {
			
			this.addFuncion();

		}
		
	}
	
	private void titulo() {
		
		this.titulo= new JLabel("Crear datos para simulacion");
		this.titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo.setBounds(28, 104, 379, 30);
		this.titulo.setForeground(Color.white);
		this.contenedor.add(this.titulo);
		
		this.titulo2= new JLabel("Crear nuevo entorno");
		this.titulo2.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo2.setBounds(28, 152, 379, 30);
		this.titulo2.setForeground(Color.white);
		this.contenedor.add(this.titulo2);
		
		this.titulo3= new JLabel("Crear nueva red");
		this.titulo3.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo3.setBounds(495, 152, 379, 30);
		this.titulo3.setForeground(Color.white);
		this.contenedor.add(this.titulo3);

	}
	
	private void botones() {
		
		this.crearEntorno=new JButton("Crear Entorno");
		this.crearEntorno.setFont(new Font("Arial", Font.PLAIN, 16));
		this.crearEntorno.setBounds(120,550,157,30);
		this.crearEntorno.addActionListener(this);
		this.crearEntorno.setVisible(true);
		this.crearEntorno.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.crearEntorno);
		
		this.crearRed=new JButton("Crear Red");
		this.crearRed.setFont(new Font("Arial", Font.PLAIN, 16));
		this.crearRed.setBounds(495,550,157,30);
		this.crearRed.addActionListener(this);
		this.crearRed.setVisible(true);
		this.crearRed.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.crearRed);
		
		this.limpiar=new JButton("Limpiar");
		this.limpiar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.limpiar.setBounds(207,720,157,30);
		this.limpiar.addActionListener(this);
		this.limpiar.setVisible(true);
		this.limpiar.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.limpiar);
		
		this.volver=new JButton("Volver");
		this.volver.setFont(new Font("Arial", Font.PLAIN, 16));
		this.volver.setBounds(28,720,157,30);
		this.volver.addActionListener(this);
		this.volver.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.volver);
		
		this.cargarCapa=new JButton("Cargar Capa");
		this.cargarCapa.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cargarCapa.setBounds(610,256,157,30);
		this.cargarCapa.addActionListener(this);
		this.cargarCapa.setVisible(true);
		this.cargarCapa.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cargarCapa);
		
		this.cargarNeuronas=new JButton("Cargar Neuronas");
		this.cargarNeuronas.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cargarNeuronas.setBounds(979,256,157,30);
		this.cargarNeuronas.addActionListener(this);
		this.cargarNeuronas.setVisible(true);
		this.cargarNeuronas.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cargarNeuronas);
		
		this.cargarFuncion=new JButton("Cargar Funcion");
		this.cargarFuncion.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cargarFuncion.setBounds(610,376,157,30);
		this.cargarFuncion.addActionListener(this);
		this.cargarFuncion.setVisible(true);
		this.cargarFuncion.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cargarFuncion);
		
	}

	private void labelsRed() {
		
		// capas
		this.capas = new JLabel("Numero de capas: ");
		this.capas.setForeground(new Color(255, 255, 255));
		this.capas.setFont(new Font("Arial", Font.PLAIN, 20));
		this.capas.setBounds(495, 215, 167, 30);
		this.contenedor.add(this.capas);
		
		SpinnerModel  model = new SpinnerNumberModel(1,1,20,1);
		this.cantidadCapas = new JSpinner(model);
		this.cantidadCapas.setBounds(672, 221, 95, 25);
		this.cantidadCapas.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cantidadCapas);
		
		// neuronas
		this.capas = new JLabel("Numero de Neuronas: ");
		this.capas.setForeground(new Color(255, 255, 255));
		this.capas.setFont(new Font("Arial", Font.PLAIN, 20));
		this.capas.setBounds(825, 215, 206, 30);
		this.contenedor.add(this.capas);
		
		SpinnerModel  model2 = new SpinnerNumberModel(1,1,30,1);
		this.cantidadNeuronas = new JSpinner(model2);
		this.cantidadNeuronas.setBounds(1041, 221, 95, 25);
		this.cantidadNeuronas.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cantidadNeuronas);

		JLabel lblNewLabel = new JLabel("Banner");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\banner.png"));
		lblNewLabel.setBounds(28, 11, 235, 82);
		getContentPane().add(lblNewLabel);

		// info RED
		this.labelInfoRed = new JLabel("");
		this.labelInfoRed.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoRed.setBounds(495, 509, 339, 30);
		this.contenedor.add(this.labelInfoRed);

		// info Entorno
		this.labelInfoEntorno = new JLabel("");
		this.labelInfoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoEntorno.setBounds(28, 608, 339, 30);
		this.contenedor.add(this.labelInfoEntorno);
		
		// info capas
		this.labelInfoCapas = new JLabel("");
		this.labelInfoCapas.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoCapas.setBounds(495, 297, 272, 30);
		this.contenedor.add(this.labelInfoCapas);
		
		// info neuronas
		this.labelInfoNeuronas = new JLabel("");
		this.labelInfoNeuronas.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoNeuronas.setBounds(825, 297, 311, 30);
		this.contenedor.add(this.labelInfoNeuronas);
		
		// info funcion
		this.labelInfoFuncion = new JLabel("");
		this.labelInfoFuncion.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoFuncion.setBounds(495, 415, 272, 30);
		this.contenedor.add(this.labelInfoFuncion);
		
		// funciones
		this.funcionActivacion = new JLabel("Funcion activacion: ");
		this.funcionActivacion.setForeground(new Color(255, 255, 255));
		this.funcionActivacion.setFont(new Font("Arial", Font.PLAIN, 20));
		this.funcionActivacion.setBounds(495, 335, 186, 30);
		this.contenedor.add(this.funcionActivacion);
				
		SpinnerModel  model3 = new SpinnerNumberModel(1,1,6,1);
		this.seleccionarFuncion = new JSpinner(model);
		this.seleccionarFuncion.setBounds(672, 341, 95, 25);
		this.seleccionarFuncion.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.seleccionarFuncion);
		
		// nombre red
		this.nombreRed = new JLabel("Nombre Red:");
		this.nombreRed.setForeground(new Color(255, 255, 255));
		this.nombreRed.setFont(new Font("Arial", Font.PLAIN, 20));
		this.nombreRed.setBounds(825, 338, 150, 25);
		this.contenedor.add(this.nombreRed);

		// campo nombre red
		this.campoNombreRed = new JTextField();
		this.campoNombreRed.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoNombreRed.setBounds(975, 377, 161, 30);
		this.campoNombreRed.addActionListener(this);
		this.contenedor.add(this.campoNombreRed);
		
		// nombre red
		this.descripcionRed = new JLabel("Descricion Red:");
		this.descripcionRed.setForeground(new Color(255, 255, 255));
		this.descripcionRed.setFont(new Font("Arial", Font.PLAIN, 20));
		this.descripcionRed.setBounds(825, 378, 150, 25);
		this.contenedor.add(this.descripcionRed);

		// campo nombre red
		this.campoDescripcionRed = new JTextField();
		this.campoDescripcionRed.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoDescripcionRed.setBounds(954, 337, 182, 30);
		this.campoDescripcionRed.addActionListener(this);
		this.contenedor.add(this.campoDescripcionRed);
				
	}
	
	private void labelsEntorno() {

		// nombre
		this.nombreEntorno = new JLabel("Nombre Entorno:");
		this.nombreEntorno.setForeground(new Color(255, 255, 255));
		this.nombreEntorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.nombreEntorno.setBounds(28, 215, 150, 25);
		this.contenedor.add(this.nombreEntorno);

		// campo nombre
		this.campoNombreEntorno = new JTextField();
		this.campoNombreEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoNombreEntorno.setBounds(207, 214, 200, 30);
		this.campoNombreEntorno.addActionListener(this);
		this.contenedor.add(this.campoNombreEntorno);

		// entradax
		this.entradaX = new JLabel("Entrada X:");
		this.entradaX.setForeground(new Color(255, 255, 255));
		this.entradaX.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entradaX.setBounds(28, 256, 150, 25);
		this.contenedor.add(this.entradaX);

		// campo entradax
		this.campoEntradaX = new JTextField();
		this.campoEntradaX.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntradaX.setBounds(207, 255, 200, 30);
		this.campoEntradaX.addActionListener(this);
		this.contenedor.add(this.campoEntradaX);

		// entraday
		this.entradaY = new JLabel("Entrada Y:");
		this.entradaY.setForeground(new Color(255, 255, 255));
		this.entradaY.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entradaY.setBounds(28, 297, 150, 25);
		this.contenedor.add(this.entradaY);

		// campo entraday
		this.campoEntradaY = new JTextField();
		this.campoEntradaY.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntradaY.setBounds(207, 296, 200, 30);
		this.campoEntradaY.addActionListener(this);
		this.contenedor.add(this.campoEntradaY);

		// salidax
		this.salidaX = new JLabel("Salida X:");
		this.salidaX.setForeground(new Color(255, 255, 255));
		this.salidaX.setFont(new Font("Arial", Font.PLAIN, 20));
		this.salidaX.setBounds(28, 338, 150, 25);
		this.contenedor.add(this.salidaX);

		// campo salidax
		this.campoSalidaX = new JTextField();
		this.campoSalidaX.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoSalidaX.setBounds(207, 337, 200, 30);
		this.campoSalidaX.addActionListener(this);
		this.contenedor.add(this.campoSalidaX);

		// saliday
		this.salidaY = new JLabel("Salida Y:");
		this.salidaY.setForeground(new Color(255, 255, 255));
		this.salidaY.setFont(new Font("Arial", Font.PLAIN, 20));
		this.salidaY.setBounds(28, 379, 150, 25);
		this.contenedor.add(this.salidaY);

		// campo saliday
		this.campoSalidaY = new JTextField();
		this.campoSalidaY.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoSalidaY.setBounds(207, 378, 200, 30);
		this.campoSalidaY.addActionListener(this);
		this.contenedor.add(this.campoSalidaY);

		// paso
		this.paso = new JLabel("Paso:");
		this.paso.setForeground(new Color(255, 255, 255));
		this.paso.setFont(new Font("Arial", Font.PLAIN, 20));
		this.paso.setBounds(28, 420, 150, 25);
		this.contenedor.add(this.paso);

		// campo paso
		this.campoPaso = new JTextField();
		this.campoPaso.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoPaso.setBounds(207, 419, 200, 30);
		this.campoPaso.addActionListener(this);
		this.contenedor.add(this.campoPaso);

		// area
		this.area = new JLabel("Area aproximacion:");
		this.area.setForeground(new Color(255, 255, 255));
		this.area.setFont(new Font("Arial", Font.PLAIN, 20));
		this.area.setBounds(28, 461, 200, 25);
		this.contenedor.add(this.area);

		// campo area
		this.campoArea = new JTextField();
		this.campoArea.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoArea.setBounds(207, 460, 200, 30);
		this.campoArea.addActionListener(this);
		this.contenedor.add(this.campoArea);

		// info Entorno
		this.labelInfoEntorno = new JLabel("");
		this.labelInfoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoEntorno.setBounds(28, 509, 379, 30);
		this.contenedor.add(this.labelInfoEntorno);

	}

	private void crearEntorno() {
		
		String nombre = this.campoNombreEntorno.getText().trim();
		double entradaX = Double.parseDouble(this.campoEntradaX.getText().trim());
		double entradaY =  Double.parseDouble(this.campoEntradaY.getText().trim());
		double salidaX =  Double.parseDouble(this.campoSalidaX.getText().trim());
		double salidaY =  Double.parseDouble(this.campoSalidaY.getText().trim());
		double paso =  Double.parseDouble(this.campoPaso.getText().trim());
		double areaAprox =  Double.parseDouble(this.campoArea.getText().trim());
		
		if(entradaX>1800 ||entradaY>900 ||salidaX>1800 ||salidaY>900) {
			
			this.labelInfoEntorno.setText("Las casillas de entrada y salida deben estan dentro de la ventana (1800 x 900).");
			this.labelInfoEntorno.setForeground(Color.RED);
			return;
			
		}
		
		if(nombre.length()==0 || entradaX<=0 ||entradaY<=0 ||salidaX<=0 ||salidaY<=0 ||paso<=0 ||areaAprox<=0) {
			
			this.labelInfoEntorno.setText("Todos los campos son obligatorios.");
			this.labelInfoEntorno.setForeground(Color.RED);
			return;
			
		}else {
			
			Entorno actual = new Entorno( nombre, 900,  1800,  entradaX,  entradaY,  salidaX,  salidaY,  paso,  areaAprox);
			this.simulacion.setEntorno(actual);
			
			if(actual.guardarEntorno()) {
				
				this.labelInfoEntorno.setText("Entorno creado correctamente.");
				this.labelInfoEntorno.setForeground(Color.GREEN);
				return;
				
			}else {
				
				this.labelInfoEntorno.setText("Error al guardar entorno.");
				this.labelInfoEntorno.setForeground(Color.RED);
				return;
				
			}
			
		}

	}
	
	private void crearRed() {
		
		String nombreRed = this.campoNombreRed.getText().trim();
		String descripcion = this.campoDescripcionRed.getText().trim();
		
		if(nombreRed.length()==0) {
			
			this.labelInfoRed.setText("Inserte un nombre para la red.");
			this.labelInfoRed.setForeground(Color.RED);
			return;
			
		}
		
		RedNeuronal actual = new RedNeuronal(nombreRed, funciones.length,numeroNeuronas, funciones); 
		
		this.simulacion.setRed(actual);
		
		if(actual.guardarRed(descripcion)) {
			
			this.labelInfoRed.setText("Red creada correctamente.");
			this.labelInfoRed.setForeground(Color.GREEN);
			
		}else {
			
			this.labelInfoRed.setText("Error al crear Red.");
			this.labelInfoRed.setForeground(Color.RED);
			this.cantidadCapas.setEnabled(true);
			this.cantidadNeuronas.setEnabled(true);
			this.seleccionarFuncion.setEnabled(true);
			this.contadorFunciones=1;
			this.contadorNeuronas=1;
			
		}
		
	}

	private void volver() {

		this.setVisible(false);
		this.indice.setVisible(true);
		
		if(simulacion.getEntorno()!=null && simulacion.getRed()!=null) {
			
			this.indice.entreno.setEnabled(true);
			this.indice.prueba.setEnabled(true);
			this.indice.infoActual.setEnabled(true);

		}else {
			
			this.indice.entreno.setEnabled(false);
			this.indice.prueba.setEnabled(false);
			this.indice.infoActual.setEnabled(false);
			
		}

	}

	private void limpiar() {
		
		this.labelInfoEntorno.setText("");
		this.labelInfoRed.setText("");
		this.campoNombreEntorno.setText("");
		this.campoEntradaX.setText("");
		this.campoEntradaY.setText("");	
		this.campoSalidaX.setText("");
		this.campoSalidaY.setText("");
		this.campoPaso.setText("");
		this.campoArea.setText("");	
		this.labelInfoCapas.setText("");
		this.labelInfoNeuronas.setText("");	
		this.labelInfoFuncion.setText("");	
		this.labelInfoRed.setText("");
		this.campoNombreRed.setText("");	
		this.campoDescripcionRed.setText("");

	}
	
	private void addCapa() {
		
		this.numCapas = Integer.parseInt(this.cantidadCapas.getValue().toString()) ;
		this.numeroNeuronas = new int[numCapas];
		this.funciones = new int[numCapas];
		this.labelInfoCapas.setText("Capas creadas: "+numCapas);
		this.labelInfoCapas.setForeground(Color.YELLOW);
		this.cantidadCapas.setEnabled(false);

	}
	
	private void addNeuronas() {
		
		int numNeuronas = Integer.parseInt(this.cantidadNeuronas.getValue().toString());
		
		if(contadorNeuronas<=numeroNeuronas.length) {
			
			this.numeroNeuronas[contadorNeuronas-1] = numNeuronas;
			
		}
		
		this.labelInfoNeuronas.setText("Neuronas en capa: "+contadorNeuronas+": "+numNeuronas);
		this.labelInfoNeuronas.setForeground(Color.YELLOW);
		
		contadorNeuronas++;
		
		if(contadorNeuronas>numeroNeuronas.length) {
			
			this.cantidadNeuronas.setEnabled(false);
			
		}

	}
	
	private void addFuncion() {
		
		int funcionActivation = Integer.parseInt(this.seleccionarFuncion.getValue().toString());
		
		if(contadorFunciones<=numeroNeuronas.length) {
			
			this.funciones[contadorFunciones-1] = funcionActivation;
			
		}
		
		this.labelInfoFuncion.setText("Funcion en capa: "+contadorFunciones+": "+funcionActivation);
		this.labelInfoFuncion.setForeground(Color.YELLOW);
		
		contadorFunciones++;
		
		if(contadorFunciones>numeroNeuronas.length) {
			
			this.seleccionarFuncion.setEnabled(false);
			
		}
		
	}
}