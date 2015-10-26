package fr.univtln.mgajovski482.D12.ViewGroup.SignUpView;

import fr.univtln.mgajovski482.D12.Container;
import fr.univtln.mgajovski482.D12.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.D12.ViewGroup.ScreenTitleView.ScreenTitleView;
import fr.univtln.mgajovski482.D12.ViewGroup.SignUpView.DocumentListener.SignUpConnectionLogsDocumentListener;
import fr.univtln.mgajovski482.D12.ViewGroup.SignUpView.DocumentListener.SignUpPersonalLogsDocumentListener;
import fr.univtln.mgajovski482.D12.ViewGroup.ViewGroupStyle;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserFactory.RUFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static fr.univtln.mgajovski482.D12.ViewGroup.ViewGroupUsefulFct.htmlFormattedText;

/**
 * Created by Maxime on 17/10/2015.
 */
public class SignUpConnectionLogsView extends AbstractView {

    private static volatile SignUpConnectionLogsView _instance = null;

    private static final String DEFAULT_GAP_LEFT_ITEM           = "gapleft 70";
    private final JLabel screenTitleJLabel                      = new JLabel(htmlFormattedText("Inscription"));
    private final JPasswordField passwordJPasswordField         = new JPasswordField(10);
    private final JLabel passwordLabel                          = new JLabel("Mot de passe : ");

    private final JPasswordField confirmPasswordJPasswordField  = new JPasswordField(10);
    private final JLabel confirmPasswordLabel                   = new JLabel("Confirmaton MDP : ");


    private final JTextField emailJTextField                    = new JTextField(20);
    private final JLabel emailLabel                             = new JLabel("E-mail :");


    private final JTextField confirmEmailJTextField             = new JTextField(20);
    private final JLabel confirmEmailLabel                      = new JLabel("Confirmation E-mail");

    private final JButton confirmJButton                        = new JButton("Valider");
    private final JButton cancelJButton                         = new JButton("Annuler");



    public SignUpConnectionLogsView(){
        super();
    }

    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){

        addTitleJLabel();
        addPasswordJPasswordField();
        addConfirmPasswordJPasswordField();
        addEmailJTextField();
        addConfirmEmailJTextField();
        addConfirmJButton();
        addCancelJButton();

        initComponentsArrayToMod();
        setBorderToJComponents();
        setFontOnJComponents(ViewGroupStyle.DEF_THIRD_GRP_FONT_SIZE);
    }


    private void addTitleJLabel(){

        screenTitleJLabel.setFont(defaultFont.deriveFont(ViewGroupStyle.DEF_TITLE_FONT_SIZE));
        _instance.add(new JSeparator(), ViewGroupStyle.DEF_BORDER_TO_TITLE_WRAP);
        _instance.add(screenTitleJLabel, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }

    private void addPasswordJPasswordField(){
        passwordLabel.setLabelFor(passwordJPasswordField);
        passwordJPasswordField.getDocument().addDocumentListener(
                new SignUpConnectionLogsDocumentListener());
        _instance.add(passwordLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(passwordJPasswordField, ViewGroupStyle.DEF_ITEM_WRAP);
    }

    private void addConfirmPasswordJPasswordField(){
        confirmPasswordLabel.setLabelFor(confirmPasswordJPasswordField);
        confirmPasswordJPasswordField.getDocument().addDocumentListener(
                new SignUpConnectionLogsDocumentListener());
        _instance.add(confirmPasswordLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(confirmPasswordJPasswordField, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }

    private void addEmailJTextField(){
        emailLabel.setLabelFor(emailJTextField);
        emailJTextField.getDocument().addDocumentListener(
                new SignUpConnectionLogsDocumentListener());
        _instance.add(emailLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(emailJTextField, ViewGroupStyle.DEF_ITEM_WRAP);
    }


    private void addConfirmEmailJTextField(){
        confirmEmailLabel.setLabelFor(confirmEmailJTextField);
        confirmEmailJTextField.getDocument().addDocumentListener(
                new SignUpConnectionLogsDocumentListener());
        _instance.add(confirmEmailLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(confirmEmailJTextField, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void addConfirmJButton(){
        confirmJButton.setEnabled(false);
        confirmJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpConnectionLogsDocumentListener.createConnectionLogs();
                RUFactory.createRegisteredUser(
                        SignUpPersonalLogsDocumentListener.getRuPersonalLogs(),
                        SignUpConnectionLogsDocumentListener.getRuConnectionLogs());
                Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();
            }
        });

        _instance.add(new JSeparator(), "");
        _instance.add(confirmJButton, ViewGroupStyle.JOIN_TWO_ITEMS);

    }


    private void addCancelJButton(){
        cancelJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();
            }
        });
        _instance.add(cancelJButton, "wrap");

    }

    public JButton getCancelJButton() {
        return cancelJButton;
    }

    public JButton getConfirmJButton() {
        return confirmJButton;
    }

    public JTextField getConfirmEmailJTextField() {
        return confirmEmailJTextField;
    }

    public JTextField getEmailJTextField() {
        return emailJTextField;
    }

    public JPasswordField getConfirmPasswordJPasswordField() {
        return confirmPasswordJPasswordField;
    }

    public JPasswordField getPasswordJPasswordField() {
        return passwordJPasswordField;
    }


    protected void initComponentsArrayToMod(){
        super.initComponentsArrayToMod();
        componentsToFont = new ArrayList<JComponent>(
                Arrays.asList(passwordLabel, confirmPasswordLabel, emailLabel,
                        confirmEmailLabel,confirmJButton, cancelJButton));

        componentsToSetBorder = new ArrayList<JComponent>(
                Arrays.asList(  passwordJPasswordField, confirmPasswordJPasswordField,
                        emailJTextField,confirmEmailJTextField));
    }


    protected void onExit(){
        super.onExit();
        confirmEmailJTextField          .setText("");
        emailJTextField                 .setText("");
        confirmPasswordJPasswordField   .setText("");
        passwordJPasswordField          .setText("");
    }


    public static SignUpConnectionLogsView getInstance() {
        if(_instance == null) {
            synchronized (SignUpPersonalLogsView.class) {
                if (_instance == null){
                    _instance = new SignUpConnectionLogsView();

                }
            }
        }
        return _instance;
    }

}
