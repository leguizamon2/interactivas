package modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import DAOs.ReclamoDAO;
import views.EdificioView;
import views.Estado;
import views.ImagenView;
import views.PersonaView;
import views.ReclamoView;
import views.UnidadView;

public class Reclamo {

	private int numero;
	private Persona usuario;
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	private Unidad unidad;
	private Estado estado;
	private List<Imagen> imagenes;
	
	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<Imagen>();
	}
	
	public Reclamo(int numero, Estado estado, Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = estado;
		this.numero = numero;
		imagenes = new ArrayList<Imagen>();
	}

		
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public List<Imagen> getImagenes(){
		return this.imagenes;
	}
	
	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}

	public void save() {
		numero = new ReclamoDAO().save(this);
	}
	
	public void update() {
		numero = new ReclamoDAO().update(this);
	}
	
	public void setImagen(Imagen i) {
		 imagenes.add(i);			
	}
	
	
	public void agregarImagen(String direccion, String tipo) throws IOException {
	  
		Imagen imagen = new Imagen(aBytes(direccion), tipo);
		imagenes.add(imagen);
		imagen.save(numero);			
	}
	
	
	
	private byte[] aBytes(String direccion) throws IOException {
				
		BufferedImage originalImage = ImageIO.read(new File(direccion));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos);
		baos.flush();
		byte[] bytesImg = baos.toByteArray();
		return bytesImg;
	}
	
	
	
	

	public ReclamoView toView() throws IOException {
		
		List<ImagenView> imags = null;
		
				
		for(Imagen i : this.imagenes)
			imags.add(i.toView());
		
		
		
		ReclamoView rv = new ReclamoView(this.numero, this.usuario.toView(),this.edificio.toView(),
										this.ubicacion,	this.descripcion,this.unidad.toView(),
										this.estado, imags);
				
		
		return rv;
		
			
	}
	
}
