package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class GyroDriveStraight extends Command {
	private double distance;
	private double setpoint;
	private double turningValue;
	private double leftVel;
	private double rightVel;
	private double kP;
	private double kD;
   

    public GyroDriveStraight(double d, double v) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		distance = d;
		leftVel = v;
		rightVel = v;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setpoint = 0.0;
    	kP = 0.0006;
    	kD = 0.008;
    	double error = setpoint - Drivetrain.gyro.getAngle();
    	double lastError = 0.0;
    	turningValue = error * kP + (error-lastError)*kD;
    	Drivetrain.frontRight.setSafetyEnabled(false);
    	Drivetrain.frontLeft.setSafetyEnabled(false);
    	Drivetrain.rearLeft.setSafetyEnabled(false);
    	Drivetrain.rearRight.setSafetyEnabled(false);
    	Drivetrain.encoderLeft.reset();
    	Drivetrain.encoderRight.reset();
    	Drivetrain.gyro.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Encoder Left Before" + Drivetrain.encoderLeft.getDistance());
    	System.out.println("Encoder Right Before" + Drivetrain.encoderRight.getDistance());
    	while(Drivetrain.encoderLeft.getDistance() < distance && Drivetrain.encoderRight.getDistance() < distance ) {
	    	if (Drivetrain.gyro.getAngle() < turningValue) {
				Drivetrain.frontRight.set(ControlMode.PercentOutput, rightVel + 0.1);
				Drivetrain.rearRight.set(ControlMode.PercentOutput, rightVel + 0.1);
				Drivetrain.frontLeft.set(ControlMode.PercentOutput, -leftVel);
				Drivetrain.rearLeft.set(ControlMode.PercentOutput,-leftVel);
				System.out.println("Left:"  + Drivetrain.gyro.getAngle());
			} else if (Drivetrain.gyro.getAngle() > turningValue) {
				Drivetrain.frontLeft.set(ControlMode.PercentOutput,-leftVel - 0.1);
				Drivetrain.rearLeft.set(ControlMode.PercentOutput,-leftVel- 0.1);
				Drivetrain.rearRight.set(ControlMode.PercentOutput,rightVel);
				Drivetrain.frontRight.set(ControlMode.PercentOutput,rightVel);
				System.out.println("Right: "+ Drivetrain.gyro.getAngle());
			}
    	}
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
