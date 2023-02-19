package tests.api;

import models.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MatchersTest {

    @Test
    public void twoStringsTest() {
        String a = "foo";
        String b = "foo";

        assertThat(a, equalTo(b));
    }

    @Test
    public void givenCollection_whenEmpty_thenCorrect() {
        List <String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void givenCollection_whenCheckSize_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collection", "beans", "text", "number");
        assertThat(hamcrestMatchers, hasSize(4));
    }



}
