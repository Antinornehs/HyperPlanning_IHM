package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ForgottenPasswordView;

import fr.univtln.mgajovski482.HyperPlanning.Gui;
import fr.univtln.mgajovski482.HyperPlanning.Container;
import fr.univtln.mgajovski482.HyperPlanning.SendEmail;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView.ScreenTitleView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupStyle;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupUsefulFct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupUsefulFct.htmlFormattedText;

/**
 * Created by Maxime on 16/10/2015.
 */

public class ForgottenPasswordView extends AbstractView {

    private static volatile ForgottenPasswordView _instance   = null;

    public static final String       DEFAULT_GAP_LEFT_ITEM    = "gapleft 20";
    public static final JLabel        screenTitleJComp         = new JLabel(htmlFormattedText("MDP Oublié ?"));
    public static final JLabel        emailLabel               = new JLabel("Email : ");
    public static final JLabel        confirmEmailLabel        = new JLabel("Confirmation Email: ");

    public static final JTextField    emailJTextField         = new JTextField(20);
    public static final JTextField    confirmEmailJTextField  = new JTextField(20);
    public static final JButton       validateJButton         = new JButton("Valider");
    public static final JButton       cancelJButton           = new JButton("Annuler");


    private ForgottenPasswordView(){
        super();
    }

    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){
        addTitleJComp();
        addEmailField();
        addConfirmEmailField();
        addValidateButton();
        addCancelButton();

        initComponentsArrayToMod();
        setFontOnJComponents(ViewGroupStyle.DEF_THIRD_GRP_FONT_SIZE);
        setBorderToJComponents();

    }

    protected void addTitleJComp(){
        screenTitleJComp.setFont(defaultFont.deriveFont(ViewGroupStyle.DEF_TITLE_FONT_SIZE));
        _instance.add(new JSeparator(), ViewGroupStyle.DEF_BORDER_TO_TITLE_WRAP);
        _instance.add(screenTitleJComp, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }

    private void addEmailField(){
        emailLabel.setLabelFor(emailJTextField);
        emailJTextField.setTransferHandler(null);
        emailJTextField.getDocument().addDocumentListener(new ForgottenPasswordDocumentListener());
        _instance.add(emailLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(emailJTextField, "wrap");
    }


    private void addConfirmEmailField(){

        confirmEmailLabel.setLabelFor(emailJTextField);
        confirmEmailJTextField.setTransferHandler(null);
        confirmEmailJTextField.getDocument().addDocumentListener(new ForgottenPasswordDocumentListener());
        _instance.add(confirmEmailLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(confirmEmailJTextField, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void addValidateButton(){

        validateJButton.setEnabled(false);
        validateJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String author = emailJTextField.getText();
                if(AbstractRegUser.staticRegUsersMap.get(author) == null) {
                    JOptionPane.showMessageDialog(Gui.getInstance().getMyWindow(),
                            htmlFormattedText("Cet e-Mail n'est pas enregistré dans notre BDD."),
                            "Erreur !", JOptionPane.ERROR_MESSAGE);


                }else{

                    JOptionPane.showMessageDialog(Gui.getInstance().getMyWindow(),
                            htmlFormattedText("Votre mot de passe a été envoyé à l'adresse mél suivante: \n"
                                    + "<html><u>" + emailJTextField.getText() + "</u>"),
                            "Mot de passe envoyé avec succès", JOptionPane.INFORMATION_MESSAGE);
                    SendEmail.forgottenPasswordMessage();
                }
                Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();

            }
        });

        _instance.add(new JSeparator(), "");
        _instance.add(validateJButton, ViewGroupStyle.JOIN_TWO_ITEMS);

    }


    private void addCancelButton(){
        cancelJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();
            }
        });
        _instance.add(cancelJButton, "wrap");
    }

    public JButton getValidateJButton() {
        return validateJButton;
    }

    public JTextField getConfirmEmailJTextField() {
        return confirmEmailJTextField;
    }

    public JTextField getEmailJTextField() {
        return emailJTextField;
    }


    protected void initComponentsArrayToMod(){
        super.initComponentsArrayToMod();
        componentsToFont = new ArrayList<JComponent>(
                Arrays.asList(emailLabel, confirmEmailLabel,validateJButton, cancelJButton));

        componentsToSetBorder = new ArrayList<JComponent>(
                Arrays.asList(emailJTextField, confirmEmailJTextField));
    }

    protected void onExit(){
        super.onExit();
        emailJTextField.setText("");
        confirmEmailJTextField.setText("");
    }

    public static ForgottenPasswordView getInstance() {
        if(_instance == null) {
            synchronized (ForgottenPasswordView.class) {
                if (_instance == null){
                    _instance = new ForgottenPasswordView();

                }
            }
        }
        return _instance ;
    }

}
