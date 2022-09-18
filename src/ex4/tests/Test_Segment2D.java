package ex4.tests;
import ex4.geometry.*;
import ex4.geometry.Segment2D;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Test_Segment2D {

	@Test
	void test_contains()
	{
		Segment2D s7=new Segment2D(new Point2D(6,6),new Point2D(4,4));
		 assertEquals(s7.contains(new Point2D(5,5)),true);
	}
	@Test
	void test_area() {
		Segment2D s3=new Segment2D(new Point2D(5,5),new Point2D(2,2));
		 assertEquals(s3.area(),0.0);
	}
	@Test
	void test_centerOfMass()
	{
		
		Segment2D s2=new Segment2D(new Point2D(6,6),new Point2D(4,4));
		assertEquals(s2.centerOfMass(),new Point2D(5.0,5.0));
	}
	@Test
	void test_perimeter()
	{
		Segment2D s1=new Segment2D(new Point2D(5,5),new Point2D(2,2));
		assertEquals(s1.perimeter(),4.242640687119285);
	}
	@Test
	void test_move()
	{
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(4,4);
		Segment2D s4=new Segment2D(p1,p2);
		s4.move(new Point2D(2,2));
		assertEquals(s4.toString(),"8.0,8.0,6.0,6.0");
	}
	@Test
	void test_getPoints()
	{
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(4,4);
		Segment2D s4=new Segment2D(p1,p2);
		Point2D[] res = new Point2D[2];
		res[0]=p1;
		res[1]=p2;
	
		assertEquals(Arrays.toString(s4.getPoints()),Arrays.deepToString(res));
	}
		
	}
	
	

