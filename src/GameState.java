public class GameState {
    public int gameState;
    public GameLogic gameLogic;
    public int firstTurn;
    public int turnNum;
    public String scene;
    public Player firstPlayer;

    public GameState(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        startGame();
    }

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
        firstPlayer = gameLogic.findFirstPlayer();
        firstTurn = turnNum;
        gameState = 0;
        setScene(gameState);
    }


    public void nextTurn() {
        if(turnNum == 4) {
            turnNum = 1;
        } else {
            turnNum++;
        }
    }

    public void endGame() {
        gameState = 1;
        setScene(gameState);
    }
}
