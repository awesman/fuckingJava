package logic;

import entity.Point;
import entity.Surface;
import entity.exception.SurfaceException;
import observer.Angle;

import java.util.ArrayList;
import java.util.List;

public class SurfaceAction {

    public static boolean surfaceExists(Surface one) {

        //TO DO fix number 2 as constant

        double x1 = one.getPointOne().getX();
        double x2 = one.getPointTwo().getX();
        double x3 = one.getPointThree().getX();
        double y1 = one.getPointOne().getY();
        double y2 = one.getPointTwo().getY();
        double y3 = one.getPointThree().getY();
        double z1 = one.getPointOne().getZ();
        double z2 = one.getPointTwo().getZ();
        double z3 = one.getPointThree().getZ();
        double a;
        double b;
        double c;
        double d;
        a = y1 * (z2 - z3) + y2 * (z3 - z1) + y3 * (z3 - z2);
        b = z1 * (x2 - x3) + z2 * (x3 - x1) + z3 * (x3 - x2);
        c = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y3 - y2);
        d = (x1 * (y2 * z3 - y3 * z2) + x2 * (y3 * z1 - y1 * z3) + x3 * (y1 * z2 - y2 * z1)) / (-1);
        return (a * x1 + b * y1 + c * z1 + d) == 0
                && (a * x2 + b * y2 + c * z2 + d) == 0
                && (a * x3 + b * y3 + c * z3 + d) == 0;
    }

    public static double cosWithOxy(Surface one) {
        Angle angle = Angle.getInstance();
        double x1 = one.getPointOne().getX();
        double x2 = one.getPointTwo().getX();
        double x3 = one.getPointThree().getX();
        double y1 = one.getPointOne().getY();
        double y2 = one.getPointTwo().getY();
        double y3 = one.getPointThree().getY();
        double z1 = one.getPointOne().getZ();
        double z2 = one.getPointTwo().getZ();
        double z3 = one.getPointThree().getZ();
        double a;
        double b;
        double c;
        a = y1 * (z2 - z3) + y2 * (z3 - z1) + y3 * (z3 - z2);
        b = z1 * (x2 - x3) + z2 * (x3 - x1) + z3 * (x3 - x2);
        c = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y3 - y2);
        double surfaceAngle = c / ((Math.sqrt(1)) * (Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2))));
        angle.addAngle(one.getId(), surfaceAngle);
        return surfaceAngle;
    }

    public static List<Surface> createSurface(List<String> lines) throws SurfaceException {
        List<Surface> surface = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] coordinates = line.split("\\s");
            if (coordinates.length != 9) {
                throw new SurfaceException("Incorrect file " + i);
            }
            try {
                Point one = new Point(Double.valueOf(coordinates[0]), Double.valueOf(coordinates[1]), Double.valueOf(coordinates[2]));
                Point two = new Point(Double.valueOf(coordinates[3]), Double.valueOf(coordinates[4]), Double.valueOf(coordinates[5]));
                Point three = new Point(Double.valueOf(coordinates[6]), Double.valueOf(coordinates[7]), Double.valueOf(coordinates[8]));
                surface.add(new Surface(id,one, two, three));
                id++;
            } catch (NumberFormatException e) {
                throw new SurfaceException("Incorrect file " + i);
            }
        }
        return surface;
    }

}
