package Programmers.Level1.동영상_재생기;

public class Main {

  public static void main(String[] args){
//    String[] commands = {"next", "prev"};
//    Solution solution = new Solution();
//
//    String answer = solution.solution("34:33",
//        "13:00",
//        "00:55",
//        "02:55",
//        commands);

    Solution solution = new Solution();
    String[] commands = {"prev", "next", "next"};

    String answer = solution.solution("10:55",
        "00:05",
        "00:15",
        "06:55",
        commands);

//    Solution solution = new Solution();
//    String[] commands = {"next"};
//
//    String answer = solution.solution("07:22",
//        "04:05",
//        "00:15",
//        "04:07",
//        commands);


    System.out.println(answer);
  }
}


class Solution {
  public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
    String answer = "";

    VideoPlayer videoPlayer = new VideoPlayer(
        video_len,
        pos,
        op_start,
        op_end
    );

    answer = videoPlayer.calculateTime(commands);

    return answer;
  }

  class VideoPlayer {
    Time videoLen;
    Time pos;
    Time opStart;
    Time opEnd;

    public VideoPlayer(String videoLen, String pos, String opStart, String opEnd) {
      this.videoLen = new Time(Integer.parseInt(videoLen.split(":")[0]), Integer.parseInt(videoLen.split(":")[1]));
      this.pos = new Time(Integer.parseInt(pos.split(":")[0]), Integer.parseInt(pos.split(":")[1]));
      this.opStart = new Time(Integer.parseInt(opStart.split(":")[0]), Integer.parseInt(opStart.split(":")[1]));
      this.opEnd = new Time(Integer.parseInt(opEnd.split(":")[0]), Integer.parseInt(opEnd.split(":")[1]));
    }

    public String calculateTime(String[] commands) {
      pos.setIfBetween(opStart, opEnd);

      for(String command : commands) {
        switch (command) {
          case "next":
            pos.next();
            break;
          case "prev":
            pos.prev();
            break;
        }
      }

      pos.setIfBetween(opStart, opEnd);

      String minute = String.valueOf(pos.minute);
      if(minute.length() == 1) {
        minute = "0" + minute;
      }

      String second = String.valueOf(pos.second);
      if(second.length() == 1) {
        second = "0" + second;
      }

      return minute + ":" + second;
    }
  }

  class Time {
    int minute;
    int second;

    public Time(int minute, int second) {
      this.minute = minute;
      this.second = second;
    }

    public void setIfBetween(Time opStart, Time opEnd) {

      if(opStart.minute <= this.minute && this.minute <= opEnd.minute) {

        if(opStart.minute == this.minute) {
          if(opStart.second < this.second) {
            this.minute = opEnd.minute;
            this.second = opEnd.second;
            return;
          }
        }

        if(opEnd.minute == this.minute) {
          if(opEnd.second > this.second) {
            this.minute = opEnd.minute;
            this.second = opEnd.second;
            return;
          }
        }

        if(opStart.second <= this.second && this.second <= opEnd.second) {
          this.minute = opEnd.minute;
          this.second = opEnd.second;
        }
      }

    }

    public void next() {
      this.second += 10;
      if(this.second > 59) {
        this.minute += 1;
        this.second %= 60;
      }

    }

    public void prev() {
      this.second -= 10;
      if(this.second < 0) {
        this.minute -= 1;
        this.second = 60 + this.second % 60;
      }

    }

    @Override
    public String toString() {
      return "Time{" +
          "minute=" + minute +
          ", second=" + second +
          '}';
    }
  }
}

