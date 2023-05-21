package entities;

import java.util.ArrayList;

public class Population {
    ArrayList<Table> tables = new ArrayList<Table>();
    double fitnessPool;


    public void evolve() {
        
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public Table getTable(int i) {
        return tables.get(i);
    }

    public void updatePool() {
        fitnessPool = 0;
        for(Table t : tables) {
            fitnessPool += t.getFitness();
        }
    }

    public Table getRandomTable() {
        return tables.get((int)(Math.random() * tables.size()));
    }

    public Table getTable() {
        double k = (Math.random() * fitnessPool);
        double sum = 0;
        for(Table t : tables) {
            sum += t.getFitness();
            if(sum >= k) {
                return t;
            }
        }
        System.out.println("Check");
        return tables.get(tables.size() - 1);
    }


}
