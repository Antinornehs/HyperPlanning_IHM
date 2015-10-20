package fr.univtln.mgajovski482.D12;

import fr.univtln.mgajovski482.D12.Other.Default_Consts;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static volatile App   INSTANCE              = null;
    private static JPanel         container             = null;
    private JFrame                myWindow              = null;


    private App() {

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
    }

    public JFrame getMyWindow() {
        return myWindow;
    }

    public static App getInstance()
    {
        if (INSTANCE == null) {
            synchronized(App.class) {
                if (INSTANCE == null) {
                    INSTANCE = new App();
                }
            }
        }
        return INSTANCE;
    }
}
