package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Base32Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encodeBase32() throws Exception {
        String encode = Base32.encodeBase32(75324, 4);
        assertEquals("29jw", encode);
    }

    @Test
    public void encodeBase32_withNegativeValue() throws Exception {
        String encode = Base32.encodeBase32(-75324, 4);
        assertEquals("-29jw", encode);
    }

    @Test
    public void encodeBase32_withoutParamLength() throws Exception {
        String encode = Base32.encodeBase32(-75324);
        assertEquals("-0000000029jw", encode);
    }

    @Test
    public void decodeBase32() throws Exception {
        long decode = Base32.decodeBase32("29jw");
        assertEquals(75324, decode);
    }

    @Test
    public void decodeBase32_withNegativeValue() throws Exception {
        long decode = Base32.decodeBase32("-29jw");
        assertEquals(-75324, decode);
    }

    @Test
    public void getCharIndex() throws Exception {
        int charIndex = Base32.getCharIndex('s');
        assertEquals(24, charIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCharIndex_withInvalidChar() throws Exception {
        int charIndex = Base32.getCharIndex('a');
    }

    @Test
    public void padLeftWithZerosToLength() throws  Exception{
        String result = Base32.padLeftWithZerosToLength("12", 3);
        assertEquals( "012", result);
    }

    @Test
    public void padLeftWithZerosToLength_whenStringLengthGreaterThanParamLength() throws  Exception{
        String result = Base32.padLeftWithZerosToLength("12345", 3);
        assertEquals( "12345", result);
    }
}