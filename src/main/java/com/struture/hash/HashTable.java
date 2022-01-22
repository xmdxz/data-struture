package com.struture.hash;

/**
 * @Author xpdxz
 * @ClassName HashTable
 * @Description TODO
 * @Date 2021/11/7 19:45
 */
public class HashTable {
    private LinkedListForEneity[] linkedListForEneities;

    private Integer size;

    public HashTable(Integer size) {
        this.size = size;
        linkedListForEneities = new LinkedListForEneity[size];
        for (int i = 0; i < size; i++) {
            linkedListForEneities[i] = new LinkedListForEneity();
        }
    }

    public boolean add(Eneity eneity) {
        return linkedListForEneities[hashCode(eneity.getId())].add(eneity);
    }

    public boolean delete(Integer id) {
        return linkedListForEneities[hashCode(id)].delete(id);
    }

    public Eneity findById(Integer id) {
        return linkedListForEneities[hashCode(id)].findById(id);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedListForEneity link : linkedListForEneities) {
            stringBuilder.append(link.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int hashCode(int id) {
        return id % size;
    }

}
