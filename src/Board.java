import java.util.*;
import java.io.*;
public class Board {
    private Tile[][] Board= new Tile[20][39];
    private String b1 = "CDDDDDDDDD|CCCDDDDDCC|MMMDMMGDDC|CMMMMMFFCC|CCCMMWFFFC|PCCCMFFWTC|PPGTFFWFFT|PPTTFFPSTT|PPPTTWPPTT|PPPTWPPTTT";
    private String b2 = "DDCWWTTTPP|DSCWTTTGPP|CCCFFFTCFF|CCFFWDDCCF|CPPWFFDDCC|PPGFWFWDDC|PPPTFFWWDD|PPTTMWWWDW|PMTTWWWWWW|TTTWWWWWWW";
    private String b3 = "PPPTTWPTTT|PPPSTWPTTT|PFFPTTWPPT|FFCPTWFGTT|FFFCCWFFWW|MMCPPWWWDD|CCCMPFFFDD|CCSDMDFFCC|WWWDDDDMCC|WWWWDDDDDC";
    private String b4 = "PPTTTWPTTF|PFTTWPTTFF|PFFTWPPFFF|FFTTWPMFDD|CFSTWPDDDD|CCTWPPMMDD|CCWWWPDDDC|WWPPWWGCMC|WDSPWMWCCC|WDDWWWWCCC";
    private String b5 = "TTTTMMPMCC|TMTTFPMMMC|FFTFFFPPWM|DFFFWGPWMM|DDDDFWPWCC|DCDDDWWCPC|DDCDDWFSPC|CCGDWFFFPP|DCWWWTTFPP|DCCWTTTPPP";
    private String b6 = "DDCWWTTPPP|DCWFFTTTPP|DDWFFTTGFP|WWWFPTFFFF|WWWWPPPPFF|WTTWPPCCDC|WTCTWPCCDC|WSCFWGDDCW|WWCFWWWDDW|WWWWWWWWWW";
    private String b7 = "CCCDDWDDDD|MMCDDWDDDD|MMCMMWDDGF|MCMMWMDFFF|CCTTWMMCFFCTTWCCCMFF|CGTTWFFFFF|PPTWPSPFPT|PPTTWPPPPT|PPTTWPPPTT";
    private String b8 = "FDDMMDDCCC|FFDDDMMCCC|FFFFFFFMMM|WWFSPPTTMM|FFWWPPPTTC|FCCWPTTCCC|DFGCWTTGCP|DDCWTTPPPP|DDDWTTTPPP|DDWWTTTPPP";
    private String[] allBoards = new String[] {b1, b2, b3, b4, b5, b6, b7, b8};
    public Board() {
        ArrayList<Integer> boardsToUse = chooseBoards();
        String temp = "";
        for(int i : boardsToUse){
            temp += allBoards[i-1];
        }

        Board = stringToBoard(temp);

    }

    public Tile[][] stringToBoard(String s){
        Tile[][] temp = new Tile[20][39];

        for(int i = 0; i <)

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
}










