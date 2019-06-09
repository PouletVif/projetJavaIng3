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
public class Evaluation {

    int id_evaluation;
    int note;
    String appreciation_evaluation;
    int id_detailbulletin;

    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAppreciation_evaluation() {
        return appreciation_evaluation;
    }

    public void setAppreciation_evaluation(String appreciation_evaluation) {
        this.appreciation_evaluation = appreciation_evaluation;
    }

    public int getId_detailbulletin() {
        return id_detailbulletin;
    }

    public void setId_detailbulletin(int id_detailbulletin) {
        this.id_detailbulletin = id_detailbulletin;
    }
    
}
