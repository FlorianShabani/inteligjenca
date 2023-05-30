package entities;

import java.util.ArrayList;

import utilities.Genetic;

public class Population {
    public ArrayList<Table> tables = new ArrayList<Table>();
    double fitnessPool;
    public Genetic g;

    public static int days = 100;

    public Population() {
        g = new Genetic(days);
        fitnessPool = 0;
        for(Table t : tables) {
            t.fitness = 0;
            g.evaluate(t);
            fitnessPool += t.getFitness();
        }
    }

    public void evolve() {
        ArrayList<Table> newGen = new ArrayList<Table>();
        for(int i = 0; i < tables.size(); i++) {
            Table t1 = getTable();
            Table t2 = getTable();
            
            //crossOver
            Table t = g.crossOver(t1, t2);

            //mutate
            g.mutate(t);
            //evaluate
            g.evaluate(t);

            newGen.add(t);
        }
        //System.out.println(newGen);
        tables = newGen;
        updatePool();
        System.out.println(fitnessPool);
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
                //System.out.println(t);
                return t;
            }
        }
        return tables.get(tables.size() - 1);
    }

    @Override
    public String toString() {
        return "Population [tables=" + tables + "\n, fitnessPool=" + fitnessPool + "]";
    }


}
