import org.junit.Test;

import java.util.List;

import static helper.FileReader.pointsInput;

public class MainTest {

    @Test
    public void testTaskOne(){
        String path = "src/main/resources/data.csv";

        List<String> points = pointsInput(path);

        for(String p : points){
            System.out.println(p);
        }
    }

}
