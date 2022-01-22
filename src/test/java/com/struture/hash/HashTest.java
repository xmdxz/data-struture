package com.struture.hash;

import org.junit.jupiter.api.Test;

/**
 * @Author xpdxz
 * @ClassName HashTest
 * @Description TODO
 * @Date 2021/11/9 22:39
 */
class HashTest {

    @Test
    void testHash() {
        HashTable hashTable = new HashTable(16);
        System.out.println(hashTable);
        hashTable.add(new Eneity(1, "张三", "男", "山西"));
        System.out.println(hashTable);
        hashTable.add(new Eneity(17, "王五", "女", "江西"));
        System.out.println(hashTable);
        hashTable.delete(1);
        System.out.println(hashTable);
        System.out.println(hashTable.findById(17));
    }

}
