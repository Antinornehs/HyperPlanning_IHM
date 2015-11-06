package fr.univtln.mgajovski482.HyperPlanning;


import fr.univtln.mgajovski482.HyperPlanning.GroupInFormation.GroupInFormation;

/**
 * <b>Main est la classe principale du programme.</b>
 * <p>
 * La classe main instancie toutes les classes meres des differents packages.
 * Elle instancie les packages :
 * <ul>
 *     <li>Actors correspondant aux utilisateurs de l'application</li>
 *     <li>Formations correspondant aux differentes formations disponibles </li>
 *     <li>Reservable correspondant aux objets réservables tel que :
 *         <ul>
 *             <li>Le materiel (Ordinateurs, Projecteurs)</li>
 *             <li>Les salles</li>
 *             <li>Les cours</li>
 *         </ul>
 *     </li>
*     <li>Gui correspondant tout ce qui touche a l'interface graphique.</li>
 * </ul>
 *  @author Maxime
 */

public class Main {

    public static void main(String[] args) throws Exception{

        ActorsMain      .getInstance();
        FormationMain   .getInstance();

        EquipmentMain   .getInstance();
        GroupsMain      .getInstance();

        ActorsMain      .getInstance();
        FormationMain   .getInstance();
//        Gui             .getInstance();

//        Filling.genStudents();
//        Filling.genTeachers();
//        Filling.genTeachingUnits();
//        Filling.genFormations();
//        Filling.genRooms();
//        Filling.genSchedules();
//        Filling.genCourses();
        Filling.genGroups();

    }
}