package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

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
	//public static DigitalInput limitSwitch = new DigitalInput(RobotMap.limSwitchPort1);
	

	// one encoder for two talon/motor.
	/*public static Encoder encLeft = new Encoder(RobotMap.encLPort1, RobotMap.encLPort2);
	public static Encoder encRight = new Encoder(RobotMap.encRPort1, RobotMap.encRPort2);
	
	public CascadeLift() {
		encLeft.reset();
		encRight.reset();
	}*/
	// method to make the cascade go up
	public static void cascadeUp(){
		casLeft1.set(ControlMode.PercentOutput, 0.25);
		casLeft2.set(ControlMode.PercentOutput, 0.25);
		casRight1.set(ControlMode.PercentOutput, 0.25);
		casRight2.set(ControlMode.PercentOutput, 0.25);
		 //didn't use encLeft for reason; just to get enc value on one side       
		/*while (encLeft.get() < distance) {
			// 0.75 is the placeholder.
			casLeft1.set(ControlMode.PercentOutput, 0.75);
			casLeft2.set(ControlMode.PercentOutput, 0.75);
			
			if (encLeft.get() <= 30) { //30 is a placeholder for the cascade limit 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(encRight.get() -30)/100) * Robot.drivetrain.rightVal, (constant *(encLeft.get() -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}
		}*/
		
		/*while (encRight.get() < distance) {
			casRight1.set(ControlMode.PercentOutput, 0.75);
			casRight2.set(ControlMode.PercentOutput, 0.75);
			
			if (encRight.get() <= 30) { 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(encRight.get() -30)/100) * Robot.drivetrain.rightVal, (constant *(encLeft.get() -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}
		}
	
		}*/
	}
//
	public static void cascadeDown() {
		casLeft1.set(ControlMode.PercentOutput, -0.25);
		casLeft2.set(ControlMode.PercentOutput, -0.25);
		casRight1.set(ControlMode.PercentOutput, -0.25);
		casRight2.set(ControlMode.PercentOutput, -0.25);
		/*while (encLeft.get() < (2*distance)) {
			casLeft1.set(ControlMode.PercentOutput, -0.75);
			casLeft2.set(ControlMode.PercentOutput, -0.75); 
			
			if ((2 * distance)-encLeft.get() <= 30 ) { 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(encRight.get() -30)/100) * Robot.drivetrain.rightVal, (constant *(encLeft.get() -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}		
		}*/

		/*while ((2 * distance)-encRight.get() < (2*distance)){
			casRight1.set(ControlMode.PercentOutput, -0.75);
			casRight2.set(ControlMode.PercentOutput, -0.75);
			
			if (encRight.get() <= 30 ) { 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(encRight.get() -30)/100) * Robot.drivetrain.rightVal, (constant *(encLeft.get() -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}
		}*/
	}
//resets encoder if cascade hits limit switch on bottom 
	/*public static void limitDown() {
		if (limitSwitch.get() == true) {
			encLeft.reset();
			encRight.reset();
		}
	}*/
	
	public void initDefaultCommand() {
	}
}
