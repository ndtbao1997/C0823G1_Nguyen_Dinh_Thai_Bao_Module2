package ss4_LopVaDoiTuongTrongJava.exec;


public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public void getElapsedTime() {
        long elaspedTime = this.endTime-this.startTime;
        System.out.println("Số mili giây đếm đc:" + elaspedTime);
    }


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Đang đếm thời gian");
        for (int i = 0; i < 1000000000; i++) {
            i++;
        }
        stopWatch.stop();
        stopWatch.getElapsedTime();
    }
}
