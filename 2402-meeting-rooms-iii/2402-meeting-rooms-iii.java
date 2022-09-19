class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> free = new PriorityQueue<>(Comparator.comparingInt(r -> r.roomNumber));
        PriorityQueue<Room> working = new PriorityQueue<>((r1, r2) -> {
            if (r1.nextAvailableTime == r2.nextAvailableTime)
                return Integer.compare(r1.roomNumber, r2.roomNumber);
            return Long.compare(r1.nextAvailableTime, r2.nextAvailableTime);
        });

        for (int i = 0; i < n; i++) {
            free.add(new Room(i));
        }

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        for (int[] meeting : meetings) {
            while (!working.isEmpty() && working.peek().nextAvailableTime <= meeting[0]) {
                free.offer(working.poll());
            }

            Room room = null;
            if (free.isEmpty()) {
                room = working.poll();
            } else {
                room = free.poll();
            }
            room.holdMeeting(meeting);
            working.offer(room);
        }

        free.addAll(working);

        return free.stream()
                .sorted((r1, r2) -> {
                    if (r1.meetingCnt == r2.meetingCnt) {
                        return Integer.compare(r1.roomNumber, r2.roomNumber);
                    }
                    return Integer.compare(r2.meetingCnt, r1.meetingCnt);
                }).findFirst().get().roomNumber;
    }

    class Room {
        int roomNumber;
        int meetingCnt = 0;
        long nextAvailableTime = -1;

        public Room(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void holdMeeting(int[] meeting) {
            int duration = meeting[1] - meeting[0];
            this.nextAvailableTime = Math.max(this.nextAvailableTime, meeting[0]) + duration;
            meetingCnt++;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "roomNumber=" + roomNumber +
                    ", meetingCnt=" + meetingCnt +
                    ", nextAvailableTime=" + nextAvailableTime +
                    '}';
        }
    }
}