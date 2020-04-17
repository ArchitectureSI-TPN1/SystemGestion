package mypackage.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.dao.EquipeDao;
import mypackage.dao.MatchDao;
import mypackage.model.Equipe;
import mypackage.model.Match;

/**
 * Servlet implementation class matchServlet
 */
public class matchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public matchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomMatch = request.getParameter("searchInfo");
		String button = request.getParameter("button");
		Match match = null;
		if(nomMatch != null && "search".equals(button)) {
			match = searchMatch(nomMatch);
			//System.out.println(equipe.getIdEquipe());
			request.setAttribute("matchInfo", match);
			request.getRequestDispatcher("view/matchView.jsp").forward(request,response);
		}else if(request.getParameter("chk") != null && "delete".equals(button)) {
			int delInfo = Integer.parseInt(request.getParameter("chk"));  
			if(deleteMatch(delInfo)) {
				request.setAttribute("message", "delSuccess");
				request.getRequestDispatcher("SystemServlet?element=match").forward(request,response);
			}else {
				request.setAttribute("message", "delFailed");
				request.getRequestDispatcher("view/matchView.jsp").forward(request,response);
			}
		}else if("add".equals(button)) {
			request.setAttribute("showAdd", "showAdd");
			request.getRequestDispatcher("view/matchView.jsp").forward(request,response);
		}else if("submitAdd".equals(button)) {
			int idMatch = Integer.parseInt(request.getParameter("idmatch"));
			String nomMatchAdd = request.getParameter("nomMatch");
			Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date date = new java.sql.Date(utilDate.getTime());
			String ville = request.getParameter("ville");
			String stade = request.getParameter("stade");
			int idEquipe1 = Integer.parseInt(request.getParameter("equipe1"));
			int idEquipe2 = Integer.parseInt(request.getParameter("equipe2"));
			int pointEquipe1 = Integer.parseInt(request.getParameter("point1"));
			int pointEquipe2 = Integer.parseInt(request.getParameter("point2"));
			
			match = new Match();
			match.setIdMatch(idMatch);
			match.setNomMatch(nomMatchAdd);
			match.setDate(date);
			match.setVille(ville);
			match.setStade(stade);
			match.setIdEquipe1(idEquipe1);
			match.setIdEquipe2(idEquipe2);
			match.setPointEquipe1(pointEquipe1);
			match.setPointEquipe2(pointEquipe2);
			addMatch(match);
			request.getRequestDispatcher("SystemServlet?element=match").forward(request,response);
		}else if("edit".equals(button)&& request.getParameter("chk") != null) {
			String edit = request.getParameter("chk");
				request.setAttribute("matchEdit", "alertVide");	
			Match matchEdit = searchMatch(Integer.parseInt(edit));
			request.setAttribute("matchEdit", matchEdit);	
			request.getRequestDispatcher("view/matchView.jsp").forward(request,response);
		}else if("submitEdit".equals(button)) {
			String editIdMatch = request.getParameter("editIdMatch");
			String editNomMatch = request.getParameter("editNomMatch");
			String date = request.getParameter("editDate");
			String editVille = request.getParameter("editVille");
			String editStade = request.getParameter("editStade");
			String editIdEquipe1 = request.getParameter("editEquipe1");
			String editIdEquipe2 = request.getParameter("editEquipe2");
			String editPoint1 = request.getParameter("editPoint1");
			String editPoint2 = request.getParameter("editPoint2");

			//Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			//java.sql.Date editdate = new java.sql.Date(utilDate.getTime());
			Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date editdate = new java.sql.Date(utilDate.getTime());
			match = new Match();
			match.setIdMatch(Integer.parseInt(editIdMatch));
			match.setNomMatch(editNomMatch);
			match.setDate(editdate);
			match.setVille(editVille);
			match.setStade(editStade);
			match.setIdEquipe1(Integer.parseInt(editIdEquipe1));
			match.setIdEquipe2(Integer.parseInt(editIdEquipe2));
			match.setPointEquipe1(Integer.parseInt(editPoint1));
			match.setPointEquipe2(Integer.parseInt(editPoint2));
			
			if(editMatch(match)) {
				request.setAttribute("message", "editSuccess");
				request.getRequestDispatcher("SystemServlet?element=match").forward(request,response);
			}
			
		}

		if("edit".equals(button) && request.getParameter("chk") == null) {
			request.getRequestDispatcher("view/wrong.jsp").forward(request,response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Match searchMatch(int idMatch) {
		MatchDao matchDao = new MatchDao();
		Match match = matchDao.searchMatch(idMatch);
		return match;
	}
	
	private Match searchMatch(String nomMatch) {
		MatchDao matchDao = new MatchDao();
		Match match = matchDao.searchMatch(nomMatch);
		return match;
	}
	

	private boolean deleteMatch(int paramId) {
		MatchDao matchDao = new MatchDao();
		return matchDao.deleteMatch(paramId);
	}
	
	private boolean addMatch(Match match) {
		MatchDao matchDao = new MatchDao();
		return matchDao.addMatch(match);
	}
	
	private boolean editMatch(Match match) {
		MatchDao  matchDao = new MatchDao();
		return matchDao.editMatch(match);
	}


}
