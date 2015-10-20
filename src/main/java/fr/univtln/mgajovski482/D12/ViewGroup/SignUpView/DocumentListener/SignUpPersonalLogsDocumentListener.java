package fr.univtln.mgajovski482.D12.ViewGroup.SignUpView.DocumentListener;

import fr.univtln.mgajovski482.D12.ViewGroup.AbstractDocumentListener;
import fr.univtln.mgajovski482.D12.ViewGroup.SignUpView.SignUpPersonalLogsView;
import fr.univtln.mgajovski482.D12.ViewGroup.ViewGroupRegex;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RUPersonalLogs;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by Maxime on 17/10/2015.
 */
public class SignUpPersonalLogsDocumentListener extends AbstractDocumentListener {

    private static Logger logger = Logger.getLogger("SignUpPersonalLogsDocumentListener.class");
    private static final SignUpPersonalLogsView view = SignUpPersonalLogsView.getInstance();
    private static final JButton continueJButton = view.getContinueJButton();
    private static RUPersonalLogs ruPersonalLogs;



    private static String
            firstNameToTest, lastNameToTest, cityToTest, postalCodeToTest,
            addressToTest, phoneNumberToTest, webSiteToTest, statusLabelToTest;

    private static Calendar
            birthDateToTest;

    private static boolean
            postalCodeIsCorrect, lastNameIsCorrect, firstNameIsCorrect, isMaleToTest,
            phoneNumberIsCorrect, webSiteIsCorrect, cityIsCorrect, addressIsCorrect;

    public SignUpPersonalLogsDocumentListener(){
    }

    public void changedUpdate(DocumentEvent e) {
        statusLabelToTest   = (String)view.getStatusJComboBox().getSelectedItem();
        isMaleToTest        = view.getGenderJComboBox().getSelectedItem().equals("M.");
        firstNameToTest     = view.getFirstNameJTextField()     .getText();
        lastNameToTest      = view.getLastNameJTextField()      .getText();
        birthDateToTest     = view.getBirthDateJDateChooser()   .getCalendar();
        cityToTest          = view.getCityJTextField()          .getText();
        postalCodeToTest    = view.getPostalCodeJTextField()    .getText();
        addressToTest       = view.getAddressJTextArea()        .getText();
        phoneNumberToTest   = view.getPhoneNumberJTextField()   .getText();
        webSiteToTest       = view.getWebsiteJTextField()       .getText();

        postalCodeIsCorrect     = postalCodeToTest.matches      (ViewGroupRegex.POSTAL_CODE_REGEX);
        lastNameIsCorrect       = lastNameToTest.matches        (ViewGroupRegex.LAST_NAME_REGEX);
        firstNameIsCorrect      = firstNameToTest.matches       (ViewGroupRegex.FIRST_NAME_REGEX);
        phoneNumberIsCorrect    = phoneNumberToTest.matches     (ViewGroupRegex.PHONE_NUMBER_REGEX);
        webSiteIsCorrect        = webSiteToTest.matches         (ViewGroupRegex.WEBSITE_REGEX);
        cityIsCorrect           = cityToTest.matches            (ViewGroupRegex.CITY_REGEX);
        addressIsCorrect        = addressToTest.matches         (ViewGroupRegex.ADDRESS_REGEX);

        continueJButton.setEnabled(false);
        if(conditionsAreOkay()) continueJButton.setEnabled(true);
    }

    public static RUPersonalLogs getRuPersonalLogs() {
        return ruPersonalLogs;
    }

    private boolean birthDateIsCorrect(){
        Calendar currentDate = Calendar.getInstance();
        if(birthDateToTest == null) return false;
        return (currentDate.compareTo(birthDateToTest) == 1) ? true : false;
    }


    private static RUPersonalLogs.Status getStatus(){
        RUPersonalLogs.Status[] stati = RUPersonalLogs.Status.values();
      for(RUPersonalLogs.Status currentStatus : stati)
           if(currentStatus.getLabel().equals(statusLabelToTest))
               return currentStatus;
        return null;
    }

    public static void createPersonalLogs(){
        logger.info("PersonalLogs Created Correctly !");
        ruPersonalLogs = new RUPersonalLogs.
                RUPersonalLogsBuilder   (getStatus(), isMaleToTest, lastNameToTest, firstNameToTest, birthDateToTest)
                .city                   (cityToTest)
                .address                (addressToTest)
                .phoneNumber            (phoneNumberToTest)
                .webSite                (webSiteToTest)
                .postalCode             (postalCodeToTest)
                .build();
    }

    private boolean conditionsAreOkay(){
        return (postalCodeIsCorrect && lastNameIsCorrect 
                && firstNameIsCorrect && phoneNumberIsCorrect 
                && webSiteIsCorrect && cityIsCorrect 
                && addressIsCorrect && birthDateIsCorrect()) ? true : false;
    }
}
