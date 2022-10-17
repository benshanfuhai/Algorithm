package pers.wc.leetcode;

public class T0006 {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    /**
     * Z字形变换
     *
     * @param s       待转换字符串
     * @param numRows Z字形结构行数
     * @return 通过Z字形转换后的字符串
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // 存放每一行的数据
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }

        int index = 0;
        int curRow = 0;

        int len = s.length();
        while (index < len) {
            while (index < len && curRow < numRows) {
                char ch = s.charAt(index);
                res[curRow].append(ch);
                index++;
                curRow++;
            }

            // 字符串长度可能无法构成完整Z字形
            if (index == len) {
                break;
            }
            //curRow = numRow，到达最后一行，开始往上移动
            curRow = numRows - 2;

            while (index < len && curRow >= 0) {
                char ch = s.charAt(index);
                res[curRow].append(ch);
                index++;
                curRow--;
            }

            // curRow < 0，开始往下移动
            curRow += 2;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(res[i]);
        }

        return ans.toString();
    }
}
