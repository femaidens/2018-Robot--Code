package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.CascadeLift;
import org.usfirst.frc.team2265.robot.subsystems.CascadePID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeUp extends Command {

    public CascadeUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CascadeLift.cascadeUp();
    	System.out.println("Cascade Up");
    	System.out.println("Encoder Left " + CascadeLift.encLeft.getDistance());	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	CascadeLift.cascadeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	CascadeLift.cascadeStop(); 
    }
}
