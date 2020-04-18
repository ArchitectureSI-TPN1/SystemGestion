package mypackage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import mypackage.model.Equipe;
import mypackage.model.Match;

public class MatchDao extends BaseDao{
	
	public List<Match> getMatchs(){
		String sql = "select * from matchinfo";
		ResultSet rs = query(sql); 
		List<Match> matchs = new ArrayList<Match>();
		try {
			while(rs.next()) {
				Match match = new Match();
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
				matchs.add(match);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return matchs;
	}
	
	public boolean addMatch(Match match) {
		String sql = "insert into matchinfo values(" + match.getIdMatch();
		sql += ",'"+match.getNomMatch()+"'"; 
		sql += ",'"+match.getDate()+"'"; 
		sql += ",'"+match.getVille()+"'"; 
		sql += ",'"+match.getStade()+"'"; 
		sql += ","+match.getIdEquipe1(); 
		sql += ","+match.getIdEquipe2(); 
		sql += ","+match.getPointEquipe1();
		sql += ","+match.getPointEquipe2();
		sql += ")";
		return update(sql);
	}
	
	public boolean deleteMatch(int paramId) {
		// TODO Auto-generated method stub
		String sql = "delete from matchinfo where idmatch =" + paramId; 
		return update(sql);
	}
	
	public boolean editMatch(Match match) {
		int id = match.getIdMatch();
		String nomMatch = match.getNomMatch();
		Date Date = match.getDate();
		String ville = match.getVille();
		String stade = match.getStade();
		int idEquipe1 = match.getIdEquipe1();
		int idEquipe2 = match.getIdEquipe2();
		int pointEquipe1 = match.getPointEquipe1();
		int pointEquipe2 = match.getPointEquipe2();
		
	
		String sql = "update matchinfo set idmatch = "+id;
		sql += ",nomMatch = '"+ nomMatch+"'";
		sql += ",date = '"+ Date+"'";
		sql += ",ville = '"+ ville+"'";
		sql += ",stade = '"+ stade+"'";
		sql += ",Equipe_idEquipe1 = "+ idEquipe1;
		sql += ",Equipe_idEquipe2 = "+ idEquipe2;
		sql += ",pointEquipe1 = "+ pointEquipe1;
		sql += ",pointEquipe2 = "+ pointEquipe2;
		sql += " where idmatch = " + id;
		//System.out.println(sql);
		return update(sql);
	}
	
	public Match searchMatch(int idMatch){
		String sql = "select * from matchinfo where idmatch = '" + idMatch +"';";
		ResultSet rs = query(sql); 
		Match match = null;
	
		try {
			while(rs.next()) {
				match = new Match();
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
				return match;
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return match;
	}
	
	
	public Match searchMatch(String nomMatch){
		String sql = "select * from matchinfo where nomMatch = '" + nomMatch +"';";
		ResultSet rs = query(sql); 
		Match match = null;
		
		try {
			while(rs.next()) {
				match = new Match();
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
				return match;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return match;
	}
	
	public List<Match> searchMatchs(String nomMatch){
		String sql = "select * from matchinfo where nomMatch = '" + nomMatch +"';";
		ResultSet rs = query(sql); 
		List<Match> matchs = new ArrayList<Match>();
		try {
			while(rs.next()) {
				Match match = new Match();
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
				matchs.add(match);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return matchs;
	}
	
	public List<Match> searchMatchsByEquipe(String nomEquipe){
		List<Match> matchs = new ArrayList<Match>();
		//matchs = null;
		EquipeDao equipeDao = new EquipeDao();
		Equipe equipe = equipeDao.searchEquipe(nomEquipe);
		//String sql = "select * from matchinfo where Equipe_idEquipe1 = 4 OR Equipe_idEquipe2 = 4;";
		if (equipe!=null) {
			String sql = "select * from matchinfo where Equipe_idEquipe1 = " + equipe.getIdEquipe() + "  OR Equipe_idEquipe2 = '" + equipe.getIdEquipe() +"';";
			ResultSet rs = query(sql); 
			try {
				while(rs.next()) {
					Match match = new Match();
					match.setIdMatch(rs.getInt("idmatch"));
					match.setNomMatch(rs.getString("nomMatch"));
					match.setDate(rs.getDate("date"));
					match.setVille(rs.getString("ville"));
					match.setStade(rs.getString("stade"));
					match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
					match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
					match.setPointEquipe1(rs.getInt("pointEquipe1"));
					match.setPointEquipe2(rs.getInt("pointEquipe2"));
					matchs.add(match);
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
		
		/*sql = "select * from matchinfo where Equipe_idEquipe2 = '" + equipe.getIdEquipe() +"';";
		rs = query(sql); 
		try {
			while(rs.next()) {
				Match match = new Match();
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
				matchs.add(match);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}*/
		return matchs;
	}
	public List<String> getNomsEquipesSearch(int m, String nomEquipe){
		//List<Match> matchs = new ArrayList<Match>();
		EquipeDao equipeDao = new EquipeDao();
		Equipe equipe = equipeDao.searchEquipe(nomEquipe);
		List<String> nomsEquipes = new ArrayList<String>();
		//String sql = "select * from matchinfo where Equipe_idEquipe1 = 4 OR Equipe_idEquipe2 = 4;";
		if(equipe!=null) {
			String sql = "select * from matchinfo where Equipe_idEquipe1 = " + equipe.getIdEquipe() + " OR Equipe_idEquipe2 = " + equipe.getIdEquipe() +";";
			ResultSet rs = query(sql); 
			//List<String> nomEquipes = new ArrayList<String>();
			try {
				while(rs.next()) {
					equipeDao = new EquipeDao();
					nomEquipe = "";
					if(m==0) {
						nomEquipe = equipeDao.searchEquipe(rs.getInt("Equipe_idEquipe1")).getNomEquipe();

					}else if(m==1) {
						nomEquipe = equipeDao.searchEquipe(rs.getInt("Equipe_idEquipe2")).getNomEquipe();

					}
					//String nomEquipe = searcheEquipeByid(rs.getInt("Equipe_idEquipe")); 
					nomsEquipes.add(nomEquipe);
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return nomsEquipes;
	}
	
	public List<String> getNomsEquipes(int m) {
		String sql = "select * from matchinfo";
		ResultSet rs = query(sql); 
		List<String> nomsEquipes = new ArrayList<String>();
		//List<String> nomEquipes = new ArrayList<String>();
		try {
			while(rs.next()) {
				EquipeDao equipeDao = new EquipeDao();
				String nomEquipe = "";
				if(m==0) {
					nomEquipe = equipeDao.searchEquipe(rs.getInt("Equipe_idEquipe1")).getNomEquipe();

				}else if(m==1) {
					nomEquipe = equipeDao.searchEquipe(rs.getInt("Equipe_idEquipe2")).getNomEquipe();

				}
				//String nomEquipe = searcheEquipeByid(rs.getInt("Equipe_idEquipe")); 
				nomsEquipes.add(nomEquipe);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return nomsEquipes;
	}

	
	
}
