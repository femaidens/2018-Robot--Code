package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

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
	
	public static DoubleSolenoid intakePiston1 = new DoubleSolenoid(RobotMap.intakeRPort1, RobotMap.intakeRPort2);
	//public static DoubleSolenoid intakePiston2 = new DoubleSolenoid(RobotMap.intakeLPort1, RobotMap.intakeLPort2);
	
	
	//public static DigitalInput limitswitch = new DigitalInput(RobotMap.acqlimPort);*/
	
	public double length = 20;
	public double circ = length*Math.PI/2;
	
	public Acquirer(){
		//piv.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		//piv.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
	}
	
	public static void extend() {
		intakePiston1.set(DoubleSolenoid.Value.kForward);
		//intakePiston2.set(DoubleSolenoid.Value.kForward);
	}
	
	public static void retract() {
		intakePiston1.set(DoubleSolenoid.Value.kReverse);
		//intakePiston2.set(DoubleSolenoid.Value.kReverse);
	} 
	
	public void acquire(){
		acqLeft.set(ControlMode.PercentOutput, 0.75);
		acqRight.set(ControlMode.PercentOutput, 0.75);
	}
	
	public void release(){
		acqLeft.set(ControlMode.PercentOutput, -0.75);
		acqRight.set(ControlMode.PercentOutput, -0.75);
	}
	
	public static void pivotDown(){
		/*encPivLeft.reset();
		encPivRight.reset();
		
		while(encPivLeft.get() > circ*236/12){
			pivRight.set(ControlMode.PercentOutput, -0.75);
			pivLeft.set(ControlMode.PercentOutput, -0.75);
		}*/
		piv.set(ControlMode.PercentOutput, -0.55);
	}
	
	public void pivotUp(){
		//encPivLeft.reset();
		//encPivRight.reset();
		
		/*while(encPivLeft.get() > circ*236/12){
			pivRight.set(ControlMode.PercentOutput, 0.75);
			pivLeft.set(ControlMode.PercentOutput, 0.75);
		}*/
		piv.set(ControlMode.PercentOutput, 0.55);
	}
	
	public void acquirerStop(){
		acqLeft.set(ControlMode.PercentOutput, 0);
		acqRight.set(ControlMode.PercentOutput, 0);
	}
	
	public void pivotStop(){
		piv.set(ControlMode.PercentOutput, 0);
	}
	
	public void pivot90(int ticks){
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}