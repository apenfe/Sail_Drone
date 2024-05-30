package ventanas;

import javax.swing.*;

import clases.Simulacion;

import java.awt.*;
import java.awt.event.*;

public class Probar extends JFrame implements ActionListener{
	
	private Index indice;
	private Simulacion simulacion;
	private Container contenedor;
	private JLabel area, agentes, labelInfo, paso, pasos, nombreADN, xin, yin, xout, yout;
	private JTextField campoAgentes, campoArea, campoPaso, campoPasos, campoNombreADN, campoxin, campoyin, campoxout, campoyout;
	private JButton adn, limpiar, volver, aleatorio, entorno;
	private JLabel titulo, lblNewLabel_1;
	
	public Probar(Index indice, Simulacion simulacion) {
		
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
		
		if(e.getSource()==this.adn) {
			
			this.adn();
			
		}else if(e.getSource()==this.limpiar) {
			
			this.limpiar();

		}else if(e.getSource()==this.volver) {
			
			this.volver();

		}else if(e.getSource()==this.aleatorio) {
			
			this.aleatorio();

		}else if(e.getSource()==this.entorno) {
			
			this.entorno();

		}
		
	}
	
	private void titulo() {
		
		this.titulo= new JLabel("Probar agentes");
		this.titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo.setBounds(28, 104, 235, 30);
		this.titulo.setForeground(Color.white);
		this.contenedor.add(this.titulo);

	}
	
	private void botones() {
		
		this.aleatorio=new JButton("Probar agentes aleaorios");
		this.aleatorio.setFont(new Font("Arial", Font.PLAIN, 16));
		this.aleatorio.setBounds(28,638,324,30);
		this.aleatorio.addActionListener(this);
		this.aleatorio.setVisible(true);
		this.aleatorio.setBackground(Color.LIGHT_GRAY);
		this.aleatorio.setEnabled(false);
		this.contenedor.add(this.aleatorio);
		
		this.adn=new JButton("Probar agentes con ADN guardado");
		this.adn.setFont(new Font("Arial", Font.PLAIN, 16));
		this.adn.setBounds(28,679,324,30);
		this.adn.addActionListener(this);
		this.adn.setVisible(true);
		this.adn.setBackground(Color.LIGHT_GRAY);
		this.adn.setEnabled(false);
		this.contenedor.add(this.adn);
		
		this.limpiar=new JButton("Limpiar");
		this.limpiar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.limpiar.setBounds(195,720,157,30);
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
		
		this.entorno=new JButton("Cargar entorno");
		this.entorno.setFont(new Font("Arial", Font.PLAIN, 16));
		this.entorno.setBounds(262,373,157,30);
		this.entorno.addActionListener(this);
		this.entorno.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.entorno);
		
	}

	private void labels() {

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adria\\Desktop\\saildrone\\SailDrone\\files\\GUI\\banner.png"));
		lblNewLabel.setBounds(28, 11, 235, 82);
		getContentPane().add(lblNewLabel);

		// numero agentes

		this.agentes = new JLabel("Numero de agentes:");
		this.agentes.setForeground(new Color(255, 255, 255));
		this.agentes.setFont(new Font("Arial", Font.PLAIN, 20));
		this.agentes.setBounds(40, 158, 187, 25);
		this.contenedor.add(this.agentes);

		// campo numero agentes

		this.campoAgentes = new JTextField();
		this.campoAgentes.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoAgentes.setBounds(237, 157, 200, 30);
		this.campoAgentes.addActionListener(this);
		this.contenedor.add(this.campoAgentes);
		
		// nombre adn

		this.nombreADN = new JLabel("Nombre de ADN:");
		this.nombreADN.setForeground(new Color(255, 255, 255));
		this.nombreADN.setFont(new Font("Arial", Font.PLAIN, 20));
		this.nombreADN.setBounds(40, 322, 187, 25);
		this.contenedor.add(this.nombreADN);

		// campo nombre adn
		
		this.campoNombreADN = new JTextField();
		this.campoNombreADN.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoNombreADN.setBounds(237, 321, 200, 30);
		this.campoNombreADN.addActionListener(this);
		this.contenedor.add(this.campoNombreADN);

		// area

		this.area = new JLabel("Area de aproximacion:");
		this.area.setForeground(new Color(255, 255, 255));
		this.area.setFont(new Font("Arial", Font.PLAIN, 20));
		this.area.setBounds(28, 281, 205, 25);
		this.contenedor.add(this.area);

		// campo area

		this.campoArea = new JTextField();
		this.campoArea.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoArea.setBounds(237, 280, 200, 30);
		this.campoArea.addActionListener(this);
		this.contenedor.add(this.campoArea);

		// paso

		this.paso = new JLabel("Paso de agente:");
		this.paso.setForeground(new Color(255, 255, 255));
		this.paso.setFont(new Font("Arial", Font.PLAIN, 20));
		this.paso.setBounds(83, 240, 150, 25);
		this.contenedor.add(this.paso);

		// campo paso

		this.campoPaso = new JTextField();
		this.campoPaso.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoPaso.setBounds(237, 239, 200, 30);
		this.campoPaso.addActionListener(this);
		this.contenedor.add(this.campoPaso);
		
		// pasos

		this.pasos = new JLabel("Pasos Maximos:");
		this.pasos.setForeground(new Color(255, 255, 255));
		this.pasos.setFont(new Font("Arial", Font.PLAIN, 20));
		this.pasos.setBounds(77, 204, 150, 25);
		this.contenedor.add(this.pasos);

		// campo pasos

		this.campoPasos = new JTextField();
		this.campoPasos.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoPasos.setBounds(237, 198, 200, 30);
		this.campoPasos.addActionListener(this);
		this.contenedor.add(this.campoPasos);

		// info

		this.labelInfo = new JLabel("");
		this.labelInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfo.setBounds(10, 597, 409, 30);
		this.contenedor.add(this.labelInfo);
		
		this.lblNewLabel_1 = new JLabel("");
		this.lblNewLabel_1.setBounds(467, 147, 797, 480); // Establece el tamaño del JLabel
		this.contenedor.add(lblNewLabel_1);
		
		    // Cargar la nueva imagen en un ImageIcon
		    ImageIcon newImageIcon = new ImageIcon(this.simulacion.getEntorno().getCarta());
		    
		    // Escalar la imagen al tamaño del JLabel
		    Image image = newImageIcon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		    
		    // Crear un nuevo ImageIcon con la imagen escalada
		    ImageIcon scaledImageIcon = new ImageIcon(image);
		    
		    // Establecer la nueva imagen escalada en el JLabel
		    this.lblNewLabel_1.setIcon(scaledImageIcon);
		    

	}

	private void adn() {
		
		String nombre = this.campoNombreADN.getText().trim();
		int numAgentes = Integer.parseInt(this.campoAgentes.getText().trim());
		int pasos = Integer.parseInt(this.campoPasos.getText().trim());
		int area = Integer.parseInt(this.campoArea.getText().trim());
		double paso = Double.parseDouble(this.campoPaso.getText().trim());
		
		if(numAgentes >0 && pasos >0 && area >0 && paso >0 && nombre.length()!=0) {
			
			if(this.simulacion.adnGUI(numAgentes,nombre, pasos, paso, area)) {
				
				this.labelInfo.setText("Simulacion de ADN correcta.");
				this.labelInfo.setForeground(Color.GREEN);
				
			}else {
				
				this.labelInfo.setText("Error al simular.");
				this.labelInfo.setForeground(Color.RED);
				
			}
			
		}else {
			
			this.labelInfo.setText("Todos los campos son obligatorios.");
			this.labelInfo.setForeground(Color.RED);
			
		}
		
	}

	private void volver() {

		this.setVisible(false);
		this.indice.setVisible(true);

	}
	

	private void limpiar() {
		
		this.labelInfo.setText("");
		this.campoAgentes.setText("");
		this.campoArea.setText("");
		this.campoPaso.setText("");
		this.campoPasos.setText("");

	}
	
	private void aleatorio() {
		
		int numAgentes = Integer.parseInt(this.campoAgentes.getText().trim());
		int pasos = Integer.parseInt(this.campoPasos.getText().trim());
		int area = Integer.parseInt(this.campoArea.getText().trim());
		double paso = Double.parseDouble(this.campoPaso.getText().trim());
		
		if(numAgentes >0 && pasos >0 && area >0 && paso >0) {
			
			this.simulacion.randomGUI(numAgentes, pasos, paso, area);
			this.labelInfo.setText("Simulacion correcta.");
			this.labelInfo.setForeground(Color.GREEN);
			
		}else {
			
			this.labelInfo.setText("Todos los campos son obligatorios.");
			this.labelInfo.setForeground(Color.RED);
			
		}
	
	}
	
	private void entorno() {
		
		int area = Integer.parseInt(this.campoArea.getText().trim());
		double paso = Double.parseDouble(this.campoPaso.getText().trim());
		
		if( area >0 && paso>0) {
			
			
			this.simulacion.configurarEntornoGUI(area, paso);
			
			updateImage(this.simulacion.getEntorno().getCarta());
			this.adn.setEnabled(true);
			this.aleatorio.setEnabled(true);
			this.labelInfo.setText("Entorno cargado correctamente.");
			this.labelInfo.setForeground(Color.GREEN);
			
		}else {
			
			this.labelInfo.setText("Todos los campos son obligatorios.");
			this.labelInfo.setForeground(Color.RED);
			
		}
	
	}
	
	private void updateImage(String mapa) {
		
		if (lblNewLabel_1 != null) {
	    // Cargar la nueva imagen en un ImageIcon
	    ImageIcon newImageIcon = new ImageIcon("entradas\\in_"+mapa+".png");
	    
	    // Escalar la imagen al tamaño del JLabel
	    Image image = newImageIcon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
	    
	    // Crear un nuevo ImageIcon con la imagen escalada
	    ImageIcon scaledImageIcon = new ImageIcon(image);
	    
	    // Establecer la nueva imagen escalada en el JLabel
	    this.lblNewLabel_1.setIcon(scaledImageIcon);
	    
		}
	}

}