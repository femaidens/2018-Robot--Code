package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CascadePID extends Subsystem {
	
	public static TalonSRX casLeft1 = new TalonSRX(RobotMap.casLPort1);
	public static TalonSRX casLeft2 = new TalonSRX(RobotMap.casLPort2);
	public static TalonSRX casRight1 = new TalonSRX(RobotMap.casRPort1);
	public static TalonSRX casRight2 = new TalonSRX(RobotMap.casRPort2);
	
	public static Encoder encLeft = new Encoder(RobotMap.encLPort1, RobotMap.encLPort2);
	public static Encoder encRight = new Encoder(RobotMap.encRPort1, RobotMap.encRPort2);
	
	private double setpoint;
	private static double actualDiff;
	private double error;
	private double lastError;
	private double kP;
	private double kD;
	private static double cascadeValue;
	
	public CascadePID() {
		setpoint = 0.0;
		kP = 0.0006;
    	kD = 0.008;
    	lastError = 0.0;
    	actualDiff = encRight.getDistance() - encLeft.getDistance();
    	error = actualDiff - setpoint;
    	cascadeValue = (error * kP) + (error-lastError) * kD ;
		encLeft.reset();
		encRight.reset();
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static void cascadeUp() {
		while (actualDiff < cascadeValue) {
			casLeft1.set(ControlMode.PercentOutput, -0.50);
			casLeft2.set(ControlMode.PercentOutput, 0.50);
			casRight1.set(ControlMode.PercentOutput, -0.50);
			casRight2.set(ControlMode.PercentOutput, -0.50);
		}		
	}
	
	public static void cascadeDown() {
		while (actualDiff < cascadeValue) {
			casLeft1.set(ControlMode.PercentOutput, 0.50);
			casLeft2.set(ControlMode.PercentOutput, -0.50);
			casRight1.set(ControlMode.PercentOutput, 0.50);
			casRight2.set(ControlMode.PercentOutput, 0.50);		
		}
	}
	
	public static void cascadeStop() {
		casLeft1.set(ControlMode.PercentOutput, 0);
		casLeft2.set(ControlMode.PercentOutput, 0);
		casRight1.set(ControlMode.PercentOutput, 0);
		casRight2.set(ControlMode.PercentOutput, 0);	
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}