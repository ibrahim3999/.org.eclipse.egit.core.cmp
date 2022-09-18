package ex4;
import java.util.Vector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Comparator;

import ex4.geometry.*;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{

	Vector <GUI_Shape>Shapes;
	Vector <GUI_Shape>w;
	public Shape_Collection()
	{
		Shapes=new Vector<GUI_Shape>();
	}
	public Shape_Collection(Vector<GUI_Shape> V) {
		this.Shapes=V;
	}

	@Override
	public GUI_Shape get(int i) {
		return Shapes.get(i);		
	}

	@Override
	public int size() {
		if(Shapes.size()==0)return 0;
		return Shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {

		return Shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		Shapes.add(i,s);
	}
	@Override
	public void add(GUI_Shape s) {
		Shapes.add(s);

	}
	@Override
	public GUI_Shape_Collection copy() {
		return new Shape_Collection(Shapes);
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		Shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		Shapes.removeAllElements();
	}

	@Override
	public void save(String file) {

		try {
			FileWriter myWriter = new FileWriter(file);//new  file Writer 
			for(int i=0;i<Shapes.size();i++) {
				myWriter.write(Shapes.get(i).toString()+"\n");//save line by line to myWriter file
			}
			myWriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String file) {
		BufferedReader reader;//class in java  read file
		try {
			w=new Vector<GUI_Shape>();
			reader=new BufferedReader(new FileReader(file));
			String line =reader.readLine();
			while(line != null)
			{
				w.add(new GUIShape(line));//add to Vector (w) line by line 
				line=reader.readLine();
			}
			Shapes.clear();
			Shapes.addAll(w);
			reader.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Rect2D getBoundingBox() {
		double Max_X_Right_Up=0,Max_Y_Right_Up=0,Min_X_Left_Down=0,Min_Y_Left_Down=0;

		for(int i=0;i<Shapes.size();i++)
		{
			for(int j=0;j<Shapes.get(i).getShape().getPoints().length;j++)
				{
				/*  the Circle Radius+centerOfMass or centerOfMass-Radius */
					if(Shapes.get(i).getShape() instanceof Circle2D  )
					{
						Circle2D c1= (Circle2D) Shapes.get(i).getShape();
						Max_X_Right_Up=Math.max(c1.getRadius()+c1.centerOfMass().x(),Max_X_Right_Up) ;
						Min_X_Left_Down=Math.min(c1.centerOfMass().x()-c1.getRadius(), Min_X_Left_Down);
						Min_Y_Left_Down=Math.min(c1.centerOfMass().y()-c1.getRadius(), Min_Y_Left_Down);
						Max_Y_Right_Up=Math.max(c1.getRadius()+c1.centerOfMass().y(), Max_Y_Right_Up);
						
					}
					else {
					/*Min point and Max Point for all shapes without Circle*/
					Max_X_Right_Up=Math.max(Shapes.get(i).getShape().getPoints()[j].x(),Max_X_Right_Up);
					Min_X_Left_Down=Math.min(Shapes.get(i).getShape().getPoints()[j].x(), Min_X_Left_Down);
					Min_Y_Left_Down=Math.min(Shapes.get(i).getShape().getPoints()[j].y(), Min_Y_Left_Down);
					Max_Y_Right_Up=Math.max(Shapes.get(i).getShape().getPoints()[j].y(), Max_Y_Right_Up);
					}
				}
		}	

		return new Rect2D(new Point2D(Min_X_Left_Down,Min_Y_Left_Down),new Point2D(Max_X_Right_Up,Max_Y_Right_Up));

	}
	@Override
	public String toString() {
		for(GUI_Shape S:Shapes)
		{
			System.out.println(S.toString());
		}
		return "";
	}

}
