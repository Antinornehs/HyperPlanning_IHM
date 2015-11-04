package fr.univtln.mgajovski482.HyperPlanning.Other;

import java.io.File;

/**
 * Created by Maxime on 14/10/2015.
 */
public final class Default_Consts {

    public static final int       DEFAULT_WINDOW_HEIGHT         = 600;
    public static final int       DEFAULT_WINDOW_WIDTH          = 800;
    public static final String    DEFAULT_APP_TITLE             = "Hypper Planning";


    public final static String  RESOURCES_PATH
            = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

    public final static String ADMIN_EMAIL
            = "hyperplanningm1dapm@gmail.com";
//mot_de_passe_hyperplanning
    public final static String ADMIN_PASSWORD
            = "mot_de_passe_hyperplanning";

    public final static String  FONT_PATH
            = RESOURCES_PATH + "font" + File.separator;


    public final static String  FONT_URL
            = "file:" + File.separator + File.separator
            + File.separator + RESOURCES_PATH
            + File.separator + "font" + File.separator;

    public final static String WALLPAPER_PATH
            = RESOURCES_PATH + "WallPaper.png";


}
