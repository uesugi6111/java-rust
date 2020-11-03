package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {
    private static final int N = 100000;

    @Test
    public void testApp() {
        int f = App.SampleJna.INSTANCE.sieve_liner(N);
        int j = App.sieveLiner(N);
        assertEquals(f, j);
        int f10 = App.SampleJna.INSTANCE.sieve_liner(N * 10);
        int j10 = App.sieveLiner(N * 10);
        assertEquals(f10, j10);

    }

}
