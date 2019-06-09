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
public class PanelProf extends JPanel{
    
    private JPanel panelDroite;
    private JPanel panelGauche;
    private JPanel panelTitre;
    private JPanel panelId;
    private JPanel panelNom;
    private JPanel panelPrenom;
    private JPanel panelBtnSM;
    private JPanel panelBtnAj;
    private JPanel panelForm;
    private JPanel panelAll;
    private JPanel panelDiscipline;
    private JButton supprimerProf;
    private JButton ajouterProf;
    private JButton modifierProf;
    private JTextField id;
    private JTextField nom;
    private JTextField prenom;
    private JTextField discipline;
    private JLabel titre;
    private JLabel labelId;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelDiscipline;
    private JTable tabProf;
    private JScrollPane tabScroll; 
     private DAOFactory daoFactory;
    
    //Eventuellement un JTextfields et un JButton pour la recherche d'éléments

    public PanelProf(DAOFactory daoFactory) {
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
        panelBtnAj = new JPanel();
        panelForm = new JPanel();
        panelAll = new JPanel();
        panelDiscipline = new JPanel();
        id = new JTextField();
        prenom = new JTextField();
        nom = new JTextField();
        discipline = new JTextField();
        titre = new JLabel();
        labelId = new JLabel();
        labelPrenom = new JLabel() ;
        labelNom = new JLabel();
        labelDiscipline = new JLabel();
        supprimerProf = new JButton("Supprimer") ;
        ajouterProf = new JButton("Ajouter") ;
        modifierProf = new JButton("Modifier") ;
        
        //tableau 
        String [] nomColonnes = {"Id professeur","Nom","Prenom","Discipline"};
        Object [][] data = {
            {"1","Mahouni","Emy","TD08","ING3"},
            {"2","Saute","Alexis","TD08","ING3"},
            
        };
        
        tabProf = new JTable(data, nomColonnes);
        tabProf.setPreferredScrollableViewportSize(new Dimension(600,450));
        tabProf.setFillsViewportHeight(true);
        
        tabScroll = new JScrollPane(tabProf);
        
        
        
        
         //mise en place du titre
        titre.setFont(new Font("Times New Roman", 1, 35)); // NOI18N
        titre.setText("Informations professeurs");
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
        labelDiscipline.setText("Discipline :");
        
        //init des textfields : box layout a besoin de la taille min et max 
        id.setPreferredSize(new Dimension(50, 30));
        prenom.setPreferredSize(new Dimension(100, 30));
        nom.setPreferredSize(new Dimension(100, 30));
        discipline.setPreferredSize(new Dimension(100, 30));

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
        //ligne discipline
        panelDiscipline.add(labelDiscipline);
        panelDiscipline.add(discipline);
        //ligne boutons Supprimer modifier
        panelBtnSM.add(supprimerProf);
        panelBtnSM.add(modifierProf);
        //ligne bouton ajouter
        panelBtnAj.add(ajouterProf);
             
        
        //ajout du formulaire dans un sous-panel ayant un gridlayout (2,2)
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
        panelForm.add(panelId);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelNom);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelPrenom);
        panelForm.add(Box.createRigidArea(new Dimension(0,15)));
        panelForm.add(panelDiscipline);
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
