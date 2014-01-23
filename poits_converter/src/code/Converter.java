package code;

import model.Point;
import sample.PointConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blackstar on 12.01.14.
 */
public class Converter implements PointConverter {
    List<Point> pointList = new ArrayList<>();
    @Override
    public List<Point> convertFromFile(File pointsFile) {
       try(BufferedReader reader = new BufferedReader(new FileReader(pointsFile))){

           String line;
           int lineNo=0;
           Point point;
           while( (line = reader.readLine()) != null){

               if(lineNo > 3 ){
               point = new PointImpl();

               String[] values = line.split(",");
                   point.setId(Long.valueOf(values[0]));
                   point.setName(values[1]);
                   point.setLatitude(Double.valueOf(values[2]));
                   point.setLongitude(Double.valueOf(values[3]));
                   point.setDescription(values[10]);

                   pointList.add(point);

           }
               lineNo++;
           }
       } catch(IOException exception){exception.printStackTrace();}

                 return pointList;

       }



    }

