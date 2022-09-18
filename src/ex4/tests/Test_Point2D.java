package ex4.tests;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


import org.junit.jupiter.api.Test;

import ex4.geometry.*;

class Test_Point2D {
	@Test
	void Test_contians()
	{
		Point2D p1=new Point2D(1,2);
		p1.contains(p1);
		assertEquals(p1.contains(p1),true);
	}
	@Test
	void Test_distance(){
		Point2D p1=new Point2D(1,2);
		Point2D p2=new Point2D(3,2);
		assertEquals(p1.distance(p2),2.0);
		assertEquals(p1.distance(),2.23606797749979);
	}
	@Test
	void Test_equals()
	{
		Point2D p2=new Point2D(3,2);
		assertEquals(p2.equals(p2),true);
	}
	@Test
	void Test_close2equals()
	{
		Point2D p1=new Point2D(1,2);
		Point2D p2=new Point2D(3,2);
		assertEquals(p2.close2equals(p1,0.01),false);
		assertEquals(p2.close2equals(p2,0.01),true);
		
	}
	@Test
	void Test_contains()
	{
		Point2D p1=new Point2D(1,2);
		Point2D p2=new Point2D(3,2);
		assertEquals(p1.contains(p2),false);
	}
	@Test
	void Test_centerOfMass()
	{
		Point2D p1=new Point2D(1,2);
		assertTrue(p1.centerOfMass().equals(p1));
	}
	@Test
	void Test_area()
	{
		Point2D p1=new Point2D(1,2);
		assertEquals(p1.area(),0.0);
	}
	@Test
	void Test_perimeter()
	{
		Point2D p1=new Point2D(1,2);
		assertEquals(p1.perimeter(),0.0);
	}
	@Test
	void Test_move()
	{
		Point2D p1=new Point2D(1,2);
		p1.move(new Point2D(1,1));
		assertEquals(p1.toString(),"2.0,3.0");
	}
	@Test
	void Test_GeoShape_copy()
	{
		Point2D p1=new Point2D(1,2);
		Point2D p2=new Point2D(1,2);
		assertEquals(p1.copy(),p2);
	}
	@Test
	void Test_getPoints()
	{
		Point2D p1=new Point2D(1,2);
		 Point2D[] c=new Point2D[1];
		 c[0] =new Point2D(1,2);
		assertEquals(Arrays.toString(p1.getPoints()),Arrays.deepToString(c));
	}
}

