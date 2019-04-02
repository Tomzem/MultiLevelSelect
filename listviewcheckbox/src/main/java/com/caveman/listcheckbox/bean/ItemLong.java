package com.caveman.listcheckbox.bean;

/**
 * Created by Administrator on 2018/11/14.
 * <p>
 * Description:
 */
public class ItemLong {

    private Long id;
    private Long pid;
    private String name;

    public ItemLong() {
    }

    public ItemLong(Long id, Long pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
