package pers.wc.leetcode;

import java.util.*;

public class T0648 {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("catt");
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }


    /**
     * 单词替换
     *
     * @param dictionary 一个由许多词根组成的词典
     * @param sentence   一个由空格分割单词形成的句子
     * @return 返回有词根替换后形成的新句子，如果有多个词根，使用最短的词根替换。
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String root : dictionary) {
                if (words[i].startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
