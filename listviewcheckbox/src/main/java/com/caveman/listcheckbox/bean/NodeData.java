package com.caveman.listcheckbox.bean;


/**
 * Created by Administrator on 2018/10/22.
 * <p>
 * Description: 每个节点的具体数据
 */
public class NodeData {

    private int id;

    private String name;

    public NodeData(){
    }

    public NodeData(String name) {
        this.name = name;
    }

    public NodeData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
