package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ContactWebmaster;

import fr.univtln.mgajovski482.HyperPlanning.Gui;
import fr.univtln.mgajovski482.HyperPlanning.Container;
import fr.univtln.mgajovski482.HyperPlanning.SendEmail;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView.ScreenTitleView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupStyle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupUsefulFct.htmlFormattedText;

/**
 * Created by Maxime on 16/10/2015.
 */
public class ContactWebmasterView extends AbstractView {

    private static volatile ContactWebmasterView _instance = null;

    public static final  String       DEFAULT_GAP_LEFT_ITEM   = "gapleft 20";
    public static final JLabel        screenTitleLabel        = new JLabel(htmlFormattedText("Contact"));
    public static final JTextField    authorJTextField        = new JTextField(20);
    public static final JLabel        authorLabel             = new JLabel("Auteur : ");
    public static final JTextField    topicJTextField         = new JTextField(20);
    public static final JLabel        topicLabel              = new JLabel("Sujet : ");
    public static final JTextArea     messageJTextArea        = new JTextArea(10,30);
    public static final JScrollPane   messageScrollPaneJComp  = new JScrollPane(messageJTextArea);
    public static final JLabel        messageLabel            = new JLabel("Message : ");
    public static final JButton       validateJButton         = new JButton("Valider");
    public static final JButton       cancelButtonJComp       = new JButton("Annuler");


    private ContactWebmasterView(){
        super();
    }

    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){

        addTitleJComp();
        addAuthorTextField();
        addTopicTextField();
        addMessageTextArea();
        initAndAddValidateButton();
        initAndAddCancelButton();

        initComponentsArrayToMod();
        setBorderToJComponents();
        setFontOnJComponents(ViewGroupStyle.DEF_THIRD_GRP_FONT_SIZE);

    }


    protected void addTitleJComp(){
        screenTitleLabel.setFont(defaultFont.deriveFont(ViewGroupStyle.DEF_TITLE_FONT_SIZE));
        _instance.add(new JSeparator(), ViewGroupStyle.DEF_BORDER_TO_TITLE_WRAP);
        _instance.add(screenTitleLabel, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }

    private void addAuthorTextField(){
        authorLabel.setLabelFor(authorJTextField);
        authorJTextField.getDocument().addDocumentListener(new ContactWebmasterDocumentListener());
        authorJTextField.setTransferHandler(null);
        _instance.add(authorLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(authorJTextField, "wrap");
    }


    private void addTopicTextField(){
        topicLabel.setLabelFor(topicJTextField);
        topicJTextField.getDocument().addDocumentListener(new ContactWebmasterDocumentListener());
        topicJTextField.setTransferHandler(null);
        _instance.add(topicLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(topicJTextField, "wrap");
    }


    private void addMessageTextArea(){
        messageLabel.setLabelFor(messageScrollPaneJComp);
        messageJTextArea.getDocument().addDocumentListener(new ContactWebmasterDocumentListener());
        messageJTextArea.setTransferHandler(null);
        _instance.add(messageLabel, DEFAULT_GAP_LEFT_ITEM);
        _instance.add(messageScrollPaneJComp, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    private void initAndAddValidateButton(){

       validateJButton.setEnabled(false);
        validateJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String author = authorJTextField.getText();
                if(AbstractRegUser.staticRegUsersMap.get(author) == null) {
                    JOptionPane.showMessageDialog(Gui.getInstance().getMyWindow(),
                            htmlFormattedText("Cet e-Mail n'est pas enregistré dans notre BDD."),
                            "Erreur !", JOptionPane.ERROR_MESSAGE);


                }else{
                    JOptionPane.showMessageDialog(Gui.getInstance().getMyWindow(),
                            htmlFormattedText("Votre message a bien été transmis.\n" +
                                    "Un opérateur va traiter votre requête."),
                            "Message envoyé avec succès", JOptionPane.INFORMATION_MESSAGE);
                    SendEmail.sendContactWebmasterMessage();
                }

                Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();
            }
        });

        _instance.add(new JSeparator(), "");
        _instance.add(validateJButton, ViewGroupStyle.JOIN_TWO_ITEMS);

    }

    private void initAndAddCancelButton(){
        cancelButtonJComp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container.getInstance().updateView(ScreenTitleView.getInstance());
                onExit();
            }
        });
        _instance.add(cancelButtonJComp, "wrap");
    }

    public JTextField getAuthorJTextField() {return authorJTextField;}

    public JTextField getTopicJTextField() {
        return topicJTextField;
    }
    public JButton      getValidateJButton() {
        return validateJButton;
    }

    public JTextArea getMessageJTextArea() {
        return messageJTextArea;
    }


    protected void initComponentsArrayToMod(){
        super.initComponentsArrayToMod();
        componentsToFont = new ArrayList<JComponent>(
                Arrays.asList(  authorLabel, topicLabel, messageLabel,
                        validateJButton, cancelButtonJComp));

        componentsToSetBorder = new ArrayList<JComponent>(
                Arrays.asList(authorJTextField, topicJTextField, messageScrollPaneJComp));
    }


    protected void onExit(){
        super.onExit();
        authorJTextField        .setText("");
        topicJTextField         .setText("");
        messageJTextArea        .setText("");
    }

    public static ContactWebmasterView getInstance() {
        if(_instance == null) {
            synchronized (ContactWebmasterView.class) {
                if (_instance == null){
                    _instance = new ContactWebmasterView();

                }
            }
        }
        return _instance;
    }
}
