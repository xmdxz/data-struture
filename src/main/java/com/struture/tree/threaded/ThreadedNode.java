package com.struture.tree.threaded;

/**
 * @Author xpdxz
 * @ClassName ThreadedNode
 * @Description TODO
 * @Date 2021/12/5 19:13
 */
public class ThreadedNode {

    private int id;

    private String message;

    private ThreadedNode left;

    private ThreadedNode right;

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

    public ThreadedNode getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "ThreadedNode{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

    public ThreadedNode(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public boolean isLeftThreaded() {
        return leftThreaded;
    }

    public void setLeftThreaded(boolean leftThreaded) {
        this.leftThreaded = leftThreaded;
    }

    public boolean isRightThreaded() {
        return rightThreaded;
    }

    public void setRightThreaded(boolean rightThreaded) {
        this.rightThreaded = rightThreaded;
    }

    private boolean leftThreaded;

    private boolean rightThreaded;


}
