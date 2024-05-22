package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.Caballero;
import modelo.Escudo;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class GuardarCaballero
 */
@WebServlet("/GuardarCaballero")
public class GuardarCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
        int fuerza = Integer.parseInt(request.getParameter("fuerza"));
        int armaId = Integer.parseInt(request.getParameter("arma"));
        int escudoId = Integer.parseInt(request.getParameter("escudo"));

        ModeloCaballero modeloCaballero = new ModeloCaballero();
        Arma arma = new Arma();
        arma = modeloCaballero.getArma(armaId);
        
        Escudo escudo = new Escudo();
        escudo = modeloCaballero.getEscudo(escudoId);

        Caballero caballero = new Caballero();
        
        

        
		if (nombre != null && !nombre.isEmpty() && !modeloCaballero.nombreExiste(nombre) &&
        	    arma != null && armaId > 0 && escudo != null && escudoId > 0 && modeloCaballero.rango(fuerza)) {
			
			caballero.setNombre(nombre);
			
			caballero.setFuerza(fuerza);
			
			caballero.setArma_id(arma);
	        
	        caballero.setEscudo_id(escudo);
	        
	        modeloCaballero.guardarCaballero(caballero);
	        
	        response.sendRedirect("VerCaballeros?msg=valido");
	        
		} else {
			
			response.sendRedirect("VerCaballeros?msg=noValido");
		}
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
