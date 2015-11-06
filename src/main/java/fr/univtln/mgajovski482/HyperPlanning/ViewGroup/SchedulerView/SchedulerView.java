package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SchedulerView;

import fr.univtln.mgajovski482.HyperPlanning.Class.Course;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Collections;

import static fr.univtln.mgajovski482.HyperPlanning.Class.Course.*;

/**
 * Created by Maxime on 26/10/2015.
 */
public class SchedulerView extends AbstractView {

    private static volatile SchedulerView _instance = null;

    private static final String days[] = {
            "Lundi", "Mardi","Mercredi",
            "Jeudi","Vendredi","Samedi", "Dimanche"};


    private static TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return 10; }
        public int getRowCount() { return 10;}
        public Object getValueAt(int row, int col) { return new Integer(row*col); }
    };

    private static JTable weekJTable            = new JTable(dataModel);
    private static JScrollPane weekJScrollPane  = new JScrollPane(weekJTable);

    public void initAbstractView(){
        super.initAbstractView();
        addJComponents();
    }

    private void addJComponents(){

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void paintCourse(Graphics g){

    }

    public static SchedulerView getInstance() {
        if(_instance == null) {
            synchronized (SchedulerView.class) {
                if (_instance == null) {
                    _instance = new SchedulerView();
                }
            }
        }
        return _instance;
    }
}
