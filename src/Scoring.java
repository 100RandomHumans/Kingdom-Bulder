import java.util.ArrayList;

public class Scoring {


    public int getScore(String objective, Player player, Board gameBoard){
        Tile[][] board = gameBoard.getBoard();
        int score = 0;
        int trk1 = 0;
        int trk2 = 0;
        Tile[][] temp = new Tile[20][20];
        int tracker = 0;

        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                temp[i][j] = board[i][j+tracker];
            }
            if(i%2 == 0){
                tracker++;
            }
        }

        if(objective.equals("City")){
            for(int i = 0; i <= 19; i++){
                for(int j = 0; j <= 29; j++){
                    if(board[i][j].getLocation().equals("City")){
                        if(board[i][j-1].hasHouse && board[i][j-1].houseColor.equals(player.getColor()) && trk1==trk2){
                            score += 3;
                            trk1++;
                        }
                        if(board[i-1][j-1].hasHouse && board[i-1][j-1].houseColor.equals(player.getColor()) && trk1==trk2){
                            score += 3;
                            trk1++;
                        }
                        if(board[i-1][j].hasHouse && board[i-1][j].houseColor.equals(player.getColor()) && trk1==trk2){
                            score += 3;
                            trk1++;
                        }
                        if(board[i+1][j].hasHouse && board[i+1][j].houseColor.equals(player.getColor()) && trk1==trk2){
                            score += 3;
                            trk1++;
                        }
                        if(board[i][j+1].hasHouse && board[i][j+1].houseColor.equals(player.getColor()) && trk1==trk2){
                            score += 3;
                            trk1++;
                        }
                        if(board[i+1][j+1].hasHouse && board[i+1][j+1].houseColor.equals(player.getColor()) && trk1==trk2){
                            score += 3;
                            trk1++;
                        }
                    }
                    trk2 = trk1;
                }
            }
            return score;
        }


        else if(objective.equals("Farmer")){
            int[] farm = new int[4];
            int cnt = 0;
            for(int i = 0; i <= 9; i++){
                for(int j = 0; j <= 9; j++){
                    if(board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())){
                        cnt += 1;
                    }
                }
            }
            farm[0] = cnt;
            cnt = 0;

            for(int i = 0; i <= 9; i++){
                for(int j = 10; j <= 19; j++){
                    if(board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())){
                        cnt += 1;
                    }
                }
            }
            farm[1] = cnt;
            cnt = 0;

            for(int i = 10; i <= 19; i++){
                for(int j = 0; j <= 9; j++){
                    if(board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())){
                        cnt += 1;
                    }
                }
            }
            farm[3] = cnt;
            cnt = 0;

            for(int i = 10; i <= 19; i++){
                for(int j = 10; j <= 19; j++){
                    if(board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())){
                        cnt += 1;
                    }
                }
            }
            farm[4] = cnt;


            int temp1, size;
            size = farm.length;


            for(int i = 0; i<size; i++ ){
                for(int j = i+1; j<size; j++){
                    if(farm[i]>farm[j]){
                        temp1 = farm[i];
                        farm[i] = farm[j];
                        farm[j] = temp1;
                    }
                }
            }

            score = farm[0]*3;
            return score;
        }


        else if(objective.equals("Discoverer")){
            for(int i = 0; i <=19; i++){
                for(int j = 0; j <= 29; j++){
                    if(board[i][j].hasHouse && board[i][j].houseColor.equals(player.getColor())){
                        score += 1;
                        break;
                    }
                }
            }
            return score;
        }


        else if(objective.equals("Worker")){
            for(int i = 0; i <= 19; i++){
                for(int j = 0; j <= 29; j++){
                    if(board[i][j].getLocation().equals("City")){
                        if(board[i][j-1].hasHouse && board[i][j-1].houseColor.equals(player.getColor())){
                            score += 1;
                        }
                        if(board[i-1][j-1].hasHouse && board[i-1][j-1].houseColor.equals(player.getColor())){
                            score += 1;
                        }
                        if(board[i-1][j].hasHouse && board[i-1][j].houseColor.equals(player.getColor())){
                            score += 1;
                        }
                        if(board[i+1][j].hasHouse && board[i+1][j].houseColor.equals(player.getColor())){
                            score += 1;
                        }
                        if(board[i][j+1].hasHouse && board[i][j+1].houseColor.equals(player.getColor())){
                            score += 1;
                        }
                        if(board[i+1][j+1].hasHouse && board[i+1][j+1].houseColor.equals(player.getColor())){
                            score += 1;
                        }
                    }
                }
            }
            return score;
        }

        return score;
    }
}
