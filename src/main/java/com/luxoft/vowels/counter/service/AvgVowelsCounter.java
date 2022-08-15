package com.luxoft.vowels.counter.service;

import com.luxoft.vowels.counter.entity.word.Word;
import com.luxoft.vowels.counter.entity.word.WordComparator;

import java.util.LinkedList;
import java.util.List;

public class AvgVowelsCounter {

    public static List<Word> countVowelsAverage(final List<Word> vowelsAndTheirNumber) {
        final List<Word> vowelsAvgNumber = new LinkedList<>();
        for (Word word : vowelsAndTheirNumber) {
            if (vowelsAvgNumber.contains(word)) {
                for (Word vowels : vowelsAvgNumber) {
                    if (vowels.equals(word)) {
                        vowels.addCounter();
                        vowels.addVowelsNumber(word.getVowelsNumber());
                        break;
                    }
                }
            } else {
                vowelsAvgNumber.add(word);
            }
        }
        vowelsAvgNumber.sort(new WordComparator());
        return vowelsAvgNumber;
    }
}
