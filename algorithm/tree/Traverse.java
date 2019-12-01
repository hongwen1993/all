package com.kagura.tree;

import static java.lang.System.*;
import org.junit.Test;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/30
 * @since 1.0.0
 */
public class Traverse {


    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public void printNode(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
        }

    }

    /**
     * 先序递归
     * （找到根，先记录根）
     *
     * @param node 根节点
     */
    public void perOrder(Node node) {
        if (node == null) {
            return;
        }
        printNode(node);
        perOrder(node.left);
        perOrder(node.right);
    }

    /**
     * 中序递归
     * （先记录根的所有左子）
     *
     * @param node 根节点
     */
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        printNode(node);
        inOrder(node.right);
    }

    /**
     * 后序递归
     * （先记录根的所有子节点）
     *
     * @param node 根节点
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        printNode(node);
    }

    public Node getTree() {
        Node node7 = new Node(7, null, null);
        Node node9 = new Node(9, null, null);
        Node node8 = new Node(8, node7, node9);
        Node node3 = new Node(3, null, null);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, node3, node5);
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, node1, node4);
        return new Node(6, node2, node8);
    }

    @Test
    public void traverse01() {
        // 前序 6 2 1 4 3 5 8 7 9 根左右
        System.out.println("先序遍历");
        perOrder(getTree());
        // 中序 1 2 3 4 5 6 7 8 9 左根右
        System.out.println("\n中序遍历");
        inOrder(getTree());
        // 后序 1 3 5 4 2 7 9 8 6 左右根
        System.out.println("\n后序遍历");
        postOrder(getTree());

    }

    @Test
    public void morris() {
        // Morris Traverse
        morrisInorderTraverse(getTree());
    }




    private void morrisInorderTraverse(Node root) {
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                // 如果没有左子，直接走右子
                out.println(cur);
                cur = cur.right;
            } else {
                Node pre = cur.left;
                // 用来遍历到最右
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == cur) {
                    // 意味着前驱节点的右节点已被设置，该次遍历为回溯
                    // 左边已经搞定，接下来需要处理右边
                    pre.right = null;
                    out.println(cur + " 线索回归打印");
                    cur = cur.right;
                } else {
                    // 第一次访问该前驱节点，设置线索，即右节点为当前节点
                    pre.right = cur;
                    out.println(String.format("%s 设置线索(%s)", cur, pre));
                    cur = cur.left;
                }
            }
        }
    }


}
