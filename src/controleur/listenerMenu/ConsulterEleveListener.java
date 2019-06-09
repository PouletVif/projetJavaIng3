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
import vue.panels.PanelInfoEleve;

/**
 *
 * @author EmyMa
 */
public class ConsulterEleveListener implements ActionListener{
     JFrame fenetreActuelle;
     DAOFactory daoFactory;

    public ConsulterEleveListener(JFrame fenetreActuelle, DAOFactory daoFactory) {
        this.fenetreActuelle = fenetreActuelle;
        this.daoFactory = daoFactory;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
       PanelInfoEleve pie = new PanelInfoEleve(this.daoFactory);
       fenetreActuelle.getContentPane().removeAll();
       fenetreActuelle.getContentPane().add(pie);
       fenetreActuelle.getContentPane().validate();
       fenetreActuelle.getContentPane().repaint();
    }
    
}
