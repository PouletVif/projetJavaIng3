/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.panels;

import DAO.DAOFactory;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EmyMa
 */
public class PanelAccueil extends JPanel{
    private JPanel panelTitre;
    private JPanel panelDescription;
    private JLabel titre;
    private JLabel description;
    
    public PanelAccueil() {
         this.setLayout(new FlowLayout());
         init();
    }
    
    
    public void init()
    {
        JPanel panelTitre = new JPanel();
        JPanel panelDescription =new JPanel() ;
        JLabel titre = new JLabel();
        JLabel description =new JLabel() ;
    }
    
}
