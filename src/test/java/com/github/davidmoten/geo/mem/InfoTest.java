package com.github.davidmoten.geo.mem;

import com.google.common.base.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;

import static org.junit.Assert.*;

public class InfoTest {

    private Info<String, Integer> info;

    @Before
    public void setUp() throws Exception {
        info = new Info<String, Integer>(1,1,20180318,"Info Value", Optional.of(0));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void id() throws Exception {
        assertEquals(Optional.of(0), info.id());
    }

    @Test
    public void lat() throws Exception {
        assertEquals(1, info.lat(), 0.1);
    }

    @Test
    public void lon() throws Exception {
        assertEquals(1, info.lon(), 0.1);
    }

    @Test
    public void time() throws Exception {
        assertEquals(20180318, info.time());
    }

    @Test
    public void value() throws Exception {
        assertEquals("Info Value", info.value());
    }

    @Test
    public void toString_inInfo() throws Exception {
        assertEquals("Info [lat=1.0, lon=1.0, time=20180318, value=Info Value, id=Optional.of(0)]", info.toString());
    }

}