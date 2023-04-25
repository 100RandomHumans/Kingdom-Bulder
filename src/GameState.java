public class GameState {
    public int gameState;
    public GameLogic gameLogic;
    public int firstTurn;
    public int turnNum;
    public String scene;
    public Player firstPlayer;
    public Player currentPlayer;
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
        currentPlayer = firstPlayer;
        gameState = 0;
        setScene(gameState);
        setTurnNum(gameLogic.players.indexOf(firstPlayer));
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

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public int getFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(int firstTurn) {
        this.firstTurn = firstTurn;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
