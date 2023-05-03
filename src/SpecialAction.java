public class SpecialAction {
    public boolean[][] specialHighlight(Player player, String terrainCard, Board gameBoard, String SpecialAction) {
        boolean[][] highlight = new boolean[20][30];
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
                //System.out.println(3);
                for (int j = 1; j <= 30; j++) {
                    if (temp[i][j].hasHouse && temp[i][j].houseColor.equals(player.getColor())) { // find all player houses on board
                        //System.out.println(4);
                        // if the 6 tiles around it is of the correct terrain, set that tile to true on highlight
                        if(temp[i][j-1].getTerrain().equals(terrainCard) && !temp[i][j-1].hasHouse){
                            highlight[i-1][j-2] = true;
                            counter++;
                        }
                        if(temp[i-1][j-1].getTerrain().equals(terrainCard) && !temp[i-1][j-1].hasHouse){
                            highlight[i-2][j-2] = true;
                            counter++;
                        }
                        if(temp[i-1][j].getTerrain().equals(terrainCard) && !temp[i-1][j].hasHouse){
                            highlight[i-2][j-1] = true;
                            counter++;
                        }
                        if(temp[i+1][j].getTerrain().equals(terrainCard) && !temp[i+1][j].hasHouse){
                            highlight[i][j-1] = true;
                            counter++;
                        }
                        if(temp[i][j+1].getTerrain().equals(terrainCard) && !temp[i][j+1].hasHouse){
                            highlight[i-1][j] = true;
                            counter++;
                        }
                        if(temp[i+1][j+1].getTerrain().equals(terrainCard) && !temp[i+1][j+1].hasHouse){
                            highlight[i][j] = true;
                            counter++;
                        }
                    }
                }
            }
            for(int i = 0; i < highlight.length; i++){
                for(int j = 0; j < highlight[0].length; j++){
                    if(board[i][j].hasHouse){
                        highlight[i][j] = false;
                    }
                }
            }
            //if the no tile around any house is of the terrain of the player
            if(counter == 0){
                //System.out.println(2);
                for (int i = 0; i <= 19; i++) {
                    for (int j = 0; j <= 29; j++) {
                        if (board[i][j].getTerrain().equals(terrainCard)) {
                            highlight[i][j] = true;
                        }
                    }
                }
                for(int i = 0; i < highlight.length; i++){
                    for(int j = 0; j < highlight[0].length; j++){
                        if(board[i][j].hasHouse){
                            highlight[i][j] = false;
                        }
                    }
                }
                return highlight;

            }
            else {
                return highlight;
            }
        }


        else if(SpecialAction.equals("Paddock")){
            for(int i = 0; i < highlight.length; i++) {
                for (int j = 0; j < highlight[0].length; j++) {
                    if (board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())) {
                        highlight[i][j] = true;
                    }
                }
            }
            return highlight;
        }


        else if(SpecialAction.equals("Harbor")){
            for(int i = 0; i < highlight.length; i++){
                for(int j = 0; j < highlight[0].length; j++){
                    if(board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())){
                        highlight[i][j] = true;
                    }
                }
            }
            return highlight;
        }


        else if(SpecialAction.equals("Tower")){
            int cnt = 0;
            int i = 0;
            for(int j = 0; j <= 19; j++){
                //left tile
                if(j != 0 && board[i][j-1].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
                //right tile
                if(j != 19 && !board[i][j+1].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
                //tile below
                if(i != 19 && !board[i+1][j].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
                //tile lower right
                if(i != 19 && j != 19 && !board[i+1][j+1].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
            }

            i = 19;
            for(int j = 10; j <= 29; j++){
                //left tile
                if(j != 0 && !board[i][j-1].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
                //right tile
                if(j != 29 && !board[i][j+1].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
                //tile above
                if(i != 0  && !board[i-1][j].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
                //tile upper left
                if(i != 0 && j != 0 && !board[i-1][j-1].hasHouse && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    highlight[i][j] = true;
                    cnt++;
                }
            }

            int b = 0;
            for(int a = 0; a <= 19; a++){
                //left tile
                if(b != 0 && board[a][b-1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //right tile
                if(b != 29 && !board[a][b+1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile above
                if(a != 0  && !board[a-1][b].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile below
                if(a != 19 && !board[a+1][b].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile upper left
                if(a != 0 && b != 0 && !board[a-1][b-1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile lower right
                if(a != 19 && b != 29 && !board[a+1][b+1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                if(a%2 == 0){
                    b++;
                }
            }

            b = 19;
            for(int a = 0; a <= 19; a++){
                //left tile
                if(b != 0 && board[a][b-1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //right tile
                if(b != 29 && !board[a][b+1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile above
                if(a != 0  && !board[a-1][b].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile below
                if(a != 19 && !board[a+1][b].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile upper left
                if(a != 0 && b != 0 && !board[a-1][b-1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                //tile lower right
                if(a != 19 && b != 29 && !board[a+1][b+1].hasHouse && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    highlight[a][b] = true;
                    cnt++;
                }
                if(a%2 == 0){
                    b++;
                }
            }

            for(int n = 0; n < highlight.length; n++){
                for(int m = 0; m < highlight[0].length; m++){
                    if(board[n][m].hasHouse){
                        highlight[n][m] = false;
                    }
                }
            }
            return highlight;
        }


        return highlight;
    }

    public boolean[][] harbor(Player player, Board gameBoard) {
        boolean[][] highlight = new boolean[20][30];
        Tile[][] board = gameBoard.getBoard();
        Tile[][] temp = new Tile[22][32];
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
        int counter = 0;
        for (int i = 1; i <= 20; i++) {
            //System.out.println(3);
            for (int j = 1; j <= 30; j++) {
                if (temp[i][j].hasHouse && temp[i][j].houseColor.equals(player.getColor())) { // find all player houses on board
                    //System.out.println(4);
                    // if the 6 tiles around it is of the correct terrain, set that tile to true on highlight
                    if(temp[i][j-1].getTerrain().equals("Water") && !temp[i][j-1].hasHouse){
                        highlight[i-1][j-2] = true;
                        counter++;
                    }
                    if(temp[i-1][j-1].getTerrain().equals("Water") && !temp[i-1][j-1].hasHouse){
                        highlight[i-2][j-2] = true;
                        counter++;
                    }
                    if(temp[i-1][j].getTerrain().equals("Water") && !temp[i-1][j].hasHouse){
                        highlight[i-2][j-1] = true;
                        counter++;
                    }
                    if(temp[i+1][j].getTerrain().equals("Water") && !temp[i+1][j].hasHouse){
                        highlight[i][j-1] = true;
                        counter++;
                    }
                    if(temp[i][j+1].getTerrain().equals("Water") && !temp[i][j+1].hasHouse){
                        highlight[i-1][j] = true;
                        counter++;
                    }
                    if(temp[i+1][j+1].getTerrain().equals("Water") && !temp[i+1][j+1].hasHouse){
                        highlight[i][j] = true;
                        counter++;
                    }
                }
            }
        }
        for(int i = 0; i < highlight.length; i++){
            for(int j = 0; j < highlight[0].length; j++){
                if(board[i][j].hasHouse){
                    highlight[i][j] = false;
                }
            }
        }
        //if the no tile around any house is of the terrain of the player
        if(counter == 0){
            //System.out.println(2);
            for (int i = 0; i <= 19; i++) {
                for (int j = 0; j <= 29; j++) {
                    if (board[i][j].getTerrain().equals("Water")) {
                        highlight[i][j] = true;
                    }
                }
            }
            for(int i = 0; i < highlight.length; i++){
                for(int j = 0; j < highlight[0].length; j++){
                    if(board[i][j].hasHouse){
                        highlight[i][j] = false;
                    }
                }
            }
            return highlight;

        }
        else {
            return highlight;
        }

    }

    public boolean[][] paddock(Player player, Board gameBoard, int p, int v){
        boolean[][] highlight = new boolean[20][30];
        Tile[][] board = gameBoard.getBoard();
        //left 2 tile
        if(p >= 2 && !board[p-2][v].hasHouse && !board[p-2][v].getTerrain().equals("Mountain") && !board[p-2][v].getTerrain().equals("Water") && !(board[p-2][v].getLocation().length()>0)){
            highlight[p-2][v] = true;
        }
        //right 2 tile
        if(p <= 27 && !board[p+2][v].hasHouse && !board[p+2][v].getTerrain().equals("Mountain") && !board[p+2][v].getTerrain().equals("Water") && !(board[p+2][v].getLocation().length()>0)){
            highlight[p+2][v] = true;
        }
        //up right 2 tile
        if(v >= 2 && !board[p][v-2].hasHouse && !board[p][v-2].getTerrain().equals("Mountain") && !board[p][v-2].getTerrain().equals("Water") && !(board[p][v-2].getLocation().length()>0)){
            highlight[p][v-2] = true;
        }
        //down left 2 tile
        if(v <= 17 && !board[p][v+2].hasHouse && !board[p][v+2].getTerrain().equals("Mountain") && !board[p][v+2].getTerrain().equals("Water") && !(board[p][v+2].getLocation().length()>0)){
            highlight[p][v+2] = true;
        }
        //up left 2 tile
        if(p >= 2 && v >= 2 && !board[p-2][v-2].hasHouse && !board[p-2][v-2].getTerrain().equals("Mountain") && !board[p-2][v-2].getTerrain().equals("Water") && !(board[p-2][v-2].getLocation().length()>0)){
            highlight[p-2][v-2] = true;
        }
        //down right 2 tile
        if(p <= 27 && v <= 17 && !board[p+2][p+2].hasHouse && !board[p+2][p+2].getTerrain().equals("Mountain") && !board[p+2][p+2].getTerrain().equals("Water") && !(board[p+2][p+2].getLocation().length()>0)){
            highlight[p+2][p+2] = true;
        }

        for(int i = 0; i < highlight.length; i++){
            for(int j = 0; j < highlight[0].length; j++){
                if(board[i][j].hasHouse){
                    highlight[i][j] = false;
                }
            }
        }
        return highlight;
    }
}
