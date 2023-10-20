package ss8_clean_code.exec;

public class TennisGame {
    private static final int INITIAL_SCORE = 0;
    private static final int FIRST_SCORE = 1;
    private static final int SECOND_SCORE = 2;
    private static final int THIRD_SCORE = 3;
    public static final String INITIAL_SCORE_DISPLAY = "Love";
    public static final String FIRST_SCORE_DISPLAY = "Fifteen";
    public static final String SECOND_SCORE_DISPLAY = "Thirty";
    public static final String THIRD_SCORE_DISPLAY = "Forty";
    public static final String EQUAL_SCORE_DISPLAY = "All";
    public static final String DEUCE = "Deuce";


    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score = "";
        if (scorePlayer1 == scorePlayer2) {
            score = getEqualScore(scorePlayer1);
        } else if (scorePlayer1 > THIRD_SCORE || scorePlayer2 > THIRD_SCORE) {
            score = getWinCases(player1Name, player2Name, scorePlayer1, scorePlayer2);
        } else {
            score = getNotEqualScores(scorePlayer1, scorePlayer2, score);
        }
        return score;
    }

    public static String getNotEqualScores(int scorePlayer1, int scorePlayer2, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                score += "-";
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case INITIAL_SCORE:
                    score += INITIAL_SCORE_DISPLAY;
                    break;
                case FIRST_SCORE:
                    score += FIRST_SCORE_DISPLAY;
                    break;
                case SECOND_SCORE:
                    score += SECOND_SCORE_DISPLAY;
                    break;
                case THIRD_SCORE:
                    score += THIRD_SCORE_DISPLAY;
                    break;
            }
        }
        return score;
    }

    public static String getEqualScore(int scorePlayer1) {
        return switch (scorePlayer1) {
            case INITIAL_SCORE -> INITIAL_SCORE_DISPLAY + "-" + EQUAL_SCORE_DISPLAY;
            case FIRST_SCORE -> FIRST_SCORE_DISPLAY + "-" + EQUAL_SCORE_DISPLAY;
            case SECOND_SCORE -> SECOND_SCORE_DISPLAY + "-" + EQUAL_SCORE_DISPLAY;
            case THIRD_SCORE -> THIRD_SCORE_DISPLAY + "-" + EQUAL_SCORE_DISPLAY;
            default -> DEUCE;
        };
    }

    public static String getWinCases(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = "Advantage " + player1Name;
        else if (minusResult == -1) score = "Advantage " + player2Name;
        else if (minusResult >= 2) score = "Win for " + player1Name;
        else score = "Win for " + player2Name;
        return score;
    }

    public static void main(String[] args) {
        System.out.println(getScore("LeVanDO", "NguyenTrongHai", 5, 5));
    }
}
