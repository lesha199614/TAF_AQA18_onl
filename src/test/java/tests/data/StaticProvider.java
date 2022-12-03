package tests.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataFotSumTest")
    public static Object[][] dataForSumTest() {
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }

    @DataProvider(name = "dataForDivTest")
    public static Object[][] dataForDivTest() {
        return new Object[][]{
                {1, 1, 1},
                {6, 3, 2},
                {-6, 3, -2},
                {-6, -3, 2},
                {6, -3, -2},
                {10, 4, 2.5},
                {-10, 4, -2.5},
                {10, -4, -2.5},
                {10.2, 2, 5.1},
                {10, 2.5, 4},
                {5.5, 2.2, 2.5},
                {1, 0.5, 2},
                {1, -0.5, -2},
                {0, 0, Double.NaN},
                {1, 0, Double.POSITIVE_INFINITY},
                {-1, 0, Double.NEGATIVE_INFINITY}
        };
    }
}
