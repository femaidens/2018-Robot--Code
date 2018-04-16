package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

//import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class RightAuton extends CommandGroup {
	String gameData; 
	
	public RightAuton() {
		gameData = "RRR"; //DriverStation.getInstance()).getGameSpecificMessage();
		// add sequential/parallel stuff
			if(gameData.length() > 0) {
				if (gameData.charAt(0) == 'R') {
					addSequential(new DriveAuton(0.65), 1.6); 
					addSequential(new TurnDegrees(-90));
					addSequential(new Release(), 0.5);
				} else {
					addSequential(new DriveAuton(0.65), 2.3); 
				}
			}
			System.out.println("autonomous COMMAND!");
	}
		

		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
}

