package Line;

public class Line {
    private MyPoint pointOne;
    private MyPoint pointTwo;
    private double slope;
    private double xInt;
    private double yInt;

    public Line(MyPoint pointOne, MyPoint pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        updateAllLineAttributes();
    }

    public MyPoint getPointOne() {
        return this.pointOne;
    }

    public MyPoint getPointTwo() {
        return this.pointTwo;
    }

    public double getSlope() {
        return this.slope;
    }

    private void updateSlope() {
        this.slope = (pointTwo.getY() - pointOne.getY()) / (pointTwo.getX() - pointOne.getX());
    }

    private void updateXInt() {
        this.xInt = (-1 * this.yInt) / this.slope;
    }

    private void updateYInt() {
        this.yInt = this.pointTwo.getY() - (this.slope * this.pointTwo.getX());
    }

    private void updateAllLineAttributes() {
        updateSlope();
        updateXInt();
        updateYInt();
    }

    public double getYInt() {
        return this.yInt;
    }

    public double getXInt() {
        return this.xInt;
    }

    public void setPointOne(MyPoint pointOne) {
        this.pointOne = pointOne;
        updateAllLineAttributes();
    }

    public void setPointTwo(MyPoint pointTwo) {
        this.pointTwo = pointTwo;
        updateAllLineAttributes();
    }

    public static MyPoint findIntersection(Line lineOne, Line lineTwo) {
        double x = (lineTwo.getYInt() - lineOne.getYInt()) / (lineOne.getSlope() - lineTwo.getSlope());
        double y = lineOne.getSlope() * x + lineOne.getYInt();

        return new MyPoint(x, y);
    }

    @Override
    public String toString() {
        return String.format(
                "Point One: (%f, %f) Point Two: (%f, %f) Slope: %f X-Intercept: %f Y-Intercept: %f Line Equation: Y = %f(x) + %f",
                this.pointOne.getX(), this.pointOne.getY(), this.pointTwo.getX(), this.pointTwo.getY(), this.slope,
                this.xInt, this.yInt, this.slope, this.yInt);
    }
}
