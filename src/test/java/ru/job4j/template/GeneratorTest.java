package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Ignore
    public void whenTemplateAndMapWithTwoKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you");
        Generator generator = new StringGenerator();
        assertThat("I am a Petr Arsentev, Who are you?", is(generator.produce(template, map)));
    }

    @Ignore
    public void whenTemplateWithKeysWhichMapNotContains() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("No keys in map");
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Petr Arsentev");
        Generator generator = new StringGenerator();
        generator.produce(template, map);
    }

    @Ignore
    public void whenMapHasExcessKeys() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Map has excess keys");
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "language", "java");
        Generator generator = new StringGenerator();
        generator.produce(template, map);
    }
}