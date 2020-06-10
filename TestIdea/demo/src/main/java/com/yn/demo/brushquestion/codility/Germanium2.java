package com.yn.demo.brushquestion.codility;

import java.util.ArrayList;
import java.util.List;

/**
 * MaxNotPresent
 * https://app.codility.com/programmers/challenges/germanium2018/
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
public class Germanium2 {


    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        int[] B = {1, 3, 2, 3};
        System.out.println(new Germanium2().solution(A, B));
    }


    public int solution(int[] A, int[] B) {

        int length = A.length;
        Node[] C = new Node[length + 1];
        for (int i = 0; i < C.length; i++) {
            Node node = new Node();
            C[i] = node;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= length + 1)
                C[A[i] - 1].add(new NodeInfo(A[i], B[i]));
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] <= length + 1)
                C[B[i] - 1].add(new NodeInfo(B[i], A[i]));
        }
        for (int i = 0; i < C.length; i++) {
            if (C[i].size() == 0)
                return i + 1;
            else if (C[i].size() == 1) {
                if (!RemoveReverse(C[i].getFirst(), i, C))
                    return i + 1;
            }
        }
        return 0;
    }

    private boolean RemoveReverse(NodeInfo nodeInfo, int index, Node[] C) {
        if (nodeInfo.reverse >= index) {//在当前位置之后,可以直接去掉反面 返回true
            if (nodeInfo.reverse <= C.length)
                C[nodeInfo.reverse - 1].remove(new NodeInfo(nodeInfo.reverse, nodeInfo.current));
            return true;
        } else {
            if (C[nodeInfo.reverse - 1].size() == 1) {
                return false;
            } else {
                C[nodeInfo.reverse - 1].remove(new NodeInfo(nodeInfo.reverse, nodeInfo.current));
                if (C[nodeInfo.reverse - 1].size() == 1) {
                    return RemoveReverse(C[nodeInfo.reverse - 1].getFirst(), index, C);
                } else {
                    return true;
                }
            }
        }

    }

    class Node {
        List<NodeInfo> list = new ArrayList<>();

        Node() {
        }

        void add(NodeInfo nodeInfo) {
            list.add(nodeInfo);
        }

        void remove(NodeInfo nodeInfo) {
            list.remove(nodeInfo);
        }

        int size() {
            return list.size();
        }

        NodeInfo getFirst() {
            return list.get(0);
        }
    }

    class NodeInfo {
        int current;//正面
        int reverse;//反面

        NodeInfo(int current, int reverse) {
            this.current = current;
            this.reverse = reverse;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NodeInfo nodeInfo = (NodeInfo) o;

            if (current != nodeInfo.current) return false;
            return reverse == nodeInfo.reverse;
        }

        @Override
        public int hashCode() {
            int result = current;
            result = 31 * result + reverse;
            return result;
        }
    }
}
