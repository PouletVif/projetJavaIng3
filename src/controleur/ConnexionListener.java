/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author EmyMa
 */
public class ConnexionListener implements ActionListener {

    private JTextField nomBdd;
    private JTextField login;
    private JTextField mdp;

    public ConnexionListener(JTextField nomBdd, JTextField login, JTextField mdp) {
        
        this.nomBdd = nomBdd;
        this.login = login;
        this.mdp = mdp;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println(this.nomBdd.getText() + " " + this.login.getText()+" "+this.mdp.getText());
    }
    
}
