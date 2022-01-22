package com.struture.recursion;

/**
 * @Author xpdxz
 * @ClassName Labyrinth
 * @Description TODO
 * @Date 2021/9/15 15:20
 * @Version 1.0
 */
public class Labyrinth {
    public static void main(String[] args) {
        int[][] labyrinth = initialize(8, 7);
        print(labyrinth);
        run(1, 1, labyrinth);
        print(labyrinth);
    }

    public static int[][] initialize(int height, int length) {
        int[][] labyrinth = new int[height][length];
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                for (int j = 0; j < length; j++) {
                    labyrinth[i][j] = -1;
                }
            } else if (i == 3) {
                for (int j = 0; j < length; j++) {
                    if (j < 3 || j == length - 1) {
                        labyrinth[i][j] = -1;
                    }
                }
            } else {
                for (int j = 0; j < length; j++) {
                    if (j == 0 || j == length - 1) {
                        labyrinth[i][j] = -1;
                    } else {
                        labyrinth[i][j] = 0;
                    }
                }
            }
        }
        return labyrinth;
    }

    public static void print(int[][] labyrinth) {
        for (int index = 0; index < labyrinth.length; index++) {
            for (int j = 0; j < labyrinth[index].length; j++) {
                System.out.print(labyrinth[index][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean run(int i, int j, int[][] labyrinth) {
        if (labyrinth[6][5] == 1) {
            return true;
        } else {
            if (labyrinth[i][j] == 0) {
                labyrinth[i][j] = 1;
                if (run(i + 1, j, labyrinth)) {
                    return true;
                } else if (run(i, j + 1, labyrinth)) {
                    return true;
                } else if (run(i - 1, j, labyrinth)) {
                    return true;
                } else if (run(i, j - 1, labyrinth)) {
                    return true;
                } else {
                    labyrinth[i][j] = 2;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
