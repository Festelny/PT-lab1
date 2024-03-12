package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = 3;
        Arbeiter[] arbeiters = new Arbeiter[N];
        Thread[] threads = new Thread[N];

        SharedQueue taskQueue = new SharedQueue();
        CollectQueue collectQueue = new CollectQueue();

        for(int i=0;i<N;i++){
            arbeiters[i] = new Arbeiter(taskQueue,collectQueue);
            threads[i] = new Thread(arbeiters[i]);
            threads[i].start();
        }

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU" +
                    "\n[number] - add number to task queue" +
                    "\ns - show results" +
                    "\nq - show results and quit");
             String input = scanner.nextLine();
            if(input.equals("q")) {
                isRunning = false;
                System.out.println(collectQueue);
            }
            else if(input.equals("s")) {
                System.out.println(collectQueue);
            }
            else {
                int number = Integer.parseInt(input);
                taskQueue.addTask(number);
            }

        }

        for (Thread thread : threads) {
            thread.interrupt();
        }

        scanner.close();
    }

    }
