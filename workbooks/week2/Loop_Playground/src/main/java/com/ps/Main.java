package com.ps;

public class Main {
    public static void main(String[] args) {
//        1 - 20, 80 - 100 --- continue
        int userGivenValue = 2;
        for(int i=1;i<101;i++){
            if(i > userGivenValue){
                break;
            }

//            if(i > 20 && i < 80){
//                continue;
//            }
            System.out.println(i);
        }
    }
}


//// 142 - 100
//
//for(int i=142;i>99;i--){
//    System.out.println(i);
//}