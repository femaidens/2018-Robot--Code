package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Talon extends Subsystem {
	public static TalonSRX testtalon = new TalonSRX(RobotMap.talonport);
	
	public Talon() {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	}
	//teleop
	public void driveMotor() {
		testtalon.set(ControlMode.PercentOutput, 0.75);
		System.out.println("TALON ACTIVATED");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

