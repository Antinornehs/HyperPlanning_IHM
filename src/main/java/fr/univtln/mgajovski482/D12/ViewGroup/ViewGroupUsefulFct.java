package fr.univtln.mgajovski482.D12.ViewGroup;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Maxime on 16/10/2015.
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
