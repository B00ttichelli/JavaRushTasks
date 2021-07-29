package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд

Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Requirements:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать статический класс Word.
3. Класс Solution не должен содержать статические поля.
4. Метод detectAllWords должен быть статическим.
5. Метод detectAllWords должен быть публичным.
6. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same");
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }



    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();
        List<Integer> first = null;
        List<Integer> last = null;
        Word word = null;

        for (int w = 0; w < words.length; w++) {
            int k = 0, m = 0;
            word = new Word(words[w]);
            first = new ArrayList<>();
            last = new ArrayList<>();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == words[w].charAt(0)) {
                        first.add(j);
                        first.add(i);
                    }
                    if (crossword[i][j] == words[w].charAt(words[w].length() - 1)) {
                        last.add(j);
                        last.add(i);
                    }
                }
            }
            StringBuilder temp = null;
            for (int f = 0; f < first.size() - 1; f += 2) {
                for (int e = 0; e < last.size() - 1; e += 2) {

                    if ((first.get(f) - last.get(e)) % (words[w].length() - 1) == 0 && (first.get(f + 1) - last.get(e + 1)) % (words[w].length() - 1) == 0) {
                        k = (first.get(f) - last.get(e)) / (words[w].length() - 1);
                        m = (first.get(f + 1) - last.get(e + 1)) / (words[w].length() - 1);
                        temp = new StringBuilder();
                        temp.append(words[w].charAt(0));
                        for (int i = 1; i < words[w].length() - 1; i++) {

                            if (words[w].charAt(i) != crossword[first.get(f + 1) - m][first.get(f) - k]) {
                                break;
                            } else {
                                if (m < 0) m--;
                                else if (m > 0) m++;
                                if (k < 0) k--;
                                else if (k > 0) k++;
                                temp.append(words[w].charAt(i));
                            }
                        }
                        temp.append(words[w].charAt(words[w].length() - 1));

                        if (words[w].equals(temp.toString())) {
                            word.setStartPoint(first.get(f), first.get(f + 1));
                            word.setEndPoint(last.get(e), last.get(e + 1));
                            wordList.add(word);
                        }
                    }
                }
            }
        }


        return wordList;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
