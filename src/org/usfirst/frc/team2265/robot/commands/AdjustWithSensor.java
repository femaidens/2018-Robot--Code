package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.PIDDrive;
import org.usfirst.frc.team2265.robot.subsystems.PIDDrive.SensorMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AdjustWithSensor extends Command{

	public AdjustWithSensor() {
		requires(Robot.drive);
		// Makes command interruptible
		setInterruptible(true);
		
	}
	@Override
	protected void initialize() {
		// Calibrates the turn angle
		if(Robot.drive.sensorMode == SensorMode.ENCODER) {
			Robot.drive.startAdjust(Robot.drive.getREncDistance(), SmartDashboard.getNumber("Right Drive", 0));
			Robot.drive.startAdjust(Robot.drive.getLEncDistance(), SmartDashboard.getNumber("Left Drive", 0));
		}

		else
			Robot.drive.startAdjust(PIDDrive.gyro.getAngle(), SmartDashboard.getNumber("Turn", 0));
		    // Sets PID of the PID controller to the values given on the SmartDashboard
			Robot.drive.getPIDController().setPID(SmartDashboard.getNumber("P", 0.1), SmartDashboard.getNumber("I", 0), SmartDashboard.getNumber("D", 0.1));
	}

	@Override
	protected void execute() {
		// Inserts the current angle of the gyro onto the SmartDashboard
		SmartDashboard.putNumber("GyroValue", PIDDrive.gyro.getAngle());
		SmartDashboard.putNumber("EncoderValue Right", Robot.drive.getREncDistance());
		SmartDashboard.putNumber("EncoderValue Right", Robot.drive.getLEncDistance());
	}

	@Override
	protected boolean isFinished() {
		// Ends when the robot is at the desired angle
		return Robot.drive.getPIDController().onTarget();
	}

	@Override
	protected void end() {
		Robot.drive.endAdjust();	
	}

	@Override
	protected void interrupted() {
		end();
	}

}