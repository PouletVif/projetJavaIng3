/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.panels;

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
    
    //Eventuellement un JTextfields et un JButton pour la recherche d'éléments

    public PanelEleve() {
        
         this.setLayout(new FlowLayout());
         init();
    }
    
    
    public void init()
    {
        panelDroite = new JPanel();
        panelGauche = new JPanel();
        panelTitre = new JPanel();
        panelId = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPrenom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBtnSM = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBtnAj = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelForm = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        
         //mise en place du titre
        titre.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
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
        
        panelNom.add(labelNom);
        panelNom.add(nom);
        
        panelPrenom.add(labelPrenom);
        panelPrenom.add(prenom);
        
        panelBtnSM.add(supprimerEleve);
        panelBtnSM.add(modifierEleve);
        
        panelBtnAj.add(ajouterEleve);
             
        
        //ajout du formulaire dans un sous-panel ayant un gridlayout (2,2)
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.PAGE_AXIS));
        panelForm.add(panelId);
        panelForm.add(panelNom);
        panelForm.add(panelPrenom);
        panelForm.add(panelBtnSM);
        panelForm.add(panelBtnAj);
       
        //ajout des sous-panels dans le panel principal en colonne
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(panelTitre);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(panelForm);
        
        //pack(); 
    }
    
    
}
