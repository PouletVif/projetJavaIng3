/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package vue;

import DAO.DAOFactory;
import controleur.listenerMenu.AccueilListener;
import controleur.listenerMenu.ConsulterEleveListener;
import controleur.listenerMenu.ConsulterProfListener;
import controleur.listenerMenu.GestionAnneeListener;
import controleur.listenerMenu.GestionBulletinListener;
import controleur.listenerMenu.GestionClassesListener;
import controleur.listenerMenu.GestionEleveListener;
import controleur.listenerMenu.GestionProfListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 *
@ -13,4 +19,76 @@ import javax.swing.JFrame;
 */
public class FenetrePrincipale extends JFrame {
    
    private JMenuBar menubar;
    private JMenu accueil;
    private JMenu eleves;
    private JMenu enseignement;
    private JMenu scolarite;
    private JMenu reporting;
    private JMenu quitter;
    private JMenuItem listeEleve;
    private JMenuItem profilEleve;
    private JMenuItem listeProf;
    private JMenuItem profilProf;
    private JMenuItem gestionClasses;
    private JMenuItem gestionBulletins;
    private JMenuItem gestionAnnee;
    private DAOFactory daoFactory;
 
    
    public FenetrePrincipale(DAOFactory daoFactory) {
        
        //titre de la fenetre
        this.setTitle("Recherche");  
        //fenetre de taille 800 x 600
        this.setSize(1200,800);
        //la fenetre pop au centre de l'écran
        this.setLocationRelativeTo(null);
        //bouton de fermeture de la fentre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.daoFactory=daoFactory;        
        init();
    }
    
    public void init()
    {
      //Barre de navigation  
      menubar = new JMenuBar();
      
      
      //boutons dans la barre de navigation
      accueil = new JMenu("Accueil");
      eleves = new JMenu("Eleves");
      enseignement = new JMenu("Enseignement");
      scolarite = new JMenu("Scolarité");
      reporting = new JMenu("Reporting");
      quitter = new JMenu("Quitter");
      
      //Menu items
      listeEleve =  new JMenuItem("Gestion élèves");
      profilEleve = new JMenuItem("Consulter élève") ;
      listeProf = new JMenuItem("Gestions enseignants") ;
      profilProf = new JMenuItem("Consulter enseigant")  ;
      gestionClasses = new JMenuItem("Gestions classes") ;
      gestionBulletins = new JMenuItem("Gestions bulletins") ;
      gestionAnnee = new JMenuItem("Gestions année") ;
      
      //Actionlisteners de la barre de navigation
      listeEleve.addActionListener(new GestionEleveListener(this,this.daoFactory));
      
      profilEleve.addActionListener(new ConsulterEleveListener(this,this.daoFactory));
      
      listeProf.addActionListener(new GestionProfListener(this,this.daoFactory));
      
      profilProf.addActionListener(new ConsulterProfListener(this,this.daoFactory));
      
      gestionAnnee.addActionListener(new GestionAnneeListener(this,this.daoFactory));
      
      gestionClasses.addActionListener(new GestionClassesListener(this,this.daoFactory));
      
      gestionBulletins.addActionListener(new GestionBulletinListener(this,this.daoFactory));
      
      //Menu listener pour accueil car ce dernier est un JMenu. 
      accueil.addMenuListener(new AccueilListener(this));
      
      //Ajout des menu item dans les JMenus qui leur sont destinés
      eleves.add(listeEleve);
      eleves.add(profilEleve);
      enseignement.add(listeProf);
      enseignement.add(profilProf);
      scolarite.add(gestionClasses);
      scolarite.add(gestionBulletins);
      scolarite.add(gestionAnnee);
      
      //Ajout des eléments du menu dans la barre de nav
      menubar.add(accueil);
      menubar.add(eleves);
      menubar.add(enseignement);
      menubar.add(scolarite);
      menubar.add(reporting);
      menubar.add(quitter);
      
      
      
      //on lie la barre de navigation à la fenetre
      this.setJMenuBar(menubar);
      
    }

    
}
