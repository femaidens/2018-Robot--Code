package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Cascade;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedCascade extends Command {
	public static Timer timer = new Timer();
	private double time;
	
    public TimedCascade(double t) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(timer.get() <= time) {
    		Cascade.cascadeUp(0.5);
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