package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nack on 2017/7/12.
 */
public class QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                else {
                    return b[0] - a[0];
                }
            }
        });

        for(int[] item : people) {
            System.out.println("(" + item[0] + ", " + item[1] + ")");
        }

        ArrayList<int[]> tmp = new ArrayList<>();
//        for(int i = 0; i < people.length; i++) {
//            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
//        }
        for(int[] item : people) {
            tmp.add(item[1], item);
        }

//        int[][] res = new int[people.length][2];
//        int i = 0;
//        for (int[] k : tmp) {
//            res[i][0] = k[0];
//            res[i++][1] = k[1];
//        }
//        return res;
        return tmp.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] num = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] result = reconstructQueue(num);
        for(int[] item : result) {
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
