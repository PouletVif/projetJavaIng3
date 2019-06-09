/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.panels;

import DAO.DAOFactory;
import controleur.moduleListener.AjoutAnneeListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author INVITE
 */
public class GestionAnnee extends JPanel {
    
    private DAOFactory daoFactory;
    JTextField annee;
    JLabel anneeLabel;
    JButton btn_ajouter;
    JButton btn_supprimer;
    

    public GestionAnnee(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        init();
    }
    
    public void init()
    {
        //instanciation des attributs
        annee = new JTextField();
        anneeLabel = new JLabel("Année : ");
        btn_ajouter = new JButton("Ajouter");
        btn_supprimer = new JButton("Supprimer");
        
        //le panel possède un FlowLayout
        this.setLayout(new FlowLayout());
        
        //Set dimension textfield
        
        annee.setPreferredSize(new Dimension(150, 30));
        //ajout des actionlistener
        annee.setText("0");
        btn_ajouter.addActionListener(new AjoutAnneeListener(this.daoFactory,annee));
        
        //ajout des composants dansn le panel
        this.add(anneeLabel);
        this.add(annee);
        this.add(btn_ajouter);
        this.add(btn_supprimer);
        
    }
    
}
