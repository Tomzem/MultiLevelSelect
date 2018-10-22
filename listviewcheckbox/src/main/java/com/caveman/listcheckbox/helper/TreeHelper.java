package com.caveman.listcheckbox.helper;

import com.caveman.listcheckbox.bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/22.
 * <p>
 * Description:
 */
public class TreeHelper {
    /**
     * 传入node  返回排序后的Node
     * 拿到用户传入的数据，转化为List<Node>以及设置Node间关系，然后根节点，从根往下遍历进行排序；
     *
     * @param datas
     * @param defaultExpandLevel 默认显示
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static List<Node> getSortedNodes(List<Node> datas, int defaultExpandLevel) {
        List<Node> result = new ArrayList<Node>();
        // 设置Node间父子关系
        List<Node> nodes = convetData2Node(datas);
        // 拿到根节点
        List<Node> rootNodes = getRootNodes(nodes);
        // 排序以及设置Node间关系
        for (Node node : rootNodes) {
            addNode(result, node, defaultExpandLevel, 1);
        }
        return result;
    }

    /**
     * 过滤出所有可见的Node
     * 过滤Node的代码很简单，遍历所有的Node，只要是根节点或者父节点是展开状态就添加返回
     *
     * @param nodes
     * @return
     */
    public static List<Node> filterVisibleNode(List<Node> nodes) {
        List<Node> result = new ArrayList<Node>();

        for (Node node : nodes) {
            // 如果为跟节点，或者上层目录为展开状态
            if (node.isRootNode() || node.isParentExpand()) {
                setNodeIcon(node);
                result.add(node);
            }
        }
        return result;
    }

    /**
     * 将我们的数据转化为树的节点
     * 设置Node间，父子关系;让每两个节点都比较一次，即可设置其中的关系
     */
    private static List<Node> convetData2Node(List<Node> nodes) {

        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node m = nodes.get(j);
                if (m.getPid() instanceof String) {
                    if (m.getPid().equals(n.getId())) { //n时m的父节点
                        n.getChildren().add(m);
                        m.setParent(n);
                    } else if (m.getId().equals(n.getPid())) { //m时n的父节点
                        m.getChildren().add(n);
                        n.setParent(m);
                    }
                } else {
                    if (m.getPid() == n.getId()) {
                        n.getChildren().add(m);
                        m.setParent(n);
                    } else if (m.getId() == n.getPid()) {
                        m.getChildren().add(n);
                        n.setParent(m);
                    }
                }
            }
        }
        return nodes;
    }

    /**
     * 获得根节点
     *
     * @param nodes
     * @return
     */
    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node.isRootNode())
                root.add(node);
        }
        return root;
    }

    /**
     * 把一个节点上的所有的内容都挂上去
     * 通过递归的方式，把一个节点上的所有的子节点等都按顺序放入
     */
    private static <T> void addNode(List<Node> nodes, Node<T> node, int defaultExpandLeval, int currentLevel) {
        nodes.add(node);
        if (defaultExpandLeval >= currentLevel) {
            node.setExpand(true);
        }

        if (node.isLeaf())
            return;
        for (int i = 0; i < node.getChildren().size(); i++) {
            addNode(nodes, node.getChildren().get(i), defaultExpandLeval, currentLevel + 1);
        }
    }

    /**
     * 设置节点的图标
     *
     * @param node
     */
    private static void setNodeIcon(Node node) {
        if (node.getChildren().size() > 0 && node.isExpand()) {
            node.setIcon(node.iconExpand);
        } else if (node.getChildren().size() > 0 && !node.isExpand()) {
            node.setIcon(node.iconNoExpand);
        } else {
            node.setIcon(-1);
        }
    }
}