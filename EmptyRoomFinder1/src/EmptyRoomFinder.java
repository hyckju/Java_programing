import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

///콘솔 기반 빈 강의실 찾기 프로그램
public class EmptyRoomFinder {

    /// TimeSlot: 예약된 시간 구간 표현
    static class timeSlot {
        private final int startHour;
        private final int endHour;


        public timeSlot(int startHour, int endHour) {
            this.startHour = startHour;
            this.endHour = endHour;
        }
        /// 주어진 시각이 배열안에 있는지 확인
        public boolean contains(int hour) {
            return hour >= startHour && hour < endHour;
        }

        public String toString() {
            return String.format("[%2d:00 ~ %2d:00]", startHour, endHour);
        }
    }


    ///Classroom: 강의실 이름과 예약된 시간 목록 불러오기
    static class classRoom {
        private final String name;
        private final List<timeSlot> timeSlots = new ArrayList<>();

        public classRoom(String name) {
            this.name = name;
        }

        /// 배열추가
        public void addTimeSlot(int startHour, int endHour) {
            timeSlots.add(new timeSlot(startHour, endHour));
        }

        /// 주어진 시각에 빈 강의실인지 확인
        public boolean isEmptyAt(int hour) {
            for (timeSlot slot : timeSlots) {
                if (slot.contains(hour)) {
                    return false;
                }
            }
            return true;
        }

        /// 예약된 전체 스케줄 문자열로 반환
        public String scheduleString() {
            if (timeSlots.isEmpty()) {
                return "예정된 강의 없음";
            }
            StringBuilder sb = new StringBuilder();
            for (timeSlot slot : timeSlots) {
                sb.append(slot).append(" ");
            }
            return sb.toString().trim();
        }

        public String getName() {
            return name;
        }
    }

    public static void main (String[] args) {
        List<classRoom> classrooms = sampleClassrooms();

        Scanner scanner = new Scanner(System.in);
        int hour;

        while (true) {
            System.out.print("조회할 시간을 입력하세요 (0 ~ 23): ");
            try {
                hour = scanner.nextInt();
                if (hour < 0 || hour > 23) {
                    System.out.println("올바른 시간을 입력하세요.");
                } else {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("\n== %02d:00 기준 빈 강의실 목록 ==\n", hour);
        boolean any = false;
        for (classRoom classroom : classrooms) {
            if (classroom.isEmptyAt(hour)) {
                System.out.printf("- %s - 예약: %s\n",
                        classroom.getName(), classroom.scheduleString()) ;
                any = true;
            }
        }
        if (!any) {
                System.out.println("빈 강의실이 없습니다.");
        }

        scanner.close();
    }

    /// 샘플 강의실과 예약
    @SuppressWarnings("ClassEscapesDefinedScope")
    public static List<classRoom> sampleClassrooms() {
        List<classRoom> classrooms = new ArrayList<>();

        classRoom classroom1 = new classRoom("101호");
        classroom1.addTimeSlot(8, 10);
        classroom1.addTimeSlot(10, 12);
        classroom1.addTimeSlot(14, 16);
        classrooms.add(classroom1);

        classRoom classroom2 = new classRoom("202호");
        classroom2.addTimeSlot(8, 10);
        classroom2.addTimeSlot(10, 12);
        classrooms.add(classroom2);

        classRoom classroom3 = new classRoom("303호");
        classroom3.addTimeSlot(10, 12);
        classrooms.add(classroom3);

        classRoom classroom4 = new classRoom("404호");
        classroom4.addTimeSlot(8, 10);
        classroom4.addTimeSlot(10, 12);
        classrooms.add(classroom4);

        classRoom classroom5 = new classRoom("505호");
        classrooms.add(classroom5);

        return classrooms;
    }
}