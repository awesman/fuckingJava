import entity.Point;
import observer.Angle;
import org.junit.Assert;
import org.junit.Test;

public class ProcessSurfaceTest extends BaseTest {

    @Test
    public void testValueChangedCos() {

        Angle angle = new Angle();
        surface.addObserver(angle);
        double cosines = angle.getAngle(id);
        System.out.println(cosines);
        Point newPointOne = new Point(-1, 5, -3);
        surface.setPointOne(newPointOne);
        double changedCos = angle.getAngle(id);
        System.out.println(changedCos);
        Assert.assertNotEquals(cosines, changedCos);
       /* Angle triangleCos = Angle.getInstance();
        double cosines = triangleCos.getAngle(id);
        System.out.println(cosines);
        surface.addObserver(surface);
        Point newPointOne = new Point(-1, 5, -3);
        surface.setPointOne(newPointOne);
        double changedCos = triangleCos.getAngle(id);
        System.out.println(changedCos);
        Assert.assertNotEquals(cosines, changedCos);*/
    }
}
