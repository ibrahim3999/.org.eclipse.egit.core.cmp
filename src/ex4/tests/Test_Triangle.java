package ex4.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import ex4.geometry.*;
class Test_Triangle {
	@Test
	void test_contains()
	{
		Triangle2D t7=new Triangle2D(new Point2D(2,5),new Point2D(4,1),new Point2D(1,1));
		 assertEquals(t7.contains(new Point2D(1.01,1)),true);
	}
	@Test
	void test_area() {
		Triangle2D t1=new Triangle2D(new Point2D(22,43),new Point2D(55,65),new Point2D(33,33));
		assertEquals(t1.area(),286.0);
	}
	@Test
	void test_perimeter()
	{
		Triangle2D t2=new Triangle2D(new Point2D(22,43),new Point2D(55,65),new Point2D(33,33));
		assertEquals(t2.perimeter(),93.36010845531759);
	}
	@Test
	void test_move()
	{
		Point2D p1 = new Point2D(22,43);
		Point2D p2 = new Point2D(55,65);
		Point2D p3 = new Point2D(33,33);
		Triangle2D t3=new Triangle2D(p1,p2,p3);
		t3.move(new Point2D(1,1));
		assertEquals(t3.toString(),"23.0,44.0,56.0,66.0,34.0,34.0");
	}
	@Test
	void test_GeoShape_copy()
	{
		Point2D p1 = new Point2D(22,43);
		Point2D p2 = new Point2D(55,65);
		Point2D p3 = new Point2D(33,33);
		Triangle2D t3=new Triangle2D(p1,p2,p3);
		Triangle2D t1=new Triangle2D(p1,p2,p3);
		assertEquals(t3.copy().toString(),t1.toString());
		
	}
	@Test
	void test_getPoints()
	{
		Point2D p1 = new Point2D(22,43);
	Point2D p2 = new Point2D(55,65);
	Point2D p3 = new Point2D(33,33);
	Triangle2D t1=new Triangle2D(p1,p2,p3);
	Point2D[] res = new Point2D[3];
	res[0]=p1;
	res[1]=p2;
	res[2]=p3;
	assertEquals(Arrays.toString(t1.getPoints()),Arrays.deepToString(res));
	}
}
