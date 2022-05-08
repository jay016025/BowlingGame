package idv.jay.bowlingGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBowlingGame {

    private BowlingGame game = new BowlingGame();

    @Test
    public void testOutputScoreArray() {
        String[] scores = new String[] {"--", "19", "5/", "X", "54", "63", "72", "11", "9-", "X/2"};
        game.setScoreArray(scores);

        String expected = "-- 19 5/ X 54 63 72 11 9- X/2";
        Assertions.assertEquals(expected, game.outputScore());
    }

    @Test
    public void testZero() {
        game.setScoreArray(new String[] {"--", "--", "--", "--", "--", "--", "--", "--", "--", "--"});
        game.sunTotalScore();

        int expected = 0;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testOneGet() {
        game.setScoreArray(new String[] {"9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-"});
        game.sunTotalScore();

        int expected = 90;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testNonSpareAndStrike() {
        game.setScoreArray(new String[] {"-2", "--", "34", "71", "9-", "63", "54", "3-", "18", "1-"});
        game.sunTotalScore();

        int expected = 57;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testHasSpare() {
        game.setScoreArray(new String[] {"22", "34", "5/", "4/", "23", "54", "3/", "61", "22", "33"});
        game.sunTotalScore();

        int expected = 82;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testHasStrike() {
        game.setScoreArray(new String[]{"22", "34", "X", "X", "23", "54", "X", "61", "22", "33"});
        game.sunTotalScore();

        int expected = 89;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testHasSpareAndStrike() {
        game.setScoreArray(new String[]{"22", "34", "X", "5/", "23", "54", "X", "61", "22", "33"});
        game.sunTotalScore();

        int expected = 86;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testHasSpareInLastTurn() {
        game.setScoreArray(new String[]{"22", "34", "X", "5/", "23", "54", "X", "61", "22", "3/", "7"});
        game.sunTotalScore();

        int expected = 104;
        Assertions.assertEquals(expected, game.getScore());

    }

    @Test
    public void testHasStrikeInLastTurn() {
        game.setScoreArray(new String[]{"22", "34", "X", "5/", "23", "54", "X", "61", "22", "X", "72"});
        game.sunTotalScore();

        int expected = 108;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testSpareInLastTurnAndStrike() {
        game.setScoreArray(new String[]{"22", "34", "X", "5/", "23", "54", "X", "61", "22", "3/", "X"});
        game.sunTotalScore();

        int expected = 110;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testStrikeInLastTurnAndStrike() {
        game.setScoreArray(new String[]{"22", "34", "X", "5/", "23", "54", "X", "61", "22", "X", "X", "X"});
        game.sunTotalScore();

        int expected = 130;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testStrikeInLastTurnAndSpare() {
        game.setScoreArray(new String[]{"22", "34", "X", "5/", "23", "54", "X", "61", "22", "X", "3/"});
        game.sunTotalScore();

        int expected = 110;
        Assertions.assertEquals(expected, game.getScore());
    }

    @Test
    public void testAllStrike() {
        game.setScoreArray(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"});
        game.sunTotalScore();

        int expected = 300;
        Assertions.assertEquals(expected, game.getScore());
    }
}
