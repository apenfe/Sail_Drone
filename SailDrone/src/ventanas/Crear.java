package ventanas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Crear extends JFrame implements ActionListener{
	
	private Index indice;
	private Container contenedor;
	private JButton volver;
	
	public Crear(Index indice) {
		
		this.indice=indice;
		this.setTitle("___Sail Drone___");
		this.setBounds(300,80,1280,800);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
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
		
		if(e.getSource()==this.volver) {
			
			this.volver();
			
		}
		
	}
	
	private void titulo() {


	}
	
	private void botones() {
		
		this.volver=new JButton("");
		this.volver.setFont(new Font("Arial", Font.PLAIN, 16));
		this.volver.setBounds(1075,59,72,37);
		this.volver.addActionListener(this);
		this.volver.setIcon(new ImageIcon("files\\GUI\\inicio_false.png")); 
		this.volver.setBorderPainted(false);
		this.volver.setContentAreaFilled(false);
		this.volver.setFocusPainted(false);
		this.volver.setOpaque(false);
		this.contenedor.add(this.volver);
	
	}
	
	private void labels() {


	}
	
	private void volver() {
		
		this.setVisible(false);
		this.indice.setVisible(true);
		
	}

}