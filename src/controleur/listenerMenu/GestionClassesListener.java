/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.listenerMenu;

import DAO.DAOFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vue.panels.PanelGestionClasses;

/**
 *
 * @author EmyMa
 */
public class GestionClassesListener implements ActionListener{

     JFrame fenetreActuelle;
     DAOFactory daoFactory;

    public GestionClassesListener(JFrame fenetreActuelle, DAOFactory daoFactory) {
        this.fenetreActuelle = fenetreActuelle;
        this.daoFactory = daoFactory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       PanelGestionClasses pgc = new PanelGestionClasses(this.daoFactory);
       fenetreActuelle.getContentPane().removeAll();
       fenetreActuelle.getContentPane().add(pgc);
       fenetreActuelle.getContentPane().validate();
       fenetreActuelle.getContentPane().repaint();
    }
    
}
