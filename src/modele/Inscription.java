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
    private int id_inscription;
    private Personne eleve;
    private Classe classe;

    public Inscription(int id_inscription, Personne eleve, Classe classe) {
        this.id_inscription = id_inscription;
        this.eleve = eleve;
        this.classe = classe;
    }

    
    
    
    public int getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }

    public Personne getEleve() {
        return eleve;
    }

    public void setEleve(Personne eleve) {
        this.eleve = eleve;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    

    

}
