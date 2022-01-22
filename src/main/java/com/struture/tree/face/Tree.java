package com.struture.tree.face;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName SearchTree
 * @Description TODO
 * @Date 2021/12/5 16:17
 */
public interface Tree<T> {

    /**
     * 前序遍历
     *
     * @return
     */
    List<T> prefixOrder();

    /**
     * 中序遍历
     *
     * @return
     */
    List<T> infixOrder();

    /**
     * 后序遍历
     *
     * @return
     */
    List<T> postOrder();

}
