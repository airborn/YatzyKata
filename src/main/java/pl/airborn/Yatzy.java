package pl.airborn;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Map.Entry;
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
        return IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(en -> en.getValue() >= 2)
                .map(Entry::getKey)
                .max(Integer::compare)
                .map(v -> 2 * v)
                .orElse(0);
    }

    public int two_pair() {
        IntSummaryStatistics statistics = IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(en -> en.getValue() >= 2)
                .map(Entry::getKey)
                .mapToInt(v -> 2 * v)
                .summaryStatistics();
        if (statistics.getCount() == 2) {
            return (int) statistics.getSum();
        } else {
            return 0;
        }
    }

    public int four_of_a_kind() {
        return ofAKind(4);
    }

    public int three_of_a_kind() {
        return ofAKind(3);
    }

    private Integer ofAKind(int kind) {
        return IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(en -> en.getValue() >= kind)
                .findFirst()
                .map(Entry::getKey)
                .map(k -> kind * k)
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
        List<Integer> duplicates = IntStream.of(dice).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(en -> en.getValue() >= 2)
                .map(e -> e.getKey() * e.getValue().intValue())
                .collect(toList());
        if (duplicates.size() == 2) {
            return duplicates.stream()
                    .collect(summingInt(i -> i));
        } else {
            return 0;
        }
    }
}