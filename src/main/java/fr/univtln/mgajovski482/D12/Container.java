package fr.univtln.mgajovski482.D12;

import fr.univtln.mgajovski482.D12.Other.Default_Consts;
import fr.univtln.mgajovski482.D12.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.D12.ViewGroup.ScreenTitleView.ScreenTitleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Maxime on 14/10/2015.
 */
public class Container extends JPanel {

    private static volatile Container   _instance           = null;
    private AbstractView                abstractView        = null;
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
            synchronized(App.class) {
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
