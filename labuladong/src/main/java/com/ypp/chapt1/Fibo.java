package com.ypp.chapt1;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(fi(6));
    }

    private static int fi(int n) {
        int[] arr = new int[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
