package ru.kborodulin.dz_2.task_1;

public class SimulateError {
    /**
     * NullPointerException
     */
    public void npe() {
        String s = null;
        s.toString();
    }

    /**
     * ArrayIndexOutOfBoundsException
     */
    public void arrIndexBoundException() {
        int arr[] = new int[1];
        arr[10] = 10;
    }

    /**
     * Cвой вариант ошибки через оператор throw
     */
    public void myException() {
        try {
            throw new Exception("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}