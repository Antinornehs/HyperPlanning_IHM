package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SchedulerView;

import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Created by Maxime on 26/10/2015.
 */
public class SchedulerView extends AbstractView {

    private static volatile SchedulerView _instance = null;

    private static final String days[] = {"Lundi", "Mardi","Mercredi",
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
