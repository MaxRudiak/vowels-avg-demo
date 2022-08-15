package service;

import com.luxoft.vowels.counter.entity.word.Word;
import com.luxoft.vowels.counter.service.FileHandler;
import com.luxoft.vowels.counter.service.VowelsNumberCounter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

public class VowelsNumberCounterTest {

    private static final String PATH_TO_TEST_FILE = "src/test/resources/test2.txt";
    private static final List<String> EXPECTED_LIST = List.of("({e}, 5) -> 2", "({i}, 2) -> 1",
            "({a, e, o}, 7) -> 3", "({e, i, u}, 9) -> 4", "({o}, 3) -> 1", "({e}, 5) -> 2",
            "({a, e, o}, 10) -> 3", "({}, 1) -> 0", "({i, o}, 7) -> 3");

    @Test
    public void shouldCountNumberOfVowelsInEachWord() {
        List<Word> vowelsWithNumbers = VowelsNumberCounter
                .countVowels(FileHandler.loadWordsFromFile(PATH_TO_TEST_FILE));
        List<String> actual = vowelsWithNumbers.stream()
                .map(Word::toString)
                .collect(Collectors.toList());
        Assertions.assertEquals(EXPECTED_LIST, actual);
    }
}
