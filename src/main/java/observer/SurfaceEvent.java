package observer;

import entity.Surface;

public class SurfaceEvent {

    Surface one;

    public SurfaceEvent(Surface one){
        this.one=one;
    }

    public Surface getOne(){
        return one;
    }
}
