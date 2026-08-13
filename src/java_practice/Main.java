package java_practice;

import java.util.Scanner;

public class Main {
  public static int result= 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // Please write your code here.
    recursiveFun(0, n);
    System.out.println(result);
  }

  public static void recursiveFun(int len, int n) {
    if(len == n) {
      result++;
      return;
    }

    for(int i=1;i<=4;i++) {
      if(len + i <= n) {
        recursiveFun(len+i, n);
      }else {
        break;
      }
    }
  }
}
