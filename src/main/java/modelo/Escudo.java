package modelo;

public class Escudo {
	
	private int id;
	private String nombre;
	private int capacidaDefensa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidaDefensa() {
		return capacidaDefensa;
	}
	public void setCapacidaDefensa(int capacidaDefensa) {
		this.capacidaDefensa = capacidaDefensa;
	}
	
	@Override
	public String toString() {
		return "Escudo [id=" + id + ", nombre=" + nombre + ", capacidaDefensa=" + capacidaDefensa + "]";
	}
	

}
