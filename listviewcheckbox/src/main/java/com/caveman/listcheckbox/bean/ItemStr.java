package com.caveman.listcheckbox.bean;

/**
 * Created by Administrator on 2018/11/14.
 * <p>
 * Description:
 */
public class ItemStr {

    private String  id;
    private String pid;
    private String name;

    public ItemStr(String id, String pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public ItemStr() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
