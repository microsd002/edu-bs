package code;

import model.Point;
import sample.PointConverter;
import java.io.File;
import java.util.List;

/**
 * Created by Blackstar on 12.01.14.
 */
public class Test {

    public static void main(String... args){

        File file = new File("src/sample.wpt");

        PointConverter pointConveter = new Converter();

        List<Point> points =  pointConveter.convertFromFile(file);

        System.out.println("File path: "+file.getAbsolutePath());

        System.out.println("-----------------------------");

        for(Point point : points)

            System.out.println(point);
        }
    }

