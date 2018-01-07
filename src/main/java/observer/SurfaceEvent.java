package observer;

import entity.Surface;

import java.util.EventObject;

public class SurfaceEvent extends EventObject {

    public SurfaceEvent(Surface source){
        super(source);
    }

    @Override
    public Surface getSource(){
        return (Surface)super.getSource();
    }
}
