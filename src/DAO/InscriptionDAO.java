/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import modele.Classe;
import modele.Inscription;
import modele.Personne;

/**
 *
 * @author INVITE
 */
public class InscriptionDAO extends DAO<InscriptionDAO>{

     public InscriptionDAO(Connexion conn) {
        super(conn);
    }
    @Override
    public boolean create(InscriptionDAO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(InscriptionDAO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(InscriptionDAO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InscriptionDAO find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Inscription> listeEleve() {
    ResultSet resultat;
    ArrayList<Inscription> listeEleve = new ArrayList<>(); 
    String requete ="SELECT i.id_inscription, p.id_personne, c.id_classe , p.nom, p.prenom, c.nom_classe, c.niveau, c.annee_classe FROM personne p, inscription i, classe c "
            + "WHERE i.id_classe_eleve = c.id_classe AND i.id_eleve_inscrit = p.id_personne AND p.est_enseignant = 0 ";
    try{
        
        resultat= connect.getStmt().executeQuery(requete);
        Inscription eleveInsc;
        Personne eleve;
        Classe classe;

        
        while(resultat.next())
        {
             System.out.println("Requete boucle1");
            eleve = new Personne(resultat.getInt("p.id_personne"),resultat.getString("p.nom"),resultat.getString("p.prenom"),false);
            System.out.println("Requete boucle2");
            classe = new Classe(resultat.getInt("c.id_classe"), resultat.getString("c.nom_classe"), resultat.getString("c.niveau")
                               ,resultat.getInt("c.annee_classe"));
            System.out.println("Requete boucle3");
            eleveInsc = new Inscription(resultat.getInt("i.id_inscription"), eleve, classe);
            listeEleve.add(eleveInsc);
            System.out.println("Requete boucle");
            
        }
        System.out.println("Requete effectué");
        return listeEleve;
        
    } catch (Exception e) {
        System.out.println("Requete invalide");
        return null;
    }  
  }
    
}
