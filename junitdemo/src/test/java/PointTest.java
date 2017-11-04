import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    List<Point> pointList;

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Hi there! We're about to run a test!");
        pointList = new ArrayList<Point>();
        pointList.add(new Point((int) (Math.random() * 1000), (int) (Math.random() * 1000)));
        pointList.add(new Point((int) (Math.random() * 1000), (int) (Math.random() * 1000)));
        System.out.printf("Testing %s -> %s\n", pointList.get(0), pointList.get(1));
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("We're done with that particular test");
    }

    @Test
    public void doRandomTest1() {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int calculatedDistance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void doRandomTest2() {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int calculatedDistance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void doRandomTest3() {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int calculatedDistance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void testGetDistance2x2to6x4() {
        Point p = new Point(2, 2);
        Point q = new Point(6, 4);
        int calculatedDistance = p.getDistance(q);
        int realDistance = 6;
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void testGetDistance6x4to2x2() {
        Point p = new Point(6, 4);
        Point q = new Point(2, 2);
        int calculatedDistance = p.getDistance(q);
        int realDistance = 6;
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void testGetDistance5x1to1x3() {
        Point p = new Point(5, 1);
        Point q = new Point(1, 3);
        int calculatedDistance = p.getDistance(q);
        int realDistance = 6;
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void testGetDistance2x2to5x2() {
        Point p = new Point(2, 2);
        Point q = new Point(5, 2);
        int calculatedDistance = p.getDistance(q);
        int realDistance = 3;
        assertEquals(realDistance, calculatedDistance);
    }

    @Test
    public void testGetDistance5x2to2x2() {
        Point p = new Point(5, 2);
        Point q = new Point(2, 2);
        int calculatedDistance = p.getDistance(q);
        int realDistance = 3;
        assertEquals(realDistance, calculatedDistance);
    }
}
