package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.Other.Default_Consts;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * <b>Gui est la classe principale de l'interface graphique.</b>
 * <p>
 * La classe Gui est un singleton comprenant :
 * <ul>
 *     <li>Un JPanel qui fait office de container.</li>
 *     <li>Une JFrame dans laquelle l'interface est generee.</li>
 * </ul>
 *
 *  @author Maxime
 */
public class Gui
{


    private static Logger logger = Logger.getLogger("Gui.class");
    private static volatile Gui     _instance = null;
    private static JPanel           container = null;
    private JFrame                  myWindow  = null;


    private Gui() {

        container   = fr.univtln.mgajovski482.HyperPlanning.Container.getInstance();
        myWindow    = new JFrame(Default_Consts.DEFAULT_APP_TITLE);

        myWindow.getContentPane().add(container);
        container.setPreferredSize(
                new Dimension(
                        Default_Consts.DEFAULT_WINDOW_WIDTH,
                        Default_Consts.DEFAULT_WINDOW_HEIGHT));

        myWindow.pack();
        myWindow.setVisible(true);
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logger.info("Gui Package Initialized !");
    }

    public JFrame getMyWindow() {
        return myWindow;
    }

    public static Gui getInstance()
    {
        if (_instance == null) {
            synchronized(Gui.class) {
                if (_instance == null) {
                    _instance = new Gui();
                }
            }
        }
        return _instance;
    }
}