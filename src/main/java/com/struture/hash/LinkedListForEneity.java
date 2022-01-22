package com.struture.hash;


/**
 * @Author xpdxz
 * @ClassName LinkedListForEneity
 * @Description TODO
 * @Date 2021/11/7 19:47
 */
public class LinkedListForEneity {

    private Node head;

    private static class Node {
        Eneity eneity;
        Node next;

        Node(Eneity eneity, Node next) {
            this.eneity = eneity;
            this.next = next;
        }
    }

    public boolean add(Eneity eneity) {
        if (head == null) {
            head = new Node(eneity, null);
            return true;
        }
        Node node = head;
        while (node.next != null) {
            if (node.eneity.getId().equals(eneity.getId())) {
                System.out.println("该员工已存在！");
                return false;
            }
            node = node.next;
        }
        node.next = new Node(eneity, null);
        return true;
    }

    public boolean delete(Integer id) {
        if (head == null) {
            return false;
        }
        if (head.eneity.getId().equals(id)) {
            head = head.next;
            return true;
        }
        Node node = head;
        while (node.next != null) {
            if (node.next.eneity.getId().equals(id)) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Eneity findById(Integer id) {
        if (head == null) {
            return null;
        }
        if (head.eneity.getId().equals(id)) {
            return head.eneity;
        }
        Node node = head;
        while (node.next != null) {
            if (node.eneity.getId().equals(id)) {
                return node.eneity;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.eneity);
            stringBuilder.append(";");
            node = node.next;
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
