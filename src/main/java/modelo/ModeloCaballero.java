package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCaballero {
	
	private Conector conector = new Conector();
	
	public ArrayList<Caballero> getCaballeros() {
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		String sql = "select * from caballeros";

		try {
			
            PreparedStatement pst = this.conector.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				Caballero caballero = new Caballero();
				
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setFoto(rs.getString("foto"));
				
				//obtener y asignar arma
				Arma arma = new Arma();
				arma.setId(rs.getInt("arma_id"));
				caballero.setArma_id(arma);
				
				System.out.println(caballero.toString());
				
				caballeros.add(caballero);
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo al conectarser en la base de datos.");
			e.printStackTrace();
		}
		
		return caballeros;
	}

}
