package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDrive extends Command {

	public static Timer timer = new Timer();
	private double angle;
	//private double leftVel;
	//private double rightVel;
	
    public AutonomousDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	angle = Drivetrain.gyro.getAngle();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	Drivetrain.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(timer.get() <=  2.5) {
    		if (Drivetrain.gyro.getAngle() < angle) {
    			Drivetrain.frontRight.set(ControlMode.PercentOutput, -0.65);
    			Drivetrain.rearRight.set(ControlMode.PercentOutput, -0.65);
    			Drivetrain.frontLeft.set(ControlMode.PercentOutput, 0.65);
    			Drivetrain.rearLeft.set(ControlMode.PercentOutput, 0.65);
    			System.out.println("Left:"  + Drivetrain.gyro.getAngle());
    		} else if (Drivetrain.gyro.getAngle() > angle) {
    			Drivetrain.frontLeft.set(ControlMode.PercentOutput,0.65);
    			Drivetrain.rearLeft.set(ControlMode.PercentOutput,0.65);
    			Drivetrain.rearRight.set(ControlMode.PercentOutput,-0.65);
    			Drivetrain.frontRight.set(ControlMode.PercentOutput, -0.65);
    			System.out.println("Right: "+ Drivetrain.gyro.getAngle());
    		}                                                                                                                                                                                                                                                                                                                                                                                                    
    		System.out.println("autonomous COMMAND!");
    	}
    } 
    
    /*if (Drivetrain.gyro.getAngle() < angle) {
		Drivetrain.frontRight.set(ControlMode.PercentOutput, rightVel + 0.1);
		Drivetrain.rearRight.set(ControlMode.PercentOutput, rightVel + 0.1);
		Drivetrain.frontLeft.set(ControlMode.PercentOutput, -leftVel);
		Drivetrain.rearLeft.set(ControlMode.PercentOutput,-leftVel);
		System.out.println("Left:"  + Drivetrain.gyro.getAngle());
	} else if (Drivetrain.gyro.getAngle() > angle) {
		Drivetrain.frontLeft.set(ControlMode.PercentOutput,-leftVel - 0.1);
		Drivetrain.rearLeft.set(ControlMode.PercentOutput,-leftVel- 0.1);
		Drivetrain.rearRight.set(ControlMode.PercentOutput,rightVel);
		Drivetrain.frontRight.set(ControlMode.PercentOutput,rightVel);
		System.out.println("Right: "+ Drivetrain.gyro.getAngle());
	}*/

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
