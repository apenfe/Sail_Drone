package ventanas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Entrenar extends JFrame implements ActionListener{
	
	private Container contenedor;
	
	public Entrenar() {
		
		this.setTitle("Sail Drone --- Rev 1.0.0");
		this.setBounds(60,60,1800,900);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.contenedor=this.getContentPane();
		this.contenedor.setLayout(null);
		
		this.titulo();
		this.labels();
		this.botones();
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	private void titulo() {


	}
	
	private void botones() {
		
	
		
	}
	
	private void labels() {


	}


}