/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author INVITE
 */
public class Personne {
    int id_personne;
    String nom;
    String prenom;
    boolean est_enseignant;

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isEst_enseignant() {
        return est_enseignant;
    }

    public void setEst_enseignant(boolean est_enseignant) {
        this.est_enseignant = est_enseignant;
    }
    
}
