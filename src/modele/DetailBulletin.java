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
public class DetailBulletin {
    int id_detailbulletin;
    String appreciation;
    int id_enseignement;
    int id_bulletin;

    public int getId_detailbulletin() {
        return id_detailbulletin;
    }

    public void setId_detailbulletin(int id_detailbulletin) {
        this.id_detailbulletin = id_detailbulletin;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public int getId_enseignement() {
        return id_enseignement;
    }

    public void setId_enseignement(int id_enseignement) {
        this.id_enseignement = id_enseignement;
    }

    public int getId_bulletin() {
        return id_bulletin;
    }

    public void setId_bulletin(int id_bulletin) {
        this.id_bulletin = id_bulletin;
    }
    
}
