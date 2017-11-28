package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (m_score1 == m_score2) {
            score = equalPoints(score);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = winningPlayer(score);
        } else {
            score = currentGameStatus(score);
        }
        return score;
    }

    public String equalPoints(String score) {
        score = getResult(score, m_score1);
        if (!score.equals("Deuce")) {
            score += "-All";
        }
        return score;
    }

    public String winningPlayer(String score) {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    public String currentGameStatus(String score) {

        score += getResult(score, m_score1);
        score += "-";
        score += getResult(score, m_score2);

        return score;
    }

    public String getResult(String score, int playerScore) {
        switch (playerScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
