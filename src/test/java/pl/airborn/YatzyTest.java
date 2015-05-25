package pl.airborn;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class YatzyTest {

    @Test
    @Parameters(method = "chance")
    @TestCaseName("[{index}] chance of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void chance_scores_sum_of_all_dice(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).chance();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] chance() {
        return new Object[]{
                new Object[]{2, 3, 4, 5, 1, 15},
                new Object[]{3, 3, 4, 5, 1, 16}
        };
    }

    @Test
    @Parameters(method = "yatzy")
    @TestCaseName("[{index}] yatzy of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void yatzy_scores_50(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).yatzy();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] yatzy() {
        return new Object[]{
                new Object[]{4, 4, 4, 4, 4, 50},
                new Object[]{6, 6, 6, 6, 6, 50},
                new Object[]{6, 6, 6, 6, 3, 0}
        };
    }

    @Test
    @Parameters(method = "ones")
    @TestCaseName("[{index}] ones of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void test_1s(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).ones();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] ones() {
        return new Object[]{
                new Object[]{1, 2, 1, 4, 5, 2},
                new Object[]{6, 2, 2, 4, 5, 0},
                new Object[]{1, 2, 1, 1, 1, 4},
                new Object[]{1, 2, 3, 4, 5, 1}
        };
    }

    @Test
    @Parameters(method = "twos")
    @TestCaseName("[{index}] twos of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void test_2s(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).twos();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] twos() {
        return new Object[]{
                new Object[]{1, 2, 3, 2, 6, 4},
                new Object[]{2, 2, 2, 2, 2, 10}
        };
    }

    @Test
    @Parameters(method = "threes")
    @TestCaseName("[{index}] threes of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void test_threes(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).threes();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] threes() {
        return new Object[]{
                new Object[]{1, 2, 3, 2, 3, 6},
                new Object[]{2, 3, 3, 3, 3, 12}
        };
    }

    @Test
    @Parameters(method = "fours")
    @TestCaseName("[{index}] fours of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void fours_test(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).fours();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] fours() {
        return new Object[]{
                new Object[]{4, 4, 4, 5, 5, 12},
                new Object[]{4, 4, 5, 5, 5, 8},
                new Object[]{4, 5, 5, 5, 5, 4},
        };
    }

    @Test
    @Parameters(method = "fives")
    @TestCaseName("[{index}] fives of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void fives(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).fives();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] fives() {
        return new Object[]{
                new Object[]{4, 4, 4, 5, 5, 10},
                new Object[]{4, 4, 5, 5, 5, 15},
                new Object[]{4, 5, 5, 5, 5, 20},
        };
    }

    @Test
    @Parameters(method = "sixes")
    @TestCaseName("[{index}] sixes of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void sixes_test(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).sixes();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] sixes() {
        return new Object[]{
                new Object[]{4, 4, 4, 5, 5, 0},
                new Object[]{4, 4, 6, 5, 5, 6},
                new Object[]{6, 5, 6, 6, 5, 18},
        };
    }

    @Test
    @Parameters(method = "pair")
    @TestCaseName("[{index}] pair of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void one_pair(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = new Yatzy(d1, d2, d3, d4, d5).score_pair();
        assertThat(actual).isEqualTo(expected);
    }

    Object[] pair() {
        return new Object[]{
                new Object[]{3, 4, 3, 5, 6, 6},
                new Object[]{5, 3, 3, 3, 5, 10},
                new Object[]{5, 3, 6, 6, 5, 12},
        };
    }

    @Test
    @Parameters(method = "pairs")
    @TestCaseName("[{index}] pairs of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void two_pairs(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = Yatzy.two_pair(d1, d2, d3, d4, d5);
        assertThat(actual).isEqualTo(expected);
    }

    Object[] pairs() {
        return new Object[]{
                new Object[]{3, 3, 5, 4, 5, 16},
                new Object[]{3, 3, 5, 5, 5, 16},
        };
    }


    @Parameters(method = "three")
    @TestCaseName("[{index}] three of a kind of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void three_of_a_kind(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = Yatzy.three_of_a_kind(d1, d2, d3, d4, d5);
        assertThat(actual).isEqualTo(expected);
    }

    Object[] three() {
        return new Object[]{
                new Object[]{3, 3, 3, 4, 5, 9},
                new Object[]{3, 3, 3, 3, 5, 9},
                new Object[]{5, 3, 5, 4, 5, 15},
        };
    }


    @Test
    @Parameters(method = "four")
    @TestCaseName("[{index}] four of a kind of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void four_of_a_kind(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = Yatzy.four_of_a_kind(d1, d2, d3, d4, d5);
        assertThat(actual).isEqualTo(expected);
    }

    Object[] four() {
        return new Object[]{
                new Object[]{3, 3, 3, 3, 5, 12},
                new Object[]{5, 5, 5, 4, 5, 20},
                new Object[]{3, 3, 3, 3, 3, 12},
        };
    }

    @Test
    @Parameters(method = "small")
    @TestCaseName("[{index}] small straight of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void smallStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = Yatzy.smallStraight(d1, d2, d3, d4, d5);
        assertThat(actual).isEqualTo(expected);
    }

    Object[] small() {
        return new Object[]{
                new Object[]{1, 2, 3, 4, 5, 15},
                new Object[]{2, 3, 4, 5, 1, 15},
                new Object[]{1, 2, 2, 4, 5, 0}
        };
    }

    @Test
    @Parameters(method = "large")
    @TestCaseName("[{index}] large straight of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void largeStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = Yatzy.largeStraight(d1, d2, d3, d4, d5);
        assertThat(actual).isEqualTo(expected);
    }

    Object[] large() {
        return new Object[]{
                new Object[]{6, 2, 3, 4, 5, 20},
                new Object[]{2, 3, 4, 5, 6, 20},
                new Object[]{1, 2, 2, 4, 5, 0}
        };
    }

    @Test
    @Parameters(method = "full")
    @TestCaseName("[{index}] full house of({0}, {1}, {2}, {3}, {4}) is {5}")
    public void fullHouse(int d1, int d2, int d3, int d4, int d5, int expected) {
        int actual = Yatzy.fullHouse(d1, d2, d3, d4, d5);
        assertThat(actual).isEqualTo(expected);
    }

    Object[] full() {
        return new Object[]{
                new Object[]{6, 2, 2, 2, 6, 18},
                new Object[]{2, 3, 4, 5, 6, 0}
        };
    }
}