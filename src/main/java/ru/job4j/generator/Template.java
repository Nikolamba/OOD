package ru.job4j.generator;

import java.util.Map;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface Template {
    String generate(String template, Map<String, String> map);
}
