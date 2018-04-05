package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
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
public class CenterAuton extends CommandGroup {
	String gameData;
	private double base = 63;
	private double height = 136;
	private double  degrees = Math.atan(base/height);
	
    public CenterAuton() {
    		//arbitrary time values and degrees--change during competition
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
    		if (gameData.charAt(0) == 'R') {
    			//addSequential(new GyroStraight(.65, 168-33/2));
    			addSequential(new TimedPivot(0.6));
    			addSequential(new TimedDrive(0.8));
    			addSequential(new TurnDegrees(20));
    			addSequential(new TimedDrive(0.65));
    			addSequential(new TurnDegrees(-20));
    			addSequential(new TimedCascade(0.3));
    			addSequential(new Release());
    			//addSequential(new TurnDegrees(degrees));
    			//Sequential(new GyroStraight(.65, Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2))));
    			//addSequential(new TurnDegrees(90- degrees));
    			//addSequential(new GyroStraight(.65, 168-base-33/2)); 
    			// 168 = distance between the alliance station to the switch
    			// 33 = width of the robot(along side)
    		} 
    		else {
    			addSequential(new TimedPivot(0.6));
    			addSequential(new TimedDrive(0.4));
    			addSequential(new TurnDegrees(-14));
    			addSequential(new TimedDrive(0.8));
    			addSequential(new TurnDegrees(14));
    			addSequential(new TimedDrive(0.4));
    			addSequential(new TimedCascade(0.3));
    			addSequential(new Release());
    		}
    	//addSequential(new DriveAuton);
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
    }
}
