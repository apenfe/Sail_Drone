package entorno;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import clases.DAO;
import clases.Entradas;

public class Entorno{
	
	private String carta="";
	private int[][][] mapa;
	private String nombre;
	private final int[] ORIGEN = {0,0};
	private double alto;
	private double ancho;
	private double entradaX;
	private double entradaY;
	private double salidaX;
	private double salidaY;
	private double paso;
	private double areaAprox;
	
	public Entorno(double paso, double areaAprox) {
		
		this.nombre = Entradas.texto("Seleccione un nombre para el entorno: ");
		this.alto = Entradas.entero("\nSeleccione un alto para el entorno (eje y): ");
		this.ancho = Entradas.entero("Seleccione un ancho para el entorno (eje x): ");
		this.entradaX = Entradas.entero("\nSeleccione coordenada x de entrada (x): ");
		this.entradaY = Entradas.entero("Seleccione coordenada y de entrada (y): ");
		this.salidaX = Entradas.entero("\nSeleccione coordenada x de salida (x): ");
		this.salidaY = Entradas.entero("Seleccione coordenada y de salida (y): ");
		this.paso = paso;
		this.areaAprox = areaAprox;
		this.carta="mapas\\mapa_1.png";
		cargarCarta();
		
	}
	
	public Entorno(String nombre, double alto, double ancho, double entradaX, double entradaY, double salidaX, double salidaY, double paso, double areaAprox) {
		
		this.nombre = nombre;
		this.alto = alto;
		this.ancho =  ancho;
		this.entradaX =  entradaX;
		this.entradaY =  entradaY;
		this.salidaX =  salidaX;
		this.salidaY =  salidaY;
		this.paso =  paso;
		this.areaAprox =  areaAprox;
		this.carta="mapas\\mapa_1.png";
		cargarCarta();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getEntradaX() {
		return entradaX;
	}

	public void setEntradaX(double entradaX) {
		this.entradaX = entradaX;
	}

	public double getEntradaY() {
		return entradaY;
	}

	public void setEntradaY(double entradaY) {
		this.entradaY = entradaY;
	}

	public double getSalidaX() {
		return salidaX;
	}

	public void setSalidaX(double salidaX) {
		this.salidaX = salidaX;
	}

	public double getSalidaY() {
		return salidaY;
	}

	public void setSalidaY(double salidaY) {
		this.salidaY = salidaY;
	}

	public double getPaso() {
		return paso;
	}

	public void setPaso(double paso) {
		this.paso = paso;
	}

	public double getAreaAprox() {
		return areaAprox;
	}

	public void setAreaAprox(double areaAprox) {
		this.areaAprox = areaAprox;
	}

	public int[] getOrigen() {
		return ORIGEN;
	}
	
	public boolean esSalida(double x, double y) {
		
		return distanciaSalida(x,y)<=areaAprox;
		
	}
	
	public double distanciaSalida(double x, double y) {
		
		double diferenciaX = x - salidaX;
        double diferenciaY = y - salidaY;
        return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
		
	}
	
	public double distanciaEntrada(double x, double y) {

		double diferenciaX = x - entradaX;
		double diferenciaY = y - entradaY;
		return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);

	}

	private boolean esTierra(double x, double y) {

		int ix = (int) x;
		int iy = (int) y;

		// Verificar que las coordenadas estén dentro de los límites de la imagen
		if (ix >= 0 && ix < mapa.length && iy >= 0 && iy < mapa[0].length) {
			return (mapa[ix][iy][0] == 210 && mapa[ix][iy][1] == 180 && mapa[ix][iy][2] == 142);
		}

		return false;

	}
	
	public boolean fueraLimites(double x, double y) {
		
		return esTierra(x,y) || x>alto||x<0||y>ancho||y<0;
		
	}
	
	public boolean guardarEntorno() {
		
		DAO db = new DAO();
		
		return db.guardarEntorno(this);

	}

	public boolean cargarCarta() {

		try {
		
			File file = new File(this.carta);
			BufferedImage image = ImageIO.read(file);

			int width = image.getWidth();
			int height = image.getHeight();

			this.mapa = new int[height][width][3];

			for (int x = 0; x < width; x++) {
				
				for (int y = 0; y < height; y++) {
					
					int pixel = image.getRGB(x, y);

					int red = (pixel >> 16) & 0xff;
					int green = (pixel >> 8) & 0xff;
					int blue = pixel & 0xff;

					this.mapa[y][x][0] = red;
					this.mapa[y][x][1] = green;
					this.mapa[y][x][2] = blue;
					
				}
				
			}

			return true;
			
		} catch (IOException e) {
			
			return false;
			
		}
		
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
		cargarCarta();
	}

}