package ru.innopolis.dz_8.task_1;

public class Passport {
    private int id;
    private String seria;
    private String nomer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    @Override
    public String toString() {
        return "\t\"passport\":" +
                "{" + "\n" +
                "\t\t\"id\":" + id + ",\n" +
                "\t\t\"seria\":" + "\"" + seria + "\"" + ",\n" +
                "\t\t\"nomer\":" + "\"" + nomer + "\"" + "\n" +
                "\t},\n";
    }
}