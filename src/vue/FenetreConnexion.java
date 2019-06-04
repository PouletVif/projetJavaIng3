/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.ConnexionListener;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author EmyMa
 */
public class FenetreConnexion extends JFrame {
    
    private JPanel accueilPanel;
    private JLabel titre;
    private JLabel labelNomBdd;
    private JLabel labelLogin;
    private JLabel labelMdp;
    private JTextField nomBdd;
    private JTextField login;
    private JTextField mdp;
    private JButton btn_co;

    public FenetreConnexion() {
        
        //initialisation des components : 5 Jpanel, 4 jlabel, 3 jtextfields et 1 jbutton
        
        //panel principal
        accueilPanel = new JPanel();
        
        //5 sous-JPanels
        JPanel panelTitre= new JPanel();
        JPanel panelNomServer= new JPanel();
        JPanel panelLogin= new JPanel();
        JPanel panelMdp= new JPanel();
        JPanel panelBtn_co= new JPanel();
        
        //Labels
        titre = new JLabel();
        labelNomBdd = new JLabel();
        labelLogin = new JLabel();
        labelMdp = new JLabel();
        
        //textfields
        nomBdd = new JTextField() ;
        login = new JTextField() ;
        mdp = new JTextField();
        
        //bouton
        btn_co = new JButton("Connexion");
        
        //initialisation de l'action listener
        ConnexionListener cl = new ConnexionListener(this,nomBdd,login,mdp);
        btn_co.addActionListener(cl);
        
        //bouton de fermeture de la fentre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre de taille 600 x 600
        this.setSize(600,600);
        //la fenetre pop au centre de l'écran
        this.setLocationRelativeTo(null);
        //titre de la fenetre
        this.setTitle("fenetreCoBdd");

        //mise en place du titre
        titre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        titre.setText("Connexion à la base de donnée");
        titre.setToolTipText("");

        //définition des labels
        labelNomBdd.setText("Nom de la bdd :");
        labelLogin.setText("login : ");
        labelMdp.setText("Mot de passe :");
        
        //init des textfields : box layout a besoin de la taille min et max 
        nomBdd.setPreferredSize(new Dimension(150, 30));
        login.setPreferredSize(new Dimension(150, 30));
        mdp.setPreferredSize(new Dimension(150, 30));

        //init du bouton 
        
       /**
         * création des sous-panels : on les crées puis on ajoutes les composants
       */
        
       //le titre en haut de page 
       //ajouts du composant
       panelTitre.add(titre);
       
       //Panel qui contient le label et le textfield du nomServer
       panelNomServer.add(labelNomBdd);
       panelNomServer.add(nomBdd);
       
       //Panel qui contient le label et le textfield du login
       panelLogin.add(labelLogin);
       panelLogin.add(Box.createHorizontalStrut(10));
       panelLogin.add(login);
       
       //Panel qui contient le label et le textfield du mot de passe
      // panelMdp.setLayout(new BoxLayout(panelMdp, BoxLayout.LINE_AXIS));
       panelMdp.add(labelMdp);
      
       panelMdp.add(mdp);
       
       //Panel qui contient le bouton de soumission
       panelBtn_co.add(btn_co);
        
        //ajout des sous-panels dans le panel principal en colonne
        accueilPanel.setLayout(new BoxLayout(accueilPanel, BoxLayout.PAGE_AXIS));
        accueilPanel.add(panelTitre);
        accueilPanel.add(Box.createRigidArea(new Dimension(35,0)));
        accueilPanel.add(panelNomServer);
         accueilPanel.add(Box.createRigidArea(new Dimension(25,0)));
        accueilPanel.add(panelLogin);
         accueilPanel.add(Box.createRigidArea(new Dimension(25,0)));
        accueilPanel.add(panelMdp);
         accueilPanel.add(Box.createRigidArea(new Dimension(25,0)));
        accueilPanel.add(panelBtn_co);
        
        //pack(); 
        
        //ajout du panel principal dans la fenetre
        this.getContentPane().add(accueilPanel);
    }
    
}
