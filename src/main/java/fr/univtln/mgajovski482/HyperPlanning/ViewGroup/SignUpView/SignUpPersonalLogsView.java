package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SignUpView;

import com.toedter.calendar.JDateChooser;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView.ScreenTitleView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SignUpView.DocumentListener.SignUpPersonalLogsDocumentListener;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupStyle;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupUsefulFct;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * <b>SignUpPersonalLogsView est une classe représentant une Vue pour l'inscription d'un membre.</b>
 *
 * @author Maxime
 */
public class SignUpPersonalLogsView extends AbstractView {

    private static volatile SignUpPersonalLogsView _instance = null;

    private static final String DEF_ITEM_GAPLEFT    = "gapleft 70";

    public static final  String[] STATUS_ARRAY = RUPersonalLogs.Status.getLabels();

    public static  final  String[] GENDER_ARRAY
            = { "M.", "Mme"};

    private final JLabel screenTitleJLabel              = new JLabel(ViewGroupUsefulFct.htmlFormattedText("Inscription"));
    private final JComboBox<String> genderJComboBox     = new JComboBox<String>();
    private final JLabel genderLabel                    = new JLabel("Sexe : ");

    private final JTextField firstNameJTextField        = new JTextField(10);
    private final JLabel  firstNameLabel                = new JLabel("Prénom : ");

    private final JTextField lastNameJTextField         = new JTextField(10);
    private final JLabel lastNameLabel                  = new JLabel("Nom : ");

    private final JTextField websiteJTextField          = new JTextField(10);
    private final JLabel websiteLabel                   = new JLabel("Site web : ");

    private final JComboBox<String> statusJComboBox     = new JComboBox<String>();
    private final JLabel statusLabel                    = new JLabel("Vous êtes : ");

    private final JTextField cityJTextField             = new JTextField(10);
    private final JLabel cityLabel                      = new JLabel("Ville : ");

    private final JTextField postalCodeJTextField       = new JTextField(5);
    private final JLabel postalCodeLabel                = new JLabel("CP : ");


    private final JTextArea addressJTextArea            = new JTextArea(3,30);
    private final JLabel addressLabel                   = new JLabel("Adresse :");
    private final JScrollPane addressJScrollPane        = new JScrollPane(addressJTextArea);


    private final JTextField phoneNumberJTextField      = new JTextField(10);
    private final JLabel phoneNumberLabel               = new JLabel("Tél : ");


    private final JButton continueJButton   = new JButton("Continuer");
    private final JButton cancelJButton     = new JButton("Annuler");

    private final JDateChooser birthDateJDateChooser = new JDateChooser();
    private final JLabel    birthDateLabel           = new JLabel("Date de naissance : ");


    private SignUpPersonalLogsView(){
        super();
    }

    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){

        addTitleJLabel();
        addGenderComboBox();

        addLastNameJTextField();
        addFirstNameJTextField();

        addBirthDateJCalendar();

        addStatusComboBox();
        addCityJTextField();
        addPostalCodeJTextField();
        addAddressJTextField();
        addPhoneNumberJTextField();
        addWebsiteJTextField();

        addContinueJButton();
        addCancelJButton();

        initComponentsArrayToMod();
        setFontOnJComponents(ViewGroupStyle.DEF_THIRD_GRP_FONT_SIZE);
        setBorderToJComponents();
    }


    private void addTitleJLabel(){

        screenTitleJLabel.setFont(defaultFont.deriveFont(ViewGroupStyle.DEF_TITLE_FONT_SIZE));
        _instance.add(new JSeparator(), ViewGroupStyle.DEF_BORDER_TO_TITLE_WRAP);
        _instance.add(screenTitleJLabel, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }
    private void addGenderComboBox(){

        genderLabel.setLabelFor(genderJComboBox);

        for(String currentGender : GENDER_ARRAY) genderJComboBox.addItem(currentGender);

        genderJComboBox.setBackground(Color.white);

        _instance.add(genderLabel, DEF_ITEM_GAPLEFT);
        _instance.add(genderJComboBox, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void addLastNameJTextField(){

        lastNameLabel.setLabelFor(lastNameJTextField);
        lastNameJTextField.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(lastNameLabel, DEF_ITEM_GAPLEFT );
        _instance.add(lastNameJTextField, ViewGroupStyle.DEF_ITEM_WRAP);
    }


    private void addFirstNameJTextField(){

        firstNameLabel.setLabelFor(firstNameJTextField);
        firstNameJTextField.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(firstNameLabel, DEF_ITEM_GAPLEFT);
        _instance.add(firstNameJTextField, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void addWebsiteJTextField(){

        websiteLabel.setLabelFor(websiteJTextField);
        websiteJTextField.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(websiteLabel, DEF_ITEM_GAPLEFT);
        _instance.add(websiteJTextField, ViewGroupStyle.DEF_ITEM_WRAP);
    }


    private void addStatusComboBox(){

        statusLabel.setLabelFor(statusJComboBox);
        for(String currentStatus : STATUS_ARRAY) statusJComboBox.addItem(currentStatus);
        statusJComboBox.setBackground(Color.white);
        _instance.add(statusLabel, DEF_ITEM_GAPLEFT);
        _instance.add(statusJComboBox, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void addCityJTextField(){

        cityLabel.setLabelFor(cityJTextField);
        cityJTextField.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(cityLabel, DEF_ITEM_GAPLEFT);
        _instance.add(cityJTextField, "split 3");
    }

    private void addPostalCodeJTextField(){

        postalCodeLabel.setLabelFor(postalCodeJTextField);
        postalCodeJTextField.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(postalCodeLabel);
        _instance.add(postalCodeJTextField, ViewGroupStyle.DEF_ITEM_WRAP);
    }

    private void addAddressJTextField(){

        addressLabel.setLabelFor(addressJScrollPane);
        addressJTextArea.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(addressLabel, DEF_ITEM_GAPLEFT);
        _instance.add(addressJScrollPane, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void addPhoneNumberJTextField(){

        phoneNumberLabel.setLabelFor(phoneNumberJTextField);
        phoneNumberJTextField.getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(phoneNumberLabel, DEF_ITEM_GAPLEFT);
        _instance.add(phoneNumberJTextField, ViewGroupStyle.DEF_ITEM_WRAP);
    }


    private void addContinueJButton(){

        continueJButton.setEnabled(false);
        continueJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpPersonalLogsDocumentListener.createPersonalLogs();
                fr.univtln.mgajovski482.HyperPlanning.Container.getInstance().updateView(SignUpConnectionLogsView.getInstance());
                onExit();
            }
        });
        _instance.add(new JSeparator(), "");
        _instance.add(continueJButton,  ViewGroupStyle.JOIN_TWO_ITEMS);
    }


    private void addCancelJButton(){

        cancelJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr.univtln.mgajovski482.HyperPlanning.Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();

            }
        });
        _instance.add(cancelJButton, "wrap");

    }

    private void addBirthDateJCalendar(){

        birthDateLabel.setLabelFor(birthDateJDateChooser);
        birthDateJDateChooser.setCalendar(Calendar.getInstance());
        ((JTextField)birthDateJDateChooser.getDateEditor())
                .getDocument().addDocumentListener(new SignUpPersonalLogsDocumentListener());
        _instance.add(birthDateLabel, DEF_ITEM_GAPLEFT);
        _instance.add(birthDateJDateChooser, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }


    public JDateChooser getBirthDateJDateChooser() {
        return birthDateJDateChooser;
    }

    public JComboBox<String> getGenderJComboBox() {
        return genderJComboBox;
    }

    public JComboBox<String> getStatusJComboBox() {
        return statusJComboBox;
    }

    public JTextField getPhoneNumberJTextField() {
        return phoneNumberJTextField;
    }

    public JButton getContinueJButton() {
        return continueJButton;
    }

    public JTextArea getAddressJTextArea() {
        return addressJTextArea;
    }

    public JTextField getPostalCodeJTextField() {
        return postalCodeJTextField;
    }

    public JTextField getCityJTextField() {
        return cityJTextField;
    }

    public JTextField getWebsiteJTextField() {
        return websiteJTextField;
    }

    public JTextField getLastNameJTextField() {
        return lastNameJTextField;
    }

    public JTextField getFirstNameJTextField() {
        return firstNameJTextField;
    }


    protected void initComponentsArrayToMod(){
        super.initComponentsArrayToMod();
        componentsToFont = new ArrayList<JComponent>(
                Arrays.asList(  genderLabel, firstNameLabel, lastNameLabel,
                        websiteLabel, statusLabel, cityLabel,
                        postalCodeLabel, addressLabel, phoneNumberLabel,
                        continueJButton, cancelJButton, birthDateLabel));

        componentsToSetBorder = new ArrayList<JComponent>(
                Arrays.asList(  genderJComboBox, firstNameJTextField, lastNameJTextField,
                        websiteJTextField, statusJComboBox, cityJTextField,
                        postalCodeJTextField, addressJScrollPane, phoneNumberJTextField, birthDateJDateChooser));
    }


    protected void onExit(){
        super.onExit();
        firstNameJTextField.setText("");
        lastNameJTextField.setText("");
        websiteJTextField.setText("");
        cityJTextField.setText("");
        postalCodeJTextField.setText("");
        addressJTextArea.setText("");
        phoneNumberJTextField.setText("");
    }

    public static SignUpPersonalLogsView getInstance() {
        if(_instance == null) {
            synchronized (SignUpPersonalLogsView.class) {
                if (_instance == null){
                    _instance = new SignUpPersonalLogsView();

                }
            }
        }
        return _instance;
    }
}
