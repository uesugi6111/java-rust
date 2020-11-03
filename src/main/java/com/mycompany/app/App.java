
package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class App {
    private static final int N = 100000000;

    public interface SampleJna extends Library {
        SampleJna INSTANCE = Native.load("/libsample_jna.so", SampleJna.class);

        int sample_add(int value);

        int sieve_liner(int value);
    };

    public static void main(String[] args) {
        System.out.println("N = " + N);
        System.out.println("FFI  :" + executeFFI(N) + "ms");
        System.out.println("Java :" + executeJava(N) + "ms");

    }

    public static long executeFFI(int n) {
        long startTime = System.currentTimeMillis();
        SampleJna.INSTANCE.sieve_liner(n);
        return System.currentTimeMillis() - startTime;

    }

    public static long executeJava(int n) {
        long startTime = System.currentTimeMillis();
        sieveLiner(n);
        return System.currentTimeMillis() - startTime;

    }

    public static int sieveLiner(int n) {
        List<Integer> primes = new ArrayList<>();

        int d[] = new int[n + 1];
        for (int i = 2; i < n + 1; ++i) {

            if (d[i] == 0) {
                primes.add(i);
                d[i] = i;
            }
            for (int p : primes) {
                if (p * i > n) {
                    break;
                }
                d[p * i] = p;
            }
        }

        return primes.size();
    }

}
