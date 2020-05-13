package B3_LopVaDTTTrongJava.BT.StopWatch;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class StopWatch {

    private Date startTime;
    private Date endTime;

    StopWatch() {
        this.startTime = new Date();
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = new Date();
    }

    public void stop() {
        this.endTime = new Date();
    }

    public long getElapsedTime() {
        Date realtimes = new Date();
        return realtimes.getTime() - this.startTime.getTime();
    }

    public static int[] array() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Nhập x");
        int x = kb.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            Random rd = new Random();
            arr[i] = rd.nextInt(100000);
        }
        return arr;

    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] array1;
        array1 = array();
        stopWatch.start();
        Arrays.sort(array1);
        System.out.println(stopWatch.getElapsedTime());

    }

}
