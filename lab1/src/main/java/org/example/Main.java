package org.example;

import org.example.modules.Mage;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String args1 = "sortowanie_zgodnie_z_alternatywnym_kryterium";
        Mage[] names = new Mage[10];
        if(args1.length() != 0){
            Mage smartest = null;
            Map<Mage,Integer>statistics=null;
            if(args1.equals("brak_sortowania")){
                smartest = new Mage("Wizard",100,68,false,false);
                for (int i = 0; i < 5; i++) {
                    names[i] = new Mage("mage"+i,i+i,i*i,false,false);
                    smartest.Add(names[i]);
                    Mage ice = new Mage("ice"+i,i+i,i*i,false,false);
                    names[i].Add(ice);
                }
                statistics= smartest.StatisticsGen(false);
            }

            if(args1.equals("sortowanie_zgodnie_z_naturalnym_porządkiem")){
                smartest = new Mage("Wizard",100,68,true,true);
                for (int i = 0; i < 5; i++) {
                    names[i] = new Mage("mage"+i,i+i,i*i,true,true);
                    smartest.Add(names[i]);
                    Mage ice = new Mage("ice"+i,i+i,i*i,true,true);
                    names[i].Add(ice);
                }
                statistics= smartest.StatisticsGen(true);
            }
            if(args1.equals("sortowanie_zgodnie_z_alternatywnym_kryterium")){
                smartest = new Mage("Wizard",100,68,true,false);
                for (int i = 0; i < 5; i++) {
                    names[i] = new Mage("mage"+i,i+i,i*i,true,false);
                    smartest.Add(names[i]);
                    Mage ice = new Mage("ice"+i,i+i,i*i,true,false);
                    names[i].Add(ice);
                }
                statistics= smartest.StatisticsGen(true);
            }
            smartest.Print(1);
            smartest.Print(statistics);
        }
    }
}