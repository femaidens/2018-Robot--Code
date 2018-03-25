package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Cascade;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeUp extends Command {
	//private static double topLimit = 200;
	
	
    public CascadeUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//ascade.encLeft.reset();
    	//Cascade.encRight.reset();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//while(Cascade.encLeft.get() < topLimit && Cascade.encRight.get() < topLimit) {
    		Cascade.cascadeUp();
    		//System.out.println("Encoder Left " + Cascade.encLeft.get());
        	//System.out.println("Encoder Right " + Cascade.encRight.get());
    	//}
    	//System.out.println("Encoder Left " + CascadeLift.encLeft.getDistance());	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Cascade.cascadeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Cascade.cascadeStop(); 
    }
}