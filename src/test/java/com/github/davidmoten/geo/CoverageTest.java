package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class CoverageTest {

    private Set set;
    private Coverage coverage;

    @Before
    public void setUp() throws Exception {
        set = new HashSet();
        String s1=new String("hello");
        String s2=new String("world");
        set.add(s1);
        set.add(s2);

        double ratio = 1.5;

        coverage = new Coverage(set, ratio);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getHashes() throws Exception {
        assertEquals(set, coverage.getHashes());
    }

    @Test
    public void getRatio() throws Exception {
        assertTrue(1.5 == coverage.getRatio());
    }

    @Test
    public void getHashLength() throws Exception {
        assertEquals(5, coverage.getHashLength());
    }

    @Test
    public void getHashLength_withLengthIsZero() throws Exception {
        set = new HashSet();
        double ratio = 1.5;
        coverage = new Coverage(set, ratio);
        assertEquals(0, coverage.getHashLength());
    }

    @Test
    public void toString_inCoverage() throws Exception {
        assertEquals("Coverage [hashes=[world, hello], ratio=1.5]", coverage.toString());
    }

}