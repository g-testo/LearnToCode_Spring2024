package com.ps;

public class InstCalc {
    int num1;
    int num2;

    public InstCalc(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add(){
        return this.num1 + this.num2;
    }

    public int sub() {
        return this.num1 - this.num2;
    }


}
