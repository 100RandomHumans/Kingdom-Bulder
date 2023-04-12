public class GameState {
    private int gameState;
    private String scene;
    private AvailableHousePlacement availableHouse;
    public void setScene(int state) {
        if(state = 0) {
            scene = "playScreen";
        } else if (state = 1) {
            scene = "endScreen";
        }
    }

    public String getScene() {
        return scene;
    }

    public void startGame() {
        gameState = 0;
        setScene(gameState);
    }

    public void startTurn() {

    }

    public void nextTurn() {
        availableHouse = new AvailableHousePlacement();
        if(availableHouse.canPlaceHouse() == false) {

        }
    }

    public void endGame() {
        gameState = 1;
        setScene(gameState);
    }
}
