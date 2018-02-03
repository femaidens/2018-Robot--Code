package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAuto extends CommandGroup {

    public RightAuto() {
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
    	
    	String gameData; // stores the position of our alliance's color on switches and scale
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.charAt(0) == 'R'){
    		addSequential(new DriveDistance(16, 0.5)); // placeholder,16ft
    		addSequential(new TurnDegrees(-90)); // placeholder
    		//addSequential(new Lift());
    		addSequential(new Acquire(false));
    	}
    
    	else { //first one is Left
    		//not in if statement bc need to cross base line
    		addSequential(new DriveDistance(2,0.5));
    		addSequential(new TurnDegrees(-90)); //placeholder
    		if(gameData.charAt(1) == 'R') { 
    			addSequential(new DriveDistance(4,0.5));
    			//addSequential(new Lift());
    			addSequential(new Acquire(false));
    		} 
    		else
    			addSequential(new TurnDegrees(-90));
    	}
    	
    
    	
    	
    }
}
