import java.util.ArrayList;

public class AvailableHousePlacement {
    public AvailableHousePlacement() {

    }
    public boolean canPlaceHouse(Player player, House house) {
        return player.getCanPlaceHouse();
    }
    public Boolean[][] housesToHighlight(Player player, String terrain, Board gameBoard) {
        Boolean[][] highlight = new Boolean[20][39];
        Tile[][] board = gameBoard.getBoard();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 39; j++){
                if(board[i][j].getLocation().equals(terrain)){
                    highlight[i][j] = true;
                }
            }
        }
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 39; j++){
                if(board[i][j].getHouse().getColor().equals(player.getColor())){

                }
            }
        }
        return null;
    }

}
