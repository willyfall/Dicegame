package com.william.demo;

import java.util.ArrayList;
import java.util.Random;

public class GameUtils {
    public static int getPlayerIndex(String[] player, String playerName) {
        for (int i = 0; i < player.length; i++) {
            if (player[i].equals(playerName)) {
                return i;
            }
        }
        return -1;
    }
    public static int rollSingleDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void playGame(int players, int dices, String[] player,int rounds, int[] playerScores) throws InterruptedException {
        int highestScore = 0;
        ArrayList<String> playersWithHighestScore = new ArrayList<>();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round);

            for (int i = 0; i < players; i++) {
                for (int j = 0; j < dices; j++) {
                    System.out.print(player[i] + " rolled: ");
                    int die = GameUtils.rollSingleDie();
                    System.out.print(die);
                    playerScores[i] += die;
                    System.out.println();
                }
                System.out.println(player[i] + " " + playerScores[i]);

                if (playerScores[i] > highestScore) {
                    highestScore = playerScores[i];
                    playersWithHighestScore.clear();
                    playersWithHighestScore.add(player[i]);
                } else if (playerScores[i] == highestScore) {
                    playersWithHighestScore.add(player[i]);
                }
                Thread.sleep(2500);
            }
        }
        if (playersWithHighestScore.size() == 1) {
            System.out.print(playersWithHighestScore.get(0));
        } else {
            System.out.println("It's a tie between ");
            for (String playerName : playersWithHighestScore) {
                System.out.print(playerName + " ");
            }
        }
        System.out.println(" with the highest score of: " + highestScore);

        if (playersWithHighestScore.size() > 1) {
            System.out.println("Tiebreaker round!");
            System.out.println("One dice each and the highest score wins!");

            int highestTiebreakerScore = 0;
            ArrayList<String> tiebreakerWinners = new ArrayList();

            for (String playerName : playersWithHighestScore) {
                int playerIndex = GameUtils.getPlayerIndex(player, playerName);

                int score = GameUtils.rollSingleDie();
                System.out.println(playerName + " rolled: " + score);
                playerScores[playerIndex] += score;

                if (score > highestTiebreakerScore) {
                    highestTiebreakerScore = score;
                    tiebreakerWinners.clear();
                    tiebreakerWinners.add(playerName);
                } else if (score == highestTiebreakerScore) {
                    tiebreakerWinners.add(playerName);
                }
                Thread.sleep(2500);
            }

            if (tiebreakerWinners.size() == 1) {
                System.out.println("The winner of the tiebreaker is: " + tiebreakerWinners.get(0));
            } else {
                System.out.println("It's still a tie in the tiebreaker!");
            }
        }
    }
}
