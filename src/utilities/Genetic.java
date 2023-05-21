package utilities;

import entities.Match;
import entities.Table;

public class Genetic {
    public static Table crossOver(Table table) {
        return null;
    }

    public static Table mutate(Table table) {

        return null;
    }

    public static Table evaluate(Table table) {
        return null;
    }

    public static Match mutateMatch(Match m) {
        Match match = m.clone();
        match.setStartTime(
            ((match.getStartTime() + (int)(Math.random() * 1440)) % 1440)
        );

        return match;
    }    
}






