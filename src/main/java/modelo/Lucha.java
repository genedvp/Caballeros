package modelo;

import java.util.Date;

public class Lucha {
	
	private int id;
	private Date fecha;
	private Caballero caballero1_id;
	private Caballero caballero2_id;
	private Caballero ganador_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Caballero getCaballero1_id() {
		return caballero1_id;
	}
	public void setCaballero1_id(Caballero caballero1_id) {
		this.caballero1_id = caballero1_id;
	}
	public Caballero getCaballero2_id() {
		return caballero2_id;
	}
	public void setCaballero2_id(Caballero caballero2_id) {
		this.caballero2_id = caballero2_id;
	}
	public Caballero getGanador_id() {
		return ganador_id;
	}
	public void setGanador_id(Caballero ganador_id) {
		this.ganador_id = ganador_id;
	}	

}
