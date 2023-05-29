package exec;

import java.util.ArrayList;

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

        Match[] matches =  {
            new Match(0, 0, t1, t2),
            new Match(0, 0, t1, t3),
            new Match(0, 0, t2, t3),
        };

        Table table = new Table(matches, teams);

        Population p = new Population();
        p.addTable(table);
        p.addTable(table);
        //System.out.println(p.tables);
        //p.evolve();

        System.out.println(table);

        p.g.mutate(table);
        
        System.out.println("\n"+table);
    }

}
