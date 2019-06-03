/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author INVITE
 */
public class DAOFactory {
    //ligne de connexion A ADAPTER
  //  protected static final Connexion conn = SdzConnexion.getInstance();  

 /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public static DAO getAnneeDAO(){
    return new AnneeDAO(conn);
  }
    public static DAO getBulletinDAO(){
    return new BulletinDAO(conn);
  }
      public static DAO getClasseDAO(){
    return new ClasseDAO(conn);
  }
        public static DAO getEnseignementDAO(){
    return new EnseignementDAO(conn);
  }
          public static DAO getEvaluationDAO(){
    return new EvaluationDAO(conn);
  }
            public static DAO getInscriptionDAO(){
    return new InscriptionDAO(conn);
  }
             public static DAO getPersonneDAO(){
    return new PersonneDAO(conn);
  }
               public static DAO getTrimestreDAO(){
    return new TrimestreDAO(conn);
  }
}
