package mypackage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypackage.model.Joueur;

public class JoueurDao extends BaseDao{
	public List<Joueur> getJoueurs(){
		String sql = "select * from joueur";
		ResultSet rs = query(sql); 
		List<Joueur> joueurs = new ArrayList<Joueur>();
		try {
			while(rs.next()) {
				Joueur joueur = new Joueur();
				joueur.setIdjoueur(rs.getInt("idJoueur"));
				joueur.setNomJoueur(rs.getString("nomJoueur"));
				joueur.setBut(rs.getInt("but"));
				joueur.setRole(rs.getString("role"));
				joueur.setNotePrese(rs.getFloat("notePrese"));
				joueur.setEquipe_idEquipe(rs.getInt("Equipe_idEquipe"));
				joueurs.add(joueur);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return joueurs;
	}
	
	public boolean addJoueur(Joueur joueurAdd) {
		String sql = "insert into joueur values(" + joueurAdd.getIdjoueur();
		sql += ",'"+joueurAdd.getNomJoueur()+"'"; ;
		sql += ","+joueurAdd.getBut(); ;
		sql += ", '"+joueurAdd.getRole()+"'"; 
		sql += ","+ joueurAdd.getNotePrese();
		sql += ","+ joueurAdd.getEquipe_idEquipe();
		sql += ")";
		System.out.println(sql);
		return update(sql);
	}
	
	public Joueur searchJoueur(String ParamNom) {
		String sql = "select * from joueur where nomJoueur = '" + ParamNom +"';";
		Joueur joueur = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				joueur = new Joueur();
				joueur.setIdjoueur(resultSet.getInt("idjoueur"));
				joueur.setNomJoueur(resultSet.getString("nomJoueur"));
				joueur.setBut(resultSet.getInt("but"));
				joueur.setRole(resultSet.getString("role"));
				joueur.setNotePrese(resultSet.getFloat("notePrese"));
				joueur.setEquipe_idEquipe(resultSet.getInt("Equipe_idEquipe"));
				return joueur;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joueur;
	}
	
	public Joueur searchJoueur(int ParamId) {
		String sql = "select * from joueur where idJoueur = "+ParamId;;
		Joueur joueur = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				joueur = new Joueur();
				joueur.setIdjoueur(resultSet.getInt("idjoueur"));
				joueur.setNomJoueur(resultSet.getString("nomJoueur"));
				joueur.setBut(resultSet.getInt("but"));
				joueur.setRole(resultSet.getString("role"));
				joueur.setNotePrese(resultSet.getFloat("notePrese"));
				joueur.setEquipe_idEquipe(resultSet.getInt("Equipe_idEquipe"));
				return joueur;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joueur;
	}
	
	public boolean deleteJoueur(int ParamId) {
		String sql = "delete from joueur where idJoueur =" + ParamId; 
		return update(sql);
	}
	
	public boolean editJoueur(Joueur joueur) {
		int id = joueur.getIdjoueur();
		String nomJoueur = joueur.getNomJoueur();
		int but = joueur.getBut();
		String role = joueur.getRole();
		Float notePrese = joueur.getNotePrese();
		int idEquipe = joueur.getEquipe_idEquipe();
		String sql = "update joueur set idjoueur = "+id;
		sql += ", nomJoueur = '"+nomJoueur+"'";
		sql += ", but = "+but;
		sql += ", role = '"+role+"'";
		sql += ", notePrese = "+notePrese;
		sql += ", Equipe_idEquipe = "+idEquipe;
		sql += " where idjoueur = "+id;
		System.out.println(sql);
		return update(sql);
	}
}
