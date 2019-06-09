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
public class Inscription {
    int id_inscription;
    int id_eleve_inscrit;
    int id_classe_eleve;

    public int getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }

    public int getId_eleve_inscrit() {
        return id_eleve_inscrit;
    }

    public void setId_eleve_inscrit(int id_eleve_inscrit) {
        this.id_eleve_inscrit = id_eleve_inscrit;
    }

    public int getId_classe_eleve() {
        return id_classe_eleve;
    }

    public void setId_classe_eleve(int id_classe_eleve) {
        this.id_classe_eleve = id_classe_eleve;
    }
    

}
