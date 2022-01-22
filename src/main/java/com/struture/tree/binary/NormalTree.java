package com.struture.tree.binary;

import com.struture.tree.face.NoNodeException;
import com.struture.tree.face.SearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName NormalTree
 * @Description TODO
 * @Date 2021/12/5 10:05
 */
public class NormalTree implements SearchTree<Node> {

    protected  final Node root;

    public NormalTree(Node root) {
        if (root == null) {
            throw new NoNodeException();
        }
        this.root = root;
    }

    @Override
    public List<Node> prefixOrder() {
        List<Node> result = new ArrayList<>();
        prefixOrder(root, result);
        return result;
    }

    private void prefixOrder(Node node, List<Node> result) {
        result.add(node);
        if (node.getLeft() != null) {
            prefixOrder(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            prefixOrder(node.getRight(), result);
        }
    }

    @Override
    public List<Node> infixOrder() {
        List<Node> result = new ArrayList<>();
        infixOrder(root, result);
        return result;
    }

    private void infixOrder(Node node, List<Node> result) {
        if (node.getLeft() != null) {
            infixOrder(node.getLeft(), result);
        }
        result.add(node);
        if (node.getRight() != null) {
            infixOrder(node.getRight(), result);
        }
    }

    @Override
    public List<Node> postOrder() {
        List<Node> result = new ArrayList<>();
        postOrder(this.root, result);
        return result;
    }

    private void postOrder(Node node, List<Node> result) {
        if (node.getLeft() != null) {
            postOrder(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            postOrder(node.getRight(), result);
        }
        result.add(node);
    }

    @Override
    public Node prefixOrderSearch(int id) {
        return prefixOrderSearch(this.root, id);
    }

    private Node prefixOrderSearch(Node node, int id) {
        if (node.getId() == id) {
            return node;
        }
        Node result = null;
        if (node.getLeft() != null) {
            result = prefixOrderSearch(node.getLeft(), id);
            if (result != null){
                return result;
            }
        }
        if (node.getRight() != null) {
            result = prefixOrderSearch(node.getRight(), id);
        }
        return result;
    }

    @Override
    public Node infixOrderSearch(int id) {
        return infixOrderSearch(this.root,id);
    }

    private Node infixOrderSearch(Node node, int id) {
        Node result = null;
        if (node.getLeft() != null) {
            result = infixOrderSearch(node.getLeft(), id);
            if (result != null) {
                return result;
            }
        }
        if (node.getId() == id) {
            return node;
        }
        if (node.getRight() != null) {
            result = infixOrderSearch(node.getRight(), id);
        }
        return result;
    }


    @Override
    public Node postOrderSearch(int id) {
        return postOrderSearch(this.root,id);
    }

    private Node postOrderSearch(Node node,int id){
        Node result = null;
        if (node.getLeft() != null){
            result  = postOrderSearch(node.getLeft(),id);
            if (result != null){
                return result;
            }
        }
        if (node.getRight() != null){
            result = postOrderSearch(node.getRight(),id);
        }
        if (node.getId() == id){
            return node;
        }
        return result;
    }

}
