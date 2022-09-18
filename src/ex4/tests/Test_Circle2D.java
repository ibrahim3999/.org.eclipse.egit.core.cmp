package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;

class Test_Circle2D {

	@Test
	void test_contains()
	{
	Point2D p1=new Point2D(1,2);
	Point2D p2=new Point2D(3,2);
	Circle2D c1=new Circle2D(p2,3);
	assertEquals(c1.contains(p1),true);
	}
	@Test
	void test_centerOfMass()
	{
		Point2D p2=new Point2D(2,2);
		Circle2D c1=new Circle2D(p2,3);
		assertEquals(c1.centerOfMass(),p2);
	}
	@Test
	void test_area()
	{
		Point2D p2=new Point2D(3,2);
		Circle2D c1=new Circle2D(p2,3);
		assertEquals(c1.area(),28.274333882308138);
	}
	@Test
	void test_perimeter()
	{
		Point2D p2=new Point2D(3,2);
		Circle2D c1=new Circle2D(p2,3);
		assertEquals(c1.perimeter(),18.84955592153876);
	}
	@Test
	void test_move()
	{
		Point2D p2=new Point2D(3,2);
		Circle2D c1=new Circle2D(p2,3);
		c1.move(new Point2D(1,1));
		assertEquals(c1.toString(),"4.0,3.0, 3.0");
	}
	@Test
	void test_GeoShape_copy()
	{
		Point2D p2=new Point2D(3,2);
		Circle2D c1=new Circle2D(p2,3);
		Circle2D c2=new Circle2D(p2,3);
		assertEquals(c1.copy().toString(),c2.toString());
		
	}
	@Test
	void test_getPoints()
	{
		Point2D p2=new Point2D(3,2);
		Circle2D c1=new Circle2D(p2,3);
		 Point2D[] c=new Point2D[2];
		 
		 c[0] =new Point2D(3,2);
			c[1] = new Point2D(c[0].x(), c[0].y()+3);
		 
		assertEquals(Arrays.toString(c1.getPoints()),Arrays.deepToString(c));

	}
	
	
	

}
