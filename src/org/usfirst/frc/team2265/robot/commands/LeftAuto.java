/*package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class LeftAuto extends CommandGroup {

    public LeftAuto() {
       
    	
    	String gameData; // stores the position of our alliance's color on switches and scale
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.charAt(0) == 'L'){
    			addSequential(new DriveDistance(16, 0.5));
    			addSequential(new TurnDegrees(90));
    			addSequential(new Acquire(false));
    	}
    	else {
    		addSequential(new DriveDistance(25,0.5)); //placeholder
    		addSequential(new TurnDegrees(90)); //placeholder
    		if(gameData.charAt(1) == 'L') {
    			addSequential(new DriveDistance(4,0.5));
    			addSequential(new Acquire(false));
    		} 
    		else 
    			addSequential(new TurnDegrees(90));
    	}
    }
    	
	}
*/
