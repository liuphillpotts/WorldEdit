package com.sk89q.worldedit;

import org.junit.*;
import static org.junit.Assert.*;

public class VectorTest {
    @Test
    public void collinearityTest() {
        assertCollinear(0,0,0, 0,0,0);

        assertCollinear(0,0,0, 1,0,0);
        assertCollinear(0,0,0, 0,1,0);
        assertCollinear(0,0,0, 0,0,1);

        assertCollinear(1,0,0, 0,0,0);
        assertCollinear(0,1,0, 0,0,0);
        assertCollinear(0,0,1, 0,0,0);

        assertCollinear(1,0,0, 2,0,0);
        assertNotCollinear(1,0,0, 0,1,0);

        assertNotCollinear(2,2,2, 8,4,4);
        assertCollinear(8,2,2, 8,2,2);
        assertNotCollinear(4,2,4, 4,4,4);
        assertNotCollinear(1,1,2, 4,8,2);
        assertNotCollinear(4,1,8, 1,4,4);
        assertCollinear(2,4,2, 1,2,1);
        assertNotCollinear(2,2,4, 1,2,1);
        assertNotCollinear(4,4,1, 4,4,4);
        assertNotCollinear(4,1,4, 1,8,2);
        assertCollinear(8,8,4, 4,4,2);
        assertNotCollinear(2,1,8, 1,1,2);
        assertNotCollinear(8,1,2, 2,1,2);
        assertNotCollinear(4,4,8, 2,2,8);
        assertNotCollinear(8,4,8, 1,4,8);
        assertNotCollinear(2,2,2, 1,4,2);
        assertNotCollinear(1,1,2, 8,8,2);
        assertNotCollinear(4,4,8, 8,4,4);
        assertNotCollinear(1,8,2, 4,4,4);
        assertNotCollinear(8,4,2, 1,2,2);
        assertNotCollinear(1,8,2, 8,1,4);
        assertNotCollinear(4,8,1, 4,8,8);
        assertNotCollinear(8,1,8, 8,8,8);
        assertNotCollinear(8,4,1, 4,2,2);
        assertNotCollinear(4,8,1, 4,2,1);
        assertNotCollinear(8,8,1, 2,4,2);
        assertCollinear(8,1,4, 8,1,4);
        assertNotCollinear(4,1,1, 2,4,8);
        assertNotCollinear(4,2,8, 1,4,1);
        assertNotCollinear(1,8,2, 1,8,1);
        assertNotCollinear(1,1,2, 4,2,2);
    }

    private void assertCollinear(double ax, double ay, double az, double bx, double by, double bz) {
        final Vector a = new Vector(ax,ay,az);
        final Vector b = new Vector(bx,by,bz);
        assertTrue(a.isCollinearWith(b));
        assertTrue(b.isCollinearWith(a));
        assertTrue(a.multiply(-1).isCollinearWith(b));
        assertTrue(a.isCollinearWith(b.multiply(-1)));
    }
    private void assertNotCollinear(double ax, double ay, double az, double bx, double by, double bz) {
        final Vector a = new Vector(ax,ay,az);
        final Vector b = new Vector(bx,by,bz);
        assertFalse(a.isCollinearWith(b));
        assertFalse(b.isCollinearWith(a));
        assertFalse(a.multiply(-1).isCollinearWith(b));
        assertFalse(a.isCollinearWith(b.multiply(-1)));
    }
}