package service;

import com.luxoft.vowels.counter.entity.word.Word;
import com.luxoft.vowels.counter.service.AvgVowelsCounter;
import com.luxoft.vowels.counter.service.FileHandler;
import com.luxoft.vowels.counter.service.VowelsNumberCounter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

public class AvgVowelsCounterTest {

    private static final String PATH_TO_TEST_FILE = "src/test/resources/test2.txt";
    private static final List<String> EXPECTED_LIST = List.of("({a, e, o}, 10) -> 3", "({e, i, u}, 9) -> 4",
            "({a, e, o}, 7) -> 3", "({i, o}, 7) -> 3", "({e}, 5) -> 2", "({o}, 3) -> 1", "({i}, 2) -> 1",
            "({}, 1) -> 0");

    @Test
    public void shouldCountAvgVowelsNumPerWord() {
        final List<String> wordsToCountVowels = FileHandler.loadWordsFromFile(PATH_TO_TEST_FILE);
        final List<Word> vowelsAndTheirNumber = VowelsNumberCounter.countVowels(wordsToCountVowels);
        List<Word> avgVowelsPerWord = AvgVowelsCounter
                .countVowelsAverage(vowelsAndTheirNumber);
        List<String> actual = avgVowelsPerWord.stream()
                .map(Word::toString)
                .collect(Collectors.toList());
        Assertions.assertEquals(EXPECTED_LIST, actual);
    }
}
