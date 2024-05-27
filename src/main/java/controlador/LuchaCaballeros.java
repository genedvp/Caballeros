package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class LuchaCaballeros
 */
@WebServlet("/LuchaCaballeros")
public class LuchaCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LuchaCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPrimero = Integer.parseInt(request.getParameter("idPrimero"));
		int idSegundo = Integer.parseInt(request.getParameter("idSegundo"));
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		ModeloCaballero mc = new ModeloCaballero();
		
		Caballero caballero1 = mc.getCaballero(idPrimero);
		Caballero caballero2 = mc.getCaballero(idSegundo);
		
		request.setAttribute("caballero1", caballero1);
		request.setAttribute("caballero2",caballero2);
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("LuchaCaballeros.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
