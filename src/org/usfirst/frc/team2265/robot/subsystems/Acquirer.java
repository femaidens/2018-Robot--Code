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
	
	public static Encoder encPiv = new Encoder(RobotMap.encPivPort1, RobotMap.encPivPort2);
	
	public int ticksPerRev = 200; // 200 is a placeholder
	public double length = ticksPerRev/4;
	
	public Acquirer(){
	}
	
	public void acquire(){
		acqLeft.set(ControlMode.PercentOutput, 0.75);//positive velocity indicates the wheels turning right
		acqRight.set(ControlMode.PercentOutput, -0.75); // negative velocity indicates the wheels turning left
		//acquired
	}
	
	public void release(){
		acqLeft.set(ControlMode.PercentOutput, -0.75);
		acqRight.set(ControlMode.PercentOutput, 0.75);
		//released
	}
	
	public void pivotDown(){
		encPiv.reset();
		
		while(encPiv.get() < length){
			piv.set(ControlMode.PercentOutput, -0.75);
		}
		piv.set(ControlMode.PercentOutput, 0);
	}
	
	public void pivotUp(){
		encPiv.reset();
		
		while(encPiv.get() < length){
			piv.set(ControlMode.PercentOutput, 0.75);
		}
		piv.set(ControlMode.PercentOutput, 0);
	}
	
	public void pivotStop() {
		acqRight.set(ControlMode.PercentOutput, 0.0);
		acqLeft.set(ControlMode.PercentOutput, 0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


