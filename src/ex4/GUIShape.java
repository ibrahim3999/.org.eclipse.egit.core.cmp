package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import ex4.geometry.*;

public class GUIShape implements GUI_Shape{
	private Color color;
	private int Tag;
	private GeoShape Shape;
	private boolean filled;

	public GUIShape(GeoShape shape,boolean filled,Color color ,int tag ) {
		this.color = color; 
		Tag = tag;
		Shape = shape;
		this.filled = filled;
	}
	public GUIShape(String str)//for String contructor
	{
		try {       
			int j =0;
			String[] a = str.split(",");
			double[] Arr = new double[a.length - 5];
			for (int i = 0; i < a.length; i++) {
				if(i == 1)
					color = Color.decode(a[i]);
				if(i == 2)
					filled = Boolean.parseBoolean(a[i]);
				if(i == 3)
					Tag = Integer.parseInt(a[i]);
				if(i > 4) {
					Arr[j++] = Double.parseDouble(a[i]);
				}
			}
			if(a[4].equals("Point2D")) {
				Shape = new Point2D(Arr[0],Arr[1]);
			}
			else if(a[4].equals("Circle2D")) {
				Shape = new Circle2D(new Point2D(Arr[0],Arr[1]),Arr[2]);
			}
			else if(a[4].equals("Segment2D")) {
				Shape = new Segment2D(new Point2D(Arr[0],Arr[1]),new Point2D(Arr[2],Arr[3]));
			}
			else if(a[4].equals("Rect2D")) {
				Shape = new Rect2D(new Point2D(Arr[0],Arr[1]),new Point2D(Arr[2],Arr[3]));
			}
			else if(a[4].equals("Triangle2D")) {
				Shape = new Triangle2D(new Point2D(Arr[0],Arr[1]),new Point2D(Arr[2],Arr[3]),new Point2D(Arr[4],Arr[5]));
			}

		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for shape init, got:"+ str +"  should be of format: " + this.toString()) ;
			throw(e);
		}
	}
	public GUIShape()//defulat contructor
	{
		this.color=Color.black;
		Tag=0;
		Shape=new Segment2D(new Point2D(2,2),new Point2D(3,3));
		filled=false;
	}
	public GUIShape(GUI_Shape GUIShape)
	{					
			filled=GUIShape.isFilled();
			Tag=GUIShape.getTag();
			color=GUIShape.getColor();
			Shape=GUIShape.getShape();
			
	}
	@Override
	public GeoShape getShape() {
		return Shape;
	}

	@Override
	public boolean isFilled() {

		return filled;
	}

	@Override
	public void setShape(GeoShape g) {
		this.Shape=g;
	}

	@Override
	public void setFilled(boolean filled) {
		this.filled=filled;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color cl) {
		this.color=cl;
	}

	@Override
	public int getTag() {
		return Tag;
	}

	@Override
	public void setTag(int tag) {
		this.Tag=tag;
	}
	@Override
	public GUI_Shape copy() {
			return new GUIShape(getShape(), isFilled(),getColor() , getTag());
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+","+(this.color.getRGB()&0xffffff)+","+this.isFilled()+","+""+this.getTag()
				+","+this.getShape().getClass().getSimpleName()+","+this.getShape().toString()+" "; 
	}
}