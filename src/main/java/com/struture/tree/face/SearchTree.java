package com.struture.tree.face;


/**
 * @Author xpdxz
 * @ClassName SearchTree
 * @Description TODO
 * @Date 2021/12/4 22:13
 */
public interface SearchTree<T> extends Tree<T> {

    /**
     * 前序遍历查找
     * @param id
     * @return
     */
    T prefixOrderSearch(int id);

    /**
     * 中序遍历查找
     * @param id
     * @return
     */
    T infixOrderSearch(int id);

    /**
     * 后续遍历查找
     * @param id
     * @return
     */
    T postOrderSearch(int id);

}
