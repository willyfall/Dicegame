package com.william.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testRollSingleDie() {
        int result = GameUtils.rollSingleDie();
        assertTrue(result >= 1 && result <= 6);
    }
    @org.junit.Test
    public void testGetPlayerIndex() {
        String[] players = {"Benny", "Frida", "Kristoffer"};
        int i = GameUtils.getPlayerIndex(players, "Frida");
        assertEquals(1, i);
    }
    @org.junit.Test
    public void testPlayGameWithNoPlayers() {
        String[] players = {};
        int[] scores = {};
        assertDoesNotThrow(() -> GameUtils.playGame(0, 2, players, 3, scores));
    }


}