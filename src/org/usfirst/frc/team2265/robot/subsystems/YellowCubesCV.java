//imports
package org.usfirst.frc.team2265.robot.subsystems;

import java.util.ArrayList;
import java.util.List;
//import java.util.Iterator;

import org.opencv.core.Core;
//import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
//import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

//camera yellow CV subsystems
public class YellowCubesCV {
	public static Mat image = new Mat();
	public static Mat blurredImage = new Mat();
	public static Mat hsvImage = new Mat();
	public static Mat mask = new Mat();
	// public static Mat mat = new Mat();
	public static List<MatOfPoint> contours;
	public static double midX;
	public static ArrayList<Rect> rectList = new ArrayList<Rect>();
	public static Rect maxRect;

	// removes noise from image
	public static void removeNoise(Mat image) {
		/*
		 * blurredImage = new Mat(); hsvImage = new Mat();
		 */

		Size size = new Size(3, 3);
		System.out.println(size.toString());
		Imgproc.cvtColor(image, hsvImage, Imgproc.COLOR_BGR2HSV, 0);
		Imgproc.blur(hsvImage, blurredImage, size); // image is now in HSV and
													// blurred is the new image
													// is in blur
	}

	// filters and contours the image
	public static void contourImage(Mat hsvImage) {
		// mat = new Mat();
		Scalar minValues = new Scalar(52, 81, 87); // place holders (guesses)
		Scalar maxValues = new Scalar(72, 100, 100); // place holders (guesses)

		/*
		 * show the current selected HSV range String valuesToPrint =
		 * "Hue range: " + minValues.val[0] + "-" + maxValues.val[0]+
		 * "\tSaturation range: " +minValues.val[1] + "-" + maxValues.val[1] +
		 * "\tValue range: "+ minValues.val[2] + "-" + maxValues.val[2];
		 * this.onFXThread(this.hsvValuesProp, valuesToPrint);
		 */

		// filters everything within the color range (returns masked image to
		// camera with only minimum /max color values)
		Core.inRange(hsvImage, minValues, maxValues, mask);
		// show the partial output
		// this.onFXThread(maskProp, this.mat2Image(mask));
		// finds and draws contours
		Imgproc.findContours(mask, contours, new Mat(), Imgproc.RETR_CCOMP, Imgproc.CHAIN_APPROX_SIMPLE);
		Imgproc.drawContours(mask, contours, -1, new Scalar(60, 255, 255), 2);
	}

	// finds the largest rectangle
	public static void findCube() {
		// creates lists of rectangles
		for (int i = 0; i < contours.size(); i++) {
			MatOfPoint cPoint = contours.get(i);
			Rect rect = Imgproc.boundingRect(cPoint);
			rectList.add(rect);
		}
		// finds biggest (closest) rectangle
		maxRect = rectList.get(0);
		for (int i = 0; i < rectList.size(); i++) {
			if (rectList.get(i).area() > maxRect.area())
				maxRect = rectList.get(i);
		}
	}

	// turns the correct angle to face the cube straight
	public static double onSide() {
		// gets the index of the largest rectangle from rectList
		int index = 0;
		for (int i = 0; i < rectList.size(); i++) {
			if (maxRect.equals(rectList.get(i))) {
				index = i;
				break;
			}
		}

		Point[] points = contours.get(index).toArray(); // gets the contour that
														// correlates to the
														// largest rectangle

		// gets the farthest left point
		double leftX = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if (leftX > points[i].x)
				leftX = points[i].x;
		}
		// gets the farthest right point
		double rightX = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if (rightX < points[i].x)
				rightX = points[i].x;
		}
		// holds endpoints for two lines (note: turn these into array lists)
		ArrayList<Point> leftPoints = new ArrayList<Point>();
		ArrayList<Point> rightPoints = new ArrayList<Point>();
		// puts values in left points and right points arrays
		for (int i = 0; i < points.length; i++) {
			if (points[i].x == leftX) {
				leftPoints.add(points[i]);
			} else if (points[i].x == rightX) {
				rightPoints.add(points[i]);
			}
		}
		// next time: get the highest and lowest y-values for these points to
		// determine lengths
		double leftLowY = leftPoints.get(0).y;
		double leftHighY = leftPoints.get(0).y;
		for (int i = 0; i < leftPoints.size(); i++) {
			if (leftLowY > leftPoints.get(i).y)
				leftLowY = leftPoints.get(i).y;
			else if (leftHighY < leftPoints.get(i).y)
				leftHighY = leftPoints.get(i).y;
		}
		double rightLowY = rightPoints.get(0).y;
		double rightHighY = rightPoints.get(0).y;
		for (int i = 0; i < rightPoints.size(); i++) {
			if (rightLowY > rightPoints.get(i).y)
				rightLowY = rightPoints.get(i).y;
			else if (rightHighY < rightPoints.get(i).y)
				rightHighY = rightPoints.get(i).y;
		}

		// get lengths of each side of the cube
		double leftSideLength = leftHighY - leftLowY;
		double rightSideLength = rightHighY - rightLowY;
		return rightSideLength - leftSideLength;
	}

}
