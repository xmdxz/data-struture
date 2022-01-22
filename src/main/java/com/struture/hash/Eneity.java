package com.struture.hash;

/**
 * @Author xpdxz
 * @ClassName Node
 * @Description TODO
 * @Date 2021/11/7 19:46
 */

public class Eneity {

    private Integer id;

    private String name;

    private String sex;

    private String address;

    public Eneity(Integer id, String name, String sex, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{ 序号:" + id + "; 姓名:" + name + "; 性别:" + sex + "; 地址:" + address + " }";
    }

}
