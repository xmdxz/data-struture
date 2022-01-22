package com.struture.tree;

import com.struture.tree.binary.Node;
import com.struture.tree.binary.NormalTree;
import com.struture.tree.face.ThreadType;
import com.struture.tree.face.Tree;
import com.struture.tree.sequential.SequentialSaveArray;
import com.struture.tree.threaded.ThreadedBinaryTree;
import com.struture.tree.threaded.ThreadedNode;
import org.junit.jupiter.api.Test;

/**
 * @Author xpdxz
 * @ClassName TreeTest
 * @Description TODO
 * @Date 2021/12/5 13:55
 */
class TreeTest {

    public static Node initTree() {
        Node root = new Node(1, "宋江");
        Node node = new Node(2, "吴用");
        Node node1 = new Node(3, "卢俊");
        Node node2 = new Node(4, "林冲");
        root.setLeft(node);
        root.setRight(node1);
        node1.setRight(node2);
        return root;
    }

    @Test
    void normalTree() {
        Node root = initTree();
        NormalTree normalTree = new NormalTree(root);
        System.out.println("前序遍历：" + normalTree.prefixOrder());
        System.out.println("中序遍历：" + normalTree.infixOrder());
        System.out.println("后序遍历：" + normalTree.postOrder());
        System.out.println("前序查找：" + normalTree.prefixOrderSearch(4));
        System.out.println("中序查找：" + normalTree.infixOrderSearch(2));
        System.out.println("后序查找：" + normalTree.postOrderSearch(3));
    }

    @Test
    void sequentialTree() {
        Tree<Integer> tree = new SequentialSaveArray<>(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("前序遍历：" + tree.prefixOrder());
        System.out.println("中序遍历：" + tree.infixOrder());
        System.out.println("后序遍历：" + tree.postOrder());
    }

    @Test
    void threadedTree() {
        ThreadedNode root = new ThreadedNode(1, "tom");
        ThreadedNode node2 = new ThreadedNode(3, "jack");
        ThreadedNode node3 = new ThreadedNode(6, "smith");
        ThreadedNode node4 = new ThreadedNode(8, "mary");
        ThreadedNode node5 = new ThreadedNode(10, "king");
        ThreadedNode node6 = new ThreadedNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root, ThreadType.POST);
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());
        System.out.println(threadedBinaryTree.postOrder());

    }
}
