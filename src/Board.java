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
    public Board() {
        ArrayList<Integer> boardsToUse = chooseBoards();
        String temp = "";
        for(int i : boardsToUse){
            temp += allBoards[i-1];
        }

        Board = stringToBoard(temp);

    }

    public Tile[][] getBoard(){
        return Board;
    }

    public Tile[][] stringToBoard(String s){
        Map<String, String> map = new HashMap<String, String>();
        map.put("T", "Forest");map.put("M", "Mountain");map.put("P", "Grass");map.put("F", "Flower");map.put("W", "Water");map.put("D", "Desert"); map.put("C", "Canyon");map.put("S", "City");map.put("B", "Barn");map.put("A", "Farm");map.put("O", "Oracle");map.put("H", "Harbor");map.put("U", "Tower");map.put("V", "Oasis");map.put("Q", "Paddock");map.put("Z", "Tavern");

        Tile[][] temp = new Tile[20][39];
        String tempString = s;
        int cnt = 0;
        int moveJ = 0;
        for(int i = 0; i <= 19; i++){
            for(int j = moveJ; j <= moveJ + 19; j++){
                if(tempString.substring(cnt, cnt+1).equals("S") || tempString.substring(cnt, cnt+1).equals("B") || tempString.substring(cnt, cnt+1).equals("A") || tempString.substring(cnt, cnt+1).equals("O") || tempString.substring(cnt, cnt+1).equals("H") || tempString.substring(cnt, cnt+1).equals("U") || tempString.substring(cnt, cnt+1).equals("V") || tempString.substring(cnt, cnt+1).equals("Q") || tempString.substring(cnt, cnt+1).equals("Z")){
                    temp[i][j] = new Tile("none", map.get(tempString.substring(cnt, cnt+1)));
                }
                else{
                    temp[i][j] = new Tile(map.get(tempString.substring(cnt, cnt+1)), "none");
                }
                cnt++;
            }
            moveJ = moveJ + 1;
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

        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 39; j++) {
                System.out.print(bb[i][j].toString() + " ");
            }
            System.out.println();
        }

        /*
        int size = 8;

        String barnBoard = "CDDDDDDDDDCCCDDDDDCCMMMDMMBDDCCMMMMMFFCCCCCMMWFFFCPCCCMFFWTCPPBTFFWFFTPPTTFFPSTTPPPTTWPPTTPPPTWPPTTT";
        String farmBoard = "DDCWWTTTPPDSCWTTTAPPCCCFFFTCFFCCFFWDDCCFCPPWFFDDCCPPAFWFWDDCPPPTFFWWDDPPTTMWWWDWPMTTWWWWWWTTTWWWWWWW";
        String oracleBoard = "PPPTTWPTTTPPPSTWPTTTPFFPTTWPPTFFCPTWFOTTFFFCCWFFWWMMCPPWWWDDCCCMPFFFDDCCSDMDFFCCWWWDDDDMCCWWWWDDDDDC";
        String harborBoard = "PPTTTWPTTFPFTTWPTTFFPFFTWPPFFFFFTTWPMFDDCFSTWPDDDDCCTWPPMMDDCCWWWPDDDCWWPPWWHCMCWDSPWMWCCCWDDWWWWCCC";
        String towerBoard = "TTTTMMPMCCTMTTFPMMMCFFTFFFPPWMDFFFWUPWMMDDDDFWPWCCDCDDDWWCPCDDCDDWFSPCCCUDWFFFPPDCWWWTTFPPDCCWTTTPPP";
        String oasisBoard = "DDCWWTTPPPDCWFFTTTPPDDWFFTTVFPWWWFPTFFFFWWWWPPPPFFWTTWPPCCDCWTCTWPCCDCWSCFWVDDCWWWCFWWWDDWWWWWWWWWWW";
        String paddockBoard = "CCCDDWDDDDMMCDDWDDDDMMCMMWDDQFMCMMWMDFFFCCTTWMMCFFCTTWCCCMFFCQTTWFFFFFPPTWPSPFPTPPTTWPPPPTPPTTWPPPTT";
        String tavernBoard = "FDDMMDDCCCFFDDDMMCCCFFFFFFFMMMWWFSPPTTMMFFWWPPPTTCFCCWPTTCCCDFZCWTTZCPDDCWTTPPPPDDDWTTTPPPDDWWTTTPPP";


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
        System.out.println(usedBoards);
        String temp2 = "";
        String[] temp = new String[] {barnBoard, farmBoard, oracleBoard, harborBoard, towerBoard, oasisBoard, paddockBoard, tavernBoard};

        for(int i : usedBoards){
            temp2 += temp[i-1];
        }
        System.out.println(temp2);
        */
    }
}










