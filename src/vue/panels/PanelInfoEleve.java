/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.panels;

import DAO.DAOFactory;
import java.awt.BorderLayout;
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
public class PanelInfoEleve extends JPanel{
    
    private JPanel panelDroite;
    private JPanel panelGauche;
    private JPanel panelTitre;
    private JPanel panelId;
    private JPanel panelNom;
    private JPanel panelPrenom; 
    private JPanel panelBtnSM;
    private JPanel panelForm;
    private JPanel panelAll;
    private JPanel panelClasse;
    private JPanel panelNiv;
    private JPanel panelTrimestres;
    
    private JButton supprimerEleve;
    private JButton inscrireEleve;
    private JButton trimestre1;
    private JButton trimestre2;
    private JButton trimestre3;
   
    private JTextField id;
    private JTextField nom;
    private JTextField prenom;
    private JTextField classe;
    private JTextField niveau;
    
    private JLabel titre;
    private JLabel labelId;
    private JLabel labelNom;
    private JLabel labelPrenom;  
    private JLabel labelClasse;
    private JLabel labelNiv;
    
    private JTable tabEleve;
    private JScrollPane tabScroll; 
     private DAOFactory daoFactory;
    
    //Eventuellement un JTextfields et un JButton pour la recherche d'éléments

    public PanelInfoEleve(DAOFactory daoFactory) {
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
        panelPrenom = new JPanel();
        panelNom = new JPanel();
        panelBtnSM = new JPanel();
        panelClasse =  new JPanel();
        panelNiv = new JPanel() ;
        panelTrimestres = new JPanel();
        panelForm = new JPanel();
        panelAll = new JPanel();
        id = new JTextField();
        prenom = new JTextField();
        nom = new JTextField();
        classe = new JTextField();
        niveau = new JTextField();
        titre = new JLabel();
        labelId = new JLabel();
        labelPrenom = new JLabel() ;
        labelNom = new JLabel();
        labelClasse = new JLabel();
        labelNiv = new JLabel();
        supprimerEleve = new JButton("Supprimer") ;
        inscrireEleve = new JButton("Inscrire") ;
        trimestre1= new JButton("Trimestre 1") ;
        trimestre2= new JButton("Trimestre 2") ;
        trimestre3= new JButton("Trimestre 3") ;
        
        //tableau 
        String [] nomColonnes = {"Id","Discipline","Enseignant","Note","Avis"};
        Object [][] data = {
        
        };
        
        tabEleve = new JTable(data, nomColonnes);
        tabEleve.setPreferredScrollableViewportSize(new Dimension(650,350));
        tabEleve.setFillsViewportHeight(true);
        
        tabScroll = new JScrollPane(tabEleve);
        
        
        /**
         * Action listeners des boutons : supprimer, inscrire élève, trimestre 1, 2, 3 
         */
        
         //mise en place du titre
        titre.setFont(new Font("Times New Roman", 1, 35)); // NOI18N
        titre.setText("Profil élève");
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
        labelId.setText("Id :");
        labelPrenom.setText("Prenom : ");
        labelNom.setText("Nom :");
        labelClasse.setText("Classe :");
        labelNiv.setText("Niveau :");
        
        //init des textfields : box layout a besoin de la taille min et max 
        id.setPreferredSize(new Dimension(50, 30));
        prenom.setPreferredSize(new Dimension(100, 30));
        nom.setPreferredSize(new Dimension(100, 30));
        classe.setPreferredSize(new Dimension(100, 30));
        niveau.setPreferredSize(new Dimension(100, 30));

        //init des actionListeners des  boutons
        
        //initialisation des jpanels qui constituent le formulaire
        panelId.add(labelId);
        panelId.add(id);
        //ligne nom
        panelNom.add(labelNom);
        panelNom.add(nom);
        //ligne prenom
        panelPrenom.add(labelPrenom);
        panelPrenom.add(prenom);
        //ligne classe
        panelClasse.add(labelClasse);
        panelClasse.add(classe);
        //ligne niveau
        panelNiv.add(labelNiv);
        panelNiv.add(niveau);
        //ligne boutons Supprimer modifier
        panelBtnSM.add(supprimerEleve);
        panelBtnSM.add(inscrireEleve);
     
        
        //ajout du formulaire dans un sous-panel ayant un boxlayout
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
        panelForm.add(panelId);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelNom);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelPrenom);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelClasse);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelNiv);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelBtnSM);
        
        //création du panel contenant les boutons des trimestres : quand on clique
        //sur l'un d'eux, on rempli la table à l'aide d'un action listener. La 
        //methode sera codée dans cette classe.
        panelTrimestres.add(trimestre1);
        panelTrimestres.add(trimestre2);
        panelTrimestres.add(trimestre3);
        
        //ajout des sous-panels dans les panels gauche et droite
        //gauche
        panelGauche.add(panelForm);
        
        //droite
        panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.PAGE_AXIS));
        panelDroite.add(tabScroll);
        panelDroite.add(panelTrimestres);
        
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
