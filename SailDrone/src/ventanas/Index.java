package ventanas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener{
	
	private Container contenedor;
	private JLabel titulo, labelInfo, icon;
	private JButton cargar, crear, entreno, prueba, infoActual, salir;
	
	public Index() {
		
		this.setTitle("Sail Drone --- Rev 1.0.0");
		this.setBounds(60,60,1800,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.contenedor=this.getContentPane();
		this.contenedor.setLayout(null);
		
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

		this.titulo = new JLabel("Sail Drone Machine Learning");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 24));
		this.titulo.setBounds(721, 19, 341, 40);
		this.contenedor.add(this.titulo);

	}
	
	private void botones() {
		
		this.entreno=new JButton("Entrenar agentes");
		this.entreno.setFont(new Font("Arial", Font.PLAIN, 16));
		this.entreno.setBounds(21,383,169,25);
		this.entreno.addActionListener(this);
		this.entreno.setEnabled(false);
		this.contenedor.add(this.entreno);
		
		this.prueba=new JButton("Probar agentes");
		this.prueba.setFont(new Font("Arial", Font.PLAIN, 16));
		this.prueba.setBounds(21,347,169,25);
		this.prueba.addActionListener(this);
		this.prueba.setEnabled(false);
		this.contenedor.add(this.prueba);	
		
		this.cargar=new JButton("Cargar datos");
		this.cargar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cargar.setBounds(21,281,169,25);
		this.cargar.addActionListener(this);
		this.contenedor.add(this.cargar);
		
		this.crear=new JButton("Crear datos");
		this.crear.setFont(new Font("Arial", Font.PLAIN, 16));
		this.crear.setBounds(21,245,169,25);
		this.crear.addActionListener(this);
		this.contenedor.add(this.crear);
		
		this.infoActual=new JButton("Ver datos actuales");
		this.infoActual.setFont(new Font("Arial", Font.PLAIN, 16));
		this.infoActual.setBounds(21,311,169,25);
		this.infoActual.addActionListener(this);
		this.infoActual.setEnabled(false);
		this.contenedor.add(this.infoActual);
		
		this.salir=new JButton("Salir");
		this.salir.setFont(new Font("Arial", Font.PLAIN, 16));
		this.salir.setBounds(21,419,169,25);
		this.salir.addActionListener(this);
		this.contenedor.add(this.salir);
		
	}
	
	private void labels() {

		// label info
		this.labelInfo = new JLabel("Entrenador para controladores de drones acuaticos");
		this.labelInfo.setFont(new Font("Arial", Font.BOLD, 20));
		this.labelInfo.setBounds(640, 70, 504, 25);
		this.contenedor.add(this.labelInfo);
		
		// label icon
		this.icon = new JLabel("");
		icon.setBackground(UIManager.getColor("Button.darkShadow"));
		icon.setForeground(new Color(192, 192, 192));
		icon.setIcon(new ImageIcon(
				"C:\\Users\\adria\\DAW\\1º AÑO\\PROGRAMACION\\maze_solver\\GUI_laberinto\\images\\pic004.jpg"));
		this.icon.setFont(new Font("Arial", Font.BOLD, 20));
		this.icon.setBounds(220, 146, 384, 273);
		this.contenedor.add(this.icon);

	}

	private void cargar() {

		Cargar cargar = new Cargar();
		this.setVisible(false);

	}

	private void salir() {

		System.exit(0);

	}

	private void crear() {

		Crear cargar = new Crear();
		this.setVisible(false);

	}

	private void entreno() {

		Entrenar entrenar = new Entrenar();
		this.setVisible(false);

	}

	private void prueba() {

		Probar probar = new Probar();
		this.setVisible(false);
	}
	
	private void infoActual() {

		Info info = new Info();
		this.setVisible(false);

	}

}