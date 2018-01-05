import entity.Point;
import entity.Surface;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class BaseTest {

    protected static int id;
    protected static Point first;
    protected static Point second;
    protected static Point third;
    protected static Surface surface;

    @BeforeClass
    public static void initSurface() {
        id = 0;
        first = new Point(1, 2,3);
        second = new Point(4, 6,6);
        third = new Point(4, 2,9);
        surface = new Surface(id, first, second, third);
    }

    @AfterClass
    public static void destroyTriangle() {
        surface = null;
    }
}
