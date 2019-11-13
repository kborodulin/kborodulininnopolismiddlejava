package ru.innopolis.dz_3.task_1;

public class ServiceNumber {
    /**
     * Делитель по типам
     */
    public static Number checkNumber(Number number, Number divider) {
        if (number instanceof Double) {
            return number.doubleValue() / divider.doubleValue();
        }
        if (number instanceof Long) {
            return number.longValue() / divider.longValue();
        }
        if (number instanceof Integer) {
            return number.intValue() / divider.intValue();
        }

        if (number instanceof Byte) {
            return number.byteValue() / divider.byteValue();
        }

        if (number instanceof Float) {
            return number.floatValue() / divider.floatValue();
        }

        if (number instanceof Short) {
            return number.shortValue() / divider.shortValue();
        }

        return 0;
    }
}