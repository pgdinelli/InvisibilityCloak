package com.pgdinelli;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.bytedeco.opencv.global.opencv_imgproc;

public class Main {
    public static void main(String[] args) {
        // capture object used to capture in real time image through the camera
        VideoCapture capture = new VideoCapture(0);
        capture.set(800, 600);

        // canvas object, shows the camera image to user
        CanvasFrame canvas = new CanvasFrame("Camera");
        canvas.setSize(800, 600);

        // mat object used to get and store pixels of an image
        Mat mat = new Mat();
        // converter object that is used to convert mat object, so it can be read by CanvasFrame class
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();

        // check if camera was opened, if not then print error message
        if (!capture.isOpened()){
            System.out.println("Error! Unable to access camera.");
        }

        // show frames while program is running
        while (true){
            capture.read(mat); // read method from VideoCapture class receives an object of Mat type as argument

            Frame frameToShow = converter.convert(mat); // converts object of type mat to type Frame
            Mat convertedMat = converter.convert(frameToShow); // converts object of type Frame to type Mat

            // convert BGR format to HSV
            opencv_imgproc.cvtColor(mat, convertedMat, opencv_imgproc.COLOR_BGR2HSV);
            // show converted image
            canvas.showImage(frameToShow);


            // adds delay inside the loop, otherwise the code runs too quick, and it won't be able to process the image correctly
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // check if frame is succesfully captured by the camera and prints console message, debugging purposes only
            if (mat.empty()) {
                System.out.println("Failed to capture frame.");
                break;
            } else {
                System.out.println("Frame captured.");
            }

        }

    }

}