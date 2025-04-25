package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * _2942 -
 *
 * @param
 * @return
 * @throws
 */
public class _2942 {

    public List<Integer> findWordsContaining(String[] words, char x) {

       List<Integer> list = new ArrayList<>();

       for (int i  = 0 ; i<words.length;i++) {
           char[] chArray = words[i].toCharArray();

           for (int j = 0; j <chArray.length;j++) {
               if (chArray[j] ==x) {
                   list.add(i);
                   break;
               }
           }
       }
       return list;

    }

    public List<Integer> findWordsContaining1(String[] words, char x) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<words.length;i++) {
            if (words[i].indexOf(x)==-1) {
                list.add(i);
            }
        }
        return list;
    }
    public List<Integer> findWordsContaining2Lambda(String[] words, char x) {
        return  IntStream.range(0, words.length).filter(i->words[i].indexOf(x)!=-1).boxed().toList();
    }

    public static void main(String[] args) {
        _2942 object = new _2942();

        String[] words = {"leet","code"};
        char x = 'e';

        System.out.println(object.findWordsContaining2Lambda(words,x));




    }
}
