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
import java.awt.GridLayout;
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
public class PanelInfoProf extends JPanel{
    
    private JPanel panelDroite;
    private JPanel panelGauche;
    private JPanel panelTitre;
    private JPanel panelId;
    private JPanel panelNom;
    private JPanel panelPrenom;
    private JPanel panelDiscipline;
    private JPanel panelAjouterNote;
    private JPanel panelBtnSM;
    private JPanel panelForm;
    private JPanel panelAll;
    private JButton supprimerProf;
    private JButton ajouterNote;
    private JTextField id;
    private JTextField nom;
    private JTextField prenom;
    private JTextField discipline;
    private JTextField idEleve;
    private JTextField note;
    private JLabel titre;
    private JLabel labelId;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelDiscipline;
    private JLabel labelIdEleve;
    private JLabel labelNote;
    
    private JTable tabEleve;
    
    private JScrollPane tabScroll; 
     private DAOFactory daoFactory;
    
    //Eventuellement un JTextfields et un JButton pour la recherche d'éléments

    public PanelInfoProf(DAOFactory daoFactory) {
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
        panelDiscipline = new JPanel();
        panelBtnSM = new JPanel();
        panelAjouterNote = new JPanel();
        panelForm = new JPanel();
        panelAll = new JPanel();
        id = new JTextField();
        prenom = new JTextField();
        nom = new JTextField();
        discipline = new JTextField();
        idEleve = new JTextField();
        note = new JTextField();
        titre = new JLabel();
        labelId = new JLabel();
        labelPrenom = new JLabel() ;
        labelNom = new JLabel();
        labelDiscipline = new JLabel();
        labelIdEleve = new JLabel();
        labelNote = new JLabel();
        
        supprimerProf = new JButton("Supprimer");
        ajouterNote = new JButton("Ajouter note");
        
        //tableau 
        String [] nomColonnes = {"Id élève","Nom","Prenom","Niveau"};
        Object [][] data = {
            {"1","Mahouni","Emy","ING3"},
            {"2","Saute","Alexis","ING3"},
            {"3","Maxime","Tran","ING3"},
            {"4","LeBrishoual","Thomas","ING2"},     
        };
        
        tabEleve = new JTable(data, nomColonnes);
        tabEleve.setPreferredScrollableViewportSize(new Dimension(600,450));
        tabEleve.setFillsViewportHeight(true);
        
        tabScroll = new JScrollPane(tabEleve);
        
        
        
        
         //mise en place du titre
        titre.setFont(new Font("Times New Roman", 1, 35)); // NOI18N
        titre.setText("Profil professeur");
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
               
        //panel d'ajout de notes : ce dernier sera de type gridLayout
        labelIdEleve.setText("Id élève");
        labelNote.setText("Note");
        idEleve.setPreferredSize(new Dimension(100, 30));
        note.setPreferredSize(new Dimension(100, 30));
        
        panelAjouterNote.setLayout(new GridLayout(2,3));
        panelAjouterNote.add(labelIdEleve);
        panelAjouterNote.add(labelNote);
        panelAjouterNote.add(new JLabel(""));
        panelAjouterNote.add(idEleve);
        panelAjouterNote.add(note);
        panelAjouterNote.add(ajouterNote);
        
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
        this.add(panelAjouterNote);
        
        //pack(); 
    }
    
    
}
