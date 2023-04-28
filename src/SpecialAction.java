public class SpecialAction {
    public Boolean[][] specialHighlight(Player player, String terrainCard, Board gameBoard, String SpecialAction) {
        Boolean[][] highlight = new Boolean[20][30];
        Tile[][] board = gameBoard.getBoard();
        int housesLeft = player.getHouseCount();
        Tile[][] temp = new Tile[22][32];
        int counter = 0;

        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                temp[i][j]  = new Tile("", "");
            }
        }
        for(int i = 1; i <= 20; i++){
            for(int j = 1; j <= 30; j++){
                temp[i][j] = board[i-1][j-1];
            }
        }
        for(int i = 0; i < highlight.length; i++){
            for(int j = 0; j < highlight[0].length; j++){
                if(board[i][j].hasHouse){
                    highlight[i][j] = false;
                }
            }
        }


        if (SpecialAction.equals("Oracle")) {
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 30; j++) {
                    if (temp[i][j].hasHouse && temp[i][j].houseColor.equals(player.getColor())) { // find all player houses on board
                        // if the 6 tiles around it is of the correct terrain, set that tile to true on highlight
                        if (temp[i][j - 1].getTerrain().equals(terrainCard) && !temp[i][j - 1].hasHouse) {
                            highlight[i - 1][j - 2] = true;
                            counter++;
                        }
                        if (temp[i - 1][j - 1].getTerrain().equals(terrainCard) && !temp[i - 1][j - 1].hasHouse) {
                            highlight[i - 2][j - 2] = true;
                            counter++;
                        }
                        if (temp[i - 1][j].getTerrain().equals(terrainCard) && !temp[i - 1][j].hasHouse) {
                            highlight[i - 2][j - 1] = true;
                            counter++;
                        }
                        if (temp[i + 1][j].getTerrain().equals(terrainCard) && !temp[i + 1][j].hasHouse) {
                            highlight[i][j - 1] = true;
                            counter++;
                        }
                        if (temp[i][j + 1].getTerrain().equals(terrainCard) && !temp[i][j + 1].hasHouse) {
                            highlight[i - 1][j] = true;
                            counter++;
                        }
                        if (temp[i + 1][j + 1].getTerrain().equals(terrainCard) && !temp[i + 1][j + 1].hasHouse) {
                            highlight[i][j] = true;
                            counter++;
                        }
                    }
                }
            }
            for (int i = 0; i < highlight.length; i++) {
                for (int j = 0; j < highlight[0].length; j++) {
                    if (board[i][j].hasHouse) {
                        highlight[i][j] = false;
                    }
                }
            }
            //if the no tile around any house is of the terrain of the player
            if (counter == 0) {
                for (int i = 0; i <= 19; i++) {
                    for (int j = 0; j <= 29; j++) {
                        if (board[i][j].getTerrain().equals(terrainCard)) {
                            highlight[i][j] = true;
                        }
                    }
                }
                return highlight;
            }
            else {
                return highlight;
            }
        }


        else if(SpecialAction.equals("Farm")){
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 30; j++) {
                    if (temp[i][j].hasHouse && temp[i][j].houseColor.equals(player.getColor())) { // find all player houses on board
                        // if the 6 tiles around it is of the correct terrain, set that tile to true on highlight
                        if (temp[i][j - 1].getTerrain().equals("Grass") && !temp[i][j - 1].hasHouse) {
                            highlight[i - 1][j - 2] = true;
                            counter++;
                        }
                        if (temp[i - 1][j - 1].getTerrain().equals("Grass") && !temp[i - 1][j - 1].hasHouse) {
                            highlight[i - 2][j - 2] = true;
                            counter++;
                        }
                        if (temp[i - 1][j].getTerrain().equals("Grass") && !temp[i - 1][j].hasHouse) {
                            highlight[i - 2][j - 1] = true;
                            counter++;
                        }
                        if (temp[i + 1][j].getTerrain().equals("Grass") && !temp[i + 1][j].hasHouse) {
                            highlight[i][j - 1] = true;
                            counter++;
                        }
                        if (temp[i][j + 1].getTerrain().equals("Grass") && !temp[i][j + 1].hasHouse) {
                            highlight[i - 1][j] = true;
                            counter++;
                        }
                        if (temp[i + 1][j + 1].getTerrain().equals("Grass") && !temp[i + 1][j + 1].hasHouse) {
                            highlight[i][j] = true;
                            counter++;
                        }
                    }
                }
            }
            for (int i = 0; i < highlight.length; i++) {
                for (int j = 0; j < highlight[0].length; j++) {
                    if (board[i][j].hasHouse) {
                        highlight[i][j] = false;
                    }
                }
            }
            //if the no tile around any house is of the terrain of the player
            if (counter == 0) {
                for (int i = 0; i <= 19; i++) {
                    for (int j = 0; j <= 29; j++) {
                        if (board[i][j].getTerrain().equals("Grass")) {
                            highlight[i][j] = true;
                        }
                    }
                }
                return highlight;
            }
            else {
                return highlight;
            }
        }


        else if(SpecialAction.equals("Tavern")){

        }


        else if(SpecialAction.equals("Harbor")){

        }


        return highlight;
    }
}
