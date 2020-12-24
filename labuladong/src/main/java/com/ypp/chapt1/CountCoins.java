package com.ypp.chapt1;

public class CountCoins {

    private static int[] coins = {1, 2, 5};

    private static int[] memo = new int[1000];

    public static void main(String[] args) {
        System.out.println(count1(12));
        System.out.println(count2(12));
        System.out.println(count3(12));
    }

    private static int count1(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int i: coins) {
            int sub = count1(amount - i);
            if (sub == -1) continue;
            res = Math.min(sub + 1, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int count2(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != 0) return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int i : coins) {
            int sub = count2(amount - i);
            if (sub == -1) continue;
            res = Math.min(sub + 1, res);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    private static int count3(int amount) {
        int dp[] = new int[amount+1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 0; i < amount + 1; i++) {
            for (int coin: coins) {
                if ((i - coin) < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
