package org.usfirst.frc.team2265.robot;

import org.usfirst.frc.team2265.robot.commands.CascadeDown;
import org.usfirst.frc.team2265.robot.commands.CascadeStop;
import org.usfirst.frc.team2265.robot.commands.CascadeUp;
import org.usfirst.frc.team2265.robot.commands.MoveCascade;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);

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

	//public static Button climberButton = new JoystickButton(driveJoystick, 6);
	//public static Button compressorButton = new JoystickButton(driveJoystick, 3);
	//public static Button dropGear = new JoystickButton(driveJoystick, 2);
	//public static Button reset = new JoystickButton(driveJoystick, 1);
	//public static Button align = new JoystickButton(driveJoystick, 8);
	//public static Button gyroStraight = new JoystickButton(driveJoystick, 5);
//	public static Button switchSpeed = new JoystickButton(driveJoystick, 7);
	public static Button CasDown = new JoystickButton(driveJoystick, 1);
	public static Button CasUp = new JoystickButton(driveJoystick, 3);
	public static Button CasStop = new JoystickButton(driveJoystick, 2);

	/*public static Button climberButton = new JoystickButton(driveJoystick, 6);
	public static Button compressorButton = new JoystickButton(driveJoystick, 3);
	public static Button dropGear = new JoystickButton(driveJoystick, 2);
	public static Button reset = new JoystickButton(driveJoystick, 1);
	public static Button align = new JoystickButton(driveJoystick, 8);
	public static Button gyroStraight = new JoystickButton(driveJoystick, 5);
	public static Button switchSpeed = new JoystickButton(driveJoystick, 7);*/
	
	public static Button casDown = new JoystickButton(driveJoystick, 1);
	public static Button casUp = new JoystickButton(driveJoystick, 2);
	

	
	public void bindButtons() {
		//climberButton.whileHeld(new Climb(1.0));
		//climberButton.whileHeld(new TurnDegrees(45));
		
		casDown.whileHeld(new MoveCascade(false));
		casUp.whileHeld(new MoveCascade(true));
		
		/*compressorButton.toggleWhenPressed(new ToggleCompressor());
		dropGear.whenPressed(new ShiftChute(false));
		reset.whenPressed(new ShiftChute(true));
		align.toggleWhenPressed(new AutoAlign());
		gyroStraight.whileHeld(new GyroStraight(0.4));
		switchSpeed.whenPressed(new SwitchSpeed());*/
		CasUp.whenPressed(new CascadeUp());
		CasDown.whenPressed(new CascadeDown());
		CasStop.whenPressed(new CascadeStop());
	}
}
