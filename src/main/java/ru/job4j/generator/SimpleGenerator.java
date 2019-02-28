package ru.job4j.generator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleGenerator implements Template {

    @Override
    public String generate(String template, Map<String, String> map) {
        if (template == null) {
            return null;
        }
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException("Missing parameters");
        }
        StringBuilder result = new StringBuilder();
        Set<String> copyMapKeys = new HashSet<>();
        while (template.contains("${")) {
            String[] splitTemplate = template.split("\\$\\{", 2);
            result.append(splitTemplate[0]);
            splitTemplate = splitTemplate[1].split("}", 2);
            if (map.get(splitTemplate[0]) == null) {
                throw new IllegalArgumentException("no key for parameter " + splitTemplate[0]);
            }
            result.append(map.get(splitTemplate[0]));
            copyMapKeys.add(map.get(splitTemplate[0]));
            template = splitTemplate[1];
        }
        if (map.size() != copyMapKeys.size()) {
            throw new IllegalArgumentException("There are redundant parameters");
        }
        result.append(template);
        return result.toString();
    }
}
