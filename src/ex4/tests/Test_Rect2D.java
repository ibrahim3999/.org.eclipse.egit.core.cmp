package ex4.tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ex4.geometry.*;
class Test_Rect2D {

	@Test
	void test_contains()
	{
		 Rect2D r2=new Rect2D(new Point2D(1,1),new Point2D(6,3));
		 assertEquals(r2.contains(new Point2D(12,3)),false);
	}
	@Test
	void test_centerOfMass()
	{
		Rect2D r2=new Rect2D(new Point2D(1,1),new Point2D(6,3));
		 assertEquals(r2.centerOfMass(),new Point2D(3.5,2.0));
	}
	@Test
	void test_area() {
		Rect2D r2=new Rect2D(new Point2D(1,1),new Point2D(6,3));
		 assertEquals(r2.area(),10.0);
	}
	@Test
	void test_perimeter()
	{
		Rect2D r2=new Rect2D(new Point2D(1,1),new Point2D(6,3));
		 assertEquals(r2.perimeter(),14);
	}
	@Test
	void test_move()
	{
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(6,3);
		
		Rect2D r2=new Rect2D(p1,p2);
		r2.move(new Point2D(2,2));
		assertEquals(r2.toString(),"3.0,3.0,8.0,5.0");
	}
	@Test
	void test_GeoShape_copy()
	{
		Rect2D r7=new Rect2D(new Point2D(1,1),new Point2D(6,3));
		Rect2D r1=new Rect2D(new Point2D(1,1),new Point2D(6,3));
		assertEquals(r7.copy().toString(),r1.toString());
	}
	@Test
	void test_getPoints()
	{
		Point2D p1=new Point2D(1,1);
		Point2D p2=new Point2D(6,3);
		Rect2D r7=new Rect2D(p1,p2);
		Point2D[] res = new Point2D[2];
		res[0]=p1;
		res[1]=p2;
		assertEquals(Arrays.toString(r7.getPoints()),Arrays.deepToString(res));
	}
	
	
	
	
	
	

}
