package com.example.myapplication;

import android.widget.Button;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private final int ROW = 4;
    private final int COL = 4;
    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<Columns> rows = new ArrayList<>();
    private int indexButtonBlank, rowFirst, colFirst;
    private int[][] emptyButton = new int[ROW][COL], fullButton = new int[ROW][COL];

    public void setRows(ArrayList<Columns> rows) {
        this.rows = rows;
    }

    public void setButtons(ArrayList<Button> buttons) {
        this.buttons = buttons;
    }

    public void setIndexButtonBlank(int indexButtonBlank) {
        this.indexButtonBlank = indexButtonBlank;
    }

    public void setRowFirst(int rowFirst) {
        this.rowFirst = rowFirst;
    }

    public void setColFirst(int colFirst) {
        this.colFirst = colFirst;
    }

    public Game(){}

    private int extraction(){
        Random random = new Random();
        int val;
        do{
            val = random.nextInt(16);
        }while(val == 0);
        return val;
    }

    public void startGame(ArrayList<Button> list){

        int[] extract = new int[15];
        int val;

        for(int i = 0; i < 15; i++){
            val = extraction();
            for(int j = 0; j < extract.length; j++){
                if(val == extract[j] && !(j == i)){
                    val = extraction();
                    j = -1;
                }
            }
            extract[i] = val;
        }

        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).setText(String.valueOf(extract[i]));
        }
    }

    private void switching(int row, int col, int butt[][]){
        String value;

        if(butt[row][col] == 0){
            value = "-";
        }
        else value = String.valueOf(butt[row][col]);
        rows.get(row).getIndex(col).setText(value);
    }

    private boolean swap(int row1, int col1, int row2, int col2){
        int valTemp;
        boolean swaped = false;

        if(row1 == row2){
            if(!(Math.abs(col1-col2) == 1)) return swaped;
        }
        else if(col1 == col2 && row1 != row2){
            if(!(Math.abs(row1-row2) == 1)) return swaped;
        }
        else if(col1 != col2 && row1 != row2) return swaped;

        valTemp = fullButton[row2][col2];
        fullButton[row2][col2] = 0;
        emptyButton[row1][col1] = valTemp;
        switching(row1,col1,emptyButton);
        switching(row2,col2,fullButton);
        swaped = true;
        return swaped;
    }

    public void setValueButton(int idxBb,int row,int col,int idxButt){
        if(indexButtonBlank == idxBb) return;
        else{
            fullButton[row][col] = Integer.parseInt(buttons.get(idxButt).getText().toString());
        }
        if(swap(rowFirst,colFirst,row,col)){
            rowFirst = row;
            colFirst = col;
            indexButtonBlank = idxBb;
        }
    }

    public boolean gameComplete(){
        boolean complete = false;
        int val = 0;
        int count = 1;

        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(rows.get(i).getIndex(j).getText().equals("-")){
                    val = 0;
                }
                else{
                    val = Integer.parseInt(rows.get(i).getIndex(j).getText().toString());
                }
                if(!(val == count) && !(count == 16)){
                    complete = false;
                    break;
                }
                else {
                    complete = true;
                }
                count ++;
            }
        }

        return complete;
    }

}
