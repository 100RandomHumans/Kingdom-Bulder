import java.util.*;
import java.io.*;
public class Board {
    private Tile[][] Board= new Tile[20][39];
    private String barnBoard = "CDDDDDDDDDCCCDDDDDCCMMMDMMBDDCCMMMMMFFCCCCCMMWFFFCPCCCMFFWTCPPBTFFWFFTPPTTFFPSTTPPPTTWPPTTPPPTWPPTTT";
    private String farmBoard = "DDCWWTTTPPDSCWTTTAPPCCCFFFTCFFCCFFWDDCCFCPPWFFDDCCPPAFWFWDDCPPPTFFWWDDPPTTMWWWDWPMTTWWWWWWTTTWWWWWWW";
    private String oracleBoard = "PPPTTWPTTTPPPSTWPTTTPFFPTTWPPTFFCPTWFOTTFFFCCWFFWWMMCPPWWWDDCCCMPFFFDDCCSDMDFFCCWWWDDDDMCCWWWWDDDDDC";
    private String harborBoard = "PPTTTWPTTFPFTTWPTTFFPFFTWPPFFFFFTTWPMFDDCFSTWPDDDDCCTWPPMMDDCCWWWPDDDCWWPPWWHCMCWDSPWMWCCCWDDWWWWCCC";
    private String towerBoard = "TTTTMMPMCCTMTTFPMMMCFFTFFFPPWMDFFFWUPWMMDDDDFWPWCCDCDDDWWCPCDDCDDWFSPCCCUDWFFFPPDCWWWTTFPPDCCWTTTPPP";
    private String oasisBoard = "DDCWWTTPPPDCWFFTTTPPDDWFFTTVFPWWWFPTFFFFWWWWPPPPFFWTTWPPCCDCWTCTWPCCDCWSCFWVDDCWWWCFWWWDDWWWWWWWWWWW";
    private String paddockBoard = "CCCDDWDDDDMMCDDWDDDDMMCMMWDDQFMCMMWMDFFFCCTTWMMCFFCTTWCCCMFFCQTTWFFFFFPPTWPSPFPTPPTTWPPPPTPPTTWPPPTT";
    private String tavernBoard = "FDDMMDDCCCFFDDDMMCCCFFFFFFFMMMWWFSPPTTMMFFWWPPPTTCFCCWPTTCCCDFZCWTTZCPDDCWTTPPPPDDDWTTTPPPDDWWTTTPPP";
    private String[] allBoards = new String[] {barnBoard, farmBoard, oracleBoard, harborBoard, towerBoard, oasisBoard, paddockBoard, tavernBoard};

    private String[] boardsUsed = new String[4];
    public Board() {
        String[] translateBoards = new String[] {"barnBoard", "farmBoard", "oracleBoard", "harborBoard", "towerBoard", "oasisBoard", "paddockBoard", "tavernBoard"};
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "barnBoard");map.put(1, "farmBoard");map.put(2, "oracleBoard");map.put(3, "harborBoard");map.put(4, "towerBoard");map.put(5, "oasisBoard");map.put(6, "paddockBoard");map.put(7, "tavernBoard");
        ArrayList<Integer> boardsToUse = chooseBoards();
        String temp = "";
        int i = 0;
        int l = 1;
        for(int j = 0; j <= 90; j += 10){
            temp += allBoards[boardsToUse.get(i)-1].substring(j, j+10);
            temp += allBoards[boardsToUse.get(l)-1].substring(j, j+10);
        }
        i = 2;
        l = 3;
        for(int j = 0; j <= 90; j += 10){
            temp += allBoards[boardsToUse.get(i)-1].substring(j, j+10);
            temp += allBoards[boardsToUse.get(l)-1].substring(j, j+10);
        }

        int tracker = 0;
        for(int a = 0; a < 4; a++){
            tracker = boardsToUse.get(a)-1;
            boardsUsed[a] = map.get(tracker);
        }

        Board = stringToBoard(temp);

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

        Tile[][] temp = new Tile[20][39];
        for(int a = 0; a <= 19; a++){
            for(int b = 0; b <= 38; b++){
                temp[a][b] = new Tile("", " ");
            }
        }
        String tempString = s;
        int cnt = 0;
        int moveJ = 0;
        for(int i = 0; i <= 19; i++){
            for(int j = i; j <= i + 19; j++){
                String temp2 = tempString.substring(cnt, cnt+1);
                if(temp2.equals("S") || temp2.equals("B") || temp2.equals("A") || temp2.equals("O") || temp2.equals("H") || temp2.equals("U") || temp2.equals("V") || temp2.equals("Q") || temp2.equals("Z")){
                    temp[i][j] = new Tile("", map.get(temp2));
                }
                else{
                    temp[i][j] = new Tile(map.get(temp2), "");
                }
                cnt++;
            }
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

    public static void main(String[] args) {

        Board  b = new Board();
        Tile[][] bb = b.getBoard();
        for(int i = 0; i<20; i++){
            System.out.print("[");
            for(int j = 0; j < 39; j++){

                if(!bb[i][j].getTerrain().equals("") || !bb[i][j].getLocation().equals("")){
                    System.out.print(bb[i][j].toString());
                }
                else{
                    System.out.print("");
                }
                if(j != 38) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }


        String[] blala = b.getUsedBoards();
        for(String s: blala){
            System.out.println(s);
        }
    }
}










