package java_practice;

import java.util.Arrays;
import java.util.Comparator;

public class SortPractice1 {
  public static void main(String[] args){

    // 배열
    int[][] meetingArray = {
        {1, 4},
        {3, 5},
        {0, 6},
        {5, 7}
    };

    Arrays.sort(meetingArray,
        Comparator.<int[]>comparingInt(a -> a[1])
            .thenComparing(Comparator.<int[]>comparingInt(a -> a[0]).reversed())
    );

    for(int[] meeting : meetingArray){
      System.out.println("[" + meeting[0] + ", " + meeting[1] + "]");
    }
  }
}
