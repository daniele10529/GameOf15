package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import java.util.ArrayList;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<Columns> rows = new ArrayList<>();
    private Game game;
    public AlertDialog.Builder alertBuild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertBuild = new AlertDialog.Builder(this);
    }

    private void buttonDefine(){
        buttons.clear();
        rows.clear();
        buttons.add((Button)findViewById(R.id.btn1));
        buttons.add((Button)findViewById(R.id.btn2));
        buttons.add((Button)findViewById(R.id.btn3));
        buttons.add((Button)findViewById(R.id.btn4));
        buttons.add((Button)findViewById(R.id.btn5));
        buttons.add((Button)findViewById(R.id.btn6));
        buttons.add((Button)findViewById(R.id.btn7));
        buttons.add((Button)findViewById(R.id.btn8));
        buttons.add((Button)findViewById(R.id.btn9));
        buttons.add((Button)findViewById(R.id.btn10));
        buttons.add((Button)findViewById(R.id.btn11));
        buttons.add((Button)findViewById(R.id.btn12));
        buttons.add((Button)findViewById(R.id.btn13));
        buttons.add((Button)findViewById(R.id.btn14));
        buttons.add((Button)findViewById(R.id.btn15));
        buttons.add((Button)findViewById(R.id.btn16));

        for(int i = 0; i < 15; i += 4){
            Columns col = new Columns();
            col.setCol1(buttons.get(i));
            col.setCol2(buttons.get(i+1));
            col.setCol3(buttons.get(i+2));
            col.setCol4(buttons.get(i+3));
            rows.add(col);
        }
    }

    public void btnNew_onClick(View v){
        buttonDefine();
        game = new Game();
        game.startGame(buttons);
        buttons.get(15).setText("-");

        game.setButtons(buttons);
        game.setRows(rows);
        game.setIndexButtonBlank(16);
        game.setRowFirst(3);
        game.setColFirst(3);
    }

    public void btn16_onClick(View v){
        game.setValueButton(16,3,3,15);
    }
    public void btn15_onClick(View v){
        game.setValueButton(15,3,2,14);
    }
    public void btn14_onClick(View v){
        game.setValueButton(14,3,1,13);
    }
    public void btn13_onClick(View v){
        game.setValueButton(13,3,0,12);
    }
    public void btn12_onClick(View v){
        game.setValueButton(12,2,3,11);
    }
    public void btn11_onClick(View v){
        game.setValueButton(11,2,2,10);
    }
    public void btn10_onClick(View v){
        game.setValueButton(10,2,1,9);
    }
    public void btn9_onClick(View v){
        game.setValueButton(9,2,0,8);
    }
    public void btn8_onClick(View v){
        game.setValueButton(8,1,3,7);
    }
    public void btn7_onClick(View v){
        game.setValueButton(7,1,2,6);
    }
    public void btn6_onClick(View v){
        game. setValueButton(6,1,1,5);
    }
    public void btn5_onClick(View v){
        game.setValueButton(5,1,0,4);
    }
    public void btn4_onClick(View v){
        game.setValueButton(4,0,3,3);
    }
    public void btn3_onClick(View v){
        game.setValueButton(3,0,2,2);
    }
    public void btn2_onClick(View v){
        game.setValueButton(2,0,1,1);
    }
    public void btn1_onClick(View v){
        game.setValueButton(1,0,0,0);
    }

}