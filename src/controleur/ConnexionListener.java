/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import DAO.Connexion;
import DAO.DAOFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import vue.FenetrePrincipale;

/**
 *
 * @author EmyMa
 */
public class ConnexionListener implements ActionListener {

    private JTextField nomBdd;
    private JTextField login;
    private JTextField mdp;
    private JFrame fenetreActu;
    
    public ConnexionListener(JFrame fenetreActu, JTextField nomBdd, JTextField login, JTextField mdp) {
        
        this.fenetreActu = fenetreActu;
        this.nomBdd = nomBdd;
        this.login = login;
        this.mdp = mdp;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
      
        try {
            
            Connexion conn = new Connexion(this.nomBdd.getText(),this.login.getText(),this.mdp.getText());
            DAOFactory daoFactory = new DAOFactory(conn);
            this.fenetreActu.dispose();
            FenetrePrincipale fp = new FenetrePrincipale(daoFactory);
            fp.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
