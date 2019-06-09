
package DAO;

/**
 *
 * @author INVITE
 */
public abstract class DAO<O> {
    
  protected Connexion connect = null;

   //ajouter les méthodes demandées dans le cdc
  public DAO(Connexion conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(O obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(O obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(O obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract O find(int id);
  
    
}

