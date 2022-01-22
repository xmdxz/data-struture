package com.struture.tree.face;

/**
 * @Author xpdxz
 * @ClassName ThreadType
 * @Description TODO
 * @Date 2021/12/5 17:54
 */
public enum ThreadType {

    /**
     * 前序遍历
     */
    PREFIX(-1),
    /**
     * 中序遍历
     */
    INFIX(0),
    /**
     * 后序遍历
     */
    POST(1);

    private int type;

    ThreadType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

}
