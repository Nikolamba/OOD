package ru.job4j.generator;

import java.util.Map;

public interface Template {
    String generate(String template, Map<String, String> map);
}
