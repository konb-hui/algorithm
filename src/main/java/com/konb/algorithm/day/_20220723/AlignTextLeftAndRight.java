package com.konb.algorithm.day._20220723;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-23 15:13
 * leetcode 68 文本左右对齐
 */
public class AlignTextLeftAndRight {

    public List<String> fullJustify(String[] words, int maxWidth) {

        int i = 0;
        int length = 0;
        int start = i;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();

        while (i < words.length) {
            int l = words[i].length();
            if (length == 0) {
                start = i;
                length += l;
            } else {
                length += l + 1;
            }

            if (length > maxWidth) {
                int wordLength = length - l - (i - start - 1);
                int blankLength = maxWidth - wordLength;
                i --;
                int wordNum = i - start;

                int average = blankLength / wordNum;
                int more = blankLength % wordNum;

                for (int a = start; a < i; a ++) {
                    stringBuilder.append(words[a]);
                    for (int b = 0; b < average; b ++) {
                        stringBuilder.append(" ");
                    }

                    if (more > 0) {
                        stringBuilder.append(" ");
                        more --;
                    }
                }
                stringBuilder.append(words[i]);
                result.add(stringBuilder.toString());
                length = 0;
                stringBuilder = new StringBuilder();

                continue;

            }

            if (i == words.length - 1) {
                int wordLength = length - l - (i - start);
                int blankLength = maxWidth - wordLength;
                int wordNum = i - start;

                int average = blankLength / wordNum;
                int more = blankLength % wordNum;

                for (int a = start; a < i; a ++) {
                    stringBuilder.append(words[a]);
                    for (int b = 0; b < average; b ++) {
                        stringBuilder.append(" ");
                    }

                    if (more > 0) {
                        stringBuilder.append(" ");
                        more --;
                    }
                }
                stringBuilder.append(words[i]);
                result.add(stringBuilder.toString());
                length = 0;
            }
            i ++;
        }

        return result;
    }

    public static void main(String[] args) {
        AlignTextLeftAndRight alignTextLeftAndRight = new AlignTextLeftAndRight();
        List<String> list = alignTextLeftAndRight.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16);

        for (String s : list) {
            System.out.println(s);
        }
    }

}
