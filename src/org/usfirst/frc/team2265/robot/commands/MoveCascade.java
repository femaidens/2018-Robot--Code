package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2265.robot.subsystems.CascadeLift;

public class MoveCascade extends Command {

	public MoveCascade() {
	}

	// Called just before this Command runs the first time

	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		/*if (CascadeLift.encLeft.get() < CascadeLift.distance) {
			CascadeLift.cascadeUp();
	}
	
		if (CascadeLift.encLeft.get() > CascadeLift.distance) {
			CascadeLift.cascadeDown();
	}*/ 
}

	// Make this return true when this Command no longer needs to run

	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true

	protected void end() {
		/*CascadeLift.encLeft.reset();
		CascadeLift.encRight.reset();*/
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
