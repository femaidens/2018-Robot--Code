package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2265.robot.subsystems.CascadeLift;

public class MoveCascade extends Command {
	private boolean down;

	public MoveCascade(boolean g) {
		down = g;
		
	}

	// Called just before this Command runs the first time

	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		/*if (CascadeLift.encLeft.get() < CascadeLift.distance) {
			CascadeLift.cascadeUp();
	}
=======
>>>>>>> branch 'Cascade' of https://github.com/femaidens/2018-Robot--Code.git
	
		if (down == true) {
			CascadeLift.cascadeUp();
	    }
		else {
			CascadeLift.cascadeDown();
<<<<<<< HEAD
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
