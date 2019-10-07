package entities;

import javax.persistence.*;

@Entity
@Table (name="imagenes")
public class ImagenEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int numero;
	@Column (name="bytes")
	private byte[] enBytes;
	private String tipo;
	
	@ManyToOne 
    @JoinColumn(name = "idReclamo")
	private ReclamoEntity reclamo;
	
		
	public ImagenEntity() {}
	
	public ImagenEntity(byte[] enBytes, String tipo) {
		this.enBytes = enBytes;
		this.tipo = tipo;
	}
	
	public ImagenEntity(int numero, byte[] enBytes, String tipo) {
		this.numero = numero;
		this.enBytes = enBytes;
		this.tipo = tipo;
	}

	public ReclamoEntity getReclamo() {
		return reclamo;
	}

	public void setReclamo(ReclamoEntity reclamo) {
		this.reclamo = reclamo;
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
