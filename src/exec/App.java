package exec;

import java.util.ArrayList;

import constraints.Collision;
import constraints.TimeBetween;
import constraints.TimeConstraint;
import entities.Population;
import entities.Team;

public class App {
    public static void main(String[] args) {
        Team t1 = new Team("Drita");
        Team t2 = new Team("Ballkani");
        Team t3 = new Team("Gjilani");
        Team t4 = new Team("Dukagjini");
        Team t5 = new Team("Prishtina");
        Team t6 = new Team("Malisheva");
        Team t7 = new Team("Llapi");
        Team t8 = new Team("Ferizaj");
        Team t9 = new Team("Trepqa 89");
        Team t10 = new Team("Drenica");
        ArrayList<Team> teams = new ArrayList<Team>();

        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t4);
        teams.add(t5);
        teams.add(t6);
        teams.add(t7);
        teams.add(t8);
        teams.add(t9);
        teams.add(t10);

        Population p = new Population(teams, 252);
        p.g.addHardConstraint(new Collision());
        p.g.addSoftConstraint(new TimeConstraint());
        p.g.addSoftConstraint(new TimeBetween());

        p.init();

        //System.out.println(p.tables);
        for(int i = 0; i < 5000; i++) {
            p.evolve(i);
        }

     System.out.println(p.getBestTable());
    }
}
