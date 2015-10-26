package fr.univtln.mgajovski482.D12;

import fr.univtln.mgajovski482.D12.Other.Default_Consts;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class Gui
{


    private static Logger logger = Logger.getLogger("Gui.class");
    private static volatile Gui     _instance = null;
    private static JPanel           container = null;
    private JFrame                  myWindow  = null;


    private Gui() {

        container   = Container.getInstance();
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