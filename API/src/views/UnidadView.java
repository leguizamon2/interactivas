package views;

public class UnidadView {

	private int id;
	private String piso;
	private String numero;
	private String habitado;
	private EdificioView edificio;
	
	public UnidadView() {}

	public UnidadView(int id, String piso, String numero, String habitado, EdificioView edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = "";
		this.edificio = edificio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String isHabitado() {
		return habitado;
	}

	public void setHabitado(String habitado) {
		this.habitado = habitado;
	}

	public EdificioView getEdificio() {
		return edificio;
	}

	public void setEdificio(EdificioView edificio) {
		this.edificio = edificio;
	}
	
	public String toString() {
		return piso + " " + numero;
	}
}
