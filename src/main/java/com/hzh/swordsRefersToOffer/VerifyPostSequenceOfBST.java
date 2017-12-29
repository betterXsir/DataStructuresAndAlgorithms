package com.hzh.swordsRefersToOffer;

public class VerifyPostSequenceOfBST {
    public static boolean solution(int[] sequence, int start, int end) {
        if(sequence == null || start > end || start < 0) {
            return false;
        }
        if(start == end || start + 1 == end) {
            return true;
        }
        int rootPos = isRoot(sequence, start, end - 1, sequence[end]);
        if(rootPos < 0) {
            return false;
        }
        else if(rootPos == start) {
            return solution(sequence, rootPos, end - 1);
        }
        else if(rootPos > end - 1) {
            return solution(sequence, start, end - 1);
        }
        else {
            return solution(sequence, start, rootPos - 1) && solution(sequence, rootPos, end - 1);
        }
    }

    public static int isRoot(int[] sequence, int start, int end, int rootData) {
        int rootPos, i = start;
        while(rootData > sequence[i] && i <= end) {
            i ++;
        }
        rootPos = i;
        while(i <= end) {
            if(sequence[i] < rootData) {
                return -1;
            }
            i ++;
        }
        return rootPos;
    }

    public static void main(String[] args) {
        int[] sequence = {5, 6, 7};
        System.out.println(solution(sequence, 0, sequence.length - 1));
    }
}
