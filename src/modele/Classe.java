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
public class Classe {

    int id_classe;
    String nom;
    String niveau;
    int annee_classe;

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getAnnee_classe() {
        return annee_classe;
    }

    public void setAnnee_classe(int annee_classe) {
        this.annee_classe = annee_classe;
    }
    
}
