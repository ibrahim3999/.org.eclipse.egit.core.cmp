package ex4.geometry;
public class Segment2D implements GeoShape{
	private Point2D A;
	private Point2D B;
	public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
	public Segment2D(Point2D A, Point2D B) {
		this.A = A;
		this.B = B;
	}
	public Segment2D()
	{
		this.A=new Point2D(1,2);
		this.A=new Point2D(3,4);
	}
	@Override
	public boolean contains(Point2D ot) {
		double sum =ot.distance(A) + ot.distance(B);
		return sum < A.distance(B) + EPS && sum > A.distance(B) - EPS;
	}
	@Override
	public Point2D centerOfMass()//centerOfMass=((x1+x2)/2),(y1+y2)/2)
	{
		return new Point2D((double) ((A.x()+B.x())/2),((double) (A.y()+B.y())/2));
	}

	/**
	 */
	@Override
	public double area() {
		return 0.0;
	}

	@Override
	public double perimeter() //  Math.sqrt( Math.pow((x1-x2),2)+ Math.pow((y1-y2),2)
	{
		return Math.sqrt((Math.pow(A.x()-B.x(),2))+(Math.pow(A.y()-B.y(),2)));
	}

	@Override
	public void move(Point2D vec) {
		this.A.move(vec);
		this.B.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment2D(new Point2D(A), new Point2D(B));
	}
	@Override
	public Point2D[] getPoints() {
		 Point2D[]ans =new Point2D[2];
		 ans[0]=A;
		 ans[1]=B;
		return ans;
	}
	@Override
	public String toString() {
		return A.x()+","+A.y()+","+B.x()+","+B.y();
	}
	public Point2D getA() {
		return A;
	}

	public void setA(Point2D A) {
		this.A = A;
	}

	public Point2D getB() {
		return B;
	}

	public void setB(Point2D B) {
		this.B = B;
	}
}
