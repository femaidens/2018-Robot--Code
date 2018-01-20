package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.YellowCubesCV;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import com.ctre.phoenix.motorcontrol.ControlMode;
import org.opencv.core.Mat;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoAlign extends Command {
	public CvSource outputStream;
	public CvSink cvSink;
	public Mat source;
	public boolean done = false;

	public AutoAlign() {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.exampleSubsystem);
		done = false;
		source = new Mat();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
		camera.setBrightness(0);
		outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
		cvSink = CameraServer.getInstance().getVideo();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		cvSink.grabFrame(source);
		YellowCubesCV.removeNoise(source);
		YellowCubesCV.contourImage(YellowCubesCV.blurredImage);
		YellowCubesCV.findCube();
		System.out.println(YellowCubesCV.onSide());
		/*
		if (YellowCubesCV.onSide() != 0) {
			Robot.drivetrain.autoAlign(YellowCubesCV.onSide());
		} else {
			done = true;
		}
		*/
		source.release();
		YellowCubesCV.blurredImage.release();
		done = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
		/*
		Drivetrain.rearLeft.set(ControlMode.PercentOutput, 0.0);
		Drivetrain.frontLeft.set(ControlMode.PercentOutput, 0.0);
		Drivetrain.rearRight.set(ControlMode.PercentOutput, 0.0);
		Drivetrain.frontRight.set(ControlMode.PercentOutput, 0.0);
		*/
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
