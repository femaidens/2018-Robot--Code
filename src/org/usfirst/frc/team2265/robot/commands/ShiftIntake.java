package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Acquirer;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftIntake extends Command {
	private boolean take;
	
    public ShiftIntake(boolean t) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	take = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (take) {
			Acquirer.extend();
		}
    	else {
			Acquirer.retract();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
