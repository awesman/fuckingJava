import entity.Point;
import entity.Surface;
import entity.exception.SurfaceException;
import logic.SurfaceAction;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.List;

import static helper.FileReader.pointsInput;

public abstract class BaseTest {

    protected static String path = "src/main/resources/data.csv";
    protected static int id;
    protected static Point first;
    protected static Point second;
    protected static Point third;
    protected static Surface surface;

    @BeforeClass
    public static void initSurface() throws SurfaceException {
        List<String> points = pointsInput(path);
        List<Surface> generatedSurfaces = SurfaceAction.createSurface(points);
        surface = generatedSurfaces.get(0);
        id = 0;
        first = new Point(1, 2, 3);
        second = new Point(4, 6, 6);
        third = new Point(4, 2, 9);
        surface = new Surface(id, first, second, third);
    }

    @AfterClass
    public static void destroyTriangle() {
        surface = null;
    }
}
