package ventanas;

import javax.swing.*;

import clases.Simulacion;

import java.awt.*;
import java.awt.event.*;

public class Crear extends JFrame implements ActionListener{
	
	private Index indice;
	private Simulacion simulacion;
	private Container contenedor;
	private JLabel icon, mapa, entorno, red, labelInfoRed, labelInfoEntorno;
	private JTextField campoMapa, campoRed, campoEntorno;
	private JButton crearRed, crearEntorno, volver, limpiar;
	private JLabel titulo, titulo2, titulo3;
	
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
		this.titulo3.setBounds(468, 152, 379, 30);
		this.titulo3.setForeground(Color.white);
		this.contenedor.add(this.titulo3);

	}
	
	private void botones() {
		
		this.crearEntorno=new JButton("Crear Entorno");
		this.crearEntorno.setFont(new Font("Arial", Font.PLAIN, 16));
		this.crearEntorno.setBounds(28,649,157,30);
		this.crearEntorno.addActionListener(this);
		this.crearEntorno.setVisible(true);
		this.crearEntorno.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.crearEntorno);
		
		this.crearRed=new JButton("Crear Red");
		this.crearRed.setFont(new Font("Arial", Font.PLAIN, 16));
		this.crearRed.setBounds(468,649,157,30);
		this.crearRed.addActionListener(this);
		this.crearRed.setVisible(true);
		this.crearRed.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.crearRed);
		
		this.limpiar=new JButton("Limpiar");
		this.limpiar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.limpiar.setBounds(250,720,157,30);
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
		
	}

	private void labelsRed() {

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\banner.png"));
		lblNewLabel.setBounds(28, 11, 235, 82);
		getContentPane().add(lblNewLabel);

		// red

		this.red = new JLabel("Red neuronal:");
		red.setForeground(new Color(255, 255, 255));
		this.red.setFont(new Font("Arial", Font.PLAIN, 20));
		this.red.setBounds(28, 211, 150, 25);
		this.contenedor.add(this.red);

		// campo red

		this.campoRed = new JTextField();
		this.campoRed.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoRed.setBounds(167, 210, 200, 30);
		this.campoRed.addActionListener(this);
		this.contenedor.add(this.campoRed);

		// mapa

		this.mapa = new JLabel("Mapa:");
		mapa.setForeground(new Color(255, 255, 255));
		this.mapa.setFont(new Font("Arial", Font.PLAIN, 20));
		this.mapa.setBounds(28, 303, 150, 25);
		this.contenedor.add(this.mapa);

		// campo mapa

		this.campoMapa = new JTextField();
		this.campoMapa.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoMapa.setBounds(167, 302, 200, 30);
		this.campoMapa.addActionListener(this);
		this.contenedor.add(this.campoMapa);

		// entorno

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo entorno

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// info RED

		this.labelInfoRed = new JLabel("");
		this.labelInfoRed.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoRed.setBounds(28, 328, 339, 30);
		this.contenedor.add(this.labelInfoRed);

		// info Entorno

		this.labelInfoEntorno = new JLabel("");
		this.labelInfoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoEntorno.setBounds(28, 328, 339, 30);
		this.contenedor.add(this.labelInfoEntorno);
				
	}
	
	private void labelsEntorno() {

		// m(String nombre, double entradaX, double entradaY, double salidaX, double salidaY, double paso, double areaAprox)

		// nombre

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo nombre

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// entradax

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo entradax

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// entraday

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo entraday

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// salidax

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo salidax

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// saliday

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo saliday

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// paso

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo paso

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// area

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 267, 150, 25);
		this.contenedor.add(this.entorno);

		// campo area

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 262, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// info Entorno

		this.labelInfoEntorno = new JLabel("");
		this.labelInfoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfoEntorno.setBounds(28, 328, 339, 30);
		this.contenedor.add(this.labelInfoEntorno);

	}

	private void crearEntorno() {
		
		String red = this.campoRed.getText().trim();
		String entorno = this.campoEntorno.getText().trim();
		String mapa = this.campoMapa.getText().trim();
		
		if(red.length()==0 || entorno.length()==0 || mapa.length()==0) {
			
			this.labelInfoEntorno.setText("Todos los campos son obligatorios.");
			this.labelInfoEntorno.setForeground(Color.RED);
			return;
			
		}
		
		boolean check = true;
		
		if(simulacion.cargarRed(red)) {
			
			this.labelInfoEntorno.setText("Red cargada correctamente.");
			this.labelInfoEntorno.setForeground(Color.GREEN);
			
		}else {
			
			this.labelInfoEntorno.setText("Error al cargar la red.");
			this.labelInfoEntorno.setForeground(Color.RED);
			return;
			
		}
		
		if(simulacion.cargarEntorno(entorno)) {
			
			this.labelInfoEntorno.setText("Entorno cargado correctamente.");
			this.labelInfoEntorno.setForeground(Color.GREEN);
			
		}else {

			this.labelInfoEntorno.setText("Error al cargar entorno.");
			this.labelInfoEntorno.setForeground(Color.RED);
			return;
			
		}
		
		simulacion.getEntorno().setCarta("mapas\\"+mapa+".png");
		
		if(check==false) {
			
			this.labelInfoEntorno.setText("Error durante la carga");
			this.labelInfoEntorno.setForeground(Color.RED);
			return;
			
		}

	}
	
	private void crearRed() {

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
		this.campoRed.setText("");
		this.campoEntorno.setText("");
		this.campoMapa.setText("");	

	}

}