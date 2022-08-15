package com.luxoft.vowels.counter;

import com.luxoft.vowels.counter.entity.word.Word;
import com.luxoft.vowels.counter.service.AvgVowelsCounter;
import com.luxoft.vowels.counter.service.FileHandler;
import com.luxoft.vowels.counter.service.VowelsNumberCounter;

import java.util.List;

public class Application {

    private static final String PATH_TO_SOURCE_FILE = "src/main/resources/input.txt";

    public static void main(String[] args) {
        List<String> wordsToCountVowels = FileHandler.loadWordsFromFile(PATH_TO_SOURCE_FILE);
        List<Word> vowelsAndTheirNumber = VowelsNumberCounter.countVowels(wordsToCountVowels);
        List<Word> vowelsAvgNumber = AvgVowelsCounter.countVowelsAverage(vowelsAndTheirNumber);
        FileHandler.writeReportToFile(vowelsAvgNumber);
    }
}
