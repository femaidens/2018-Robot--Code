package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.ControlMode;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import edu.wpi.first.wpilibj.Encoder;
/**
 *
 */
public class DriveDistance extends Command {
	
	private double angle;
	private double distance;
	private double distanceLeft, distanceRight;
	private double rightVel, leftVel;
	public static Timer timer = new Timer();
	
    public DriveDistance(double d, double v) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	distance = d;
    	rightVel = leftVel = v;
    	
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = Drivetrain.gyro.getAngle();
		Drivetrain.encoderLeft.reset();
		Drivetrain.encoderRight.reset();
		timer.reset();
		timer.start();
		
		Robot.drivetrain.drive(leftVel,rightVel);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Drivetrain.gyro.getAngle() < angle) {
			Drivetrain.frontRight.set(ControlMode.PercentOutput,rightVel + 0.075);
			Drivetrain.rearRight.set(ControlMode.PercentOutput,rightVel + 0.075);
			Drivetrain.frontLeft.set(ControlMode.PercentOutput,leftVel - 0.075);
			Drivetrain.rearLeft.set(ControlMode.PercentOutput,leftVel - 0.075);
			System.out.println("Left:"  + Drivetrain.gyro.getAngle());
		} else if (Drivetrain.gyro.getAngle() > angle) {
			Drivetrain.frontLeft.set(ControlMode.PercentOutput,leftVel + 0.075);
			Drivetrain.rearLeft.set(ControlMode.PercentOutput,leftVel+ 0.075);
			Drivetrain.rearRight.set(ControlMode.PercentOutput,rightVel - 0.075);
			Drivetrain.frontRight.set(ControlMode.PercentOutput,rightVel - 0.075);
			System.out.println("Right: "+Drivetrain.gyro.getAngle());
		}
    	
    	distanceLeft = Drivetrain.encoderLeft.get();
	distanceRight = Drivetrain.encoderRight.get();
		
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//if distance on either right or left is greater than what we want, robot stops
    	return (distanceLeft > (distance * 236/12)) || (distanceRight > (distance * 236/12) || (timer.get() > 5.0));
    	
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	//stops motors and resets encoders
    	Robot.drivetrain.drive(0, 0);
    	Drivetrain.encoderLeft.reset(); 
    	Drivetrain.encoderRight.reset(); //remove if we want to see how far the encoder has moved AFTER stopping
    	timer.reset();
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
