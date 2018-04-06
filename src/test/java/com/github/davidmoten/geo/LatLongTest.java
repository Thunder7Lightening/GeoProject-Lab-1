package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LatLongTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toString_inLatLong() throws Exception {
        LatLong latLong = new LatLong(0, 5);
        assertEquals("LatLong [lat=0.0, lon=5.0]", latLong.toString());
    }

}