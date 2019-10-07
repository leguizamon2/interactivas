package modelo;

import java.util.ArrayList;
import java.util.List;

import DAOs.PersonaDAO;
import DAOs.UnidadDAO;
import exceptions.UnidadException;
import views.EdificioView;
import views.UnidadView;

public class Unidad {

	private int id;
	private String piso;
	private String numero;
	private String habitado;
	private Edificio edificio;
	private List<Persona> duenios;
	private List<Persona> inquilinos;
	
	public Unidad(int id, String piso, String numero, String habitado, Edificio edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = habitado;
		this.edificio = edificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public void transferir(Persona nuevoDuenio) {
		duenios = new ArrayList<Persona>();
		duenios.add(nuevoDuenio);
	}
	
	public void agregarDuenio(Persona duenio) {
		duenios.add(duenio);
	}
	
	public void alquilar(Persona inquilino) throws UnidadException {
		if(this.habitado != "S") {
			this.habitado = "S";
			inquilinos = new ArrayList<Persona>();
			inquilinos.add(inquilino);
		}
		else
			throw new UnidadException("La unidad esta ocupada");
	}

	public void agregarInquilino(Persona inquilino) {
		inquilinos.add(inquilino);
		this.update();
	}
	


	public String getHabitado() {
		return habitado;
	}
	
	public void setHabitado(String hab) {
		this.habitado = hab;
	}
	
	public void liberar() {
		this.inquilinos = new ArrayList<Persona>();
		this.habitado = "N";
	}
	
	public void habitar() throws UnidadException {
		if(this.habitado == "S")
			throw new UnidadException("La unidad ya esta habitada");
		else
			this.habitado = "S";
	}
	
	public int getId() {
		return id;
	}

	public String getPiso() {
		return piso;
	}

	public String getNumero() {
		return numero;
	}

	
	public Edificio getEdificio() {
		return edificio;
	}

	public List<Persona> getDuenios() {
		return duenios;
	}

	public List<Persona> getInquilinos() {
		return inquilinos;
	}

	public UnidadView toView() {
		EdificioView auxEdificio = edificio.toView();
		return new UnidadView(id, piso, numero, habitado, auxEdificio);
	}
	
	public void save() {
		new UnidadDAO().save(this);						
	}
	
	public void update() {
		// TODO Auto-generated method stub
		new UnidadDAO().update(this);
	}
	
}
