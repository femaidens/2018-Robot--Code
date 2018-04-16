package org.usfirst.frc.team2265.robot;

import org.usfirst.frc.team2265.robot.commands.Acquire;
import org.usfirst.frc.team2265.robot.commands.AcquirerStop;
import org.usfirst.frc.team2265.robot.commands.CascadeDown;
import org.usfirst.frc.team2265.robot.commands.CascadeStop;
import org.usfirst.frc.team2265.robot.commands.CascadeUp;
import org.usfirst.frc.team2265.robot.commands.Lock;
import org.usfirst.frc.team2265.robot.commands.PivotDown;
import org.usfirst.frc.team2265.robot.commands.PivotStop;
import org.usfirst.frc.team2265.robot.commands.PivotUp;
import org.usfirst.frc.team2265.robot.commands.Release;
import org.usfirst.frc.team2265.robot.commands.ShiftIntake;
import org.usfirst.frc.team2265.robot.commands.ToggleCompressor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	public static Joystick driveJoystick2 = new Joystick(RobotMap.driveJoyPort2);
	
	//public static Joystick launchpad = new Joystick(RobotMap.launchpadPort);
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
	
	public static Button CasDown = new JoystickButton(driveJoystick, 1);
	public static Button CasUp = new JoystickButton(driveJoystick, 3);
	
	public static Button Acquire = new JoystickButton(driveJoystick, 5);
	public static Button Release = new JoystickButton(driveJoystick, 6);

	public static Button intakePist = new JoystickButton(driveJoystick, 7);
	
	public static Button pivotUp = new JoystickButton(driveJoystick, 2);
	public static Button pivotDown = new JoystickButton(driveJoystick, 4);
	
	//public static Button compressorButton = new JoystickButton(driveJoystick, 1);
	public static Button CasDown2 = new JoystickButton(driveJoystick2, 1);
	public static Button CasUp2 = new JoystickButton(driveJoystick2, 3);
	
	public static Button Acquire2 = new JoystickButton(driveJoystick2, 5);
	public static Button Release2 = new JoystickButton(driveJoystick2, 6);

	public static Button intakePist2 = new JoystickButton(driveJoystick2, 7);
	
	public static Button lockCascade = new JoystickButton(driveJoystick2, 8);
	
	//launchpad buttons
	/*public static Button casup = new JoystickButton(launchpad, 2);
	public static Button casdown = new JoystickButton(launchpad, 5);
	
	public static Button acquire = new JoystickButton(launchpad, 14);
	public static Button release = new JoystickButton(launchpad, 4);
	
	//public static Button pivUp = new JoystickButton(launchpad, 14);
	//public static Button pivDown = new JoystickButton(launchpad, 4);
	*/
	public void bindButtons() {
		//compressorButton.toggleWhenPressed(new ToggleCompressor());
			
		//joystick
		CasUp.whileHeld(new CascadeUp());
		CasUp.whenReleased(new CascadeStop());
				
		CasDown.whileHeld(new CascadeDown());
		CasDown.whenReleased(new CascadeStop());
				
		Acquire.whileHeld(new Acquire());
		Acquire.whenReleased(new AcquirerStop());
				
		Release.whileHeld(new Release());
		Release.whenReleased(new AcquirerStop());
				
		intakePist.toggleWhenPressed(new ShiftIntake());
		
		lockCascade.toggleWhenPressed(new Lock());
		
		pivotUp.whileHeld(new PivotUp());
		pivotUp.whenReleased(new PivotStop());
			
		pivotDown.whileHeld(new PivotDown());
		pivotDown.whenReleased(new PivotStop());
		
		//joystick2
		
		CasUp2.whileHeld(new CascadeUp());
		CasUp2.whenReleased(new CascadeStop());
				
		CasDown2.whileHeld(new CascadeDown());
		CasDown2.whenReleased(new CascadeStop());
				
		Acquire2.whileHeld(new Acquire());
		Acquire2.whenReleased(new AcquirerStop());
				
		Release2.whileHeld(new Release());
		Release2.whenReleased(new AcquirerStop());
				
		intakePist2.toggleWhenPressed(new ShiftIntake());
		
		lockCascade.toggleWhenPressed(new Lock());
		
		
		/*launchpad 
		casup.whileHeld(new CascadeUp());
		casup.whenReleased(new CascadeStop());
				
		casdown.whileHeld(new CascadeDown());
		casdown.whenReleased(new CascadeStop());
		
		acquire.whileHeld(new Acquire());
		acquire.whenReleased(new AcquirerStop());
				
		release.whileHeld(new Release());
		release.whenReleased(new AcquirerStop());
				
		//pivUp.whileHeld(new PivotUp());
		//pivUp.whenReleased(new PivotStop());
				
		//pivDown.whileHeld(new PivotDown());
		//pivDown.whenReleased(new PivotStop());;*/
	}
}
