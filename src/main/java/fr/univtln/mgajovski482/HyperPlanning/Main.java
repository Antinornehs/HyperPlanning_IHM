package fr.univtln.mgajovski482.HyperPlanning;

/**
 * Created by Maxime on 16/10/2015.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        ActorsMain      .getInstance();
        FormationMain   .getInstance();
        EquipmentMain   .getInstance();
//        Gui             .getInstance();

//        Filling.genStudents();
//        Filling.genTeachers();
//        Filling.genTeachingUnits();
//        Filling.genFormations();
//        Filling.genRooms();
        Filling.genSchedules();

    }
}