package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Student;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Teacher;
import fr.univtln.sgrassell418.d12.dao.entityManagers.*;

import java.util.logging.Logger;

/**
 * Created by stephane on 04/11/15.
 */
public class Filling {

    private Logger logger = Logger.getLogger("logFiller");

    public static void genStudents(){
        EntityManager<Student, String> sm = new StudentManager();
        for (String mapKey : AbstractRegUser.staticRegUsersMap.keySet()) {
            if(AbstractRegUser.staticRegUsersMap.get(mapKey).getRuPersonalLogs().getStatus().equals(RUPersonalLogs.Status.STUDENT)){
                sm.insert((Student) AbstractRegUser.staticRegUsersMap.get(mapKey));
            }
        }
    }

    public static void genTeachers(){
        EntityManager<Teacher, String> tm = new TeacherManager();
        for (String mapKey : AbstractRegUser.staticRegUsersMap.keySet()) {
            if(AbstractRegUser.staticRegUsersMap.get(mapKey).getRuPersonalLogs().getStatus().equals(RUPersonalLogs.Status.TEACHER)
               || AbstractRegUser.staticRegUsersMap.get(mapKey).getRuPersonalLogs().getStatus().equals(RUPersonalLogs.Status.DIRECTOR_OF_FORMATION)){
                tm.insert((Teacher) AbstractRegUser.staticRegUsersMap.get(mapKey));
            }
        }
    }

    public static void genTeachingUnits(){
        EntityManager<TeachingUnit, String> tum = new TeachingUnitManager();
        for(String mapKey : Formation.formationMap.keySet()){
            for(TeachingUnit tu : Formation.formationMap.get(mapKey).getTeachingUnits()){
                tum.insert(tu);
            }
        }
    }

    public static void genFormations(){
        EntityManager<Formation, String> fm = new FormationManager();
        for(String mapKey : Formation.formationMap.keySet()){
            System.out.println(Formation.formationMap.get(mapKey));
            fm.insert(Formation.formationMap.get(mapKey));
        }
    }
}
