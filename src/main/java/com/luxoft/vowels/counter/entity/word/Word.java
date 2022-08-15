package com.luxoft.vowels.counter.entity.word;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@AllArgsConstructor
@Getter
public class Word {
    protected Set<Character> wordChars = new TreeSet<>();
    protected final int wordLength;
    private int vowelsNumber;
    private int counter = 1;

    public Word(int wordLength) {
        this.wordLength = wordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return wordLength == word.wordLength && Objects.equals(wordChars, word.wordChars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordChars, wordLength);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Character> iterator = wordChars.iterator();

        sb.append("(");
        if (!iterator.hasNext()) {
            sb.append("{}");
        } else {
            sb.append("{");
            while (iterator.hasNext()) {
                sb.append(iterator.next());
                if (!iterator.hasNext()){
                    sb.append("}");
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(", " + wordLength + ") -> ")
                .append(new DecimalFormat("#.##").format((double) vowelsNumber / counter));

        return sb.toString();
    }


    public void add(char c, int vowelsNumber) {
        wordChars.add(c);
        this.vowelsNumber = vowelsNumber;
    }

    public void addCounter() {
        this.counter += counter;
    }

    public void addVowelsNumber(int vowelsNumber) {
        this.vowelsNumber += vowelsNumber;
    }
}
