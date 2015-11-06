package fr.univtln.mgajovski482.HyperPlanning.ViewGroup;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * <b>ViewGroupUsefullFct est une classe utilitaire comprenant des methodes utiles a
 * l'elaboration de l'interface graphique</b>
 *  @author Maxime
 */

public final class ViewGroupUsefulFct {

    public static String htmlFormattedText(String string){
        return "<html>" +string + "</html>";
    }


    public final static Font importFont(String fontPath) {
        URL fontUrl = null;
        Font font   = null;

        try {
            fontUrl = new URL(fontPath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsEnvironment.registerFont(font);

        return font;
    }
}
