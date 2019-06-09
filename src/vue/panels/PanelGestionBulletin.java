/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.panels;

import DAO.DAOFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author EmyMa
 */
public class PanelGestionBulletin extends JPanel {
    private JPanel panelDroite;
    private JPanel panelGauche;
    private JPanel panelTitre;
    private JPanel panelId, panelAppreciation, panelTrimestre;
    private JPanel panelIdEleve, panelNom, panelPrenom;
    private JPanel panelBtnSM;
    private JPanel panelBtnAj;
    private JPanel panelForm;
    private JPanel panelAll;
    
    private JButton supprimerBulletin;
    private JButton ajouterBulletin;
    private JButton modifierBulletin;
    
    private JTextField id;
    private JTextField appreciation;
    private JTextField trimestre;
    private JTextField id_eleve;
    private JTextField nom;
    private JTextField prenom;
    
    private JLabel titre;
    private JLabel labelId;
    private JLabel labelTrimestre;
    private JLabel labelAppreciation;
    private JLabel labelIdEleve;
    private JLabel labelNom;
    private JLabel labelPrenom;
    
    private JTable tabBulletins;
    private JScrollPane tabScroll; 
     private DAOFactory daoFactory;
    
    //Eventuellement un JTextfields et un JButton pour la recherche d'éléments

    public PanelGestionBulletin(DAOFactory daoFactory) {
         this.daoFactory = daoFactory;
         this.setLayout(new FlowLayout());
         init();
    }
    
    
    public void init()
    {
        panelDroite = new JPanel();
        panelGauche = new JPanel();
        panelTitre = new JPanel();
        panelId = new JPanel();
        panelTrimestre = new JPanel();
        panelAppreciation = new JPanel();
        panelIdEleve = new JPanel();
        panelPrenom = new JPanel();
        panelNom = new JPanel();
        panelBtnSM = new JPanel();
        panelBtnAj = new JPanel();
        panelForm = new JPanel();
        panelAll = new JPanel();
        id = new JTextField();
        appreciation = new JTextField();
        trimestre = new JTextField();
        id_eleve = new JTextField();
        nom = new JTextField();
        prenom = new JTextField();
        
        titre = new JLabel();
        labelId = new JLabel();
        labelTrimestre = new JLabel() ;
        labelAppreciation = new JLabel();
        labelIdEleve = new JLabel();
        labelNom= new JLabel();
        labelPrenom = new JLabel();
        
        supprimerBulletin= new JButton("Supprimer") ;
        ajouterBulletin = new JButton("Ajouter") ;
        modifierBulletin = new JButton("Modifier") ;
        
        //tableau 
        String [] nomColonnes = {"Id bulletin","Id eleve","Nom","Prenom","Appreciation"};
        Object [][] data = {
        };
        
        tabBulletins = new JTable(data, nomColonnes);
        tabBulletins.setPreferredScrollableViewportSize(new Dimension(650,350));
        tabBulletins.setFillsViewportHeight(true);
        
        tabScroll = new JScrollPane(tabBulletins);
        
        
        
        
         //mise en place du titre
        titre.setFont(new Font("Times New Roman", 1, 35)); // NOI18N
        titre.setText("Gestion bulletins");
        titre.setToolTipText("");

       /*
        Panel qui contient le titre, ce dernier est un flowlayout de base
        */
       panelTitre.add(titre);
       
        /*
        Création du panel gauche : ce dernier aura un formulaire ou l'utilisateur pourra
        saisir le nom, le prénom et l'id d'un élève. En dessous on aura 3 boutons 
        qui ont trois actions performed : supprimer, ajouter et modifier élève
        */
        
        //définition des labels
        labelId.setText("Id classe :");
        labelTrimestre.setText("Nom classe: ");
        labelAppreciation.setText("Niveau :");
        labelIdEleve.setText("Id eleve :");
        labelNom.setText("Nom :");
        labelPrenom.setText("Prenom :");
        
        //init des textfields : box layout a besoin de la taille min et max 
        id.setPreferredSize(new Dimension(50, 30));
        trimestre.setPreferredSize(new Dimension(100, 30));
        appreciation.setPreferredSize(new Dimension(100, 30));
        id_eleve.setPreferredSize(new Dimension(50, 30));
        nom.setPreferredSize(new Dimension(100, 30));
        prenom.setPreferredSize(new Dimension(100, 30));
        

        //init des actionListeners des  boutons
        
        //initialisation des jpanels qui constituent le formulaire
        
        //id du bulletin
        panelId.add(labelId);
        panelId.add(id);
        
        //trimestre
        panelTrimestre.add(labelTrimestre);
        panelTrimestre.add(trimestre); 
        //appreciation
        panelAppreciation.add(labelAppreciation);
        panelAppreciation.add(appreciation); 
        
        //id eleve
        panelIdEleve.add(labelIdEleve);
        panelIdEleve.add(id_eleve);
        
        //ligne nom
        panelNom.add(labelNom);
        panelNom.add(nom);
        //ligne prenom
        panelPrenom.add(labelPrenom);
        panelPrenom.add(prenom);
        //ligne boutons Supprimer modifier
        panelBtnSM.add(supprimerBulletin);
        panelBtnSM.add(modifierBulletin);
        //ligne bouton ajouter
        panelBtnAj.add(ajouterBulletin);
             
        
        //ajout du formulaire dans un sous-panel ayant un gridlayout (2,2)
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
        panelForm.add(panelId);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelTrimestre);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelAppreciation);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelIdEleve);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelNom);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelPrenom);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelBtnSM);
        panelForm.add(Box.createRigidArea(new Dimension(0,5)));
        panelForm.add(panelBtnAj);
       
        //ajout des sous-panels dans les panels gauche et droite
        panelGauche.add(panelForm);
        panelDroite.add(tabScroll);
        panelAll.setLayout(new FlowLayout());
        panelAll.add(panelGauche);
        panelAll.add(Box.createHorizontalStrut(95));
        panelAll.add(panelDroite);
        
        //ajout des sous-panels dans le panel principal en colonne
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(panelTitre);
        this.add(panelAll);
        
        //pack(); 
    }
}
