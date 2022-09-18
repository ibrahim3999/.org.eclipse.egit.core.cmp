package ex4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;

class TestShape_Collection {

	@Test
	void get_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		V.add(G1[3]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		assertEquals(s1.get(0).toString(),"GUIShape,255,true,0,Segment2D,77.0,2.0,1.0,8.0 ");
		assertEquals(s1.get(1).toString(),"GUIShape,255,true,2,Segment2D,0.0,2.0,1.0,6.0 ");
		assertEquals(s1.get(2).toString(),"GUIShape,255,true,0,Point2D,1.0,2.0 ");
	}
	@Test 
	void size_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		V.add(G1[3]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		assertEquals(s1.size(),4);
	}
	
	
	@Test 
	void removeElementAt_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		s1.removeElementAt(2);
		assertEquals(s1.toString(),"[GUIShape,255,true,0,Segment2D,77.0,2.0,1.0,8.0 , GUIShape,255,true,2,Segment2D,0.0,2.0,1.0,6.0 ]");
	}
	@Test 
	void addAt_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		s1.addAt(G1[2], 0);
		assertEquals(s1.toString(),"[GUIShape,255,true,0,Point2D,1.0,2.0 , GUIShape,255,true,0,Segment2D,77.0,2.0,1.0,8.0 , GUIShape,255,true,2,Segment2D,0.0,2.0,1.0,6.0 , GUIShape,255,true,0,Point2D,1.0,2.0 ]");
	}
	@Test 
	void add_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		s1.add(G1[2]);
		assertEquals(s1.toString(),"[GUIShape,255,true,0,Segment2D,77.0,2.0,1.0,8.0 , GUIShape,255,true,2,Segment2D,0.0,2.0,1.0,6.0 , GUIShape,255,true,0,Point2D,1.0,2.0 , GUIShape,255,true,0,Point2D,1.0,2.0 ]");
	}
	@Test 
	void copy_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		assertEquals(s1.toString(),s1.copy().toString());
	}
	@Test 
	void sort_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		s1.sort(new Shape_Comp(4));
		
		assertEquals(s1.toString(),"[GUIShape,255,true,0,Point2D,1.0,2.0 , GUIShape,255,true,2,Segment2D,0.0,2.0,1.0,6.0 , GUIShape,255,true,0,Segment2D,77.0,2.0,1.0,8.0 ]");
	}
	@Test 
	void removeAll_Test()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		s1.removeAll();
		assertEquals(s1.toString(),"[]");
	}
	@Test
	void test_load()
	{
		GUI_Shape_Collection s1=new Shape_Collection();
		s1.load("Test_Shape_Collection_load.txt");
		assertEquals(s1.toString(),"[GUIShape,255,true,0,Point2D,1.0,2.0 ]");
		
	}
	@Test
	void test_save()
	{
		GUI_Shape_Collection s1=new Shape_Collection();
		GUI_Shape_Collection s2=new Shape_Collection();
		s1.add(new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0));
		s1.save("Test_Shape_Collection_save.txt");
		s2.load("Test_Shape_Collection_save.txt");
		System.out.println(s1);
		System.out.println(s2);
		assertEquals(s1.toString(),s2.toString());
		
	}
	@Test
	void test_getBoundingBox()
	{
		Vector <GUI_Shape>V=new Vector<GUI_Shape>();
		GUI_Shape []G1=new GUI_Shape[4];
		G1[0]=new  GUIShape(new Segment2D(new Point2D(77,2),new Point2D(1,8)),true,Color.blue ,0);
		G1[1]=new  GUIShape(new Segment2D(new Point2D(0,2),new Point2D(1,6)),true,Color.blue ,2);
		G1[2]=new GUIShape(new Point2D(1,2),true,Color.blue ,0);
		V.add(G1[0]);
		V.add(G1[1]);
		V.add(G1[2]);
		GUI_Shape_Collection s1=new Shape_Collection(V);
		System.out.println(s1.getBoundingBox());
		assertEquals(s1.getBoundingBox().toString(),"0.0,0.0,77.0,8.0");

	}
	
}