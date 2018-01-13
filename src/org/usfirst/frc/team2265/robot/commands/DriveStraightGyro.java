package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveStraightGyro extends Command {
	
	public int angle;
	public double rightVel, leftVel;
	public double distanceLeft, distanceRight;
	
	public DriveStraightGyro(double vel) {
		// requires(Robot.driveTrain);
		rightVel = leftVel = vel;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Drivetrain.gyro.reset();
		Drivetrain.encoderLeft.reset();
		Drivetrain.encoderRight.reset();
		angle = 0;
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Drivetrain.gyro.getAngle() < angle) {
			Drivetrain.frontRight.set(ControlMode.PercentOutput,rightVel + 0.1);
			Drivetrain.rearRight.set(ControlMode.PercentOutput,rightVel + 0.1);
			Drivetrain.frontLeft.set(ControlMode.PercentOutput,leftVel - 0.1);
			Drivetrain.rearLeft.set(ControlMode.PercentOutput,leftVel - 0.1);
			System.out.println("Left:" + Drivetrain.gyro.getAngle());
		} else if (Drivetrain.gyro.getAngle() > angle) {
			Drivetrain.frontLeft.set(ControlMode.PercentOutput,leftVel + 0.1);
			Drivetrain.rearLeft.set(ControlMode.PercentOutput,leftVel + 0.1);
			Drivetrain.rearRight.set(ControlMode.PercentOutput,rightVel - 0.1);
			Drivetrain.frontRight.set(ControlMode.PercentOutput,rightVel - 0.1);
			System.out.println("Right: " + Drivetrain.gyro.getAngle());
		}
		//distanceLeft = Drivetrain.encoderLeft.get();
		//distanceRight = Drivetrain.encoderRight.get();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.drive(0, 0);
		Drivetrain.encoderLeft.reset();
		Drivetrain.encoderRight.reset();
		Drivetrain.gyro.reset();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
