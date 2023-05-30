package exec;

import java.util.ArrayList;

import constraints.Collision;
import constraints.SameDayConstraint;
import constraints.TimeBetween;
import constraints.TimeConstraint;
import entities.Match;
import entities.Population;
import entities.Table;
import entities.Team;

public class App {
    public static void main(String[] args) {
        Team t1 = new Team("LFC");
        Team t2 = new Team("RMA");
        Team t3 = new Team("MUN");
        ArrayList<Team> teams = new ArrayList<Team>();

        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);

        Table table = new Table(teams);

        
        Population p = new Population();
        p.g.addHardConstraint(new Collision());
        p.g.addSoftConstraint(new TimeConstraint());
        p.g.addSoftConstraint(new TimeBetween());
        p.g.addHardConstraint(new SameDayConstraint());

        table.generateMatches(p.g);
        //TODO keep best table across iterations
        
        p.addTable(table);
        p.addTable(table);
        //System.out.println(p.tables);
        for(int i = 0; i < 200000; i++) {
            p.evolve();
        }
        System.out.println(p);
    }
}
