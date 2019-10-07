package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.UnidadException;
import views.EdificioView;
import views.UnidadView;

import javax.persistence.*;


@Entity
@Table (name="unidades")
public class UnidadEntity {

	@Column(name="identificador")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String piso;
	private String numero;
	private String habitado;

    @ManyToOne
    @JoinColumn(name = "codigoEdificio")
	private EdificioEntity edificio;
    
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "duenios",
            joinColumns = @JoinColumn(name = "identificador"),
            inverseJoinColumns = @JoinColumn(name = "documento")
    )
    private List<PersonaEntity> duenios;
    
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "inquilinos",
            joinColumns = @JoinColumn(name = "identificador"),
            inverseJoinColumns = @JoinColumn(name = "documento")
    )
	private List<PersonaEntity> inquilinos;
    
    public void setDuenios(List<PersonaEntity> duenios) {
		this.duenios = duenios;
	}

	public void setInquilinos(List<PersonaEntity> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public UnidadEntity() {}
	
	public UnidadEntity(int id, String piso, String numero, String habitado, EdificioEntity edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.setHabitado(habitado);
		this.edificio = edificio;
		//this.duenios = new ArrayList<Persona>();
		//this.inquilinos = new ArrayList<Persona>();
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

	
	public EdificioEntity getEdificio() {
		return edificio;
	}

	public List<PersonaEntity> getDuenios() {
		return duenios;
	}

	public List<PersonaEntity> getInquilinos() {
		return inquilinos;
	}

	public String getHabitado() {
		return habitado;
	}

	public void setHabitado(String habitado) {
		this.habitado = habitado;
	}


}
