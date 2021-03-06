package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Cascade;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeDown extends Command {
	//private static double lowerLimit = 100;
   
	public CascadeDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//Cascade.encLeft.reset();
    	//Cascade.encRight.reset();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//while(Cascade.encLeft.get() > lowerLimit && Cascade.encRight.get() > lowerLimit) {
	    	Cascade.cascadeDown();
	    	//System.out.println("Encoder Left " + Cascade.encLeft.get());
	    	//System.out.println("Encoder Right " + Cascade.encRight.get()); 
    	//}
    	/*if(Cascade.encLeft.get() < 100 && Cascade.encRight.get() < 100)
    		Cascade.cascadeStop(); 
    	else {
    		Cascade.cascadeDown();
    	}
    	System.out.println("Cascade Down");*/
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