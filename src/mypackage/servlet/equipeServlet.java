package mypackage.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypackage.dao.EquipeDao;
import mypackage.model.Equipe;

/**
 * Servlet implementation class equipeServlet
 */
public class equipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public equipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEquipe = request.getParameter("searchInfo");
		
		String button = request.getParameter("button");
		System.out.println(button);
		Equipe equipe = null;
		if(nomEquipe != null && "search".equals(button)) {
			equipe = searchEquipe(nomEquipe);
			//System.out.println(equipe.getIdEquipe());
			request.setAttribute("equipeInfo", equipe);
			request.getRequestDispatcher("view/equipeView.jsp").forward(request,response);
		}else if(nomEquipe != null && "delete".equals(button)) {
			if(deleteEquipe(nomEquipe)) {
				request.setAttribute("delMessage", "delSuccess");
				request.getRequestDispatcher("view/equipeView.jsp").forward(request,response);
			}else {
				request.setAttribute("delMessage", "delFailed");
			}
			
		}
		
			
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Equipe searchEquipe(String nomEquipe) {
		EquipeDao equipeDao = new EquipeDao();
		Equipe equipe = equipeDao.searchEquipe(nomEquipe);
		return equipe;
	}
	
	private boolean deleteEquipe(String paramNom) {
		EquipeDao equipeDao = new EquipeDao();
		return equipeDao.deleteEquipe(paramNom);
	}

}
