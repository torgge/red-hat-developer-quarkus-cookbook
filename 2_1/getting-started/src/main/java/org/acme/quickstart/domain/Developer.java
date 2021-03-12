package org.acme.quickstart.domain;

public class Developer {
    static long counter = 1;
    private long id;
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public Developer() {
    }

    public static long getCounter() {
        return counter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void persist() {
        this.id = counter++;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
