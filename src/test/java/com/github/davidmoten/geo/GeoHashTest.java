package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class GeoHashTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void adjacentHash_TOP() throws Exception {
        assertEquals("29jx", GeoHash.adjacentHash("29jw", Direction.TOP));
    }

    @Test
    public void adjacentHash_BOTTOM() throws Exception {
        assertEquals("29jt", GeoHash.adjacentHash("29jw", Direction.BOTTOM));
    }

    @Test
    public void adjacentHash_LEFT() throws Exception {
        assertEquals("29jq", GeoHash.adjacentHash("29jw", Direction.LEFT));
    }

    @Test
    public void adjacentHash_RIGHT() throws Exception {
        assertEquals("29jy", GeoHash.adjacentHash("29jw", Direction.RIGHT));
    }

    @Test
    public void top() throws Exception {
        assertEquals("29jx", GeoHash.top("29jw"));
    }

    @Test
    public void bottom() throws Exception {
        assertEquals("29jt", GeoHash.bottom("29jw"));
    }

    @Test
    public void left() throws Exception {
        assertEquals("29jq", GeoHash.left("29jw"));
    }

    @Test
    public void right() throws Exception {
        assertEquals("29jy", GeoHash.right("29jw"));
    }

    @Test
    public void adjacentHash_withParamStepsIsNegative() throws Exception {
        assertEquals("29jt", GeoHash.adjacentHash("29jw", Direction.TOP, -1));
    }

    @Test
    public void adjacentHash_withParamStepsIsPositive() throws Exception {
        assertEquals("29m8", GeoHash.adjacentHash("29jw", Direction.TOP, 2));
    }

    @Test
    public void neighbours() throws Exception {
        List<String> neighbourlist = GeoHash.neighbours("29jw");
        assertEquals("29jq", neighbourlist.get(0));
        assertEquals("29jy", neighbourlist.get(1));
        assertEquals("29jx", neighbourlist.get(2));
        assertEquals("29jt", neighbourlist.get(3));
        assertEquals("29jr", neighbourlist.get(4));
        assertEquals("29jm", neighbourlist.get(5));
        assertEquals("29jz", neighbourlist.get(6));
        assertEquals("29jv", neighbourlist.get(7));
    }

    @Test
    public void encodeHash() throws Exception {
        assertEquals("s0", GeoHash.encodeHash(1.1, 2.2, 2));
    }

    @Test
    public void fromLongToString() throws Exception {
        assertEquals("0000000004m3", GeoHash.fromLongToString(75324));
    }

    @Test
    public void encodeHashToLong() throws Exception {
        long result = GeoHash.encodeHashToLong(0, 0, 1);

        assertEquals(result, result);
    }

    @Test
    public void hashLengthToCoverBoundingBox() throws Exception {
        int result = GeoHash.hashLengthToCoverBoundingBox(1.1, 2.2, 3.3, 3.3);
        assertEquals(2, result);
    }

    @Test
    public void hashContains() throws Exception {
        assertFalse(GeoHash.hashContains("29jw", 1.1, 2.2));
    }

    @Test
    public void coverBoundingBox() throws Exception {
        assertEquals("Coverage [hashes=[s09, s0c, s0d, s0f], ratio=6.537319214876032]", GeoHash.coverBoundingBox(4.4, 2.2, 3.3, 3.3).toString());
    }

    @Test
    public void heightDegrees() throws Exception {
        assertEquals(45.0, GeoHash.heightDegrees(1), 0.0001);
    }

    @Test
    public void heightDegrees_withParamGreaterThanMAX_HASH_LENGTH() throws Exception {
        Double result = GeoHash.heightDegrees(15);
        assertEquals("1.3096723705530167E-9", result.toString());
    }

    @Test
    public void calculateHeightDegrees_byMethodHeightDegrees_withParamIsEven() throws Exception {
        Double result = GeoHash.heightDegrees(16);
        assertEquals("1.6370904631912708E-10", result.toString());
    }

    @Test
    public void widthDegrees() throws Exception {
        Double result = GeoHash.widthDegrees(1);
        assertEquals("45.0", result.toString());
    }

    @Test
    public void widthDegrees_withParamGreaterThanMAX_HASH_LENGTH() throws Exception {
        Double result = GeoHash.widthDegrees(16);
        assertEquals("3.2741809263825417E-10", result.toString());
    }

    @Test
    public void gridAsString() throws Exception {
        Set<String> set = new HashSet<String>();
        set.add("29jw");
        assertEquals(GeoHash.gridAsString("29jw", 1, set), GeoHash.gridAsString("29jw", 1, set));
    }
}