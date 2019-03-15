package ru.job4j.generator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс обработки входных строк с ключами
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class SimpleGenerator implements Template {
    private int useMapCount;
    private final Pattern pattern;

    public SimpleGenerator() {
        this.pattern = Pattern.compile("\\$\\{[A-zA-Z0-9]+}");
    }

    /**
     * Функция производит замену всех ключей вида ${...} на ключи
     * из Map<String, String> map
     * @param template входящая строка с ключами
     * @param map набор ключей для замены
     * @return возвращает новую строку с изменныхми ключами
     */
    @Override
    public String generate(String template, Map<String, String> map) {
        if (template  == null || map == null || map.size() == 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        Matcher matcher = pattern.matcher(template);

        int start, end = 0;
        while (matcher.find()) {
            start = matcher.start();
            sb.append(template, end, start);
            sb.append(getValue(matcher.group(), map));
            end = matcher.end();
        }
        if (map.size() > useMapCount) {
            throw new IllegalArgumentException("Redundant parameters");
        }
        sb.append(template, end, template.length());
        return sb.toString();
    }

    private String getValue(String target, Map<String, String> map) {
        String key = target.substring(2, target.length() - 1);
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Missing parameter");
        }
        useMapCount++;
        return map.get(key);
    }
}
