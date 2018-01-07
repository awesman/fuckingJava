package observer;

import entity.Point;
import entity.Surface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static logic.SurfaceAction.cosWithOxy;

public class Angle implements Observer {

    public static Angle instance = null;
    private static List<Surface> angles = new ArrayList<>();


    public void addObservable(Surface surface) {
        angles.add(surface);
    }

    public static Angle getInstance() {
        if (instance == null) {
            instance = new Angle();
        }
        return instance;
    }

    @Override
    public void processSurface(SurfaceEvent event) {

        double newCos = cosWithOxy(event.getSource());
        Point one = event.getSource().getPointOne();
        Point newPoint;
        Iterator<Surface> iterator = angles.iterator();
        boolean change = false;
        while (iterator.hasNext()) {
            Surface sur = iterator.next();
            newPoint = sur.getPointOne();
            if (one.equals(newPoint)) {
                change = true;
            }
        }
        if (change) {
            event.getSource().setCos(newCos);
            LeaderInfo.currentCos = newCos;
        }
    }
}
