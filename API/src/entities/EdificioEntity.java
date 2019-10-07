package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="edificios")
public class EdificioEntity {
	
	@Id
	private int codigo;
	private String nombre;
	private String direccion;  
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.MERGE)
	private List<UnidadEntity> unidades;
	
	
	public EdificioEntity() { }

	public EdificioEntity(int codigo, String nombre, String direccion){
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public List<UnidadEntity> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadEntity> unidades) {
		this.unidades = unidades;
	}
	
}
                            