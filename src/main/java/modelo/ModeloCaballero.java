package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ModeloCaballero {
    
    private Conector conector = new Conector();
    
    public ArrayList<Caballero> getCaballeros() {
        
        ArrayList<Caballero> caballeros = new ArrayList<>();
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
               
                //obtener toda la información de arma y asignarla 
                Arma arma = getArma(rs.getInt("arma_id"));
                caballero.setArma_id(arma);
                
                //obtener toda la información de esucdo y asignarla 
                Escudo escudo = getEscudo(rs.getInt("escudo_id"));
                caballero.setEscudo_id(escudo);
                
                //System.out.println(caballero.toString());
                
                caballeros.add(caballero);
            }
            
        } catch (SQLException e) {
        	
            System.out.println("Fallo al conectarse en la base de datos. (caballeros)");
           
        }
        
        return caballeros;
    }

    public Escudo getEscudo(int id) {
        String sql = "select * from escudos where id=?";
        Escudo escudo = new Escudo();
        PreparedStatement pst;
        
        try {
            pst = this.conector.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {  
                escudo.setId(rs.getInt("id"));
                escudo.setCapacidaDefensa(rs.getInt("capacidad_defensa"));
                escudo.setNombre(rs.getString("nombre"));
            }
            
            return escudo;
            
        } catch (SQLException e) {
        	
        	System.out.println("Fallo al conectarse en la base de datos. (escudos)");
            return null;
        }
    }

    public Arma getArma(int id) {
        
        String sql = "select * from armas where id=?";
        
        Arma arma = new Arma();
        PreparedStatement pst;
        
        try {
            pst = this.conector.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) { 
                arma.setId(rs.getInt("id"));
                arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
                arma.setFoto(rs.getString("foto"));
                arma.setNombre(rs.getString("nombre"));
            }
            
            return arma;
            
        } catch (SQLException e) {
        	
        	System.out.println("Fallo al conectarse en la base de datos. (armas)");
            return null;
        }
    }

public void guardarCaballero(Caballero caballero) {
		
		String sql = "INSERT INTO caballeros (nombre, fuerza, arma_id, escudo_id) VALUES (?, ?, ?, ?)";
		
		try {
			
			PreparedStatement pst = conector.conexion.prepareStatement(sql);
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3, caballero.getArma_id().getId());
			pst.setInt(4, caballero.getEscudo_id().getId());
			/*pst.setInt(5, 0);
			pst.setString(6, "img_");*/
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error insert caballero");
		}
	}

	public ArrayList<Escudo> getEscudos() {
		
		ArrayList<Escudo> escudos = new ArrayList<>();
		String sql = "select * from escudos";
		
		try {
			PreparedStatement pst = this.conector.conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setCapacidaDefensa(rs.getInt("capacidad_defensa"));
				escudo.setNombre(rs.getString("nombre"));
				
				escudos.add(escudo);
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo al conectarse en la base de datos. (escudos)");
		}
		
		return escudos;
	}

	public ArrayList<Arma> getArmas() {
		
		ArrayList<Arma> armas = new ArrayList<>();
		String sql = "select * from armas";
		
		try {
			PreparedStatement pst = this.conector.conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
				arma.setFoto(rs.getString("foto"));
				arma.setNombre(rs.getString("nombre"));
				
				armas.add(arma);
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo al conectarse en la base de datos. (armas)");
		}
		
		return armas;
	}
	
	public boolean nombreExiste(String nombre) {
		
	    ArrayList<Caballero> caballeros = getCaballeros();
	    
	    for (Caballero caballero : caballeros) {
	        if (caballero.getNombre().equalsIgnoreCase(nombre)) {
	            // existe
	            return true;
	        }
	    }
	    // El nombre no existe
	    return false;
	}

	public boolean rango(int fuerza) {
		
		if (fuerza>0 && fuerza<=100) {
			return true;
			
		}
			return false;
	}

	public boolean caballerosConNombre(String desconocido) {

	ArrayList<Caballero> caballeros = getCaballeros();
		    
		for (Caballero caballero : caballeros) {
			
		    if (caballero.getNombre().contains(desconocido)) {
		    	
		    	return true;
		    	
		        }
		 }
		return false;
		    
	}

	public ArrayList<Caballero> getCaballerosConNombre(String desconocido) {
		
		ArrayList<Caballero> caballeros = getCaballeros();
		
	    Iterator<Caballero> caballerosI = caballeros.iterator();

		    while(caballerosI.hasNext()) {
		    	
		      Caballero c = (Caballero) caballerosI.next();
	
			      if (!(c.getNombre().toLowerCase().contains(desconocido.toLowerCase()))) {
			    	  
			    	  caballerosI.remove();
			    	  
			        }
		    }
		
		return caballeros;
	}

	public ArrayList<Caballero> removeCaballero(int idElegido) {

		ArrayList<Caballero> caballeros = getCaballeros();
		
	    Iterator<Caballero> caballerosI = caballeros.iterator();

		    while(caballerosI.hasNext()) {
		    	
		      Caballero c = (Caballero) caballerosI.next();
	
			      if ((c.getId()==idElegido)) {
			    	  
			    	  caballerosI.remove();
			    	  
			        }
		    }
		return caballeros;
		
	}

	public Caballero getCaballero(int idPrimero) {
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
               
                //obtener toda la información de arma y asignarla 
                Arma arma = getArma(rs.getInt("arma_id"));
                caballero.setArma_id(arma);
                
                //obtener toda la información de esucdo y asignarla 
                Escudo escudo = getEscudo(rs.getInt("escudo_id"));
                caballero.setEscudo_id(escudo);
                
                return caballero;
            }
            
        } catch (SQLException e) {
        	
            System.out.println("Fallo al conectarse en la base de datos. (OBTENER UN CABALLERO)");
           
        }
        
        return null;
	}
}