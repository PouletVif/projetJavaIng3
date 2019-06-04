/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.FenetreConnexion;
import vue.FenetreModule;
import vue.FenetreRecherche;
import vue.panels.PanelEleve;

/**
 *
 * @author EmyMa
 */
public class GestionEcoleMain {
    
    public static void main(String args[]){
        FenetreConnexion fc = new FenetreConnexion();
        //fc.setVisible(true);
        FenetreRecherche fr =new FenetreRecherche();
        PanelEleve pe = new PanelEleve();
        fr.getContentPane().add(pe);
        fr.setVisible(true);
        
        

        
    }
}
