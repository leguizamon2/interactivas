package controlador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import DAOs.EdificioDAO;
import DAOs.ImagenDAO;
import DAOs.PersonaDAO;
import DAOs.ReclamoDAO;
import DAOs.UnidadDAO;
import exceptions.EdificioException;
import exceptions.ImagenException;
import exceptions.PersonaException;
import exceptions.ReclamoException;
import exceptions.UnidadException;
import modelo.Edificio;
import modelo.Imagen;
import modelo.Persona;
import modelo.Reclamo;
import modelo.Unidad;
import views.EdificioView;
import views.Estado;
import views.PersonaView;
import views.ReclamoView;
import views.UnidadView;

public class Controlador {

		private static Controlador instancia = null;
			
		private Controlador() {}

		public static Controlador getInstancia() {
				if(instancia == null)
					instancia = new Controlador();
				return instancia;
			}
	
		public List <PersonaView> getPersonas(){
			List<PersonaView> resultado = new ArrayList<PersonaView>();
			List<Persona> personas = new PersonaDAO().getPersonas();
			for(Persona p : personas)
				resultado.add(p.toView());
			return resultado;
		}
		
		
	public List<EdificioView> getEdificios(){
		List<EdificioView> resultado = new ArrayList<EdificioView>();
		List<Edificio> edificio = new EdificioDAO().getEdificios();
		for(Edificio e : edificio)
			resultado.add(e.toView());
		return resultado;
	}
	
	
	public List<ReclamoView> getReclamos() throws IOException{
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		List<Reclamo> reclamo= new ReclamoDAO().getReclamos();
		for(Reclamo r : reclamo)
			resultado.add(r.toView());
		return resultado;
	}
	
	
	//agregado para chequeo, no estaba
	public BufferedImage getREIMG(int numReclamo) throws IOException, ImagenException{
	  Imagen i= new ImagenDAO().findById(numReclamo);
	  InputStream in = new ByteArrayInputStream(i.getEnBytes());
	  BufferedImage img = ImageIO.read(in);
	  return img; 
	 
	}
	
		
	
	
	
	
	public List<UnidadView> getUnidadesPorEdificio(int codigo) throws EdificioException{
		List<UnidadView> resultado = new ArrayList<UnidadView>();
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		for(Unidad unidad : unidades)
			resultado.add(unidad.toView());
		return resultado;
	}
	
	public List<PersonaView> habilitadosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habilitados = edificio.habilitados();
		for(Persona persona : habilitados)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> duenios = edificio.duenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> habitantesPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habitantes = edificio.habitantes();
		for(Persona persona : habitantes)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> dueniosPorUnidad(int codigo) throws UnidadException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo);
		List<Persona> duenios = unidad.getDuenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> inquilinosPorUnidad(int codigo, String piso, String numero) throws UnidadException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo);
		List<Persona> inquilinos = unidad.getInquilinos();
		for(Persona persona : inquilinos)
			resultado.add(persona.toView());
		return resultado;
	}
	
	public void transferirUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);
		unidad.update();
	}

	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
		unidad.update();
	}

	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
		unidad.update();
	}

	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);
	}

	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo);
		unidad.liberar();
		unidad.update();
	}
	
	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo);
		unidad.habitar();
		unidad.update();
	}
	
	public void agregarPersona(String documento, String nombre) {
		Persona persona = new Persona(documento, nombre);
		persona.save();
	}
	
	public void eliminarPersona(String documento) throws PersonaException {
		Persona persona = buscarPersona(documento);
		persona.delete();
	}
	
	public List<ReclamoView> reclamosPorEdificio(int codigo) throws EdificioException, ReclamoException, IOException{
		List<Reclamo> resultado = new ArrayList<Reclamo>();
		List<ReclamoView> resultadoV = new ArrayList<ReclamoView>();
				
		resultado = new ReclamoDAO().findByEdificio(codigo);
		
		for(Reclamo r : resultado)
			resultadoV.add(r.toView());
		
		return resultadoV;
	}
	
	public List<ReclamoView> reclamosPorUnidad(int codigo, String piso, String numero) throws ReclamoException, IOException {
			
		List<Reclamo> resultado = new ArrayList<Reclamo>();
		List<ReclamoView> resultadoV = new ArrayList<ReclamoView>();
				
		resultado = new ReclamoDAO().findByUnidad(codigo,piso,numero);
		
		for(Reclamo r : resultado)
			resultadoV.add(r.toView());
		
		return resultadoV;
		
	}
	
	public ReclamoView reclamosPorNumero(int numero) throws IOException, ReclamoException {
					
		return new ReclamoDAO().findById(numero).toView();
	}
	
	public List<ReclamoView> reclamosPorPersona(String documento) throws PersonaException, IOException {
		List<Reclamo> resultado = new ArrayList<Reclamo>();
		List<ReclamoView> resultadoV = new ArrayList<ReclamoView>();
				
		resultado = new ReclamoDAO().findByPersona(documento);
		
		for(Reclamo r : resultado)
			resultadoV.add(r.toView());
		
		return resultadoV;
	}
 
	public int agregarReclamo(int codigoEd, int codigoUn, String piso, String documento, String ubicacion, String descripcion) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigoEd);
		Unidad unidad = buscarUnidad(codigoUn);
		Persona persona = buscarPersona(documento);
		Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
		reclamo.save();
		return reclamo.getNumero();
	}
	
	
	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException, IOException {
		Reclamo reclamo = buscarReclamo(numero);
				
		reclamo.agregarImagen(direccion, tipo);
			
	}
	
	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
		reclamo.update();
	}
	
	private Edificio buscarEdificio(int codigo) throws EdificioException {
		Edificio e = new EdificioDAO().findById(codigo, true);
		return e;
	}

	private Unidad buscarUnidad(int codigo) throws UnidadException{
		Unidad u = new UnidadDAO().findById(codigo);
		return u;
	}	
	
	private Persona buscarPersona(String documento) throws PersonaException {
		
		Persona p = new PersonaDAO().findById(documento);
		return p;
		
	}
	
	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		Reclamo r = new ReclamoDAO().findById(numero);
		return r;
	}
}

	