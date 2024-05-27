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
 * Servlet implementation class LuchaCaballero1
 */
@WebServlet("/LuchaCaballeroSegundo")
public class LuchaCaballeroSegundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuchaCaballeroSegundo() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPrimero = Integer.parseInt(request.getParameter("idPrimero"));
		
		ModeloCaballero mc = new ModeloCaballero();
		
		ArrayList<Caballero> caballeros = mc.removeCaballero(idPrimero);
		
		request.setAttribute("idPrimero", idPrimero);
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("VerLuchaSegundo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
