package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ladder extends Subsystem {
	
	public static DoubleSolenoid sol = new DoubleSolenoid(RobotMap.ladderPort1, RobotMap.ladderPort2);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Ladder(){
	}
	
	public void extend(){
		sol.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retract(){
		sol.set(DoubleSolenoid.Value.kReverse);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

