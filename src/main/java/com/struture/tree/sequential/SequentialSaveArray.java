package com.struture.tree.sequential;

import com.struture.tree.face.NoNodeException;
import com.struture.tree.face.Tree;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName SequentialSaveArray
 * @Description TODO
 * @Date 2021/12/5 16:20
 */
public class SequentialSaveArray<T> implements Tree<T> {

    private final T[] nodes;

    private final int size;

    public SequentialSaveArray(T[] nodes) {
        if (nodes == null || nodes.length == 0) {
            throw new NoNodeException();
        }
        this.nodes = nodes;
        this.size = nodes.length;
    }

    @Override
    public List<T> prefixOrder() {
        List<T> result = new ArrayList<>();
        prefixOrder(0, result);
        return result;
    }

    private void prefixOrder(int index, List<T> result) {
        result.add(nodes[index]);
        if (index * 2 + 1 < this.size) {
            prefixOrder(index * 2 + 1, result);
        }
        if (index * 2 + 2 < this.size) {
            prefixOrder(index * 2 + 2, result);
        }
    }

    @Override
    public List<T> infixOrder() {
        List<T> result = new ArrayList<>();
        infixOrder(0,result);
        return result;
    }

    private void infixOrder(int index, List<T> result) {
        if (index * 2 + 1 < this.size) {
            infixOrder(index * 2 + 1, result);
        }
        result.add(nodes[index]);
        if (index * 2 + 2 < this.size) {
            infixOrder(index * 2 + 2, result);
        }
    }


    @Override
    public List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrder(0,result);
        return result;
    }
    
    private void postOrder(int index,List<T> result){
        if (index * 2 + 1 < this.size){
            postOrder(index * 2 + 1,result);
        }
        if (index * 2 + 2 <this.size){
            postOrder(index * 2 + 2,result);
        }
        result.add(nodes[index]);
    }
}
