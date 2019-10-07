package entities;

import java.util.ArrayList;
import java.util.List;

import views.Estado;
import javax.persistence.*;

@Entity
@Table (name="reclamos")
public class ReclamoEntity {

	@Column(name="idReclamo")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	@ManyToOne
    @JoinColumn(name = "documento")
	private PersonaEntity usuario;
	
	@ManyToOne
    @JoinColumn(name = "codigo")
	private EdificioEntity edificio;
	
	private String ubicacion;
	private String descripcion;
	
	@ManyToOne
    @JoinColumn(name = "identificador")
	private UnidadEntity unidad;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@OneToMany(mappedBy = "reclamo", cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private List<ImagenEntity> imagenes;
	
	public ReclamoEntity() {}
	
	public ReclamoEntity(PersonaEntity usuario, EdificioEntity edificio, String ubicacion, String descripcion, UnidadEntity unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<ImagenEntity>();
	}
	
	public ReclamoEntity(int numero, Estado estado, PersonaEntity usuario, EdificioEntity edificio, String ubicacion, String descripcion, UnidadEntity unidad) {
		this.numero = numero;
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = estado;
		imagenes = new ArrayList<ImagenEntity>();
	}

		
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public PersonaEntity getUsuario() {
		return usuario;
	}

	public EdificioEntity getEdificio() {
		return edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public UnidadEntity getUnidad() {
		return unidad;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public List<ImagenEntity> getImagenes(){
		return this.imagenes;
	}
	
	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}

	
}
