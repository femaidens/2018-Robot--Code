package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

//makes public class ladder a subsystem
public class Ladder extends Subsystem {
    //ticks is thee variable that holds the number of ticks it takes to go down completely
	double ticks = 5.0;
	public static TalonSRX ladTalon = new TalonSRX(RobotMap.ladtalonPort);
	public static Encoder ladEnc = new Encoder(RobotMap.ladencPort1, RobotMap.ladencPort2);
	
	//need to make a method for the created class
	
	public Ladder(){
		ladEnc.reset();
		ladEnc.reset();
    }
   //while the encoder is less than the amount of ticks it takes to move the 
//triangular device, it will continue to move the talon backwards

	public void extend(){
		while (ladEnc.get() < ticks) {
    		ladTalon.set(ControlMode.PercentOutput,0.75);
    	}
	}
/*while the encoder is less than the amount of ticks it takes to move the triangular device, it will continue to move the talon forward*/
	public void retract() {
		while (ladEnc.get() < ticks){
			ladTalon.set(ControlMode.PercentOutput, -0.75);
		}
	}
	
	public void initDefaultCommand() {
    }
}

