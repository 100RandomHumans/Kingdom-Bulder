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
        int housesLeft = player.getHouseCount();

        // if the player still has all houses, return all locations
        if(housesLeft == 30) {
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < i+20; j++) {
                    if (board[i][j].getLocation().equals(terrain)) {
                        highlight[i][j] = true;
                    }
                }
            }
            return highlight;
        }

        // if the player has placed houses, look for all houses, scan the tiles around for terrain equal to terrainCard
        if(housesLeft != 30 && housesLeft >= 0) {
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < i + 20; j++) {
                    if (board[i][j].getHouse().getColor().equals(player.getColor())) { // find all player houses on board
                        // if the 6 tiles around it is of the correct terrain, set that tile to true on gameboard

                    }
                }
            }
            return highlight;
        }



        return null;
    }





}
