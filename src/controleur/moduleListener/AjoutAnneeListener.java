/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.moduleListener;

import DAO.DAO;
import DAO.DAOFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import modele.Annee;

/**
 *
 * @author INVITE
 */
public class AjoutAnneeListener implements ActionListener {
    
    private DAOFactory daoFactory;
    private JTextField annee;

    public AjoutAnneeListener(DAOFactory daoFactory, JTextField annee) {
        this.daoFactory = daoFactory;
        this.annee = annee;
                
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int anneeText = Integer.parseInt(this.annee.getText());
        System.out.println(anneeText);
        DAO<Annee> anneeDAO = daoFactory.getAnneeDAO();
        Annee annee = new Annee (anneeText);
        anneeDAO.create(annee);
    }
    
}
