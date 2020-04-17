package mypackage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

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
		Match match = new Match();
		try {
			while(rs.next()) {
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return match;
	}
	
	
	public Match searchMatch(String nomMatch){
		String sql = "select * from matchinfo where nomMatch = '" + nomMatch +"';";
		ResultSet rs = query(sql); 
		Match match = new Match();
		try {
			while(rs.next()) {
				match.setIdMatch(rs.getInt("idmatch"));
				match.setNomMatch(rs.getString("nomMatch"));
				match.setDate(rs.getDate("date"));
				match.setVille(rs.getString("ville"));
				match.setStade(rs.getString("stade"));
				match.setIdEquipe1(rs.getInt("Equipe_idEquipe1"));
				match.setIdEquipe2(rs.getInt("Equipe_idEquipe2"));
				match.setPointEquipe1(rs.getInt("pointEquipe1"));
				match.setPointEquipe2(rs.getInt("pointEquipe2"));
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
	
}
