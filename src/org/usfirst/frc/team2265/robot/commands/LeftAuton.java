package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAuton extends CommandGroup {
	String gameData;
	public static Timer timer = new Timer();

	public LeftAuton() {

		timer.reset();
		timer.start();
		Drivetrain.gyro.reset();
		double angle = 0;

		gameData =  "LLL";//DriverStation.getInstance().getGameSpecificMessage();

		// add sequential/parallel stuff

		while (timer.get() <= 1.6) {
			if (Drivetrain.gyro.getAngle() < angle) {
				addSequential(new DriveAuton(0.65, -0.65));
				System.out.println("Left:" + Drivetrain.gyro.getAngle());

			} else if (Drivetrain.gyro.getAngle() > angle) {
				addSequential(new DriveAuton(-0.65, 0.65));
				System.out.println("Right: " + Drivetrain.gyro.getAngle());
			}
			System.out.println("autonomous COMMAND!");

		}
		addSequential(new DriveAuton(0.0, -0.0));

		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				addSequential(new TurnDegrees(90));
				addSequential(new Release());
			}
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
}
