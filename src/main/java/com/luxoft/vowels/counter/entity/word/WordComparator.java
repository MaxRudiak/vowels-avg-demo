package com.luxoft.vowels.counter.entity.word;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

    @Override
    public int compare(final Word o1, final Word o2) {
        if (o2.wordChars.size() - o1.wordChars.size() == 0) {
            return o2.wordLength - o1.wordLength;
        } return o2.wordChars.size() - o1.wordChars.size();
    }
}
