package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAuton extends Command {
	private double l,r;
    public DriveAuton(double x, double y) {
    	l=x;
    	r=y;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drivetrain.frontLeft.set(ControlMode.PercentOutput, l);
		Drivetrain.rearLeft.set(ControlMode.PercentOutput, l);
		Drivetrain.rearRight.set(ControlMode.PercentOutput, r);
		Drivetrain.frontRight.set(ControlMode.PercentOutput, r);
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
