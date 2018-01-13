package org.usfirst.frc.team2265.robot;

import org.usfirst.frc.team2265.robot.commands.Acquire;
import org.usfirst.frc.team2265.robot.commands.Pivot;
import org.usfirst.frc.team2265.robot.commands.ToggleCommpressor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

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
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	//public static Button climberButton = new JoystickButton(driveJoystick, 6);
	
	public static Button compressorButton = new JoystickButton(driveJoystick, 3);
	public static Button acquire = new JoystickButton(driveJoystick, 2);
	public static Button release = new JoystickButton(driveJoystick, 1);
	public static Button pivotUp = new JoystickButton(driveJoystick, 6);
	public static Button pivotDown = new JoystickButton(driveJoystick, 5);
	public static Button ladderUp = new JoystickButton(driveJoystick, 9);
	public static Button ladderDown= new JoystickButton(driveJoystick, 8);
	//public static Button dropGear = new JoystickButton(driveJoystick, 2);
	//public static Button reset = new JoystickButton(driveJoystick, 1);
	
	public static Button align = new JoystickButton(driveJoystick, 11);
	
	//public static Button gyroStraight = new JoystickButton(driveJoystick, 5);
	//public static Button switchSpeed = new JoystickButton(driveJoystick, 7);
	
	

	
	public void bindButtons() {
		/*climberButton.whileHeld(new Climb(1.0));
		//climberButton.whileHeld(new TurnDegrees(45));
		compressorButton.toggleWhenPressed(new ToggleCompressor());
		dropGear.whenPressed(new ShiftChute(false));
		reset.whenPressed(new ShiftChute(true));
		align.toggleWhenPressed(new AutoAlign());
		gyroStraight.whileHeld(new GyroStraight(0.4));
		switchSpeed.whenPressed(new SwitchSpeed());*/
		compressorButton.toggleWhenPressed(new ToggleCommpressor());
		acquire.whenPressed(new Acquire(true));
		release.whenPressed(new Acquire(false));
		pivotUp.whenPressed(new Pivot(true));
		pivotDown.whenPressed(new Pivot(false));
		ladderUp.whenPressed(new Pivot(false));
		ladderDown.whenPressed(new Pivot(true));
		//create align
	
		
	}
}
