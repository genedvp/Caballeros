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
 * Servlet implementation class VerCaballeros
 */
@WebServlet("/VerCaballeros")
public class VerCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		String desconocido = request.getParameter("stringDesconocido");
		
		ModeloCaballero mc = new ModeloCaballero();
		
		if (desconocido != null) {

			ArrayList<Caballero> caballeros = mc.getCaballerosConNombre(desconocido);
			
			request.setAttribute("caballeros", caballeros);
			
			request.getRequestDispatcher("VerCaballeros.jsp").forward(request, response);
			
		} else {
			
			ArrayList<Caballero> caballeros = mc.getCaballeros();
			
			request.setAttribute("caballeros", caballeros);
			
			request.getRequestDispatcher("VerCaballeros.jsp").forward(request, response);
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
