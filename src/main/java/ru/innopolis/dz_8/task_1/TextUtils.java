package ru.innopolis.dz_8.task_1;

/**
 * Вспомогательные утилиты для обработки текст
 */
public class TextUtils {
    public String quotesText(String str) {
        if ("false".equals(str) || "true".equals(str) || str.chars().allMatch(Character::isDigit)) {
            return str;
        }
        return "\"" + str + "\"";
    }

    public String removePrefix(String str) {
        if (str.startsWith("get")) {
            str = str.substring(3).toLowerCase();
        }
        if (str.startsWith("is")) {
            str = str.substring(2).toLowerCase();
        }
        return str;
    }

    public String removeComma(String str) {
        if (str.length() > 0) {
            if (",".equals(str.substring(str.length() - 1))) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public Object castText(String str) {
        Object object = str;
        if ("false".equals(str.toLowerCase()) || "true".equals(str.toLowerCase())) {
            return Boolean.parseBoolean(str);
        }
        if (!str.startsWith("\"") && str.indexOf(".") > 0) {
            return Double.parseDouble(str);
        }
        if (!str.startsWith("\"") && str.indexOf(".") == -1) {
            return Integer.parseInt(str);
        }
        return object;
    }
}