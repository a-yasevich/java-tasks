package ru.mail.polis.homework.collections.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание оценивается в 2 балла.
 * Одна из самых популярных задач.
 * Наша структура хранит обрывки слов. Надо реализовать метод positionPartString
 * который вернет: позиции где находятся подстроки, из которых можно составить
 * переданное слово. Так же известно что слова, которые писались в структуру, изначально
 * делились пополам для записи в нее.
 * Отрабатывать метод должен за О(n).
 */
public class SearchInTheShredderList {
    private List<String> partStrings = new ArrayList<>();

    public SearchInTheShredderList() {
    }

    public SearchInTheShredderList(List<String> partStrings) {
        this.partStrings = partStrings;
    }

    public void add(String value) {
        partStrings.add(value);
    }

    public String get(int index) {
        return partStrings.get(index);
    }

    /**
     * Ищем позиции подстрок из которых можно составить передаваемое слово
     *
     * @param value - передаваемоей слово
     * @return - либо массив с реальными позициями подстрок если нашли, либо - null
     */
    public int[] positionPartString(String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        String part1 = value.substring(0, value.length() / 2 - 1);
        String part2 = value.substring(value.length() / 2 - 1);
        int part1Address = -1;
        int part2Address = -1;
        for (int i = 0; i < partStrings.size(); i++) {
            String part = partStrings.get(i);
            if (part.equals(part1)) {
                part1Address = i;
            }
            if (part2.equals(part)) {
                part2Address = i;
            }
            if (part1Address != -1 && part2Address != -1) {
                return new int[]{part1Address, part2Address};
            }
        }
        return null;
    }
}
