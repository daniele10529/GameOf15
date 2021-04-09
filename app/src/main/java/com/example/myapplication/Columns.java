package com.example.myapplication;

import android.widget.Button;

public class Columns {
    private Button col1;
    private Button col2;
    private Button col3;
    private Button col4;

    public Button getIndex(int index){
        Button ris = null;
        switch (index){
            case 0:
                ris = getCol1();
                break;
            case 1:
                ris = getCol2();
                break;
            case 2:
                ris = getCol3();
                break;
            case 3:
                ris =  getCol4();
                break;
        }
        return ris;
    }

    public Button getCol1() { return col1; }
    public void setCol1(Button col1) { this.col1 = col1; }

    public Button getCol2() { return col2; }
    public void setCol2(Button col2) { this.col2 = col2; }

    public Button getCol3() { return col3; }
    public void setCol3(Button col3) { this.col3 = col3; }

    public Button getCol4() { return col4; }
    public void setCol4(Button col4) { this.col4 = col4; }


}
