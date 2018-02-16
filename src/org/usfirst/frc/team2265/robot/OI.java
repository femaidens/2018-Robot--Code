package org.usfirst.frc.team2265.robot;

import org.usfirst.frc.team2265.robot.commands.CascadeDown;
import org.usfirst.frc.team2265.robot.commands.CascadeUp;
import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
import org.usfirst.frc.team2265.robot.commands.HookServo;
import org.usfirst.frc.team2265.robot.commands.Pivot;
import org.usfirst.frc.team2265.robot.commands.SwitchSpeed;
import org.usfirst.frc.team2265.robot.commands.UnhookServo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	public static Joystick launchpad = new Joystick(RobotMap.launchPort);

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	/*
	public static Button climberButton = new JoystickButton(driveJoystick, 6);
	public static Button compressorButton = new JoystickButton(driveJoystick, 3);
	public static Button dropGear = new JoystickButton(driveJoystick, 2);
	public static Button reset = new JoystickButton(driveJoystick, 1);
	public static Button align = new JoystickButton(driveJoystick, 8);
	public static Button gyroStraight = new JoystickButton(driveJoystick, 5);
	public static Button switchSpeed = new JoystickButton(driveJoystick, 7);
	*/
	public static Button cascadeUpButton = new JoystickButton(launchpad,15);
	public static Button cascadeDownButton = new JoystickButton(launchpad,5);
	public static Button pivotUpButton = new JoystickButton(launchpad,14);
	public static Button pivotDownButton = new JoystickButton(launchpad,4);
	public static Button servoUpButton = new JoystickButton(launchpad,12);
	public static Button servoDownButton = new JoystickButton(launchpad,2);
	public static Button switchSpeedButton = new JoystickButton(launchpad,13);
	

	
	public void bindButtons() {
		/*climberButton.whileHeld(new Climb(1.0));
		//climberButton.whileHeld(new TurnDegrees(45));
		
		compressorButton.toggleWhenPressed(new ToggleCompressor());
		dropGear.whenPressed(new ShiftChute(false));
		reset.whenPressed(new ShiftChute(true));
		align.toggleWhenPressed(new AutoAlign());
		gyroStraight.whileHeld(new GyroStraight(0.4));
		switchSpeed.whenPressed(new SwitchSpeed());*/

		cascadeUpButton.whileHeld(new CascadeUp()); // to replace with CascadeUp()
		cascadeDownButton.whileHeld(new CascadeDown()); // to replace with CascadeDown()
		pivotUpButton.whileHeld(new Pivot(false));
		pivotDownButton.whileHeld(new Pivot(true));
		servoUpButton.whileHeld(new HookServo()); // to replace with servoUp()
		servoDownButton.whileHeld(new UnhookServo()); // to replace with servoDown()
		switchSpeedButton.toggleWhenPressed(new SwitchSpeed()); // to replace with switchSpeed()
	}
}
