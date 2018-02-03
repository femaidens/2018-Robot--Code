package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc.team2265.robot.subsystems.PIDDrive;
import org.usfirst.frc.team2265.robot.Robot;
/**
 *
 */
public class PIDAuton extends Command {
	
	
	
	public PIDAuton(double d, double v) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.piddrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
