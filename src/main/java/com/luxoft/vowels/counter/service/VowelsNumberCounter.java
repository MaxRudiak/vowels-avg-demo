package com.luxoft.vowels.counter.service;

import com.luxoft.vowels.counter.entity.word.Word;

import java.util.LinkedList;
import java.util.List;

public class VowelsNumberCounter {

    public static List<Word> countVowels(final List<String> wordsToCountVowels) {
        final List<Word> vowelsAndTheirNumber = new LinkedList<>();
        for (String word : wordsToCountVowels) {
            Word countedVowels = new Word(word.length());
            int vowelsCount = 0;
            for (char c : word.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    countedVowels.add(c, ++vowelsCount);
                }
            }
            vowelsAndTheirNumber.add(countedVowels);
        }
        return vowelsAndTheirNumber;
    }
}
