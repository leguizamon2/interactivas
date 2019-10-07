package views;

import java.awt.image.BufferedImage;

public class ImagenView {
	
	private int numero;
	private byte[] enBytes;
	private String tipo;
	private BufferedImage img;
	
	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public ImagenView() {}
	
	public ImagenView(BufferedImage img) {
		this.img = img;
	}	
	
	public ImagenView(int numero, byte[] enBytes, String tipo) {
		this.numero = numero;
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
}
