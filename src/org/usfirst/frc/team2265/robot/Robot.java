/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
//import org.usfirst.frc.team2265.robot.subsystems.Acquirer;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2265.robot.subsystems.ExampleSubsystem;
//import org.usfirst.frc.team2265.robot.subsystems.Ladder;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	public static OI m_oi;
	public static Drivetrain drivetrain;
	//public static Ladder ladder;
	//public static Acquirer acquirer;
	
	public static Compressor compressy;
	
	public static CvSource outputStream;
	public static CvSink cvSink;
	public static Mat source;
	public static List<MatOfPoint> contours;
	public static Rect maxRect;
	public static Mat hsvImage;// = new Mat();
	public static Mat blurredImage;// = new Mat();
	public static Mat mask;// = new Mat();
	//public static NetworkTable table;
	public static ArrayList<Rect> rectList = new ArrayList<Rect>();


	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		/*
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		drivetrain = new Drivetrain();
		//ladder = new Ladder();
		// = new Acquirer();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		compressy = new Compressor();
		*/
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	    camera.setResolution(640, 480);
	    camera.setBrightness(0);
	    CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	    CvSink cvSink = CameraServer.getInstance().getVideo();
	    
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
	    new Thread(() -> {
								/*
								Mat source = new Mat();
								Mat image = new Mat();
								//Mat image2 = new Mat();
								*/
						    	hsvImage = new Mat();
								blurredImage = new Mat();
								mask = new Mat();
							    source = new Mat();
								while (!Thread.interrupted()) {
									cvSink.grabFrame(source);
									/*
									Imgproc.cvtColor(source, image, Imgproc.COLOR_BGR2HSV, 0);
									
									outputStream.putFrame(image);
									image.release();
									source.release();
									*/
									//source = Imgcodecs.imread("2018-01-20 11-25-06.138");
									removeNoise(source);
									contourImage(blurredImage);
									findCube();
									System.out.println(onSide());
									
									//saves the image in the Downloads file
									//Imgcodecs.imwrite("C:\\Users\\FeMaidens\\Downloads\\source.jpg", source);
									//Imgcodecs.imwrite("C:\\Users\\FeMaidens\\Downloads\\blurred.jpg", blurredImage);
									
									source.release();
									blurredImage.release();
								}
						    }).start();
						}
						
						// removes noise from image
						public static void removeNoise(Mat image) {
						
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
					
						/**
						 * This function is called once each time the robot enters Disabled mode.
						 * You can use it to reset any subsystem information you want to clear when
						 * the robot is disabled.
						 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
