package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/11/29.
 */
public class ReplaceSpaceOfString5 {
    /**
     * @Description  创建新的字符串
     * @param str
     * @return
     */
    public static String solution1(String str){
        StringBuilder target = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ') {
                target.append("%20");
            }
            else {
                target.append(str.charAt(i));
            }
        }
        return target.toString();
    }

    /**
     * @Description 在原来的字符串上进行替换
     * @param str
     */
    public static void solution2(char[] str, int length) {
        if(str == null || length <= 0){
            throw new IllegalArgumentException("参数错误");
        }
        int i = 0, originalLength = 0, newLength = 0, numberOfBlank = 0;
        while(str[i] != '\0') {
            originalLength++;
            if(str[i] == ' '){
                numberOfBlank++;
            }
        }
        newLength = originalLength + 2 * numberOfBlank;
        if(newLength > length){
            throw new IndexOutOfBoundsException("需要分配更多的内存");
        }
        int indexOfOriginal = originalLength, indexOfNew = newLength;
        while(indexOfNew > indexOfOriginal && indexOfOriginal >= 0){
            if(str[indexOfNew] == ' ') {
                str[indexOfNew--] = '0';
                str[indexOfNew--] = '2';
                str[indexOfNew--] = '%';
            }
            else {
                str[indexOfNew--] = str[indexOfOriginal];
            }
            indexOfOriginal--;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution1("We are happy."));
    }
}
