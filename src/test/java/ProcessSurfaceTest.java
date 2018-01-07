import entity.Point;
import observer.Angle;
import org.junit.Assert;
import org.junit.Test;

public class ProcessSurfaceTest extends BaseTest {

    @Test
    public void testValueChangedCos() {

        Angle angle = new Angle();
        surface.addObserver(angle);
        double oldCos = surface.getCos();
        Point newPointOne = new Point(18, 5, -3);
        surface.setPointOne(newPointOne);
        double newCos = surface.getCos();
        Assert.assertNotEquals(oldCos, newCos);
    }
}
