package ventanas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;

public class Cargar extends JFrame implements ActionListener{
	
	private Index indice;
	private Container contenedor;
	private JLabel icon;
	private JButton volver;
	private JLabel lblNewLabel_1, titulo;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public Cargar(Index indice) {
		
		this.indice=indice;
		this.setTitle("___Sail Drone___");
		this.setBounds(300,80,1280,800);
		
		// Establecer el icono de la ventana
        this.setIconImage(new ImageIcon("files\\GUI\\icono.png").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.contenedor=this.getContentPane();
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
		
		this.titulo= new JLabel("Cargar datos simulación");
		titulo.setBounds(28, 98, 331, 30);
		this.titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo.setForeground(Color.white);

	}
	
	private void botones() {
	
		this.volver=new JButton("Volver");
		volver.setBounds(28, 713, 157, 37);
		this.volver.setFont(new Font("Arial", Font.PLAIN, 16));
		this.volver.addActionListener(this);
		this.volver.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		getContentPane().add(titulo);
		getContentPane().add(lblNewLabel);
		getContentPane().add(volver);
		
		textField = new JTextField();
		textField.setBounds(213, 152, 146, 37);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 200, 146, 34);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 245, 146, 37);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Red Neuronal: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(28, 164, 175, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del entorno: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(28, 209, 175, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre del mapa: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(28, 252, 175, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton cargar = new JButton("Cargar");
		cargar.setFont(new Font("Arial", Font.PLAIN, 16));
		cargar.setBackground(Color.LIGHT_GRAY);
		cargar.setBounds(28, 301, 157, 37);
		getContentPane().add(cargar);
		
		JButton Limpiar = new JButton("Limpiar");
		Limpiar.setFont(new Font("Arial", Font.PLAIN, 16));
		Limpiar.setBackground(Color.LIGHT_GRAY);
		Limpiar.setBounds(202, 301, 157, 37);
		getContentPane().add(Limpiar);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\esquina.png"));
		lblNewLabel_5.setBounds(793, 0, 471, 271);
		getContentPane().add(lblNewLabel_5);
		
	}
	
	private void labels() {
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(28, 11, 235, 82);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\banner.png"));

	}

	private void volver() {

		this.setVisible(false);
		this.indice.setVisible(true);
		
	}
}