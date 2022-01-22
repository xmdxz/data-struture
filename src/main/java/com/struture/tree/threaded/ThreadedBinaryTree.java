package com.struture.tree.threaded;

import com.struture.tree.face.SearchTree;
import com.struture.tree.face.ThreadType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ThreadedBinaryTree
 * @Description TODO
 * @Date 2021/12/5 17:27
 */
public class ThreadedBinaryTree implements SearchTree<ThreadedNode> {

    private final ThreadedNode root;

    private ThreadedNode preNode;

    public ThreadedBinaryTree(ThreadedNode root, ThreadType type) {
        this.root = root;
        switch (type) {
            case POST:
                postThread(this.root);
                break;
            case INFIX:
                infixThread(this.root);
                break;
            case PREFIX:
                prefixThread(this.root);
                break;
            default:
                break;
        }
    }

    private void prefixThread(ThreadedNode node) {
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightThreaded(true);
        }
        if (node.getLeft() == null && preNode != null) {
            node.setLeft(preNode);
            node.setLeftThreaded(true);
        }
        preNode = node;
        if (node.getLeft() != null && !node.isLeftThreaded()) {
            prefixThread(node.getLeft());
        }
        if (node.getRight() != null && !node.isRightThreaded()) {
            prefixThread(node.getRight());
        }
    }

    private void infixThread(ThreadedNode node) {
        if (node.getLeft() != null && !node.isLeftThreaded()) {
            infixThread(node.getLeft());
        }
        if (node.getLeft() == null && preNode != null) {
            node.setLeft(preNode);
            node.setLeftThreaded(true);
        }
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightThreaded(true);
        }
        preNode = node;
        if (node.getRight() != null && !node.isRightThreaded()) {
            infixThread(node.getRight());
        }

    }

    private void postThread(ThreadedNode node) {
        if (node.getLeft() != null && !node.isLeftThreaded()) {
            postThread(node.getLeft());
        }
        if (node.getRight() != null && !node.isRightThreaded()) {
            postThread(node.getRight());
        }
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightThreaded(true);
        }
        if (node.getLeft() == null && preNode != null) {
            node.setLeft(preNode);
            node.setLeftThreaded(true);
        }
        preNode = node;
    }

    @Override
    public ThreadedNode prefixOrderSearch(int id) {
        return null;
    }

    @Override
    public ThreadedNode infixOrderSearch(int id) {
        return null;
    }

    @Override
    public ThreadedNode postOrderSearch(int id) {
        return null;
    }

    @Override
    public List<ThreadedNode> prefixOrder() {
        List<ThreadedNode> prefixNodes = new ArrayList<>();
        ThreadedNode node = root;
        while (node != null) {
            prefixNodes.add(node);
            if (node.getLeft() != null && !node.isLeftThreaded()) {
                node = node.getLeft();
                continue;
            }
            while (node.isRightThreaded()) {
                node = node.getRight();
                prefixNodes.add(node);
            }
            node = node.getRight();
        }
        return prefixNodes;
    }

    @Override
    public List<ThreadedNode> infixOrder() {
        List<ThreadedNode> infixNodes = new ArrayList<>();
        ThreadedNode node = root;
        while (node != null) {
            if (node.getLeft() != null && !node.isLeftThreaded()) {
                node = node.getLeft();
                continue;
            }
            infixNodes.add(node);
            while (node.isRightThreaded()) {
                node = node.getRight();
                infixNodes.add(node);
            }
            node = node.getRight();
        }
        return infixNodes;
    }

    @Override
    public List<ThreadedNode> postOrder() {
        List<ThreadedNode> postNodes = new ArrayList<>();
        ThreadedNode node = root;
        while (node != null) {
            if (node.getLeft() != null && !node.isLeftThreaded()) {
                node = node.getLeft();
                continue;
            }
            while (node.isRightThreaded()) {
                node = node.getRight();
                postNodes.add(node);
            }
            postNodes.add(node);
            node = node.getRight();
        }
        return postNodes;
    }
}
