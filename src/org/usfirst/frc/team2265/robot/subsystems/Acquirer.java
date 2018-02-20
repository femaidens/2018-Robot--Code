package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class Acquirer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static TalonSRX acqLeft = new TalonSRX(RobotMap.acqLeftPort);
	public static TalonSRX acqRight = new TalonSRX(RobotMap.acqRightPort);
	public static TalonSRX piv = new TalonSRX(RobotMap.pivPort);
	
	
	public double length = 20;
	public double circ = length*Math.PI/2;
	
	public Acquirer(){
	}
	
	public void acquire(){
		acqLeft.set(ControlMode.PercentOutput, 0.75);
		acqRight.set(ControlMode.PercentOutput, 0.75);
	}
	
	public void release(){
		acqLeft.set(ControlMode.PercentOutput, -0.75);
		acqRight.set(ControlMode.PercentOutput, -0.75);
	}
	
	public void acquireStop() {
		acqLeft.set(ControlMode.PercentOutput, 0);
		acqRight.set(ControlMode.PercentOutput, 0);
	}
	
	public void pivotDown(){
		piv.set(ControlMode.PercentOutput, -0.75);
	}
	
	public void pivotUp(){  
		piv.set(ControlMode.PercentOutput, 0.75);
	}
	
	public void pivotStop() {
		piv.set(ControlMode.PercentOutput, 0);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

