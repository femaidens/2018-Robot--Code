package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class RightAuton extends CommandGroup {
	String gameData;
	public static Timer timer = new Timer();

	public RightAuton() {
		timer.reset();
		timer.start();
		Drivetrain.gyro.reset();
		double angle = 0;
		
		//add sequential/parallel stuff
		/*
		while (timer.get() <= 1.6) {
			if (Drivetrain.gyro.getAngle() < angle) {
				Drivetrain.frontRight.set(ControlMode.PercentOutput, -0.65);
				Drivetrain.rearRight.set(ControlMode.PercentOutput, -0.65);
				Drivetrain.frontLeft.set(ControlMode.PercentOutput, 0.65);
				Drivetrain.rearLeft.set(ControlMode.PercentOutput, 0.65);
				System.out.println("Left:" + Drivetrain.gyro.getAngle());
			} else if (Drivetrain.gyro.getAngle() > angle) {
				Drivetrain.frontLeft.set(ControlMode.PercentOutput, 0.65);
				Drivetrain.rearLeft.set(ControlMode.PercentOutput, 0.65);
				Drivetrain.rearRight.set(ControlMode.PercentOutput, -0.65);
				Drivetrain.frontRight.set(ControlMode.PercentOutput, -0.65);
				System.out.println("Right: " + Drivetrain.gyro.getAngle());
			}
			System.out.println("autonomous COMMAND!");
		}
		*/
		
		
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
