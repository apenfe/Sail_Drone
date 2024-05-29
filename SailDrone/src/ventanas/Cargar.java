package ventanas;

import javax.swing.*;

import clases.Entradas;
import clases.Simulacion;

import java.awt.*;
import java.awt.event.*;

public class Cargar extends JFrame implements ActionListener{
	
	private Index indice;
	private Simulacion simulacion;
	private Container contenedor;
	private JLabel icon, mapa, entorno, red, labelInfo;
	private JTextField campoMapa, campoRed, campoEntorno;
	private JButton cargar, limpiar, volver;
	private JLabel lblNewLabel_1, titulo;
	
	public Cargar(Index indice, Simulacion simulacion) {
		
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
		this.labels();
		this.botones();
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.cargar || e.getSource()==this.campoEntorno || e.getSource()==this.campoMapa || e.getSource()==this.campoRed) {
			
			this.cargar();
			
		}else if(e.getSource()==this.limpiar) {
			
			this.limpiar();

		}else if(e.getSource()==this.volver) {
			
			this.volver();

		}
		
	}
	
	private void titulo() {
		
		this.titulo= new JLabel("Carga de datos");
		this.titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo.setBounds(28, 104, 235, 30);
		this.titulo.setForeground(Color.white);
		this.contenedor.add(this.titulo);

	}
	
	private void botones() {
		
		this.cargar=new JButton("Cargar");
		this.cargar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cargar.setBounds(28,329,157,30);
		this.cargar.addActionListener(this);
		this.cargar.setVisible(true);
		this.cargar.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cargar);
		
		this.limpiar=new JButton("Limpiar");
		this.limpiar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.limpiar.setBounds(210,329,157,30);
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

	private void labels() {

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\banner.png"));
		lblNewLabel.setBounds(28, 11, 235, 82);
		getContentPane().add(lblNewLabel);

		// red

		this.red = new JLabel("Red neuronal:");
		red.setForeground(new Color(255, 255, 255));
		this.red.setFont(new Font("Arial", Font.PLAIN, 20));
		this.red.setBounds(28, 170, 150, 25);
		this.contenedor.add(this.red);

		// campo red

		this.campoRed = new JTextField();
		this.campoRed.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoRed.setBounds(167, 169, 200, 30);
		this.campoRed.addActionListener(this);
		this.contenedor.add(this.campoRed);

		// mapa

		this.mapa = new JLabel("Mapa:");
		mapa.setForeground(new Color(255, 255, 255));
		this.mapa.setFont(new Font("Arial", Font.PLAIN, 20));
		this.mapa.setBounds(28, 265, 150, 25);
		this.contenedor.add(this.mapa);

		// campo mapa

		this.campoMapa = new JTextField();
		this.campoMapa.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoMapa.setBounds(167, 264, 200, 30);
		this.campoMapa.addActionListener(this);
		this.contenedor.add(this.campoMapa);

		// entorno

		this.entorno = new JLabel("Entorno:");
		entorno.setForeground(new Color(255, 255, 255));
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 20));
		this.entorno.setBounds(28, 220, 150, 25);
		this.contenedor.add(this.entorno);

		// campo entorno

		this.campoEntorno = new JTextField();
		this.campoEntorno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoEntorno.setBounds(167, 215, 200, 30);
		this.campoEntorno.addActionListener(this);
		this.contenedor.add(this.campoEntorno);

		// info

		this.labelInfo = new JLabel("");
		this.labelInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfo.setBounds(28, 370, 339, 30);
		this.contenedor.add(this.labelInfo);
		
		this.lblNewLabel_1 = new JLabel("");
		this.lblNewLabel_1.setBounds(405, 0, 859, 510); // Establece el tamaño del JLabel
		this.contenedor.add(lblNewLabel_1);

	}

	private void cargar() {
		
		String red = this.campoRed.getText().trim();
		String entorno = this.campoEntorno.getText().trim();
		String mapa = this.campoMapa.getText().trim();
		
		if(red.length()==0 || entorno.length()==0 || mapa.length()==0) {
			
			this.labelInfo.setText("Todos los campos son obligatorios.");
			this.labelInfo.setForeground(Color.RED);
			return;
			
		}
		
		boolean check = true;
		
		if(simulacion.cargarRed(red)) {
			
			this.labelInfo.setText("Red cargada correctamente.");
			this.labelInfo.setForeground(Color.GREEN);
			
		}else {
			
			this.labelInfo.setText("Error al cargar la red.");
			this.labelInfo.setForeground(Color.RED);
			return;
			
		}
		
		if(simulacion.cargarEntorno(entorno)) {
			
			this.labelInfo.setText("Entorno cargado correctamente.");
			this.labelInfo.setForeground(Color.GREEN);
			
		}else {

			this.labelInfo.setText("Error al cargar entorno.");
			this.labelInfo.setForeground(Color.RED);
			return;
			
		}
		
		simulacion.getEntorno().setCarta("mapas\\"+mapa+".png");
		updateImage(mapa);
		
		if(check==false) {
			
			this.labelInfo.setText("Error durante la carga");
			this.labelInfo.setForeground(Color.RED);
			return;
			
		}

	}

	private void volver() {

		this.setVisible(false);
		this.indice.setVisible(true);
		
		if(simulacion.getEntorno()!=null && simulacion.getRed()!=null && simulacion.getEntorno().getCarta()!=null) {
			
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
		
		this.labelInfo.setText("");
		this.campoRed.setText("");
		this.campoEntorno.setText("");
		this.campoMapa.setText("");	

	}
	
	private void updateImage(String mapa) {
		
		if (lblNewLabel_1 != null) {
	    // Cargar la nueva imagen en un ImageIcon
	    ImageIcon newImageIcon = new ImageIcon("mapas\\"+mapa+".png");
	    
	    // Escalar la imagen al tamaño del JLabel
	    Image image = newImageIcon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
	    
	    // Crear un nuevo ImageIcon con la imagen escalada
	    ImageIcon scaledImageIcon = new ImageIcon(image);
	    
	    // Establecer la nueva imagen escalada en el JLabel
	    this.lblNewLabel_1.setIcon(scaledImageIcon);
	    
		}
	}

}