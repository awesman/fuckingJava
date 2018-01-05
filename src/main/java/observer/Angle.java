package observer;

import entity.Surface;
import logic.SurfaceAction;

import java.util.ArrayList;
import java.util.List;

public class Angle implements SurfaceObserver {

    public static Angle instance = null;
    private static List<Surface> angles = new ArrayList<>();


    public void addObservable(Surface surface){
        angles.add(surface);
    }

    public static Angle getInstance() {
        if (instance == null) {
            instance = new Angle();
        }
        return instance;
    }

   /* public double getAngle(int id) {
        return angles.get(id);
    }

    public void addAngle(int id, double square) {
        angles.add(id, square);
    }*/

    @Override
    public void processSurface(SurfaceEvent event) {
        double angle = event.getOne().getCos();

        Surface one = event.getOne();
        int id = one.getId();
        double newAngle = SurfaceAction.cosWithOxy(one);
        angles.set(id, newAngle);
    }
}
