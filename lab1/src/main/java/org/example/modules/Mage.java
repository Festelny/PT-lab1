package org.example.modules;

import java.util.*;

public class Mage implements Comparable {
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getPower() {
        return power;
    }

    public Mage(String name, int level, double power, boolean sort, boolean type) {
        this.name = name;
        this.level = level;
        this.power = power;
        if(sort){
            if(type){ //1 dla nturalnego/ 0 dla alternatywnego
                this.apprentices = new TreeSet<>();
            }
            else {
                this.apprentices = new TreeSet<>(new AltComparator());
            }
        }
        else{
            this.apprentices = new HashSet<>();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mage other = (Mage) o;
        return Objects.equals(name,other.name) && (this.level == other.level) && Double.compare(power,other.power) == 0 && Objects.equals(apprentices, other.apprentices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, power, apprentices);
    }

    @Override
    public int compareTo(Object o) {

        if (o == null){
            throw new NullPointerException("Objekt nie istnieje");
        }
        if (o.getClass() != Mage.class){
            throw new ClassCastException("Objekt jest zlej klasy");
        }

        Mage other = (Mage)o;

        if(this.name.compareTo(other.name) != 0) {
            return this.name.compareTo(other.name);
        }
        if(this.level != other.level){
            return Integer.compare(this.level,other.level);
        }
        return Double.compare(this.power,other.power);
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", power=" + power +
                '}';
    }

    public void Print(int lvl){
        for (int i = 0; i < lvl; i++) {
            System.out.print("-");
        }
        System.out.println(this.toString());
        for (Mage lower : this.apprentices){
            lower.Print(lvl+1);
        }
    }

    public void Print(Map<Mage, Integer> statistic){
        System.out.println(this.toString()+"st="+statistic.get(this));
        for (Mage lower : this.apprentices){
            System.out.println(lower.toString()+"st="+statistic.get(lower));
        }
    }
    public void Add(Mage mage){
        this.apprentices.add(mage);
    }

    public Map<Mage, Integer> StatisticsGen(boolean sortype){
        Map<Mage,Integer> statistics=null;
        if(sortype){
            statistics = new TreeMap<>();
        } else {
            statistics = new HashMap<>();
        }
        decCount(this,statistics);
        return statistics;
    }

    public int decCount(Mage mage,Map<Mage, Integer> statistic){
        int deepth=0;
        for(Mage lower : mage.apprentices){
            deepth +=1+decCount(lower, statistic);
        }
        statistic.put(mage,deepth);
        return deepth;
    }

}