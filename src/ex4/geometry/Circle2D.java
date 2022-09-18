package ex4.geometry;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;

	public Circle2D(Point2D cen, double rad) {	
		try {
			if(rad<0) {
				this._radius = 1;
				throw new Exception("Radius cannot be neqative!!!! the new Radius equal 1 your input Radius equals "+rad);
				
			}
			else {
				_radius=rad;
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception triggered");
			System.err.println(e.getMessage());
		}
	this._center = new Point2D(cen);	
}
public Circle2D()
{
	this._center=(new Point2D(1,2));
	this._radius=0.25;
}
public double getRadius() {return this._radius;}

@Override
public String toString()
{ return _center.toString()+", "+_radius;}
@Override
public boolean contains(Point2D ot) {
	double dist = ot.distance(this._center);
	return dist<=this._radius;
}
@Override
public Point2D centerOfMass() {
	return new Point2D(this._center);
}
@Override
public double area() {
	double ans = Math.PI * Math.pow(this._radius, 2);
	return ans;
}
@Override
public double perimeter() {
	double ans = Math.PI * 2 * this._radius;
	return ans;
}
@Override
public void move(Point2D vec) {
	_center.move(vec);
}
@Override
public GeoShape copy() {
	return new Circle2D(_center, _radius);
}
@Override
public Point2D[] getPoints() {
	Point2D[] ans = new Point2D[2];
	ans[0] =new Point2D(this._center);
	ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
	return ans;
}

}