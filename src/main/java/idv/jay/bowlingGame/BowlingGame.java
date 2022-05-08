package idv.jay.bowlingGame;


public class BowlingGame {

    public static final String BLANK = " ";
    public static final String SPARE = "/";
    public static final String STRIKE = "X";

    private String[] scores = new String[12];
    private int score = 0;
    private int spareCnt;
    private int strikeCnt;

    public String outputScore() {

        String scoreArray = "";

        for (int i = 0; i < scores.length; i++) {
            if(i == scores.length -1)
                scoreArray += scores[i];
            else
                scoreArray += scores[i] + BLANK;

        }

        return scoreArray;
    }

    public void setScoreArray(String[] scores) {
        this.scores = scores;
    }

    public void sunTotalScore() {

        String scoreArray = this.outputScore();
        String turn = "";

        if(scoreArray.indexOf(SPARE) == -1 && scoreArray.indexOf(STRIKE) == -1) {
            for (int i = 0; i < this.scores.length; i++) {
                this.addGeneralScore(this.scores[i]);
            }
        }else {
            for (int i = 0; i < this.scores.length; i++) {
                turn = this.scores[i];
                if(turn.indexOf(SPARE) != -1 && i != this.scores.length -1) spareCnt++;
                else if(turn.indexOf(STRIKE) != -1 && i != this.scores.length -1) strikeCnt++;
                else {
                    if(strikeCnt == 11) {
                        this.score += 300;
                        return;
                    }

                    this.addSpareScore(turn);
                    this.addGeneralScore(turn);
                    this.addStrikeScore(turn);
                }
            }

        }

        if(strikeCnt == 3) {
            this.score += 50;
            return;
        }

        if (spareCnt != 0 || strikeCnt != 0) {
            this.addGeneralScore(turn);
            this.addSpareScore(turn);
            this.addStrikeScore(turn);
        }

    }


    public void addGeneralScore(String turn) {

        if(turn.indexOf(SPARE) >= 0 || turn.indexOf(STRIKE) >= 0) {
            this.score += 10;
            return;
        }

        for (int i = 0; i < turn.length(); i++) {
            Character c = turn.charAt(i);
            try {

                this.score += Integer.parseInt(c.toString());
            }catch (NumberFormatException e) {
                this.score += 0;
            }
        }
    }

    public void addSpareScore(String turn) {

        if(turn.indexOf(SPARE) >= 0 || turn.indexOf(STRIKE) >= 0) {
            this.score += (10 + 10) * spareCnt;
            spareCnt = 0;
            return;
        }

        int temp = 0;
        for (int i = 0; i < turn.length(); i++) {
            Character c = turn.charAt(i);
            try {
                temp += Integer.parseInt(c.toString());
                break;
            }catch (NumberFormatException e) {
                temp += 0;
            }
        }
        this.score += (10 + temp) * spareCnt;
        spareCnt = 0;
    }

    public void addStrikeScore(String turn) {

        if(turn.indexOf(SPARE) >= 0 || turn.indexOf(STRIKE) >= 0) {
            this.score += (10 + 10) * strikeCnt;
            strikeCnt = 0;
            return;
        }

        int temp = 0;
        for (int i = 0; i < turn.length(); i++) {
            Character c = turn.charAt(i);
            try {
                temp += Integer.parseInt(c.toString());
            }catch (NumberFormatException e) {
                this.score += 0;
            }
        }
        this.score += (10 + temp) * strikeCnt;
        strikeCnt = 0;
    }

    public int getScore() {
        return this.score;
    }
}
