package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

public class CascadeLift extends Subsystem {

	// this variable is a placeholder
	static double circ = 10;
	public static double distance = circ * 236 / 12;
	static double constant = -85/170;

	// casLeft1 is the rear left motor near the ladder and casRight1 is the rear
	// right motor near the ladder.
	public static TalonSRX casLeft1 = new TalonSRX(RobotMap.casLPort1);
	public static TalonSRX casLeft2 = new TalonSRX(RobotMap.casLPort2);
	public static TalonSRX casRight1 = new TalonSRX(RobotMap.casRPort1);
	public static TalonSRX casRight2 = new TalonSRX(RobotMap.casRPort2);

	// one encoder for two talon/motor.
	public static Encoder encLeft = new Encoder(RobotMap.encLPort1, RobotMap.encLPort2);
	public static Encoder encRight = new Encoder(RobotMap.encRPort1, RobotMap.encRPort2);
	
	public CascadeLift() {
		encLeft.reset();
		encRight.reset();
	}

	// method to make the cascade go up
	public static void cascadeUp(){
         double newRightVel = (constant*(encRight.get() -30)/100) * Robot.drivetrain.rightVel;
		 double newLeftVel = (constant * (encLeft.get() -30)/100) * Robot.drivetrain.leftVel;
         
		while (encLeft.get() < distance) {
			// 0.75 is the placeholder.
			casLeft1.set(ControlMode.PercentOutput, 0.75);
			casLeft2.set(ControlMode.PercentOutput, 0.75);
		}
		while (encRight.get() < distance) {
			casRight1.set(ControlMode.PercentOutput, 0.75);
			casRight2.set(ControlMode.PercentOutput, 0.75);
		}
		if (encLeft.get() <= 30)
			Robot.drivetrain.drive();
		else
			Robot.drivetrain.drive();
	}

	public static void cascadeDown() {
		while (encLeft.get() < distance) {
			casLeft1.set(ControlMode.PercentOutput, -0.75);
			casLeft2.set(ControlMode.PercentOutput, -0.75);
		}

		while (encRight.get() < distance) {
			casRight1.set(ControlMode.PercentOutput, -0.75);
			casRight2.set(ControlMode.PercentOutput, -0.75);
		}
	}

	public void initDefaultCommand() {
	}
}
