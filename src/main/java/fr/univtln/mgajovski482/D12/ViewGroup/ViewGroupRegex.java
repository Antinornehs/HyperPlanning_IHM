package fr.univtln.mgajovski482.D12.ViewGroup;

/**
 * Created by Maxime on 16/10/2015.
 */
public final class ViewGroupRegex {

    public static final     String USER_PASSWORD_REGEX =   "^[a-z0-9_-]{6,18}$";

    public static final    String WEBSITE_REGEX
            = "(http(s)?://.)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    public static final    String EMAIL_REGEX           = "^[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$";
    public static final    String PHONE_NUMBER_REGEX    = "^0[1-79][0-9]{8}$";
    public static final    String POSTAL_CODE_REGEX     = "^[0-9]{2} ?[0-9]{3}$";
    public static final    String LAST_NAME_REGEX       = "^[a-zéèàêâùïüëA-Z]{2,20}$";
    public static final    String FIRST_NAME_REGEX      = "^[a-zéèàêâùïüëA-Z]{2,20}$";
    public static final    String CITY_REGEX            = "^[a-zA-Z1-9-/ éèàêâùïüë]{1,50}$";
    public static final    String ADDRESS_REGEX         = "^[a-zA-Z0-9 ,-/éèàêâùïüë]{0,50}$";

}
