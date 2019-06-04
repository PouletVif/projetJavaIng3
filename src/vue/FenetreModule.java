/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author EmyMa
 */
public class FenetreModule extends JFrame {
    private JPanel modulesPanel;
    private JLabel titre;
    private JButton btnRecherche;
    private JButton btnMaj;
    private JButton btnReporting;
    

    public FenetreModule() {
        
        //initialisation des components : 3 Jpanels, 1 jlabels et 3 jbuttons
        
        //panel principal
        modulesPanel = new JPanel();
        
        //3 sous-JPanels
        JPanel panelTitre = new JPanel();
        JPanel panelBtnRMaj= new JPanel();
        JPanel panelBtnReporting= new JPanel();
        
        //label
        titre = new JLabel();
        
        //boutons
        btnRecherche = new JButton("Recherche");
        btnMaj = new JButton("Mise à jour");
        btnReporting = new JButton("Reporting");
        
        //fermeture de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre de taille 600 x 600
        this.setSize(600,600);
        //la fenetre pop au centre de l'écran
        this.setLocationRelativeTo(null);
        //titre de la fenetre
        this.setTitle("fenetreModules");

        //mise en place du titre
        titre.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        titre.setText("Bienvenue à l'interface de gestion d'école");
        titre.setToolTipText("");


        
        //init des textfields : box layout a besoin de la taille min et max 
        btnMaj.setPreferredSize(new Dimension(150, 60));
        btnRecherche.setPreferredSize(new Dimension(150, 60));
        btnReporting.setPreferredSize(new Dimension(150, 60));
       
        
       /**
         * création des sous-layouts : on les crée puis on ajoutes les composants
       */
        
       //le titre en haut de page
       //ajout du composant
       panelTitre.add(titre);
       
    
       //Panel qui contient les boutons qui redirigent vers les fenetres dédiées aux
       //modules Recherche et Mise à jour
       panelBtnRMaj.add(btnRecherche);
       //Mise en place d'un espace entre le bouton recherche et Maj
       panelBtnRMaj.add(Box.createHorizontalStrut(30));   
       panelBtnRMaj.add(btnMaj);
       
       
       //Panel qui contient le bouton qui mène à la fenetre dédié au reporting
       panelBtnReporting.add(btnReporting);
 
        //ajout des sous-panels dans le panel principal en colonne
        modulesPanel.setLayout(new BoxLayout(modulesPanel, BoxLayout.PAGE_AXIS));
        modulesPanel.add(panelTitre);
        modulesPanel.add(Box.createRigidArea(new Dimension(10,0)));
        modulesPanel.add(panelBtnRMaj);
        modulesPanel.add(Box.createRigidArea(new Dimension(10,0)));
        modulesPanel.add(panelBtnReporting);
        
        //pack(); 
        
        //ajout du panel principal dans la fenetre
        this.getContentPane().add(modulesPanel);
    }
}
