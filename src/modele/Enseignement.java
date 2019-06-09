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
public class Enseignement {
    int id_enseignement;
    String nom;
    int id_enseignant;
    int id_classe;

    public int getId_enseignement() {
        return id_enseignement;
    }

    public void setId_enseignement(int id_enseignement) {
        this.id_enseignement = id_enseignement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }
    
}
