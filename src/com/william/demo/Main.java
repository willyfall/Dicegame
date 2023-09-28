package com.william.demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int players;
        boolean overTwo=false;

        do {
            System.out.println("Enter how many Players");
            players = input.nextInt();
            if (players>=2){
                overTwo=true;
            } else {
                System.out.println("There has to be at least 2 Players!");
            }
        }while (!overTwo);

        System.out.println("Enter how many dices each player get to roll");
        int dices = input.nextInt();

        String[] player = new String[players];
        int[] playerScores = new int[players];

        for (int i=0; i<players;i++){
            System.out.println("Player"+(i+1)+"Enter name");
            player[i] = input.next();
        }

        System.out.println("Lets play");

        int highestScore = 0;
        ArrayList<String> playersWithHighestScore = new ArrayList<>();

        for (int i=0; i<players;i++){

            for (int j=0;j<dices;j++) {

                Random random = new Random();
                System.out.print(player[i] + " rolled: ");
                int die = random.nextInt(6) + 1;
                System.out.print(die);
                playerScores[i] += die;
                System.out.println();
            }
            System.out.println((player[i])+(" ")+(playerScores[i]));

            if (playerScores[i] > highestScore) {
                highestScore = playerScores[i];
                playersWithHighestScore.clear();
                playersWithHighestScore.add(player[i]);
            }else if (playerScores[i] == highestScore){
                playersWithHighestScore.add(player[i]);

                }


        }
        if (playersWithHighestScore.size() == 1){
            System.out.print(playersWithHighestScore.get(0));
        } else {
        for (String playerName : playersWithHighestScore) {
            System.out.print(playerName + " ");
        }
        }
        System.out.println(" has the highest score of: "+highestScore);
    }
}
