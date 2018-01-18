package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Acquirer;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Acquire extends Command {
	
	private boolean acquired;
	
    public Acquire(boolean a) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	acquired = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(acquired){
    		Robot.acquirer.acquire();
    		return;
    	}
    	if(!acquired){
    		Robot.acquirer.release();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Acquirer.acqLeft.set(ControlMode.PercentOutput,0);
    	Acquirer.acqRight.set(ControlMode.PercentOutput,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}