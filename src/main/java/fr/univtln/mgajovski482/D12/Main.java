package fr.univtln.mgajovski482.D12;

import fr.univtln.mgajovski.d12.FormationMain;
import fr.univtln.mgajovski482.d12.ActorsMain;

/**
 * Created by Maxime on 16/10/2015.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        EquipmentMain   .getInstance();
        ActorsMain      .getInstance();
        FormationMain   .getInstance();
        Gui             .getInstance();
    }
}