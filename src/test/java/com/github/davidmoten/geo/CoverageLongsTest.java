package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoverageLongsTest {

    private long[] hashes;
    private CoverageLongs coverageLongs;

    @Before
    public void setUp() throws Exception {
        hashes = new long[]{75324, 75325};
        int count = hashes.length;
        double ratio = 1.5;
        coverageLongs = new CoverageLongs(hashes, count, ratio);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getHashes() throws Exception{
        for(int index = 0; index < coverageLongs.getHashes().length; index++)
            assertEquals(hashes[index], coverageLongs.getHashes()[index]);
    }

    @Test
    public void getRatio() throws Exception{
        assertTrue(1.5 == coverageLongs.getRatio());
    }

    @Test
    public void getHashLength() throws Exception{
        assertEquals(12,  coverageLongs.getHashLength());
    }

    @Test
    public void getHashLength_withCountIsZero() throws Exception{
        double ratio = 1.5;
        coverageLongs = new CoverageLongs(new long[]{}, 0, ratio);
        assertEquals(0,  coverageLongs.getHashLength());
    }

    @Test
    public void getCount() throws Exception{
        int count = hashes.length;
        assertEquals(2,  coverageLongs.getCount());
    }
}