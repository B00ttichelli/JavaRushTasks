package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader result;
    public static ImageReader getImageReader(ImageTypes imageTypes){

        try {
            switch (imageTypes){
                case BMP:
                    result = new BmpReader();
                    break;
                case JPG:
                    result = new JpgReader();
                    break;
                case PNG:
                    result = new PngReader();
                    break;


                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }catch (NullPointerException e){
            throw new IllegalArgumentException();
        }
        return result;
    }
}
