package com.yn.demo.brushquestion;

public class Solution {

    public static int solution(int N) {
        // write your code in Java SE 8
        String nString = N+"";
        if(N==0)
            return  50;
        else if(N>0){
            for(int i = 0;i<nString.length();i++){
                if(nString.charAt(i)<'5'){
                    return new Integer(nString.substring(0,i)+"5"+nString.substring(i));
                }
            }
            return  new Integer(nString+"5");
        }else{
            for(int i = 1;i<nString.length();i++){
                if(nString.charAt(i)>'5'){
                    return new Integer(nString.substring(0,i)+"5"+nString.substring(i));
                }
            }
            return  new Integer(nString+"5");
        }
    }
    public static boolean solution2(String S) {
        boolean hasB = false;
        for(int i = 0;i<S.length();i++){
            if (hasB && S.charAt(i) == 'a')
                return false;
            if (S.charAt(i) == 'b')
                hasB = true;
        }
        return  true;
    }


    public static void main(String[] args) {
        System.out.println(solution(100));
        System.out.println(solution(115));
        System.out.println(solution(0));
        System.out.println(solution(510));
        System.out.println(solution(8000));
        System.out.println(solution(-100));
        System.out.println(solution(-115));
        System.out.println(solution(0));
        System.out.println(solution(-510));
        System.out.println(solution(-8000));
    }
}
