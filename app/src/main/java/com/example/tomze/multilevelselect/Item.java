package com.example.tomze.multilevelselect;

public class Item {
    private int id;
    private int pid;
    private String name;

    public Item(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
