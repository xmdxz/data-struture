package com.struture.tree.application;

import com.struture.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;


/**
 * @Author xpdxz
 * @ClassName HuffmanTree
 * @Description TODO
 * @Date 2022/1/16 12:23
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] array = ArrayUtil.initArray(100, 1000);
        System.out.println(Arrays.toString(array));
        Node initializeHuffmanTree = initializeHuffmanTree(array);
        infixOrder(initializeHuffmanTree);
        System.out.println("=================");
        hierarchicalTraversal(initializeHuffmanTree);
        System.out.println("wpl:" + minWpl(initializeHuffmanTree));
    }

    /**
     * 初始化霍夫曼树
     * 基本思路：
     * 使用一个数组进行遍历排序
     *
     * @param array
     * @return
     */
    public static Node initializeHuffmanTree(int[] array) {
        int index = 1;
        Node[] nodes = new Node[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = new Node(array[i]);
        }
        Comparator<Node> comparator = Comparator.comparingInt(k -> k.value);
        while (index <= array.length - 1) {
            Arrays.sort(nodes, index - 1, array.length, comparator);
            Node node = new Node(nodes[index - 1].value + nodes[index].value, nodes[index - 1], nodes[index]);
            nodes[index] = node;
            index++;
        }
        return nodes[array.length - 1];
    }

    public static int minWpl(Node root) {
        if (root == null) {
            System.out.println("二叉树为空");
        }
        int wpl = 0;
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.addLast(root);
        for (int i = 0, num = 1; num > 0; i++) {
            int instead = num;
            num = 0;
            for (int j = 0; j < instead; j++) {
                Node node = nodes.removeFirst();
                if (node.left != null) {
                    nodes.addLast(node.left);
                    num++;
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                    num++;
                }
                if (node.left == null && node.right == null) {
                    System.out.println(node.value + "->" + i);
                    wpl += node.value * i;
                }
            }
        }
        return wpl;
    }

    public static void hierarchicalTraversal(Node root) {
        if (root == null) {
            System.out.println("二叉树为空");
        }
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.addLast(root);
        for (int i = 1, num = 1; num > 0; i++) {
            System.out.print("第" + i + "层:");
            int instead = num;
            num = 0;
            for (int j = 0; j < instead; j++) {
                Node node = nodes.removeFirst();
                System.out.print(node);
                if (node.left != null) {
                    nodes.addLast(node.left);
                    num++;
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                    num++;
                }
            }
            System.out.println();
        }
    }

    public static void infixOrder(Node node) {
        if (node.left != null) {
            infixOrder(node.left);
        }
        System.out.println(node);
        if (node.right != null) {
            infixOrder(node.right);
        }
    }

    protected static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + this.value + "]";
        }
    }
}
