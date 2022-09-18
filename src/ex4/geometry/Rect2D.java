package ex4.geometry;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{
	private Point2D left_low;
	private Point2D right_up;

	public Rect2D(Point2D left_low,Point2D right_up)
	{
		this.left_low= new Point2D(left_low);
		this.right_up= new Point2D(right_up);
	}
	@Override
	public boolean contains(Point2D ot) //when the point inside rect is btween the rect 
	{
		return (((this.left_low.y()<=ot.y()) && (this.right_up.y()>=ot.y()) &&(this.left_low.x()<=ot.x() && this.right_up.x()>=ot.x())));

	}
	@Override
	public Point2D centerOfMass() //equals to half length and width (x1-x2)/2 and (y1-y2)/2
	{
		return new Point2D((left_low.x()+right_up.x())/2,(left_low.y()+right_up.y())/2);
	}
	@Override
	public double area()//area=length * width
	{
		return ((left_low.x()-right_up.x())*(left_low.y()-right_up.y()));
	}

	@Override
	public double perimeter() //perimeter=length*2 +width*2
	{
		return ((right_up.x()-left_low.x())+(right_up.y()-left_low.y()))*2;
	}
	@Override
	public void move(Point2D vec) {
		this.right_up.move(vec);
		this.left_low.move(vec);
	}
	@Override
	public GeoShape copy() {
		return new Rect2D(left_low,right_up);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] res = new Point2D[2];
		res[0]=left_low;
		res[1]=right_up;
		return res;
	}
	@Override
	public String toString() {
		return left_low.x()+","+left_low.y()+","+right_up.x()+","+right_up.y();
				
	}
	public Point2D getLeft_low() {
		return left_low;
	}
	public void setLeft_low(Point2D left_low) {
		this.left_low = left_low;
	}
	public Point2D getRight_up() {
		return right_up;
	}
	public void setRight_up(Point2D right_up) {
		this.right_up = right_up;
	}
}