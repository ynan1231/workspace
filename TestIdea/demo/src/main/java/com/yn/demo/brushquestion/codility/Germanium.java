package com.yn.demo.brushquestion.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are playing a game with N cards. On both sides of each card there is a positive integer. The cards are laid on the table.
 * The score of the game is the smallest positive integer that does not occur on the face-up cards. You may flip some cards over.
 * Having flipped them, you then read the numbers facing up and recalculate the score. What is the maximum score you can achieve?
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two arrays of integers A and B, both of length N, describing the numbers written on both sides of the cards,
 * facing up and down respectively, returns the maximum possible score.
 * <p>
 * For example, given A = [1, 2, 4, 3] and B = [1, 3, 2, 3], your function should return 5, as without flipping any card the smallest positive integer excluded from this sequence is 5.
 * <p>
 * Given A = [4, 2, 1, 6, 5] and B = [3, 2, 1, 7, 7], your function should return 4, as we could flip the first card so that the numbers facing up are [3, 2, 1, 6, 5] and it is impossible to have both numbers 3 and 4 facing up.
 * <p>
 * Given A = [2, 3] and B = [2, 3] your function should return 1, as no matter how the cards are flipped, the numbers facing up are [2, 3].
 * <p>
 * 题目解读:
 * 有一组卡片,正反两面 都有数字,返回正面卡片未出现的最小值,
 * 取所有方案中最大的数
 */
public class Germanium {

    //worng
    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int length = A.length;

        //初始化
        int[] C = new int[length+1];
//        for (int i : C) {
//            i = 0;
//        }
        Map<Integer,List<Integer>> bMap = new HashMap<Integer,List<Integer>>();
        for (int i = 0; i < B.length; i++) {
            if (bMap.get(B[i])==null){
                List list = new ArrayList();
                list.add(i);
                bMap.put(B[i],list);
            }else{
                bMap.get(B[i]).add(i);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i]<=length +1)
                C[A[i]-1]++;
        }
        int result = 1;
        for (int i = 0; i < C.length; i++) {
            if(C[i] == 0){
                if (bMap.get(i+1) == null){
                    return  i+1;
                }else{
                  List<Integer> indexList = bMap.get(i+1);
                    int tempIndex = -1;
                    int tempAmax = -1;
                    for (int i1 = 0; i1 < indexList.size(); i1++) {
                        int bIndex = (int) indexList.get(i1);
                        if(A[bIndex] <=i+1 && C[A[bIndex]-1]<=1) {
                            continue;
                        }
                        if (tempAmax < A[bIndex]){
                            tempIndex = bIndex;
                            tempAmax = A[bIndex];
                        }
                    }
                    if (tempAmax>-1){
                        //翻转bIndex
                        C[B[tempIndex]-1]++;
                        if (A[tempIndex]<=length+1)
                            C[A[tempIndex]-1]--;
                    }else{
                        return  i +1;
                    }
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        int[] B = {1, 3, 2, 3};
        System.out.println(solution(A,B));
    }

     class Node{
        List<String> list=new ArrayList<>();
        Node(){
        }
        void add(String nodeName){
            list.add(nodeName);
        }
        void remove(String nodeName){
            list.remove(nodeName);
        }
        int size(){
            return  list.size();
        }
        String getFirst(){
            return  list.get(0);
        }
    }
    public int solution2(int[] A, int[] B) {

        int length = A.length;
        Node[] C = new Node[length+1];
        for (int i = 0; i < C.length; i++) {
            Node node = new Node();
            C[i] = node;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i]<=length+1)
                 C[A[i]-1].add("A"+i);
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i]<=length+1)
                C[B[i]-1].add("B"+i);
        }
        for (int i = 0; i < C.length; i++) {
            if(C[i].size()==0)
                return  i+1;
            else if (C[i].size()==1){
                if(!RemoveReverse(C[i].getFirst(),A,B,i,C))
                       return i+1;
            }
    }
    return 0;
}

     private static boolean RemoveReverse(String nodeName,int[] A, int[] B,int index, Node[] C) {
            int[] current,reverse;
            String currentString,reverseString;
            if (nodeName.charAt(0)=='A') {
                current = A;
                currentString="A";
                reverse = B;
                reverseString="B";
            }else {
                current = B;
                currentString="B";
                reverse = A;
                reverseString="A";
            }
            Integer i = new Integer(nodeName.substring(1));
            if (reverse[i]>=index){//在当前位置之后,可以直接去掉反面 返回true
                if(reverse[i]<=C.length)
                    C[reverse[i]-1].remove(reverseString+i);
                return  true;
            }else {
                if(C[reverse[i]-1].size()==1){
                    return false;
                }else{
                    C[reverse[i]-1].remove(reverseString+i);
                    if(C[reverse[i]-1].size()==1){
                        return RemoveReverse(C[reverse[i]-1].getFirst(),A,B,index,C);
                    }else{
                        return  true;
                    }
                }
            }

        }
    }
