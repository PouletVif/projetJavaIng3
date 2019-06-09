/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.listenerMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import vue.panels.PanelAccueil;

/**
 *
 * @author EmyMa
 */
public class AccueilListener implements MenuListener{

    JFrame fenetreActuelle;
    
    public AccueilListener(JFrame fenetreActuelle) {
        this.fenetreActuelle = fenetreActuelle;
    }
    
    @Override
    public void menuSelected(MenuEvent arg0) {
       PanelAccueil pa = new PanelAccueil();
       fenetreActuelle.getContentPane().removeAll();
       fenetreActuelle.getContentPane().add(pa);
       fenetreActuelle.getContentPane().validate();
       fenetreActuelle.getContentPane().repaint();
    }

    @Override
    public void menuDeselected(MenuEvent e) {
      System.out.println("Deselected");  
    }

    @Override
    public void menuCanceled(MenuEvent e) {
           System.out.println("Canceled"); 
    }
    
}
