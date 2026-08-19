package Programmers.Level1.지폐_접기;

public class Main {
  static class Solution {
    public int solution(int[] wallet, int[] bill) {
      int answer = dfs(wallet, bill, 0);

      return answer;
    }

    private int dfs(int[] wallet, int[] bill, int count) {
      if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
        return count;
      } else if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
        return count;
      }

      if(bill[0] > bill[1]) {
        bill[0] /= 2;
      } else {
        bill[1] /= 2;
      }
      return dfs(wallet, bill, count + 1);
    }
  }


  public static void main(String[] args) {
//    int[] wallet = {30,15};
//    int[] bill = {26, 17};

    int[] wallet = {50, 50};
    int[] bill = {100, 241};

    Solution solution = new Solution();

    System .out.println(solution.solution(wallet, bill));

  }
}
