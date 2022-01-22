package com.struture.tree.binary;


/**
 * @Author xpdxz
 * @ClassName Node
 * @Description TODO
 * @Date 2021/12/4 23:10
 */
public class Node {

    private int id;

    private String message;

    public Node(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Node(int id, String message, Node left, Node right) {
        this.id = id;
        this.message = message;
        this.left = left;
        this.right = right;
    }

    private Node left;

    private Node right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "Node{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

}
