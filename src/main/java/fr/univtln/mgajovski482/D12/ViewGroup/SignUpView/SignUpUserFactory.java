package fr.univtln.mgajovski482.D12.ViewGroup.SignUpView;

import fr.univtln.mgajovski482.d12.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RUConnectionLogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RULogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RUPersonalLogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.Student;

/**
 * Created by Maxime on 17/10/2015.
 */
public class SignUpUserFactory {

    public static void createRegisteredUser(RUPersonalLogs ruPersonalLogs,
                                            RUConnectionLogs ruConnectionLogs){

        RUPersonalLogs.Status   currentStatus = ruPersonalLogs.getStatus();
        RUPersonalLogs.Status[] stati = RUPersonalLogs.Status.values();
        AbstractRegUser abstractRegUser = new Student(new RULogs(ruPersonalLogs, ruConnectionLogs));
        System.out.println(AbstractRegUser.getStaticRegUsersMap().size());

        System.out.println(AbstractRegUser.getStaticRegUsersMap().values());
        AbstractRegUser b = AbstractRegUser.getStaticRegUsersMap().get("aaa@gmail.com");
        System.out.println(b);

    }

}
