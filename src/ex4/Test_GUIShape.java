package ex4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Test_GUIShape {
	@Test
	void Test_GUI_Shape_copy()
	{
		GUIShape G1=new GUIShape(new Segment2D(new Point2D(2,2),new Point2D(3,3)),true,Color.green,3);
		GUIShape G2=new GUIShape(new Segment2D(new Point2D(2,2),new Point2D(3,3)),true,Color.green,3);
		 assertEquals(G1.copy().toString(),G2.toString());
		 G1=new GUIShape(new Point2D(2,2),false,Color.red,2);
		 G2=new GUIShape(new Point2D(2,2),false,Color.red,2);
		 assertEquals(G1.copy().toString(),G2.toString());
		 G1=new GUIShape(new Triangle2D(new Point2D(2,2),new Point2D(2,6),new Point2D(5,5)),false,Color.cyan,5);
		 G2=new GUIShape(new Triangle2D(new Point2D(2,2),new Point2D(2,6),new Point2D(5,5)),false,Color.cyan,5);
		 assertEquals(G1.copy().toString(),G2.toString());
		 
		 
	}
	@Test
	void Test_toString()
	{
		GUIShape G1=new GUIShape(new Segment2D(new Point2D(2,2),new Point2D(3,3)),true,Color.green,3);
		String s1="GUIShape,65280,true,3,Segment2D,2.0,2.0,3.0,3.0 ";
		assertEquals(G1.toString(),s1);
		G1=new GUIShape(new Point2D(2,2),false,Color.red,2);
		s1="GUIShape,16711680,false,2,Point2D,2.0,2.0 ";
		assertEquals(G1.toString(),s1);
		
	}

}
