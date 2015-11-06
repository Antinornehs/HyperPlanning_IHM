package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView;

import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractViewGroupListener;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ContactWebmaster.ContactWebmasterView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ForgottenPasswordView.ForgottenPasswordView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SchedulerView.SchedulerView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SignUpView.SignUpFormationView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SignUpView.SignUpPersonalLogsView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupStyle;
import fr.univtln.mgajovski482.HyperPlanning.Container;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupUsefulFct;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by Maxime on 03/10/2015.
 */
public class ScreenTitleView extends AbstractView {

    private final String        DEF_ITEM_GAPLEFT            = "gapleft 20";

    private static volatile ScreenTitleView _instance = null;

    public static final  JTextField        loginJTextField         = new JTextField        (10);
    public static final JPasswordField    passwordJPasswordField  = new JPasswordField    (10);
    public static final JLabel            screenTitleJLabel       = new JLabel(ViewGroupUsefulFct.htmlFormattedText("Hyper Planning"));
    public static final JLabel            forgottenPasswordJLabel = new JLabel(ViewGroupUsefulFct.htmlFormattedText("Perte d'identifiants"));
    public static final JLabel            signUpJLabel            = new JLabel(ViewGroupUsefulFct.htmlFormattedText("S'inscrire"));
    public static final JLabel            contactWebmasterJLabel  = new JLabel(ViewGroupUsefulFct.htmlFormattedText("Nous contacter"));
    public static final JLabel            visitorAccessJLabel     = new JLabel(ViewGroupUsefulFct.htmlFormattedText("Acces visiteur"));
    public static final JLabel            loginJLabel             = new JLabel("Pseudo : ");
    public static final JLabel            passwordJLabel          = new JLabel("Mot de passe : ");
    public static final JButton           logInJButton            = new JButton("Valider");



    private ScreenTitleView(){
        super();
    }


    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){
        addTitleJComp();
        addLoginJComp();
        addPasswordJComp();
        addVisitorAccessItem();
        addLogInButton();
        addForgottenPasswordJComp();
        addContactWebmasterJComp();
        addSignUpJComp();

        initComponentsArrayToMod();
        setFontOnJComponents(ViewGroupStyle.DEF_SCND_GRP_FONT_SIZE);
        setBorderToJComponents();

    }


    private void addTitleJComp(){
        screenTitleJLabel.setFont(defaultFont.deriveFont(ViewGroupStyle.DEF_TITLE_FONT_SIZE));
        _instance.add(new JSeparator(), ViewGroupStyle.DEF_BORDER_TO_TITLE_WRAP);
        _instance.add(screenTitleJLabel, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }
    private void addLoginJComp(){
        loginJLabel.setLabelFor(loginJTextField);
        loginJTextField.getDocument().addDocumentListener(new ScreenTitleDocumentListener());
        loginJTextField.setTransferHandler(null);
        _instance.add(loginJLabel, DEF_ITEM_GAPLEFT);
        _instance.add(loginJTextField,"wrap");
    }

    private void addPasswordJComp(){
        passwordJLabel.setLabelFor(passwordJPasswordField);
        passwordJPasswordField.getDocument().addDocumentListener(new ScreenTitleDocumentListener());
        passwordJPasswordField.setTransferHandler(null);
        _instance.add(passwordJLabel, DEF_ITEM_GAPLEFT);
        _instance.add(passwordJPasswordField, "wrap 30");
    }

    private void addForgottenPasswordJComp(){
        forgottenPasswordJLabel.addMouseListener(new AbstractViewGroupListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                forgottenPasswordJLabel.setText(ViewGroupUsefulFct.htmlFormattedText
                        ("<span style=\"color:" + ViewGroupStyle.DEFAULT_HIGHLIGHT_COLOR + "\">Perte d'identifiants"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                forgottenPasswordJLabel.setText(ViewGroupUsefulFct.htmlFormattedText
                        ("Perte d'identifiants"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Container.getInstance().updateView(ForgottenPasswordView.getInstance());
                onExit();
                mouseExited(e);

            }
        });

        _instance.add(forgottenPasswordJLabel, DEF_ITEM_GAPLEFT + "," + "wrap");
    }

    private void addSignUpJComp(){
        signUpJLabel.addMouseListener(new AbstractViewGroupListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                signUpJLabel.setText(ViewGroupUsefulFct.htmlFormattedText
                        ("<span style=\"color:" + ViewGroupStyle.DEFAULT_HIGHLIGHT_COLOR + "\">S'inscrire"));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                signUpJLabel.setText(ViewGroupUsefulFct.htmlFormattedText("S'inscrire"));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Container.getInstance().updateView(SignUpPersonalLogsView.getInstance());
                onExit();
                mouseExited(e);
            }
        });

        _instance.add(signUpJLabel, DEF_ITEM_GAPLEFT + "," + "wrap");
    }

    private void addContactWebmasterJComp(){
        contactWebmasterJLabel.addMouseListener(new AbstractViewGroupListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                contactWebmasterJLabel.setText(ViewGroupUsefulFct.htmlFormattedText
                        ("<span style=\"color:" + ViewGroupStyle.DEFAULT_HIGHLIGHT_COLOR + "\">Nous contacter"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                contactWebmasterJLabel.setText(ViewGroupUsefulFct.htmlFormattedText("Nous contacter"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Container.getInstance().updateView(ContactWebmasterView.getInstance());
                onExit();
                mouseExited(e);

            }
        });

        _instance.add(contactWebmasterJLabel, DEF_ITEM_GAPLEFT + "," + "wrap");
    }

    private void addLogInButton(){
        logInJButton.setEnabled(false);
        logInJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });
        _instance.add(logInJButton, "wrap");
    }

    private void addVisitorAccessItem(){
        visitorAccessJLabel.addMouseListener(new AbstractViewGroupListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                visitorAccessJLabel.setText(ViewGroupUsefulFct.htmlFormattedText
                        ("<span style=\"color:" + ViewGroupStyle.DEFAULT_HIGHLIGHT_COLOR + "\">Acces visiteur"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                visitorAccessJLabel.setText(ViewGroupUsefulFct.htmlFormattedText("Acces visiteur"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Container.getInstance().updateView(SchedulerView.getInstance());
                onExit();
                mouseExited(e);
            }

        });
        _instance.add(visitorAccessJLabel,"gapleft 120");
    }

    public JButton getLogInJButton() {
        return logInJButton;
    }

    public JPasswordField getPasswordJPasswordField() {
        return passwordJPasswordField;
    }

    public JTextField getLoginJTextField() {
        return loginJTextField;
    }


    protected void initComponentsArrayToMod(){
        super.initComponentsArrayToMod();
        componentsToFont = new ArrayList<JComponent>(
                Arrays.asList(  forgottenPasswordJLabel, signUpJLabel, contactWebmasterJLabel,
                                visitorAccessJLabel,loginJLabel, passwordJLabel));

        componentsToSetBorder = new ArrayList<JComponent>(
                Arrays.asList(loginJTextField, passwordJPasswordField));
    }

    @Override
    protected void onExit() {
        super.onExit();
        passwordJPasswordField.setText("");
        loginJTextField.setText("");
    }

    public static ScreenTitleView getInstance() {
        if(_instance == null) {
            synchronized (ScreenTitleView.class) {
                if (_instance == null) {
                    _instance = new ScreenTitleView();
                }
            }
        }
        return _instance;
    }

}
