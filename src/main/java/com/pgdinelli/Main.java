package com.pgdinelli;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.bytedeco.opencv.global.opencv_imgproc;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static org.opencv.core.CvType.CV_8UC3;
import static org.bytedeco.opencv.global.opencv_core.*;


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

        // check if camera was opened, if not then print error message
        if (!capture.isOpened()){
            System.out.println("Error! Unable to access camera.");
        }

        // background object used to capture the background of the image
        Mat background = new Mat();

        // converter object that is used to convert mat object, so it can be read by CanvasFrame class
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();

        // add event listener to capture background when key is pressed
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    mat.copyTo(background); // Capture background
                    System.out.println("Background captured.");
                }
            }
        });

        // show frames while program is running
        while (true){
            capture.read(mat); // read method from VideoCapture class, receives an object of Mat type as argument

            // checks if mat is being captured
            if (mat.empty()) {
                System.out.println("Failed to capture frame.");
                break;
            }

            // check if background has been captured
            if (background.empty()) {
                canvas.showImage(converter.convert(mat));
                continue;
            }

            // convertedMat used to convert the original mat from BGR to HSV format
            Mat convertedMat = new Mat();
            // convert BGR format to HSV
            opencv_imgproc.cvtColor(mat, convertedMat, opencv_imgproc.COLOR_BGR2HSV);


            // Mat objects to get masks for color
            Mat finalMask = new Mat(mat.size(), CV_8UC1);
            Mat invertedMask = new Mat(mat.size(), CV_8UC1);
            Mat foreground = new Mat(mat.size(), mat.type());
            Mat backgroundMasked = new Mat(mat.size(), mat.type());
            Mat result = new Mat(mat.size(), mat.type());

            // set HSV intervals for the chosen color
            Mat lowerInferior = new Mat(1, 1, CV_8UC3, new Scalar(35, 50, 50, 0));
            Mat lowerSuperior = new Mat(1, 1, CV_8UC3, new Scalar(110, 255, 255, 0));
            // filter HSV intervals and create a mask
            inRange(convertedMat, lowerInferior, lowerSuperior, finalMask);

            // Smoothing the mask using GaussianBlur filter, smoothes strong borders
            opencv_imgproc.GaussianBlur(finalMask, finalMask, new Size(1, 1), 0);

            // invert masks
            bitwise_not(finalMask, invertedMask);

            // combine the inverted mask with the original mask
            bitwise_and(mat, mat, foreground, invertedMask);
            bitwise_and(background, background, backgroundMasked, finalMask);

            // merge and show the final image result
            add(foreground, backgroundMasked, result);
            canvas.showImage(converter.convert(result));

            // adds delay inside the loop, otherwise the code runs too quick, and it won't be able to process the image correctly
            try {
                Thread.sleep(30);
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

        // release resources
        capture.release();
        canvas.dispose();

    }

}