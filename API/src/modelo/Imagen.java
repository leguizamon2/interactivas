package modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import DAOs.ImagenDAO;
import DAOs.PersonaDAO;
import views.ImagenView;
import views.PersonaView;

public class Imagen {

	private int numero;
	private byte[] enBytes;
	private String tipo;
	
	public Imagen(byte[] enBytes, String tipo) {
		this.enBytes = enBytes;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public byte[] getEnBytes() {
		return enBytes;
	}

	public void setEnBytes(byte[] enBytes) {
		this.enBytes = enBytes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void save(int numeroReclamo) throws IOException {
		
		new ImagenDAO().save(this);
			
	}

	public ImagenView toView() {
		return new ImagenView(numero,enBytes,tipo);
	}


}
