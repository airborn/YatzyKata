package pl.airborn;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import static java.util.Map.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Yatzy {

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int chance() {
        return IntStream.of(dice).sum();
    }

    public int yatzy() {
        return IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .values().stream()
                .filter(size -> size == 5)
                .map(s -> 50)
                .findFirst().orElse(0);
    }

    public int ones() {
        return countOccurrences(1);
    }

    public int twos() {
        return countOccurrences(2);
    }

    public int threes() {
        return countOccurrences(3);
    }


    public int fours() {
        return countOccurrences(4);
    }

    public int fives() {
        return countOccurrences(5);
    }

    public int sixes() {
        return countOccurrences(6);
    }

    private int countOccurrences(int occurrenceOf) {
        return IntStream.of(dice).filter(i -> i == occurrenceOf).sum();
    }

    public int score_pair() {
        int[] counts = new int[6];
        counts[dice[0] - 1]++;
        counts[dice[1] - 1]++;
        counts[dice[2] - 1]++;
        counts[dice[3] - 1]++;
        counts[dice[4] - 1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public int two_pair() {
        int[] counts = new int[6];
        counts[dice[0] - 1]++;
        counts[dice[1] - 1]++;
        counts[dice[2] - 1]++;
        counts[dice[3] - 1]++;
        counts[dice[4] - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int four_of_a_kind() {
        return IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(en -> en.getValue() >= 4)
                .findFirst()
                .map(Entry::getKey)
                .map(k -> 4 * k)
                .orElse(0);
    }

    public int three_of_a_kind() {
        return IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(en -> en.getValue() >= 3)
                .findFirst()
                .map(Entry::getKey)
                .map(k -> 3 * k)
                .orElse(0);
    }

    public int smallStraight() {
        int sum = IntStream.of(dice).distinct().sum();
        if (sum == 15) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int sum = IntStream.of(dice).distinct().sum();
        if (sum == 20) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[dice[0] - 1] += 1;
        tallies[dice[1] - 1] += 1;
        tallies[dice[2] - 1] += 1;
        tallies[dice[3] - 1] += 1;
        tallies[dice[4] - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}