package ex4;
import java.awt.Color;
import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	private GUI_Shape_Collection _gsc;
	
	public Ex4()
	{
		_gsc=new Shape_Collection();
	}
	@Override
	public void init(GUI_Shape_Collection g) {
		_gsc=g;
	}
	

	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return _gsc;
	}

	@Override
	public void show() {
		StdDraw.clear();
		Rect2D bb = _gsc.getBoundingBox();
		Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
		double m0 = Math.min(min.x(), min.y());
		double m1 = Math.max(max.x(), max.y());
		StdDraw.setScale(m0-0.1,m1+0.1);
		
		for (int i = 0; i < _gsc.size(); i++) {
			GUI_Shape g = _gsc.get(i);
			Color c = g.getColor();
			StdDraw.setPenColor(c);
			boolean fill = g.isFilled();
			GeoShape o = g.getShape();

			if(o instanceof Point2D) //if o is Point
			{
				Point2D p = ((Point2D)o).centerOfMass();
				StdDraw.point(p.x(), p.y());				
			}

			if(o instanceof Circle2D)//when o is Circle2D
			{
				Point2D p = ((Circle2D)o).centerOfMass();
				if(fill)//when true else false
					StdDraw.filledCircle(p.x(), p.y(), ((Circle2D)o).getRadius());
				else
					StdDraw.circle(p.x(), p.y(), ((Circle2D)o).getRadius());
			}

			if(o instanceof Rect2D)//when o is Rect2D
			{
				Point2D p = ((Rect2D)o).centerOfMass();
				double high=((Rect2D)o).getLeft_low().x() - ((Rect2D)o).getRight_up().x();
				double width=((Rect2D)o).getRight_up().y() - ((Rect2D)o).getLeft_low().y();
				if(high<0)high*=-1;
				if(width<0)width*=-1;
				if(fill)//when true else false
					StdDraw.filledRectangle(p.x(), p.y(), high/2, width/2);
				
				else
					StdDraw.rectangle(p.x(), p.y(),high/2,width/2);
			}
			if(o instanceof Triangle2D) {
				Point2D A = ((Triangle2D)o).getA();
				Point2D B = ((Triangle2D)o).getB();
				Point2D C = ((Triangle2D)o).getC();
				double[] xp = {A.x(), B.x(), C.x()};
				double[] yp = {A.y(), B.y(), C.y()};
				if(fill)//when true else false
					StdDraw.filledPolygon(xp, yp);
				else {
					StdDraw.line(A.x(), A.y(), B.x(), B.y());
					StdDraw.line(B.x(), B.y(), C.x(), C.y());
					StdDraw.line(C.x(), C.y(), A.x(), A.y());
				}
			}

			if(o instanceof Segment2D)//when o is Segment
			{
				Point2D A = ((Segment2D)o).getA();
				Point2D B = ((Segment2D)o).getB();
				StdDraw.line(A.x(), A.y(), B.x(), B.y());
			}
		}
	}



	@Override
	public String getInfo() {
		return _gsc.toString();
	}
}