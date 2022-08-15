package com.luxoft.vowels.counter.service;

import com.luxoft.vowels.counter.entity.word.Word;
import com.luxoft.vowels.counter.exception.VowelsCounterException;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {

    public static List<String> loadWordsFromFile(final String pathToFile) {
        validatePathToFile(pathToFile);
        final List<String> wordsToCountVowels;
        try (final BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            wordsToCountVowels = br.lines()
                    .flatMap(s -> Arrays.stream(s.split("[^a-zA-Z0-9\\-'_]")))
                    .filter(s -> s.matches("^[a-zA-Z0-9\\-'_]+$"))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new VowelsCounterException("This file doesn't exist!");
        } catch (IOException e) {
            throw new VowelsCounterException("Exception related to input has happened!");
        }
        return wordsToCountVowels;
    }

    public static void writeReportToFile(final List<Word> vowelAvgNumber) {
        try (final PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
            for (Word string : vowelAvgNumber) {
                writer.println(string);
            }
        } catch (FileNotFoundException e) {
            throw new VowelsCounterException("Can't create such file!");
        } catch (UnsupportedEncodingException e) {
            throw new VowelsCounterException("Named charset is not supported");
        }
    }

    private static void validatePathToFile(final String pathToFile) {
        if (StringUtils.isEmpty(pathToFile)) {
            throw new VowelsCounterException("Path to file should exist and should be specified!");
        }
    }
}
