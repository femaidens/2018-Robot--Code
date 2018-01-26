package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.PIDDrive;
import org.usfirst.frc.team2265.robot.subsystems.PIDDrive.DriveMode;
import org.usfirst.frc.team2265.robot.subsystems.PIDDrive.SensorMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class PIDDriveCommand extends Command {
	
	private Joystick driveJoystick;
    public PIDDriveCommand(Joystick stick) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        // Initialize joystick used for setting speed.
       driveJoystick = stick;
        // Makes command interruptible.
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(SmartDashboard.getString("Turning?", "true").toLowerCase().equals("true")) {
    		Robot.drive.sensorMode = SensorMode.ENCODER;
    		Robot.drive.driveMode = DriveMode.TURN;
    	}
    	else {
    		Robot.drive.sensorMode = SensorMode.GYRO;
    		Robot.drive.driveMode = DriveMode.DRIVE;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		// Puts the current value of the gyro onto the Smart Dashboard
    		SmartDashboard.putNumber("EncoderL Value", PIDDrive.encoderLeft.getDistance());
    		SmartDashboard.putNumber("EncoderR Value", PIDDrive.encoderRight.getDistance());
    		// Rotates the robot; speed correlated with magnitude of joystick on the y axis
    		Robot.drive.setSpeed(-driveJoystick.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	    Robot.drive.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
    
}