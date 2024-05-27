package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entorno.Entorno;
import red.RedNeuronal;

public class DAO{

	private static final String SERVER = "127.0.0.1";
	private static final String PORT = "3306";
	private static final String DATABASE = "redes_neuronales";
	private static final String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DATABASE;
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	public boolean guardarRed(RedNeuronal red) {

		try {
			
			String descripcion = Entradas.texto("Inserte una descricion para la RED NEURONAL: ");

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String nn = "INSERT INTO red(nombre,numCapas,descripcion) VALUES ('"+red.getNombre()+"','"+red.getNumCapas()+"','"+descripcion+"')";
			stmt.executeUpdate(nn);
			
			for (int i = 0; i < red.getNumCapas(); i++) {
				
				String layer = "INSERT INTO capa(red_nombre,ordenCapa,numNeuronas,numNeuronasCapaAnterior,funcion) VALUES ('"+red.getNombre()+"','"+(i+1)+"','"+red.getCapas()[i].getNumNeuronas()+"','"+red.getCapas()[i].getNumNeuronasCapaAnterior()+"','"+red.getCapas()[i].getFuncion()+"')";
				stmt.executeUpdate(layer);
				
			}
			
			stmt.close();
			conn.close();
			
			return true;

		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	
	public boolean guardarGenes(String red, String adn, double[] genes) {
		
		try {
			
			String descripcion = Entradas.texto("Inserte una descricion para este ADN: ");

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String nn = "INSERT INTO adn(nombre,nombre_red,description) VALUES ('"+adn+"','"+red+"','"+descripcion+"')";
			stmt.executeUpdate(nn);
			
			for (int i = 0; i < genes.length; i++) {
				
				String layer = "INSERT INTO gen(posicion,nombre_adn,valor) VALUES ("+i+",'"+adn+"',"+genes[i]+");";
				stmt.executeUpdate(layer);
				
			}
			
			stmt.close();
			conn.close();
			
			return true;

		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	
	public double[] cargarGenes(String red, String adn) {
		
		double[] genes = new double[0];
		int total = 0;
		
		try {

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String consulta = "SELECT count(*) as total FROM gen WHERE nombre_adn = '"+adn+"';";
			
			ResultSet rs = stmt.executeQuery(consulta);
			
			
			while(rs.next()) {
				
				total=Integer.parseInt(rs.getString("total"));
				
			}
			
			genes = new double[total];
			
			String consulta2 = "SELECT * from gen WHERE nombre_adn = '"+adn+"' ORDER BY posicion;";
			
			rs = stmt.executeQuery(consulta2);
			int i = 0;
			
			while(rs.next()) {
				
				genes[i]=Double.parseDouble(rs.getString("valor"));
				i++;
			}
			
			rs.close();
			stmt.close();
			conn.close();
			return genes;

		} catch (Exception e) {
			
			System.out.println(e);
			return genes;
			
		}
		
	}
	
	public RedNeuronal cargarRedNeuronal(String nombre) {
		
		RedNeuronal cargado = null;
		int[] numeroNeuronas = new int[0];
		int[] funcion = new int[0];
		String nombreSimulacion="";
		int numCapas=0;
		
		try {

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String consulta = "SELECT * FROM red WHERE nombre = '"+nombre+"';";
			
			ResultSet rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				
				nombreSimulacion+=rs.getString("nombre");
				numCapas=Integer.parseInt(rs.getString("numCapas"));
				
			}
			
			numeroNeuronas = new int[numCapas];
			funcion = new int[numCapas];
			
			String consulta2 = "SELECT * from capa WHERE red_nombre = '"+nombreSimulacion+"';";
			
			rs = stmt.executeQuery(consulta2);
			int i = 0;
			
			while(rs.next()) {
				
				numeroNeuronas[i]=Integer.parseInt(rs.getString("numNeuronas"));
				funcion[i]=Integer.parseInt(rs.getString("funcion"));
				i++;
			}
			
			cargado = new RedNeuronal(nombreSimulacion,numCapas,numeroNeuronas,funcion);
			
			rs.close();
			stmt.close();
			conn.close();
			return cargado;

		} catch (Exception e) {
			
			return cargado;
			
		}

	}
	
	public boolean guardarEntorno(Entorno en) {

		try {

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();
				
			String entorno = "INSERT INTO entorno(nombre,alto,ancho,entradaX,entradaY,salidaX,salidaY,paso,areaAprox) "
			+ "VALUES ('"+en.getNombre()+"',"+en.getAlto()+","+en.getAncho()+","+en.getEntradaX()+","+en.getEntradaY()+","+en.getSalidaX()+","+en.getSalidaY()+","+en.getPaso()+","+en.getAreaAprox()+");";
			stmt.executeUpdate(entorno);
			
			stmt.close();
			conn.close();
			
			return true;

		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	
	public Entorno cargararEntorno(String nombre) {

		Entorno cargado = null;
		
		try {

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String entorno = "SELECT * FROM entorno WHERE nombre = '"+nombre+"';";
			
			ResultSet rs = stmt.executeQuery(entorno);
			
			while(rs.next()) {
				
				String name= rs.getString("nombre");
				double alto =Double.parseDouble(rs.getString("alto"));
				double ancho = Double.parseDouble(rs.getString("ancho"));
				double entradaX = Double.parseDouble(rs.getString("entradaX"));
				double entradaY = Double.parseDouble(rs.getString("entradaY"));
				double salidaX = Double.parseDouble(rs.getString("salidaX"));
				double salidaY = Double.parseDouble(rs.getString("salidaY"));
				double paso = Double.parseDouble(rs.getString("paso"));
				double areaAprox = Double.parseDouble(rs.getString("areaAprox"));
				
				cargado = new Entorno(name,alto,ancho,entradaX,entradaY,salidaX,salidaY,paso,areaAprox);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			return cargado;

		} catch (Exception e) {
			
			return cargado;
			
		}
		
	}
	
}