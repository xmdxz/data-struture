package com.struture.tree.application;

import java.util.*;

/**
 * @Author xpdxz
 * @ClassName HuffmanCode
 * @Description TODO
 * @Date 2022/1/18 20:24
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String origin = "i like like like java do you like a java";
        Encode encode = encode(origin);
        System.out.println(decode(encode));
    }

    //========================================霍夫曼编码的decode==============================

    public static String decode(Encode encode) {
        Map<String, Byte> instead = new HashMap<>(16);
        encode.huffmanCode.forEach((k, v) -> instead.put(v, k));
        String binaryString = byteToString(encode.result);
        byte[] decode = binaryStringToOrigin(binaryString, instead);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : decode) {
            stringBuilder.append((char) b);
        }
        return stringBuilder.toString();
    }

    private static byte[] binaryStringToOrigin(String result, Map<String, Byte> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Byte> origin = new ArrayList<>();
        char[] array = result.toCharArray();
        for (char c : array) {
            stringBuilder.append(c);
            Byte aByte = huffmanCode.get(stringBuilder.toString());
            if (aByte != null) {
                origin.add(aByte);
                stringBuilder.setLength(0);
            }
        }
        int length = origin.size();
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = origin.get(i);
        }
        return bytes;
    }

    private static String byteToString(byte[] result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < result.length - 1; index++) {
            int ori = result[index];
            if (ori >= 0) {
                ori |= 256;
            }
            String bit = Integer.toBinaryString(ori);
            if (index == result.length - 2 && result[index + 1] != 0) {
                int endCount = result[index + 1];
                bit = bit.substring(bit.length() - endCount);
                stringBuilder.append(bit);
            } else {
                stringBuilder.append(bit.substring(bit.length() - 8));
            }
        }
        return stringBuilder.toString();
    }

    //=========================================霍夫曼编码的encode==============================

    public static Encode encode(String origin) {
        byte[] bytes = origin.getBytes();
        Node root = initializeHuffmanTree(bytes);
        Map<Byte, String> huffmanCode = getHuffmanCode(root);
        String binaryString = encodeToBinaryString(huffmanCode, bytes);
        return new Encode(binaryStringToBytes(binaryString), huffmanCode);
    }

    private static byte[] binaryStringToBytes(String binaryString) {
        int stringLength = binaryString.length();
        byte[] result = new byte[(stringLength + 7) / 8 + 1];
        for (int start = 0, index = 0; start < stringLength; start += 8, index++) {
            int end = Math.min(start + 8, stringLength);
            String oneByte = binaryString.substring(start, end);
            if (oneByte.length() != 8 && end == stringLength) {
                result[result.length - 1] = (byte) oneByte.length();
            } else {
                result[result.length - 1] = 0;
            }
            result[index] = (byte) Integer.parseInt(oneByte, 2);
        }
        return result;
    }

    private static String encodeToBinaryString(Map<Byte, String> huffmanCode, byte[] origin) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte c : origin) {
            stringBuilder.append(huffmanCode.get(c));
        }
        return stringBuilder.toString();
    }

    private static Node initializeHuffmanTree(byte[] origin) {
        int index = 1;
        Map<Byte, Node> process = new HashMap<>(16);
        for (byte b : origin) {
            Node v = process.get(b);
            if (v == null) {
                process.put(b, new Node(b, 1));
            } else {
                v.value++;
            }
        }
        Node[] nodes = process.values().toArray(new Node[0]);
        Comparator<Node> comparator = Comparator.comparingInt(k -> k.value);
        while (index <= nodes.length - 1) {
            Arrays.sort(nodes, index - 1, nodes.length, comparator);
            Node node = new Node(null, nodes[index - 1].value + nodes[index].value, nodes[index - 1], nodes[index]);
            nodes[index] = node;
            index++;
        }
        return nodes[nodes.length - 1];
    }

    private static Map<Byte, String> getHuffmanCode(Node root) {
        if (root == null) {
            throw new InputMismatchException("数据为空！");
        }
        Map<Node, String> process = new HashMap<>(16);
        Map<Byte, String> result = new HashMap<>(16);
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.addLast(root);
        int num = 1;
        while (num > 0) {
            int instead = num;
            num = 0;
            for (int j = 0; j < instead; j++) {
                Node node = nodes.removeFirst();
                String value = process.get(node);
                if (node.left != null) {
                    nodes.addLast(node.left);
                    process.compute(node.left, (k, v) -> value == null ? "0" : value + "0");
                    num++;
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                    process.compute(node.right, (k, v) -> value == null ? "1" : value + "1");
                    num++;
                }
                if (node.left == null && node.right == null) {
                    result.put(node.origin, process.get(node));
                }
            }
        }
        return result;
    }

    private static void hierarchicalTraversal(Node root) {
        if (root == null) {
            System.out.println("二叉树为空");
        }
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.addLast(root);
        for (int i = 1, num = 1; num > 0; i++) {
            System.out.print("第" + i + "层:");
            int instead = num;
            num = 0;
            for (int j = 0; j < instead; j++) {
                Node node = nodes.removeFirst();
                System.out.print(node);
                if (node.left != null) {
                    nodes.addLast(node.left);
                    num++;
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                    num++;
                }
            }
            System.out.println();
        }
    }

    private static class Encode {
        private byte[] result;
        private Map<Byte, String> huffmanCode;

        Encode(byte[] result, Map<Byte, String> huffmanCode) {
            this.result = result;
            this.huffmanCode = huffmanCode;
        }

        public byte[] getResult() {
            return this.result;
        }

        public Map<Byte, String> getHuffmanCode() {
            return this.huffmanCode;
        }
    }

    private static class Node {

        Byte origin;
        int value;
        Node left;
        Node right;

        Node(Byte origin, int value) {
            this.value = value;
            this.origin = origin;
        }

        Node(Byte origin, int value, Node left, Node right) {
            this.value = value;
            this.origin = origin;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Node)) {
                return false;
            }
            Node node = (Node) obj;
            return node.right == right && node.left == left && node.value == value && node.origin.equals(origin);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            return "[" + (this.origin == null ? "null" : (char) (byte) origin) + ", " + value + "]";
        }
    }


}
