import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

///콘솔 기반 빈 강의실 찾기 프로그램
public class EmptyRoomFinder {

    /// TimeSiot: 예약된 시간 구간 표현
    static class TimeSlot {
        private final int startHour;
        private final int endHour;


        public TimeSlot(int startHour, int endHour) {
            this.startHour = startHour;
            this.endHour = endHour;
        }

        public boolean contains(int hour) {
            return hour >= startHour && hour <= endHour;
        }

        public String toString() {
            return String.format("[%2d:00 ~ %2d:00]", startHour, endHour);
        }

    }
}