package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {


    @Test
    public void test1() {
        System.out.println("Это мой 1_1 тест");
    }

    @Test
    public void test2() {
        System.out.println("Это мой 1_2 тест");
    }
}
