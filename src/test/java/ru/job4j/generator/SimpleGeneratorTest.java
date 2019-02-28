package ru.job4j.generator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    private final SimpleGenerator simpleGenerator = new SimpleGenerator();
    private final Map<String, String> map = new HashMap<>();

    @Test
    public void whenTakeTextWithSingleDataShouldReturnStringWithParam() {
        String text = "I am ${name}";
        map.put("name", "Nikolay");
        String result = simpleGenerator.generate(text, map);
        assertEquals("I am Nikolay", result);
    }

    @Test
    public void whenTakeTextWithTwoDataShouldReturnStringWithParams() {
        String text = "I am ${name}. Who are ${subject}?";
        map.put("name", "Nikolay");
        map.put("subject", "you");
        String result = simpleGenerator.generate(text, map);
        assertEquals("I am Nikolay. Who are you?", result);
    }

    @Test
    public void whenTakeTextWithSameDataShouldReturnStringWithSameParams() {
        String text = "Help, ${sos}, ${sos}, ${sos}";
        map.put("sos", "Aaaa");
        String result = simpleGenerator.generate(text, map);
        assertEquals("Help, Aaaa, Aaaa, Aaaa", result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenTakeEmptyParameterShouldGetException() {
        String text = "I am ${name}";
        simpleGenerator.generate(text, map);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifNoKeyForParameterShouldThrowException() {
        String text = "I am ${name}";
        map.put("sos", "Aaaa");
        simpleGenerator.generate(text, map);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifAreRedundantParamsShouldGetException() {
        String text = "I am ${name}";
        map.put("name", "Nikolay");
        map.put("sos", "Aaaa");
        simpleGenerator.generate(text, map);
    }

    @Test
    public void whenTakeNullStringShouldReturnNull() {
        map.put("name", "Nikolay");
        assertNull(simpleGenerator.generate(null, map));
    }
}