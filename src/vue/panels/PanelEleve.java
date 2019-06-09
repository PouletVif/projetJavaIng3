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
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modele.Inscription;

/**
 *
 * @author EmyMa
 */
public class PanelEleve extends JPanel{
    
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
    private JButton supprimerEleve;
    private JButton ajouterEleve;
    private JButton modifierEleve;
    private JTextField id;
    private JTextField nom;
    private JTextField prenom;
    private JLabel titre;
    private JLabel labelId;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JTable tabEleve;
    private JScrollPane tabScroll; 
     private DAOFactory daoFactory;
    ArrayList<Inscription> listeEleve ;
    //Eventuellement un JTextfields et un JButton pour la recherche d'éléments

    public PanelEleve(DAOFactory daoFactory, ArrayList<Inscription> listeEleve ) {
         this.daoFactory = daoFactory;
         this.listeEleve = listeEleve;
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
        id = new JTextField();
        prenom = new JTextField();
        nom = new JTextField();
        titre = new JLabel();
        labelId = new JLabel();
        labelPrenom = new JLabel() ;
        labelNom = new JLabel();
        supprimerEleve = new JButton("Supprimer") ;
        ajouterEleve = new JButton("Ajouter") ;
        modifierEleve = new JButton("Modifier") ;
        
        String [] nomColonnes = {"Id","Nom","Prenom","Classe","Niveau"};
        
        
       
        //tableau 
        
        tabEleve = new JTable(); 
        tabEleve.setPreferredScrollableViewportSize(new Dimension(650,500));
        tabEleve.setFillsViewportHeight(true);
        
        DefaultTableModel model =new DefaultTableModel(0,0);
        model.setColumnIdentifiers(nomColonnes);
        tabEleve.setModel(model);
        Object[] ligne = new Object[5];
        
        for(int i = 0; i<this.listeEleve.size(); i++)
        {
            ligne[0] = this.listeEleve.get(i).getEleve().getId_personne();
            ligne[1] =this.listeEleve.get(i).getEleve().getNom();
            ligne[2] = this.listeEleve.get(i).getEleve().getPrenom();
            ligne[3] = this.listeEleve.get(i).getClasse().getNom();
            ligne[4] = this.listeEleve.get(i).getClasse().getNiveau();
            model.addRow(ligne);
        }

        
        
         tabScroll = new JScrollPane(tabEleve);
        
         //mise en place du titre
        titre.setFont(new Font("Times New Roman", 1, 35)); // NOI18N
        titre.setText("Informations élèves");
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
        
        //init des textfields : box layout a besoin de la taille min et max 
        id.setPreferredSize(new Dimension(50, 30));
        prenom.setPreferredSize(new Dimension(100, 30));
        nom.setPreferredSize(new Dimension(100, 30));

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
        //ligne boutons Supprimer modifier
        panelBtnSM.add(supprimerEleve);
        panelBtnSM.add(modifierEleve);
        //ligne bouton ajouter
        panelBtnAj.add(ajouterEleve);
             
        
        //ajout du formulaire dans un sous-panel ayant un gridlayout (2,2)
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
        panelForm.add(panelId);
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
