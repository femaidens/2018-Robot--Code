/*package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class RightAuto extends CommandGroup {

    public RightAuto() {
    	String gameData; // stores the position of our alliance's color on switches and scale
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.charAt(0) == 'R'){
    		addSequential(new DriveDistance(16, 0.5)); // placeholder,16ft
    		addSequential(new TurnDegrees(-90)); // placeholder
    		//addSequential(new Lift());
    		addSequential(new Acquire());
    	}
    
    	else { //first one is Left
    		//not in if statement bc need to cross base line
    		addSequential(new DriveDistance(2,0.5));
    		addSequential(new TurnDegrees(-90)); //placeholder
    		if(gameData.charAt(1) == 'R') { 
    			addSequential(new DriveDistance(4,0.5));
    			//addSequential(new Lift());
    			addSequential(new Acquire());
    		} 
    		else
    			addSequential(new TurnDegrees(-90));
    	}
    	
    
    	
    	
    }
}
*/

