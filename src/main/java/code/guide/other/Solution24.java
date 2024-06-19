package code.guide.other;

/**
 * Created by zhenfei7 on 2024/6/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 数字的中文表达
 * 319 -> 三百一十九
 * 1014 -> 一千零十四
 * 7400741 -> 七百四十万零七百四十一
 */
public class Solution24 {
    public static void main(String[] args) {
//        char[] chars = new char[4];
//        chars[0] = '1';
//        System.out.println(String.valueOf(chars));

        System.out.println(getNumChiExp(319));
        System.out.println(getNumChiExp(1014));
        System.out.println(getNumChiExp(7400741));
    }

    public static String getNumChiExp(Integer num) {

        String numStr = String.valueOf(num);
        char[] oneUnitArr = null;
        char[] twoUnitArr = null;
        char[] threeUnitArr = null;
        if (numStr.length() > 8) {
            threeUnitArr = numStr.substring(numStr.length() - 4, numStr.length()).toCharArray();
            twoUnitArr = numStr.substring(numStr.length() - 8, numStr.length() - 4).toCharArray();
            oneUnitArr = numStr.substring(0, numStr.length() - 8).toCharArray();
        } else if (numStr.length() > 4) {
            threeUnitArr = numStr.substring(numStr.length() - 4, numStr.length()).toCharArray();
            twoUnitArr = numStr.substring(0, numStr.length() - 4).toCharArray();
        } else {
            threeUnitArr = numStr.substring(0, numStr.length()).toCharArray();
        }

        String numChiExp = "";
        if (oneUnitArr != null) {
            numChiExp = numChiExp + getNumUnitChiExp(oneUnitArr) + "亿";
        }
        if (twoUnitArr != null) {
            numChiExp = numChiExp + getNumUnitChiExp(twoUnitArr) + "万";
        }
        if (threeUnitArr != null) {
            numChiExp = numChiExp + getNumUnitChiExp(threeUnitArr);
        }

        return numChiExp;
    }

    public static String getNumUnitChiExp(char[] numUnitCharArr) {
        Map<String, String> numMap = new HashMap<>();
        numMap.put("0", "零");
        numMap.put("1", "一");
        numMap.put("2", "二");
        numMap.put("3", "三");
        numMap.put("4", "四");
        numMap.put("5", "五");
        numMap.put("6", "六");
        numMap.put("7", "七");
        numMap.put("8", "八");
        numMap.put("9", "九");

        if (numUnitCharArr == null || numUnitCharArr.length == 0) {
            return null;
        }

        String numUnitStr = "";

        if (numUnitCharArr.length > 0) {
            if (numUnitCharArr[numUnitCharArr.length - 1] == '0') {

            } else {
                numUnitStr = numMap.get(String.valueOf(numUnitCharArr[numUnitCharArr.length - 1]));

            }
        }

        if (numUnitCharArr.length > 1) {
            if (numUnitCharArr[numUnitCharArr.length - 2] == '0') {
                if (!numUnitStr.isEmpty() && numUnitCharArr[numUnitCharArr.length - 1] != '0') {
                    numUnitStr = "零" + numUnitStr;
                }
            } else {
                numUnitStr = numMap.get(String.valueOf(numUnitCharArr[numUnitCharArr.length - 2])) + "十" + numUnitStr;

            }
        }

        if (numUnitCharArr.length > 2) {
            if (numUnitCharArr[numUnitCharArr.length - 3] == '0') {
                if (!numUnitStr.isEmpty() && numUnitCharArr[numUnitCharArr.length - 2] != '0') {
                    numUnitStr = "零" + numUnitStr;
                }
            } else {
                numUnitStr = numMap.get(String.valueOf(numUnitCharArr[numUnitCharArr.length - 3])) + "百" + numUnitStr;

            }
        }

        if (numUnitCharArr.length > 3) {
            if (numUnitCharArr[numUnitCharArr.length - 4] == '0') {
                if (!numUnitStr.isEmpty() && numUnitCharArr[numUnitCharArr.length - 3] != '0') {
                    numUnitStr = "零" + numUnitStr;
                }
            } else {
                numUnitStr = numMap.get(String.valueOf(numUnitCharArr[numUnitCharArr.length - 4])) + "千" + numUnitStr;
            }
        }

        return numUnitStr;
    }

}
