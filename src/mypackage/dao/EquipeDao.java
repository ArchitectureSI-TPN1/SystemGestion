package mypackage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import mypackage.model.Equipe;

public class EquipeDao extends BaseDao{
	public boolean addEquipe(Equipe equipe){
		String sql = "insert into equipe values('"+equipe.getIdEquipe()+"', '"+equipe.getNomEquipe()+"','"+equipe.getNbParticipation()+"','"+equipe.getNbVictore()+"')";
		return update(sql);
	}
	
	public List<Equipe> getEquipes(){
		String sql = "select * from equipe";
		ResultSet rs = query(sql); 
		List<Equipe> equipes = new ArrayList<Equipe>();
		try {
			while(rs.next()) {
				Equipe equipe = new Equipe();
				equipe.setIdEquipe(rs.getInt("idEquipe"));
				equipe.setNomEquipe(rs.getString("nomEquipe"));
				equipe.setNbParticipation(rs.getInt("nbParticipation"));
				equipe.setNbVictore(rs.getInt("nbVictoire"));
				equipes.add(equipe);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return equipes;
	}
	
	public boolean deleteEquipe(String nomEquipe) {
		// TODO Auto-generated method stub
		String sql = "set @@foreign_key_checks = 0;";
		return update(sql);
	}
	
	public Equipe searchEquipe(String ParamNom) {
		String sql = "select * from equipe where nomEquipe = '" + ParamNom +"';";
		Equipe equipe = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				equipe = new Equipe();
				equipe.setIdEquipe(resultSet.getInt("idEquipe"));
				equipe.setNomEquipe(resultSet.getString("nomEquipe"));
				equipe.setNbParticipation(resultSet.getInt("nbParticipation"));
				equipe.setNbVictore(resultSet.getInt("nbVictoire"));
				return equipe;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipe;
	}
}
