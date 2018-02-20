package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;


/**
 *
 */
public class ServoCascade extends Subsystem {
	  public static Servo serv = new Servo(RobotMap.servoPort);


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

