package ru.innopolis.dz_8.task_1;

public class Json {
    private StringBuilder builder = new StringBuilder();
    private int count;

    public StringBuilder getBuilder() {
        return builder;
    }

    public void jsonFormatUnload(String str) {
        if (builder.length() == 0) {
            builder.append("{}");
        }

        if (count == 0) {
            builder.insert(builder.length() - 1, quotesText(str) + ":");
        } else if (count % 2 == 0 && count != 0) {
            builder.insert(builder.length() - 1, "," + quotesText(str) + ":");
        } else {
            builder.insert(builder.length() - 1, quotesText(str));
        }

        count++;
    }

    public String quotesText(String str) {
        if ("false".equals(str) || "true".equals(str) || str.chars().allMatch(Character::isDigit)) {
            return str;
        }
        return "\"" + str + "\"";
    }
}