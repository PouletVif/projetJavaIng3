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
import vue.panels.PanelProf;

/**
 *
 * @author EmyMa
 */
public class GestionProfListener implements ActionListener {

     JFrame fenetreActuelle;
     DAOFactory daoFactory;

    public GestionProfListener(JFrame fenetreActuelle, DAOFactory daoFactory) {
        this.fenetreActuelle = fenetreActuelle;
        this.daoFactory = daoFactory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       PanelProf pp = new PanelProf(this.daoFactory);
       fenetreActuelle.getContentPane().removeAll();
       fenetreActuelle.getContentPane().add(pp);
       fenetreActuelle.getContentPane().validate();
       fenetreActuelle.getContentPane().repaint();  
    }
    
}
