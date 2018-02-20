package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAuto extends CommandGroup {
	
    public CenterAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.charAt(0) == 'L'){
    		addSequential(new PivotDown());
    		addSequential(new Acquire());
    		addSequential(new TurnDegrees(-45)); // placeholder
    		addSequential(new DriveDistance(14/Math.cos(45), 0.75)); // placeholder
    		addSequential(new TurnDegrees(-15)); // placeholder
    		addSequential(new CascadeUp());
    		addSequential(new Release());
    		addSequential(new DriveDistance(-20, 0.5)); //may need to make drive distance back
    		//Cascade lift, addSequential(new Lift());
    		
    	}
    	else{
    		addSequential(new PivotDown());
    		addSequential(new Acquire());
    		addSequential(new TurnDegrees(45)); // placeholder
    		addSequential(new DriveDistance(14/Math.cos(45), 0.75)); // placeholder
    		addSequential(new TurnDegrees(15)); // placeholder
    		addSequential(new CascadeUp());
    		addSequential(new Release());
    		addSequential(new DriveDistance(-20, 0.5));
    	}

    	
    }
    
}
