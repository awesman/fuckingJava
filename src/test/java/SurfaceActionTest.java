import entity.Point;
import entity.Surface;
import entity.exception.SurfaceException;
import logic.SurfaceAction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SurfaceActionTest extends BaseTest{

    @Test
    public void existsTest() {

        Surface one = new Surface(id, first, second, third);
        boolean expected = true;
        boolean result = SurfaceAction.surfaceExists(one);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void TestCreateSurface() throws SurfaceException {
        List<String> lines = new ArrayList<>();
        lines.add("1 2 3 4 6 6 4 2 9");
        Surface surface = new Surface(id, first, second, third);
        List<Surface> surfaces = new ArrayList<>();
        surfaces.add(surface);
        List<Surface> createSurfaces =
                SurfaceAction.createSurface(lines);
        Assert.assertEquals(surfaces, createSurfaces);
    }

    @Test(expected = SurfaceException.class)
    public void TestGenerateSurfaceException()
            throws SurfaceException {
        List<String> lines = new ArrayList<>();
        lines.add("5 6 f 7 1 2");
        SurfaceAction.createSurface(lines);
    }
}
