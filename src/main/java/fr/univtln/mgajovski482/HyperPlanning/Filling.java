package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.Dao.entityManagers.*;
import fr.univtln.mgajovski482.HyperPlanning.Class.Course;
import fr.univtln.mgajovski482.HyperPlanning.GroupInFormation.GroupInFormation;
import fr.univtln.mgajovski482.HyperPlanning.Reservable.Room.Room;
import fr.univtln.mgajovski482.HyperPlanning.Schedule.Schedule;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Student;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Teacher;

import java.util.logging.Logger;

/**
 * Created by stephane on 04/11/15.
 */

public class Filling {

    private static Logger logger = Logger.getLogger("logFiller");

    public static void genStudents(){
        EntityManager<Student, String> sm = new StudentManager();
        for (String mapKey : AbstractRegUser.staticRegUsersMap.keySet()) {
            if(AbstractRegUser.staticRegUsersMap.get(mapKey).getRuPersonalLogs().getStatus().equals(RUPersonalLogs.Status.STUDENT)){
//                System.out.println(AbstractRegUser.staticRegUsersMap.get(mapKey));
                sm.insert((Student) AbstractRegUser.staticRegUsersMap.get(mapKey));
            }
        }
        logger.info("Students generated");
    }

    public static void genTeachers(){

        EntityManager<Teacher, String> tm = new TeacherManager();
        for (String mapKey : AbstractRegUser.staticRegUsersMap.keySet()) {
            if(AbstractRegUser.staticRegUsersMap.get(mapKey).getRuPersonalLogs().getStatus().equals(RUPersonalLogs.Status.TEACHER)
               || AbstractRegUser.staticRegUsersMap.get(mapKey).getRuPersonalLogs().getStatus().equals(RUPersonalLogs.Status.DIRECTOR_OF_FORMATION)){
                tm.insert((Teacher) AbstractRegUser.staticRegUsersMap.get(mapKey));
            }
        }
        logger.info("Teachers generated");
    }

    public static void genTeachingUnits(){
        EntityManager<TeachingUnit, String> tum = new TeachingUnitManager();
        for(String mapKey : Formation.formationMap.keySet()){
            for(TeachingUnit tu : Formation.formationMap.get(mapKey).getTeachingUnits()){
                tum.insert(tu);
            }
        }
        logger.info("Teaching Units generated");
    }

    public static void genFormations(){
        EntityManager<Formation, String> fm = new FormationManager();
        for(String mapKey : Formation.formationMap.keySet()){
//            System.out.println(Formation.formationMap.get(mapKey));
            fm.insert(Formation.formationMap.get(mapKey));
        }
        logger.info("Formations generated");
    }

    public static void genRooms(){
        EntityManager<Room, String> rm = new RoomManager();
        for(String mapKey : Room.staticRoomMap.keySet()){
//            System.out.println(Room.staticRoomMap.get(mapKey));
            rm.insert(Room.staticRoomMap.get(mapKey));
        }
        logger.info("Rooms generated");
    }

    public static void genSchedules(){
        EntityManager<Schedule, Integer> sm = new ScheduleManager();
        for(int mapKey : Schedule.staticScheduleMap.keySet()){
//            System.out.println(Schedule.staticScheduleMap.get(mapKey));
            sm.insert(Schedule.staticScheduleMap.get(mapKey));
        }
        logger.info("Schedules generated");
    }


    public static void genCourses(){
        EntityManager<Course, Integer> cm = new CourseManager();
        for(int mapKey : Course.staticCourseMap.keySet()){
//            System.out.println(Course.staticClassMap.get(mapKey));
            cm.insert(Course.staticCourseMap.get(mapKey));
        }
        logger.info("Courses generated");
    }
    /*
    public static void genGroups(){

        EntityManager<GroupInFormation, Integer> gm = new GroupManager();
        System.out.println(GroupInFormation.staticGroupInFormationMap.size());
        for(int mapKey : GroupInFormation.staticGroupInFormationMap.keySet()){
            System.out.println(GroupInFormation.staticGroupInFormationMap.get(mapKey));
            gm.insert(GroupInFormation.staticGroupInFormationMap.get(mapKey));
        }
        logger.info("Groups generated");
    }
    */
}