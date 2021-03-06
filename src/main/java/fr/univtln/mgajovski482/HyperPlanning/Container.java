package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.Other.Default_Consts;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView.ScreenTitleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <b>Container est un JPanel contenant toutes les vues de l'application.</b>
 * <p>
 * La classe Container est un singleton qui va servir :
 * <ul>
 *     <li>A mettre à jour les differentes vues de l'application</li>
 *     <li>A afficher un Wallpaper sur lequel les JPanel se poseront</li>
 * </ul>
 *
 *  @author Maxime
 */
public class Container extends JPanel {

    private static volatile Container   _instance           = null;
    private AbstractView abstractView        = null;
    private final String                WALLPAPER_PATH      = Default_Consts.WALLPAPER_PATH;


    private Container() {
        initFirstView(ScreenTitleView.getInstance());
    }

    public void paintComponent(Graphics g)
    {
        clearPaintedComponents(g);
        displayWallpaper(g);
    }

    private void displayWallpaper(Graphics g){

        BufferedImage backgroundImg = null;
        File backgroundURL          = new File(WALLPAPER_PATH);
        try{
            backgroundImg = ImageIO.read(backgroundURL);
        }catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(backgroundImg, 0, 0, null);
    }

    private void clearPaintedComponents(Graphics g){
        g.clearRect(0, 0, Default_Consts.DEFAULT_WINDOW_WIDTH, Default_Consts.DEFAULT_WINDOW_HEIGHT);
    }

    public void initFirstView(AbstractView aView){
        setView(aView);
    }

    public void setView(AbstractView aView)
    {
        this.abstractView = aView;
        if(!abstractView.isInitialised())
            abstractView.initAbstractView();
        add(abstractView);
    }

    public void updateView(AbstractView aView){
        this.removeAll();
        setView(aView);
        revalidate();
        repaint();
    }

    public static Container getInstance() {
        if (_instance == null) {
            synchronized(Gui.class) {
                if (_instance == null) {
                    _instance = new Container();
                }
            }
        }
        return _instance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyPanel Class" + "\n");
        stringBuilder.append(abstractView);
        return stringBuilder.toString();
    }
}