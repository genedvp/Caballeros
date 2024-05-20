package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                
                //obtener y asignar arma
                Arma arma = getArma(rs.getInt("arma_id"));
                caballero.setArma_id(arma);
                
                //obtener y asignar escudo
                Escudo escudo = getEscudo(rs.getInt("escudo_id"));
                caballero.setEscudo_id(escudo);
                
                System.out.println(caballero.toString());
                
                caballeros.add(caballero);
            }
            
        } catch (SQLException e) {
            System.out.println("Fallo al conectarse en la base de datos.");
            e.printStackTrace();
        }
        
        return caballeros;
    }

    private Escudo getEscudo(int id) {
        String sql = "select * from escudos where id=?";
        Escudo escudo = new Escudo();
        PreparedStatement pst;
        
        try {
            pst = this.conector.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {  // Mover el cursor a la primera fila
                escudo.setId(rs.getInt("id"));
                escudo.setCapacidaDefensa(rs.getInt("capacidad_defensa"));
                escudo.setNombre(rs.getString("nombre"));
            }
            
            return escudo;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Arma getArma(int id) {
        
        String sql = "select * from armas where id=?";
        
        Arma arma = new Arma();
        PreparedStatement pst;
        
        try {
            pst = this.conector.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {  // Mover el cursor a la primera fila
                arma.setId(rs.getInt("id"));
                arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
                arma.setFoto(rs.getString("foto"));
                arma.setNombre(rs.getString("nombre"));
            }
            
            return arma;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
