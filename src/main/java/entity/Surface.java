package entity;

import logic.SurfaceAction;
import observer.Angle;
import observer.SurfaceEvent;
import java.util.Objects;

public class Surface {

    private int id;
    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;
    private Angle angle;
    private double cos;


    public Surface(int id, Point pointOne, Point pointTwo, Point pointThree) {
        this.id = id;
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
        this.cos = SurfaceAction.cosWithOxy(this);
    }

    public void addObserver(Angle observer) {
        this.angle = observer;
        observer.addObservable(this);
    }

    private void notifyObserver(){
        if(angle !=null){
            angle.processSurface(new SurfaceEvent(this));
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPointOne() {
        return pointOne;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
        notifyObserver();
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
        notifyObserver();
    }

    public Point getPointThree() {
        return pointThree;
    }

    public void setPointThree(Point pointThree) {
        this.pointThree = pointThree;
        notifyObserver();
    }

    public double getCos() {
        return cos;
    }

    public void setCos(double cos) {
        this.cos = cos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surface)) return false;
        Surface surface = (Surface) o;
        return Objects.equals(getPointOne(), surface.getPointOne()) &&
                Objects.equals(getPointTwo(), surface.getPointTwo()) &&
                Objects.equals(getPointThree(), surface.getPointThree());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPointOne(), getPointTwo(), getPointThree());
    }

    @Override
    public String toString() {
        return "Surface{" +
                "pointOne=" + pointOne +
                ", pointTwo=" + pointTwo +
                ", pointThree=" + pointThree +
                '}';
    }

}
