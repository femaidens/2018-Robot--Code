package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
/**
 *
 */

public class PIDDrive extends PIDSubsystem {
	public static final double SETPOINT = 10.0;
	double kp = 0.1;//sets the proportional value to 0.1
	double ki = 0.0;
	double kd = 0.0;
	
	//initializes the subsystem
	@SuppressWarnings("deprecation")
	public PIDDrive(String name, double kp, double ki, double kd) {
    	super("PIDDrive", 0.1, 0.0, 0.0); //the PID values are set here
    	LiveWindow.addActuator("Drive", "PIDSubsystemController", getPIDController());
    	getPIDController().setContinuous(true); //sets the PID controller to consider the inputs to be continuous
    	getPIDController().setPercentTolerance(20.0); //the tolerable percent error is 20
    	setSetpoint(10.0); //the desired setpoint (may be the encoder tick distance desired)
    	enable(); //enables the PID Controller
    }
    
    public void adjustDrive() {	
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive system, like a motor
        // e.g. yourMotor.set(output);
    	//set wheels to values given by PID controller
    	Drivetrain.frontLeft.pidWrite(output);
    	Drivetrain.frontRight.pidWrite(output);
    	Drivetrain.rearLeft.pidWrite(output);
    	Drivetrain.rearRight.pidWrite(output);
    	
    }
}
