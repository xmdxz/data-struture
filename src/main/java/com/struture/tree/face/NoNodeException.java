package com.struture.tree.face;

/**
 * @Author xpdxz
 * @ClassName NoNodeException
 * @Description TODO
 * @Date 2021/12/5 11:42
 */
public class NoNodeException extends RuntimeException{

    public NoNodeException() {
        super("你不能创建一个空树");
    }
}
