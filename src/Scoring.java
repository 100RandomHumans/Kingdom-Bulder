public class Scoring {
    private String[] scoringCards = new String[4];
    public Scoring() {
        GameLogic obj = new GameLogic();
        scoringCards[0] = obj.getCardOne();
        scoringCards[1] = obj.getCardTwo();
        scoringCards[2] = obj.getCardThree();
    }
    public int getScore() {
        int score = 0;
        for(String a: scoringCards) {
            if (a.equals("Discoverer")) {

            }
            if (a.equals("Citizen")) {

            }
            if (a.equals("Worker")) {
            }
        }
        return score;
    }
}
