/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Annee;
/**
 *
 * @author INVITE
 */
    public class AnneeDAO extends DAO<Annee> {
  public AnneeDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Annee obj) {
    return false;
  }

  public boolean delete(Annee obj) {
    return false;
  }
   
  public boolean update(Annee obj) {
    return false;
  }
  
   //méthode générique openclassroom
  public Annee find(int id) {
    Annee annee = new Annee();      

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM annee WHERE id_annee = " + id);
      if(result.first())
        annee = new Annee(
          id,
          result.getString("elv_nom"),
          result.getString("elv_prenom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return annee;
  }
}
