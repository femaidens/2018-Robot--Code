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
    		addSequential(new TurnDegrees(19)); // placeholder
    		addSequential(new DriveDistance(14/Math.cos(45), 0.5)); // placeholder
    		addSequential(new TurnDegrees(-19)); // placeholder
    		//Cascade lift, addSequential(new Lift());
    		addSequential(new Acquire(false));
    	}
    	else{
    		addSequential(new TurnDegrees(-19)); // placeholder
    		addSequential(new DriveDistance(14/Math.cos(45), 0.5)); // placeholder
    		addSequential(new TurnDegrees(19)); // placeholder
    		//cascade lift, addSequential(new Lift());
    		addSequential(new Acquire(false));
    	}
    	
    	/*SmartDashboard.putString(“OurSwitchColor”,gameData.charAt(0));
    	SmartDashboard.putString(“ScaleColor”,gameData.charAt(1));
    	SmartDashboard.putString(“OtherSwitchColor”,gameData.charAt(2));*/
    	
    }
    
}
