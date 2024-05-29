package ventanas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener{
	
	private Container contenedor;
	private JLabel icon;
	private JButton cargar, crear, entreno, prueba, infoActual, salir;
	private JLabel lblNewLabel_1, titulo;
	
	public Index() {
		
		this.setTitle("___Sail Drone___");
		this.setBounds(300,80,1280,800);
		
		// Establecer el icono de la ventana
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
		
		if(e.getSource()==this.cargar) {
			
			this.cargar();
			
		}else if(e.getSource()==this.crear) {
			
			this.crear();

		}else if(e.getSource()==this.entreno) {
			
			this.entreno();

		}else if(e.getSource()==this.prueba) {
			
			this.prueba();

		}else if(e.getSource()==this.infoActual) {
			
			this.infoActual();

		}else if(e.getSource()==this.salir) {
			
			this.salir();

		}
		
	}
	
	private void titulo() {
		
		this.titulo= new JLabel("Unmaned Surface Vehicle Trainer");
		this.titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo.setBounds(30, 430, 500, 30);
		this.titulo.setForeground(Color.white);
		this.contenedor.add(this.titulo);

	}
	
	private void botones() {
		
		this.entreno=new JButton("Entrenar agentes");
		this.entreno.setFont(new Font("Arial", Font.PLAIN, 16));
		this.entreno.setBounds(62,200,157,37);
		this.entreno.addActionListener(this);
		this.entreno.setVisible(true);
		this.entreno.setBackground(Color.LIGHT_GRAY);
		this.entreno.setEnabled(false);
		this.contenedor.add(this.entreno);
		
		this.prueba=new JButton("Probar agentes");
		this.prueba.setFont(new Font("Arial", Font.PLAIN, 16));
		this.prueba.setBounds(62,248,157,37);
		this.prueba.addActionListener(this);
		this.prueba.setVisible(true);
		this.prueba.setBackground(Color.LIGHT_GRAY);
		this.prueba.setEnabled(false);
		this.contenedor.add(this.prueba);	
		
		this.cargar=new JButton("Cargar datos");
		this.cargar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cargar.setBounds(62,152,157,37);
		this.cargar.addActionListener(this);	
		this.cargar.setVisible(true);
		this.cargar.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.cargar);
		
		this.crear=new JButton("Crear datos");
		this.crear.setFont(new Font("Arial", Font.PLAIN, 16));
		this.crear.setBounds(62,104,157,37);
		this.crear.addActionListener(this);
		this.crear.setVisible(true);
		this.crear.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.crear);
		
		this.infoActual=new JButton("Informacion");
		this.infoActual.setFont(new Font("Arial", Font.PLAIN, 16));
		this.infoActual.setBounds(62,296,157,37);
		this.infoActual.addActionListener(this);
		this.infoActual.setVisible(true);
		this.infoActual.setBackground(Color.LIGHT_GRAY);
		this.infoActual.setEnabled(false);
		this.contenedor.add(this.infoActual);
		
		this.salir=new JButton("Salir");
		this.salir.setFont(new Font("Arial", Font.PLAIN, 16));
		this.salir.setBounds(62,344,157,37);
		this.salir.addActionListener(this);
		this.salir.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.salir);
		
	}
	
	private void labels() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\banner.png"));
		lblNewLabel.setBounds(28, 11, 235, 82);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\portada.png"));
		lblNewLabel_1.setBounds(273, 0, 991, 761);
		getContentPane().add(lblNewLabel_1);
		

	}

	private void cargar() {

		new Cargar(this);
		this.setVisible(false);

	}

	private void salir() {

		System.exit(0);

	}

	private void crear() {

		new Crear(this);
		this.setVisible(false);

	}

	private void entreno() {

		new Entrenar(this);
		this.setVisible(false);

	}

	private void prueba() {

		new Probar(this);
		this.setVisible(false);
	}
	
	private void infoActual() {

		new Info(this);
		this.setVisible(false);

	}

}