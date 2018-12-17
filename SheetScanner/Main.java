package SheetScanner;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static SheetScanner.Util.*;

public class Main {

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String[] args) throws Exception {
        Mat source = Imgcodecs.imread(getInput("ex_1.jpg"));
        findQuad.Quadrilateral quad = findQuad.findDocument(source);
        findQuad.setTrans(quad, findQuad.mark4Point(source, quad.points));
        String[] Answers = findQuad.findBubble(quad);
        System.out.println("finished");
    }
}
