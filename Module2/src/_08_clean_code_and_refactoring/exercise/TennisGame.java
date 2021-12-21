package _08_clean_code_and_refactoring.exercise;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String scoreResult = "";
        boolean isDeuce = player1Score == player2Score;
        if (isDeuce) {
            if (player1Score < FORTY) {
                scoreResult = checkScore(player1Score) + "-All";
            } else {
                scoreResult = checkScore(player1Score);
            }
        } else if (player1Score >= FORTY || player2Score >= FORTY) {
            int minusResult = player1Score - player2Score;
            scoreResult = checkWinnerOrAdvantage(minusResult);
        } else {
            scoreResult = checkScore(player1Score) + "-" + checkScore(player2Score);
        }
        return scoreResult;
    }

    private static String checkWinnerOrAdvantage(int minusResult) {
        String scoreResult;
        if (minusResult == 1) scoreResult = "Advantage player1";
        else if (minusResult == -1) scoreResult = "Advantage player2";
        else if (minusResult >= 2) scoreResult = "Win for player1";
        else scoreResult = "Win for player2";
        return scoreResult;
    }

    private static String checkScore(int player1Score) {
        String scoreResult;
        switch (player1Score) {
            case LOVE:
                scoreResult = "Love";
                break;
            case FIFTEEN:
                scoreResult = "Fifteen";
                break;
            case THIRTY:
                scoreResult = "Thirty";
                break;
            case FORTY:
                scoreResult = "Forty";
                break;
            default:
                scoreResult = "Deuce";
                break;
        }
        return scoreResult;
    }
}
