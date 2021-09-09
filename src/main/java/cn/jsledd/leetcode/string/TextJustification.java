package cn.jsledd.leetcode.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @version 1.0
 * @ClassName : TextJustification
 * @Description : 68. 文本左右对齐
 * @Author : JSLEDD
 * @Date: 2021-09-10 07:30
 */
public class TextJustification {
    public static void main(String[] args) {
        //String[] words = {"What","must","be","acknowledgment","shall","be"};
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
        "to","a","computer.","Art","is","everything","else","we","do","everything","else"};
        int maxWidth = 20;
        new TextJustification().fullJustify(words, maxWidth).forEach(System.out::println);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int currlength = 0;
        Queue<String> q = new ArrayDeque<>();
        StringBuilder db = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            if (currlength + length> maxWidth) {
                //不是末行，只有一个单词
                if(q.size() ==1){
                    db.append(q.poll());
                    while (currlength <= maxWidth) {
                        db.append(" ");
                        currlength++;
                    }
                }
                else {
                    //不是末行，多个单次单词
                    int kong = maxWidth - currlength + 1;
                    int morekong = kong % (q.size() - 1);
                    int avgkong = kong / (q.size() - 1);

                    while (!q.isEmpty()) {
                        db.append(q.poll());
                        int kongcount = avgkong;
                        if (morekong > 0) {
                            kongcount = avgkong + 1;
                            morekong--;
                        }
                        if (!q.isEmpty()) {
                            db.append(" ");
                        }
                        for (int k = 0; k < kongcount && !q.isEmpty(); k++) {
                            db.append(" ");
                        }
                    }
                }
                list.add(db.toString());
                db = new StringBuilder();
                currlength = 0;
            }
            currlength += length;
            currlength++;
            q.offer(words[i]);
        }
        while (!q.isEmpty()) {
            db.append(q.poll());
            if(q.isEmpty()){
                currlength --;
            }
            else{
                db.append(" ");
            }
        }
        while (currlength < maxWidth) {
            db.append(" ");
            currlength++;
        }
        list.add(db.toString());

        return list;
    }
}
