/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Annee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author INVITE
 */

public class AnneeDAO extends DAO<Annee> {
    
    
  public AnneeDAO(Connexion conn) {
    super(conn);
  }
/**
 * 
 * @param obj
 * @return 
 */
  @Override
  public boolean create(Annee obj) {
    int resultat;
    //String requete ="INSERT INTO annee('id_annee') VALUES("+obj.getId_annee()+")";
    String requete ="INSERT INTO annee(id_annee) VALUES('"+ obj.getId_annee() +"')";
    try{
        resultat= connect.getStmt().executeUpdate(requete);
        System.out.println("Annee ajoutée");
        return true;
    } catch (Exception e) {
        System.out.println("Annee n'as pas pu être ajoutée");
        return false;
    }  
  }


  public boolean delete(Annee obj) {
    return false;
  }
   
  public boolean update(Annee obj) {
    return false;
  }
  
   //méthode générique openclassroom

 /* public Annee find(int id) {
=======
  public Annee find(int id) {
>>>>>>> 557cffbf159a5bd7bb434aafa61ffe3519065728
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
<<<<<<< HEAD
*/

    @Override
    public Annee find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
