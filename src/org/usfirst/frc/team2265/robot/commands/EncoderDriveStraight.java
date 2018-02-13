package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDriveStraight extends Command {
	private double distance;
	private double setpoint;
	private double drivingValue;
	private double actualChange;
	private double leftVel;
	private double rightVel;
	private double kP;
	private double kD;
	
    public EncoderDriveStraight(double d, double v) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	distance = d;
    	leftVel = v;
    	rightVel = v;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*setpoint = 0.0; //this is the desired difference between the left encoder distance and the right encoder distance
    	kP = 0.0006;
    	kD = 0.008;
    	actualChange = Drivetrain.encoderLeft.getDistance() - Drivetrain.encoderRight.getDistance();
    	double error = setpoint - (actualChange);
    	double lasterror = 0.0;
    	double drivingValue = error * kP + (error-lasterror)*kD;
    	Drivetrain.encoderRight.reset();
    	Drivetrain.encoderLeft.reset();*/
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*while(Drivetrain.encoderLeft.getDistance() < distance && Drivetrain.encoderRight.getDistance() < distance) {
    	
    		
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
