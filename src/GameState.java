public class GameState {
    private int gameState;
    private String scene;
    public void setScene(int state) {
        if(gameState = 0) {
            scene = "playScreen";
        } else if (gameState = 1) {
            scene = "endScreen";
        }
    }

    public String getScene() {
        return scene;
    }

    public void startGame() {

    }

    public void startTurn() {

    }

    public void nextTurn() {

    }

    public void endGame() {
        gameState = 1;
        setScene(gameState);
    }
}
