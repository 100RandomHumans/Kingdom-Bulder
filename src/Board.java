import java.util.*;

public class Board {
    public Tile[][] Board;
    public Tile[][] BoardNoX;
    public String barnBoard = "CDDDDDDDDDCCCDDDDDCDMMMDMMBDDCCMMMMMFFCCCCCMMWFFFCPCCCMFFWTCPPBTFFWFFTPPTTFFPSTTPPPTTWPPTTPPPTWPPTTT"; //checked
    public String farmBoard = "DDCWWTTTPPDSCWTTTAPPCCCFFFTCFFCCFFWDDCCFCPPWFFDDCCPPAFWFWDDCPPPTFFWWDDPPTTMWWWDWPMTTWWWWWWTTTWWWWWWW";
    public String oracleBoard = "PPPTTWPTTTPPPSTWPTTTPFFPTTWPPTFFCPTWFOTTFFFCCWFFWWMMCPPWWWDDCCCMPFFFDDCCSDMDFFCCWWWDDDDMCCWWWWDDDDDC";
    public String harborBoard = "PPTTTWPTTFPFTTWPTTFFPFFTWPPFFFFFTTWPMFDDCFSTWPDDDDCCTWPPMMDDCCWWWPDDDCWWPPWWHCMCWDSPWMWCCCWDDWWWWCCC";
    public String towerBoard = "TTTTMMPMCCTMTTFPMMMCFFTFFFPPWMDFFFWUPWMMDDDDFWPWCCDCDDDWWCPCDDCDDWFSPCCCUDWFFFPPDCWWWTTFPPDCCWTTTPPP";
    public String oasisBoard = "DDCWWTTPPPDCWFFTTTPPDDWFFTTVFPWWWFPTFFFFWWWWPPPPFFWTTWPPCCDCWTCTWPCCDCWSCFWVDDCWWWCFWWWDDWWWWWWWWWWW";
    public String paddockBoard = "CCCDDWDDDDMMCDDWDDDDMMCMMWDDQFMCMMWMDFFFCCTTWMMCFFCTTWCCCMFFCQTTWFFFFFPPTWPSPFPTPPTTWPPPPTPPTTWPPPTT";
    public String tavernBoard = "FDDMMDDCCCFFDDDMMCCCFFFFFFFMMMWWFSPPTTMMFFWWPPPTTCFCCWPTTCCCDFZCWTTZCPDDCWTTPPPPDDDWTTTPPPDDWWTTTPPP";
    private String[] allBoards = new String[] {barnBoard, farmBoard, oracleBoard, harborBoard, towerBoard, oasisBoard, paddockBoard, tavernBoard};

    public String[] boardsUsed = new String[4];
    public Board() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "barnBoard");map.put(1, "farmBoard");map.put(2, "oracleBoard");map.put(3, "harborBoard");map.put(4, "towerBoard");map.put(5, "oasisBoard");map.put(6, "paddockBoard");map.put(7, "tavernBoard");

        //ArrayList<Integer> boardsToUse = chooseBoards();
        String temp = "";
        int i = 0;
        int l = 1;
        for(int j = 0; j <= 90; j += 10){
            //temp += allBoards[boardsToUse.get(i)-1].substring(j, j+10);
            //temp += allBoards[boardsToUse.get(l)-1].substring(j, j+10);
            temp += allBoards[2].substring(j, j+10);
            temp += allBoards[7].substring(j, j+10);
        }
        i = 2;
        l = 3;
        for(int j = 0; j <= 90; j += 10){
            //temp += allBoards[boardsToUse.get(i)-1].substring(j, j+10);
            //temp += allBoards[boardsToUse.get(l)-1].substring(j, j+10);
            temp += allBoards[1].substring(j, j+10);
            temp += allBoards[3].substring(j, j+10);
        }

        /*
        int tracker = 0;
        for(int a = 0; a < 4; a++){
            tracker = boardsToUse.get(a)-1;
            boardsUsed[a] = map.get(tracker);
        }
        */
        boardsUsed[0] = "oracleBoard";
        boardsUsed[1] = "tavernBoard";
        boardsUsed[2] = "farmBoard";
        boardsUsed[3] = "harborBoard";



        Board = stringToBoard(temp);
        BoardNoX();


    }

    public Tile[][] getBoard(){
        return Board;
    }

    public String[] getUsedBoards(){
        return boardsUsed;
    }
    public Tile[][] stringToBoard(String s){
        Map<String, String> map = new HashMap<String, String>();
        map.put("T", "Forest");map.put("M", "Mountain");map.put("P", "Grass");map.put("F", "Flower");map.put("W", "Water");map.put("D", "Desert"); map.put("C", "Canyon");map.put("S", "City");map.put("B", "Barn");map.put("A", "Farm");map.put("O", "Oracle");map.put("H", "Harbor");map.put("U", "Tower");map.put("V", "Oasis");map.put("Q", "Paddock");map.put("Z", "Tavern");

        Tile[][] temp = new Tile[20][30];
        for(int a = 0; a <= 19; a++){
            for(int b = 0; b <= 29; b++){
                temp[a][b] = new Tile("", "x");
            }
        }
        String tempString = s;
        int cnt = 0;
        int i = 0;
        String temp2 = "";
        for(int j = 0; j <=19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[i][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[i][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        int jTrack = 1;
        int iTrack = 1;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }


        iTrack = 2;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 2;
        iTrack = 3;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 2;
        iTrack = 4;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 3;
        iTrack = 5;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 3;
        iTrack = 6;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 4;
        iTrack = 7;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 4;
        iTrack = 8;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 5;
        iTrack = 9;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 5;
        iTrack = 10;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 6;
        iTrack = 11;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 6;
        iTrack = 12;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 7;
        iTrack = 13;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 7;
        iTrack = 14;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 8;
        iTrack = 15;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 8;
        iTrack = 16;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 9;
        iTrack = 17;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 9;
        iTrack = 18;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        jTrack = 10;
        iTrack = 19;

        for(int j = jTrack; j <=jTrack+19; j++){
            temp2 = tempString.substring(cnt, cnt+1);
            if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                temp[iTrack][j] = new Tile("", map.get(temp2));
            }
            else{
                temp[iTrack][j] = new Tile(map.get(temp2), "");
            }
            cnt++;
        }

        return temp;
    }

    public ArrayList<Integer> chooseBoards() { // chooses 4 random boards without repeats to use
        int size = 8;

        ArrayList<Integer> list = new ArrayList<Integer>(size);
        ArrayList<Integer> usedBoards = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) {
            list.add(i);
        }
        Random rand = new Random();
        while(list.size() > 4) {
            int index = rand.nextInt(list.size());
            usedBoards.add(list.remove(index));
        }
        return usedBoards;
    }

    public String[] getAllBoards(){
        return allBoards;
    }

    public void BoardNoX() {
        Tile[][] temp = new Tile[20][20];

        for (int i = 0; i < 20; i++) {
            int count = 0;
            for (Tile t : Board[i]) {
                if (!t.getLocation().equals("x")) {
                    temp[i][count] = t;
                    count++;
                }
            }
        }

        BoardNoX = temp;

    }

    public boolean[][] thirtyToTwenty(boolean[][] b){
        boolean[][] temp = new boolean[20][20];
        int tracker = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                temp[i][j] = b[i][j+tracker];
            }
            if(i%2 == 0){
                tracker++;
            }
        }



        return temp;
    }

    public Tile[][] TilethirtyToTwenty(Tile[][] b){
        Tile[][] temp = new Tile[20][20];
        int tracker = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                temp[i][j] = b[i][j+tracker];
            }
            if(i%2 == 0){
                tracker++;
            }
        }
        return temp;
    }








    public static void main(String[] args) {
        Board b = new Board();
        Tile[][] bb = b.getBoard(); // 20 by 30 array
        Map<String, String> map = new HashMap<String, String>();
        map.put("Forest"," _Forest_ ");map.put("Mountain"," Mountain ");map.put("Grass"," __Grass_ ");
        map.put("Flower"," _Flower_ ");map.put("Water"," _Water__ ");map.put("Desert"," _Desert_ ");
        map.put("Canyon"," _Canyon_ ");map.put("City"," __City__ ");map.put("Barn"," __Barn__ ");
        map.put("Farm"," __Farm__ ");map.put("Oracle"," _Oracle_ ");map.put("Harbor"," _Harbor_ ");
        map.put("Tower"," __Tower_ ");map.put("Oasis"," _Oasis__ ");map.put("Paddock"," Paddock_ ");
        map.put("Tavern"," _Tavern_ ");map.put("x"," ________ ");

        /*
        for(int i = 0; i<bb.length; i++){
            System.out.print("[");
            for(int j = 0; j < bb[i].length; j++){

                if(!bb[i][j].getTerrain().equals("") || !bb[i][j].getLocation().equals("")){
                    System.out.print(map.get(bb[i][j].toString()));
                }
                else{
                    System.out.print("");
                }
                if(j != 29) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
        */

        for(int i = 0; i < bb.length; i++){
            for(int j = 0; j < bb[0].length; j++){
                System.out.print(map.get(bb[i][j].toString()));
            }
            System.out.println();
        }

        Tile[][] bbb = b.TilethirtyToTwenty(bb);

        for(int i = 0; i < bbb.length; i++){
            for(int j = 0; j < bbb[0].length; j++){
                System.out.print(map.get(bbb[i][j].toString()));
            }
            System.out.println();
        }


        String[] boardsThatWereUsed = b.getUsedBoards();
        for(String s: boardsThatWereUsed){
            System.out.println(s);
        }


        /*
        int tracker = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                System.out.print("[ " + i + " / " + j + " / " + tracker + " / " + (j+tracker) + " ] ");
            }
            if(i%2 == 0){
                tracker++;
            }
            System.out.println();
        }
        */


    }
}










