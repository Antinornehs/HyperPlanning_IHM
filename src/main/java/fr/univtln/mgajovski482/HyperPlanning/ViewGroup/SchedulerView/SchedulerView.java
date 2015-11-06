package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.SchedulerView;

import fr.univtln.mgajovski482.HyperPlanning.Course.Course;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

import static fr.univtln.mgajovski482.HyperPlanning.Course.Course.*;

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
    }

    private void addJComponents(){

    }

    @Override
    public void paintComponent(Graphics g) {
        paintCourses(g);
    }

    public void paintCourses(Graphics g){
        List<Course> coursesOfTheWeek = Course.getCoursesOfTheWeek();
        System.out.println("prout : " + coursesOfTheWeek.size());
        for(Course currentCourse : coursesOfTheWeek)
            paintCourse(g, currentCourse);
    }

    public void paintCourse(Graphics g, Course course){
        Calendar currentCalendar = Calendar.getInstance();
        Calendar courseCalendar = course.getSchedule().getFromCalendar();
        int dayDifference = courseCalendar.get(Calendar.DAY_OF_MONTH) - currentCalendar.get(Calendar.DAY_OF_MONTH);
        int calendarBeginningHour = courseCalendar.get(Calendar.HOUR_OF_DAY);
        int classDuration = course.getSchedule().getHourDuration();

        g.setColor(Color.BLACK);
        System.out.println(dayDifference + " " + calendarBeginningHour + " " + classDuration);
        g.fillRect(
                dayDifference * 50,
                calendarBeginningHour * 50,
                200,
                classDuration * 200);
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
