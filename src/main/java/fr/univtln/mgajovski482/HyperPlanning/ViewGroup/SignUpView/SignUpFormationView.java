package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SignUpView;

import fr.univtln.mgajovski482.HyperPlanning.Container;
import fr.univtln.mgajovski482.HyperPlanning.Formation;
import fr.univtln.mgajovski482.HyperPlanning.Gui;
import fr.univtln.mgajovski482.HyperPlanning.TeachingUnit;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView.ScreenTitleView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SignUpView.DocumentListener.SignUpPersonalLogsDocumentListener;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupStyle;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupUsefulFct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maxime on 26/10/2015.
 */
public class SignUpFormationView extends AbstractView{


    private static volatile SignUpFormationView _instance = null;


    private static final String DEF_ITEM_GAPLEFT        = "gapleft 70";
    private static final String[] FORMATION_ARRAY       = Formation.getFormationsLabel();
    private final JLabel screenTitleJLabel              = new JLabel(
            ViewGroupUsefulFct.htmlFormattedText("Inscription"));


    private final JComboBox<String> formationJComboBox     = new JComboBox<String>();
    private final JLabel formationLabel                    = new JLabel("Formation : ");


    private final JLabel        formationDescJLabel               = new JLabel();
    private final JTextPane     formationDescJTextPane            = new JTextPane();
    private final JScrollPane   formationDescJScrollPane          = new JScrollPane(formationDescJTextPane);

    private final JButton continueJButton                        = new JButton("Valider");
    private final JButton cancelJButton                         = new JButton("Annuler");


    private SignUpFormationView(){
        super();
    }

    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){

        addTitleJLabel();
        addFormationComboBox();

        initComponentsArrayToMod();
        addFormationDescription();
        addContinueJButton();
        addCancelJButton();

        initComponentsArrayToMod();

        setFontOnJComponents(ViewGroupStyle.DEF_THIRD_GRP_FONT_SIZE);
    }


    private void addTitleJLabel(){

        screenTitleJLabel.setFont(defaultFont.deriveFont(ViewGroupStyle.DEF_TITLE_FONT_SIZE));
        _instance.add(new JSeparator(), ViewGroupStyle.DEF_BORDER_TO_TITLE_WRAP);
        _instance.add(screenTitleJLabel, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);

    }

    private void addFormationComboBox(){

        formationLabel.setLabelFor(formationJComboBox);

        for(String currentFormation : FORMATION_ARRAY) formationJComboBox.addItem(currentFormation);

        formationJComboBox.setBackground(Color.white);
        formationJComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateFormationDescJLabel((String) formationJComboBox.getSelectedItem());
            }
        });

        _instance.add(formationLabel, DEF_ITEM_GAPLEFT + "," + ViewGroupStyle.JOIN_TWO_ITEMS);
        _instance.add(formationJComboBox, ViewGroupStyle.DEF_GROUP_ITEM_WRAP);
    }


    public void updateFormationDescJLabel(String formationLabel){

        List<TeachingUnit> teachingUnits = Formation.formationMap.get(formationLabel).getTeachingUnits();
        System.out.println(teachingUnits .size());
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<html>");
        for(TeachingUnit teachingUnit : teachingUnits)
            stringBuilder.append(teachingUnit.htmlToString());
        stringBuilder.append("</html>");
        System.out.println(stringBuilder.toString());

        formationDescJLabel.setText(stringBuilder.toString());
        formationDescJTextPane  .insertComponent(formationDescJLabel);
    }

    private void addFormationDescription(){

        int windowWidth     = Gui.getInstance().getMyWindow().getWidth();
        int windowHeight    = Gui.getInstance().getMyWindow().getHeight();
        String formationLabel = (String) formationJComboBox.getSelectedItem();

        formationDescJTextPane  .setContentType("text/html");
        formationDescJTextPane  .setEditable(false);
        formationDescJScrollPane.setPreferredSize(new Dimension(windowWidth * 2 / 3, windowHeight / 2));
        updateFormationDescJLabel(formationLabel);

        _instance.add(formationDescJScrollPane, ViewGroupStyle.DEF_GROUP_ITEM_WRAP );
    }


    private void addContinueJButton(){

        continueJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formation formation = Formation.formationMap.get(formationJComboBox.getSelectedItem());
                Container.getInstance().updateView(SignUpConnectionLogsView.getInstance());
                SignUpPersonalLogsDocumentListener.setFormation(formation);
                onExit();
            }
        });
        _instance.add(continueJButton,  ViewGroupStyle.JOIN_TWO_ITEMS );
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

    public JButton getContinueJButton() {
        return continueJButton;
    }

    public JLabel getFormationDescJLabel() {
        return formationDescJLabel;
    }

    public JComboBox<String> getFormationJComboBox() {
        return formationJComboBox;
    }

    protected void initComponentsArrayToMod(){
        super.initComponentsArrayToMod();
        componentsToFont = new ArrayList<JComponent>(
                Arrays.asList( formationLabel, continueJButton, cancelJButton,
                        formationDescJLabel
                        ));
/*
        componentsToSetBorder = new ArrayList<JComponent>(
                Arrays.asList(  firstNameJTextField, lastNameJTextField,websiteJTextField,
                        cityJTextField, postalCodeJTextField, addressJScrollPane,
                        phoneNumberJTextField, birthDateJDateChooser));*/
    }

    public static SignUpFormationView getInstance() {
        if(_instance == null) {
            synchronized (SignUpFormationView.class) {
                if (_instance == null){
                    _instance = new SignUpFormationView();

                }
            }
        }
        return _instance;
    }
}
