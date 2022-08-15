package service;

import com.luxoft.vowels.counter.entity.word.Word;
import com.luxoft.vowels.counter.exception.VowelsCounterException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.luxoft.vowels.counter.service.FileHandler.*;

class FileHandlerTest {

    private static final String PATH_TO_TEST_FILE = "src/test/resources/test.txt";
    private static final String INCORRECT_PATH_TO_FILE = "src/test/resources/non-existent.txt";
    private static final List<String> EXPECTED_WORD_OUTPUT = List
            .of("platon", "made", "bamboo", "boats");

    @Test
    public void shouldCorrectlyLoadWordsFromFile() {
        final List<String> actualOutput = loadWordsFromFile(PATH_TO_TEST_FILE);
        Assertions.assertEquals(EXPECTED_WORD_OUTPUT, actualOutput);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWithNullAndEmptyPathToFile(String pathToFile) {
        final String expectedMessage = "Path to file should exist and should be specified!";
        final Throwable nullPath = Assertions.assertThrows(VowelsCounterException.class,
                () -> loadWordsFromFile(pathToFile));
        Assertions.assertEquals(expectedMessage, nullPath.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", INCORRECT_PATH_TO_FILE})
    void shouldThrowExceptionWithIncorrectPathToFile(String pathToFile) {
        final String expectedMessage = "This file doesn't exist!";
        final Throwable incorrectPath = Assertions.assertThrows(VowelsCounterException.class,
                () -> loadWordsFromFile(pathToFile));
        Assertions.assertEquals(expectedMessage, incorrectPath.getMessage());
    }

    @Test
    public void shouldWriteReportToFile() throws IOException {
        final Word testWord = new Word(new HashSet<>(Arrays.asList('a', 'e')),
                2, 2,1  );
        writeReportToFile(List.of(testWord));
        String expected = readFile("output.txt").get(0);
        Assertions.assertEquals(expected, testWord.toString());

    }

    private List<String> readFile (String path) throws IOException {
        return Files.lines((Paths.get(path)))
                .map(String::toString)
                .collect(Collectors.toList());
    }
}
