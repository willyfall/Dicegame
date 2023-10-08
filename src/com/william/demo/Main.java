package com.william.demo;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CustomScanner customScanner = new CustomScanner();
        int players;
        boolean overTwo = false;

        do {
            System.out.println("Enter how many Players");
            players = customScanner.nextInt();
            if (players >= 2) {
                overTwo = true;
            } else {
                System.out.println("There has to be at least 2 Players!");
            }
        } while (!overTwo);

        System.out.println("Enter how many dices each player get to roll");
        int dices = customScanner.nextInt();

        System.out.println("Enter how many rounds to play:");
        int rounds = customScanner.nextInt();

        String[] player = new String[players];
        int[] playerScores = new int[players];

        for (int i = 0; i < players; i++) {
            System.out.println("Player" + (i + 1) + "Enter name");
            player[i] = customScanner.next();
        }

        System.out.println("Lets play");

        GameUtils.playGame(players, dices, player,rounds, playerScores);
    }
}


