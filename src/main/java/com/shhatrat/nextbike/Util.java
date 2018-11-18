package com.shhatrat.nextbike;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util{


    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static double calculateDistanceBetweenPoints(
            double x1,
            double y1,
            double x2,
            double y2) {
        double result = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        result = result * 10000;
        return result;
    }

}
