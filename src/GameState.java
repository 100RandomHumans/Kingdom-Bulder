public class GameState {
    private int gameState;
    private int firstTurn;
    private int turnNum;
    private String scene;
    private AvailableHousePlacement availableHouse;
    private ArrayList<Player> players;
    public void setScene(int state) {
        if(state == 0) {
            scene = "playScreen";
        } else if (state == 1) {
            scene = "endScreen";
        }
    }

    public String getScene() {
        return scene;
    }

    public void startGame() {
        GameLogic gameLogic = new GameLogic();
        firstPlayer = gameLogic.findFirstPlayer();
        String num = firstPlayer(firstPlayer.length() - 1);
        turnNum = Integer.parseInt(num);
        firstTurn = turnNum;
        gameState = 0;
        setScene(gameState);
    }

    public void startTurn() {
        Player currentPlayer = new Player();
        currentPlayer = players.get(turnNum - 1);
    }

    public void nextTurn() {
        if(turnNum == 4) {
            turnNum = 1;
        } else {
            turnNum++;
        }

        availableHouse = new AvailableHousePlacement();
        if(availableHouse.canPlaceHouse() == false) {
            while(turnNum != firstTurn) {
                if(turnNum == 4) {
                    turnNum = 1;
                } else {
                    turnNum++;
                }
            }
        }
    }

    public void endGame() {
        gameState = 1;
        setScene(gameState);
    }
}
