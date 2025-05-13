import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

///콘솔 기반 빈 강의실 찾기 프로그램
public class EmptyRoomFinder {

    /// TimeSiot: 예약된 시간 구간 표현
    public static class TimeSlot {
        public int startHour;
        public int startMinute;
        public int endHour;
        public int endMinute;

        public TimeSlot(int startHour, int startMinute, int endHour, int endMinute) {
            this.startHour = startHour;
            this.startMinute = startMinute;
        }

        public boolean contains(int hour, int minute) {
            return hour >= startHour && hour <= endHour && minute >= startMinute && minute <= endMinute;
        }

    }
}