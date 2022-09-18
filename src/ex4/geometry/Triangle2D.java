package ex4.geometry;
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	private Point2D A;
	private Point2D B;
	private Point2D C;
	public double  EPS=0.000000000000001;
	public Triangle2D(Point2D A,Point2D B,Point2D C) {
		this.A=A;
		this.B=B;
		this.C=C;
	}
	@Override
	public boolean contains(Point2D ot) {
		Triangle2D areaOtBC=new Triangle2D(ot,B,C);
		Triangle2D areaOtBA=new Triangle2D(ot,B,A);
		Triangle2D areaOtCA=new Triangle2D(ot,C,A);
		double area3Tri=areaOtBC.area()+areaOtBA.area()+areaOtCA.area();
		return area3Tri==this.area()-EPS;
	}
	@Override
	public Point2D centerOfMass() {
		return new Point2D((A.x()+B.x()+C.x())/3,(A.y()+B.y()+C.y())/3);
	}
	@Override
	public double area() {
		/*length AB and BC and CB*/
		Segment2D a=new Segment2D(A,B);
		Segment2D b=new Segment2D(A,C);
		Segment2D c=new Segment2D(C,B);	
		/*Heron's formula*/
			return (Math.sqrt((a.perimeter()+b.perimeter()+c.perimeter())
					*(a.perimeter()+b.perimeter()-c.perimeter())
					*(b.perimeter()+c.perimeter()-a.perimeter())*(c.perimeter()+a.perimeter()-b.perimeter())))/4;
	}

	@Override
	
	public double perimeter() {
		/*length AB and BC and CB*/
		Segment2D a=new Segment2D(A,B);
		Segment2D b=new Segment2D(A,C);
		Segment2D c=new Segment2D(C,B);	
		return a.perimeter()+b.perimeter()+c.perimeter();//AB+AC+BC
	}

	@Override
	public void move(Point2D vec) {
		this.A.move(vec);
		this.B.move(vec);
		this.C.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Triangle2D(A,B,C);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] res=new Point2D[3];
		res[0]=A;
		res[1]=B;
		res[2]=C;
		return res;
	}
	@Override
	public String toString() {
		return ""+A.x()+","+A.y()+","+B.x()+","+B.y()+","+C.x()+","+C.y();
	}
	public Point2D getA() {
		return A;
	}
	public void setA(Point2D a) {
		A = a;
	}
	public Point2D getB() {
		return B;
	}
	public void setB(Point2D b) {
		B = b;
	}
	public Point2D getC() {
		return C;
	}
	public void setC(Point2D c) {
		C = c;
	}
}