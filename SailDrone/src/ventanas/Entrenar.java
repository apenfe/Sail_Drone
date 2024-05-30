package ventanas;

import javax.swing.*;

import agente.Agente;
import clases.Simulacion;

import java.awt.*;
import java.awt.event.*;

public class Entrenar extends JFrame implements ActionListener{
	
	private Agente mejor;
	private Index indice;
	private Simulacion simulacion;
	private Container contenedor;
	private JLabel area, agentes, labelInfo, paso, pasos, nombreADN, generaciones, nombreADN2, nuevoADN, descripcion;
	private JTextField campoAgentes, campoArea, campoPaso, campoPasos, campoNombreADN, campoGeneraciones, campoNombreADN2, campoNuevoADN, campoDescripcion;
	private JButton continuar, limpiar, volver, cero, entorno, adn;
	private JLabel titulo, lblNewLabel_1;
	
	public Entrenar(Index indice, Simulacion simulacion) {
		
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
		
		if(e.getSource()==this.cero) {
			
			this.cero();
			
		}else if(e.getSource()==this.limpiar) {
			
			this.limpiar();

		}else if(e.getSource()==this.volver) {
			
			this.volver();

		}else if(e.getSource()==this.continuar) {
			
			this.continuar();

		}else if(e.getSource()==this.entorno) {
			
			this.entorno();

		}else if(e.getSource()==this.adn) {
			
			this.guardarADN();

		}
		
	}
	
	private void titulo() {
		
		this.titulo= new JLabel("Entrenar agentes");
		this.titulo.setFont(new Font("Arial",Font.PLAIN,30));
		this.titulo.setBounds(28, 104, 235, 30);
		this.titulo.setForeground(Color.white);
		this.contenedor.add(this.titulo);

	}
	
	private void botones() {
		
		this.cero=new JButton("Entrenar agentes desde 0");
		this.cero.setFont(new Font("Arial", Font.PLAIN, 16));
		this.cero.setBounds(28,638,324,30);
		this.cero.addActionListener(this);
		this.cero.setVisible(true);
		this.cero.setBackground(Color.LIGHT_GRAY);
		this.cero.setEnabled(false);
		this.contenedor.add(this.cero);
		
		this.continuar=new JButton("Continuar entrenando agentes");
		this.continuar.setFont(new Font("Arial", Font.PLAIN, 16));
		this.continuar.setBounds(28,679,324,30);
		this.continuar.addActionListener(this);
		this.continuar.setVisible(true);
		this.continuar.setBackground(Color.LIGHT_GRAY);
		this.continuar.setEnabled(false);
		this.contenedor.add(this.continuar);
		
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
		this.entorno.setBounds(138,488,157,30);
		this.entorno.addActionListener(this);
		this.entorno.setBackground(Color.LIGHT_GRAY);
		this.contenedor.add(this.entorno);
		
		this.adn=new JButton("Guardar ADN");
		this.adn.setFont(new Font("Arial", Font.PLAIN, 16));
		this.adn.setBounds(641,721,150,30);
		this.adn.addActionListener(this);
		this.adn.setVisible(true);
		this.adn.setBackground(Color.LIGHT_GRAY);
		this.adn.setEnabled(false);
		this.contenedor.add(this.adn);
		
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
		
		// numero agentes

				this.descripcion = new JLabel("Descripcion ADN:");
				this.descripcion.setForeground(new Color(255, 255, 255));
				this.descripcion.setFont(new Font("Arial", Font.PLAIN, 20));
				this.descripcion.setBounds(393, 681, 187, 25);
				this.contenedor.add(this.descripcion);

				// campo numero agentes

				this.campoDescripcion = new JTextField();
				this.campoDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
				this.campoDescripcion.setBounds(620, 680, 200, 30);
				this.campoDescripcion.addActionListener(this);
				this.campoDescripcion.setEnabled(false);
				this.contenedor.add(this.campoDescripcion);
		
		// nombre adn

		this.nombreADN = new JLabel("Nombre de ADN 1:");
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
		
		// nombre adn2

		this.nombreADN2 = new JLabel("Nombre de ADN 2:");
		this.nombreADN2.setForeground(new Color(255, 255, 255));
		this.nombreADN2.setFont(new Font("Arial", Font.PLAIN, 20));
		this.nombreADN2.setBounds(40, 404, 187, 25);
		this.contenedor.add(this.nombreADN2);
		
		// campo nombre adn2
				
		this.campoNombreADN2 = new JTextField();
		this.campoNombreADN2.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoNombreADN2.setBounds(237, 403, 200, 30);
		this.campoNombreADN2.addActionListener(this);
		this.contenedor.add(this.campoNombreADN2);

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
		
		// generaciones

		this.generaciones = new JLabel("Nº Generaciones:");
		this.generaciones.setForeground(new Color(255, 255, 255));
		this.generaciones.setFont(new Font("Arial", Font.PLAIN, 20));
		this.generaciones.setBounds(40, 363, 187, 25);
		this.contenedor.add(this.generaciones);

		// campo generaciones

		this.campoGeneraciones = new JTextField();
		this.campoGeneraciones.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoGeneraciones.setBounds(237, 362, 200, 30);
		this.campoGeneraciones.addActionListener(this);
		this.contenedor.add(this.campoGeneraciones);
		
		// generaciones

				this.nuevoADN = new JLabel("Nombre de nuevo ADN:");
				this.nuevoADN.setForeground(new Color(255, 255, 255));
				this.nuevoADN.setFont(new Font("Arial", Font.PLAIN, 20));
				this.nuevoADN.setBounds(393, 640, 215, 25);
				this.contenedor.add(this.nuevoADN);

				// campo generaciones

				this.campoNuevoADN = new JTextField();
				this.campoNuevoADN.setFont(new Font("Arial", Font.PLAIN, 15));
				this.campoNuevoADN.setBounds(620, 639, 200, 30);
				this.campoNuevoADN.addActionListener(this);
				this.campoNuevoADN.setEnabled(false);
				this.contenedor.add(this.campoNuevoADN);

		// info

		this.labelInfo = new JLabel("");
		this.labelInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelInfo.setBounds(28, 450, 409, 30);
		this.contenedor.add(this.labelInfo);

		this.lblNewLabel_1 = new JLabel("");
		this.lblNewLabel_1.setBounds(467, 147, 797, 480); // Establece el tamaño del JLabel
		this.contenedor.add(lblNewLabel_1);

		// Cargar la nueva imagen en un ImageIcon
		ImageIcon newImageIcon = new ImageIcon(this.simulacion.getEntorno().getCarta());

		// Escalar la imagen al tamaño del JLabel
		Image image = newImageIcon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
				Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen escalada
		ImageIcon scaledImageIcon = new ImageIcon(image);

		// Establecer la nueva imagen escalada en el JLabel
		this.lblNewLabel_1.setIcon(scaledImageIcon);

	}

	private void continuar() {
		
		String adn1 = this.campoNombreADN.getText().trim();
		String adn2 = this.campoNombreADN2.getText().trim();
		int numAgentes = Integer.parseInt(this.campoAgentes.getText().trim());
		int numGeneraciones = Integer.parseInt(this.campoGeneraciones.getText().trim());
		int pasos = Integer.parseInt(this.campoPasos.getText().trim());
		
		if(numAgentes >0 && pasos >0 && adn1.length()!=0 && numGeneraciones >0) {
			
			this.mejor = this.simulacion.continuarEntrenamientoGUI(numAgentes, numGeneraciones, pasos, adn1,  adn2);
				
			this.labelInfo.setText("Entrenamiento correcto");
			this.labelInfo.setForeground(Color.GREEN);
			
			if(mejor!=null) {
				this.adn.setEnabled(true);
				this.campoNuevoADN.setEnabled(true);
				this.campoDescripcion.setEnabled(true);
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
		this.campoGeneraciones.setText("");
		this.campoNombreADN.setText("");
		this.campoNombreADN2.setText("");
		this.campoNuevoADN.setText("");
		this.campoDescripcion.setText("");

	}
	
	private void cero() {
		
		int numAgentes = Integer.parseInt(this.campoAgentes.getText().trim());
		int pasos = Integer.parseInt(this.campoPasos.getText().trim());
		int numGeneraciones = Integer.parseInt(this.campoGeneraciones.getText().trim());
		
		if(numAgentes >0 && pasos >0 && numGeneraciones >0) {
			
			this.mejor = this.simulacion.entrenarDesdeCeroGUI(numAgentes,numGeneraciones,pasos);
			this.labelInfo.setText("Entrenamiento correcto.");
			this.labelInfo.setForeground(Color.GREEN);
			
			if(mejor!=null) {
				
				this.adn.setEnabled(true);
				this.campoNuevoADN.setEnabled(true);
				this.campoDescripcion.setEnabled(true);
				
			}
			
		}else {
			
			this.labelInfo.setText("Todos los campos son obligatorios.");
			this.labelInfo.setForeground(Color.RED);
			
		}
	
	}
	
	private void entorno() {
		
		int area = Integer.parseInt(this.campoArea.getText().trim());
		double paso = Double.parseDouble(this.campoPaso.getText().trim());
		
		if(area>0 && paso>0) {
			
			
			this.simulacion.configurarEntornoGUI(area, paso);
			
			updateImage(this.simulacion.getEntorno().getCarta());
			this.continuar.setEnabled(true);
			this.cero.setEnabled(true);
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
	
	private void guardarADN() {
		
		String nombre = this.campoNuevoADN.getText().trim();
		String description = this.campoDescripcion.getText().trim();
		
		if(nombre.length()>0) {
			
			if(this.simulacion.guardarADN(nombre,mejor,description)) {
				
				this.labelInfo.setText("ADN guardado correctamente.");
				this.labelInfo.setForeground(Color.GREEN);
				
				this.adn.setEnabled(false);
				this.campoNuevoADN.setEnabled(false);
				this.campoDescripcion.setEnabled(false);
				
			}else {
				
				this.labelInfo.setText("Error al guardar ADN.");
				this.labelInfo.setForeground(Color.RED);
				
			}
			
		}else {
			
			this.labelInfo.setText("Todos los campos son obligatorios.");
			this.labelInfo.setForeground(Color.RED);
			
		}
	
	}
}