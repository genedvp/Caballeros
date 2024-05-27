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
@WebServlet("/LuchaCaballero1")
public class LuchaCaballero2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuchaCaballero2() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idElegido = Integer.parseInt(request.getParameter("elegido"));
		
		//o caballero1 probar con ambos
		
		ModeloCaballero mc = new ModeloCaballero();
		
		ArrayList<Caballero> caballeros = mc.removeCaballero(idElegido);
		
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("VerLucha.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
