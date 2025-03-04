public class SpecialAction {
    public boolean[][] specialHighlight(Player player, String terrainCard, Board gameBoard, String SpecialAction) {
        boolean[][] highlight = new boolean[20][30];
        Tile[][] board = gameBoard.getBoard();
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
            boolean[][] tempP;
            boolean tempUwu = false;

            for(int i = 0; i < highlight.length; i++) {
                for (int j = 0; j < highlight[0].length; j++) {
                    tempUwu = false;
                    if (board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())) {
                        tempP = paddock(player, gameBoard, i, j);

                        for(int l = 0; l < tempP.length; l++){
                            for(int b = 0; b < tempP[l].length; b++){
                                if(tempP[l][b]){
                                    tempUwu = true;
                                }
                            }
                        }

                        if(tempUwu){
                            highlight[i][j] = true;
                        }
                        else{
                            highlight[i][j] = false;
                        }
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
                if(j != 0 && board[i][j-1].hasHouse && board[i][j-1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //right tile
                if(j != 19 && board[i][j+1].hasHouse && board[i][j+1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile above
                if(i != 0  && board[i-1][j].hasHouse && board[i-1][j].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile below
                if(i != 19 && board[i+1][j].hasHouse && board[i+1][j].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile upper left
                if(i != 0 && j != 0 && board[i-1][j-1].hasHouse && board[i-1][j-1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile lower right
                if(i != 19 && j != 19 && board[i+1][j+1].hasHouse && board[i+1][j+1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
            }

            i = 19;
            for(int j = 10; j <= 29; j++){
                //left tile
                if(j != 0 && board[i][j-1].hasHouse && board[i][j-1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //right tile
                if(j != 29 && board[i][j+1].hasHouse && board[i][j+1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile above
                if(i != 0  && board[i-1][j].hasHouse && board[i-1][j].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile below
                if(i != 19 && board[i+1][j].hasHouse && board[i+1][j].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile upper left
                if(i != 0 && j != 0 && board[i-1][j-1].hasHouse && board[i-1][j-1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
                //tile lower right
                if(i != 19 && j != 19 && board[i+1][j+1].hasHouse && board[i+1][j+1].houseColor.equals(player.getColor()) && !board[i][j].getTerrain().equals("Mountain") && !board[i][j].getTerrain().equals("Water")){
                    if(!board[i][j].hasHouse) {
                        highlight[i][j] = true;
                        cnt++;
                    }
                }
            }

            int b = 0;
            for(int a = 0; a <= 19; a++){
                //left tile
                if(b != 0 && board[a][b-1].hasHouse && board[a][b-1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //right tile
                if(b != 29 && board[a][b+1].hasHouse && board[a][b+1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile above
                if(a != 0  && board[a-1][b].hasHouse && board[a-1][b].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile below
                if(a != 19 && board[a+1][b].hasHouse && board[a+1][b].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile upper left
                if(a != 0 && b != 0 && board[a-1][b-1].hasHouse && board[a-1][b-1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile lower right
                if(a != 19 && b != 29 && board[a+1][b+1].hasHouse && board[a+1][b+1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                if(a%2 == 0){
                    b++;
                }
            }

            b = 19;
            for(int a = 0; a <= 19; a++){
                //left tile
                if(b != 0 && board[a][b-1].hasHouse && board[a][b-1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //right tile
                if(b != 29 && board[a][b+1].hasHouse && board[a][b+1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile above
                if(a != 0  && board[a-1][b].hasHouse && board[a-1][b].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile below
                if(a != 19 && board[a+1][b].hasHouse && board[a+1][b].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile upper left
                if(a != 0 && b != 0 && board[a-1][b-1].hasHouse && board[a-1][b-1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                //tile lower right
                if(a != 19 && b != 29 && board[a+1][b+1].hasHouse && board[a+1][b+1].houseColor.equals(player.getColor()) && !board[a][b].getTerrain().equals("Mountain") && !board[a][b].getTerrain().equals("Water")){
                    if(!board[a][b].hasHouse) {
                        highlight[a][b] = true;
                        cnt++;
                    }
                }
                if(a%2 == 0){
                    b++;
                }
            }

            if(cnt == 0){
                i = 0;
                for(int j = 0; j <= 19; j++){
                    if(!board[i][j].getTerrain().equals("Water") && !board[i][j].getTerrain().equals("Mountain")){
                        highlight[i][j] = true;
                    }
                }
                i = 19;
                for(int j = 10; j <= 29; j++){
                    if(!board[i][j].getTerrain().equals("Water") && !board[i][j].getTerrain().equals("Mountain")){
                        highlight[i][j] = true;
                    }
                }
                b = 0;
                for(int a = 0; a <= 19; a++){
                    if(!board[a][b].getTerrain().equals("Water") && !board[a][b].getTerrain().equals("Mountain")){
                        highlight[a][b] = true;
                    }
                    if(a%2 == 0){
                        b++;
                    }
                }
                b = 19;
                for(int a = 0; a <= 19; a++){
                    if(!board[a][b].getTerrain().equals("Water") && !board[a][b].getTerrain().equals("Mountain")){
                        highlight[a][b] = true;
                    }
                    if(a%2 == 0){
                        b++;
                    }
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
        //upper right 2
        if(p >= 2){
            highlight[p-2][v] = true;
        }
        //lower left 2
        if(p <= 17){
            highlight[p+2][v] = true;
        }
        //left 2 tile
        if(v >= 2){
            highlight[p][v-2] = true;
        }
        //right 2 tile
        if(v <= 27){
            highlight[p][v+2] = true;
        }
        //up left 2 tile
        if(p >= 2 && v >= 2){
            highlight[p-2][v-2] = true;
        }
        //down right 2 tile
        if(p <= 17 && v <= 27){
            highlight[p+2][v+2] = true;
        }

        for(int i = 0; i < highlight.length; i++){
            for(int j = 0; j < highlight[0].length; j++){
                if(board[i][j].hasHouse || board[i][j].getTerrain().equals("Water") || board[i][j].getTerrain().equals("Mountain") || board[i][j].getLocation().equals("City") || board[i][j].getLocation().equals("Oracle") || board[i][j].getLocation().equals("Harbor") || board[i][j].getLocation().equals("Paddock") || board[i][j].getLocation().equals("Tower")){
                    highlight[i][j] = false;
                }
            }
        }
        return highlight;
    }
}
