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

        /// Classroom: 강의실 이름과 예약된 시간 목록 불러오기
        static class Classroom {
            private final String name;
            private final List<TimeSlot> timeSlots = new ArrayList<>();

            public Classroom(String name) {
                this.name = name;
            }

            /// 배열추가
            public void addTimeSlot(int startHour, int endHour) {

                timeSlots.add(new TimeSlot(startHour, endHour));
            }

            /// 주어진 시각이 빈 강의실인지 확인
            public boolean isEmptyAt(int hour) {
                for (TimeSlot timeSlot : timeSlots) {
                    if (timeSlot.contains(hour)) {
                        return false;
                    }
                }
                return true;
            }
            /// 예약된 전체 스케줄 문자열로 전환

        }

    }
}