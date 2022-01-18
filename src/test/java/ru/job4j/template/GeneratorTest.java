package ru.job4j.template;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    /*
    @Test
    public void whenTemplateAndMapWithTwoKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you");
        Generator generator = new StringGenerator();
        assertThat("I am a Petr Arsentev, Who are you?", is(generator.produce(template, map)));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTemplateWithKeysWhichMapNotContains() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Petr Arsentev");
        Generator generator = new StringGenerator();
        generator.produce(template, map);
    }

    @Test(expected = IllegalStateException.class)
    public void whenMapHasExcessKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "language", "java");
        Generator generator = new StringGenerator();
        generator.produce(template, map);
    }
    */
}