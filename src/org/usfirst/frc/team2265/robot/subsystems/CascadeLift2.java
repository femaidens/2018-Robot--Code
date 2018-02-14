package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

public class CascadeLift2 extends Subsystem {

	// this variable is a placeholder for the circumference of the sprocket 
	static double circ = 10;
	//the distance (in encoder ticks) from the bottom to the top of the cascade
	public static double distance = circ * 236 / 12; 
	//represents the slope of the linear relationship between the encoder ticks and the speed of the drivetrain 
	static double constant = -85/170;

	/*casLeft1 is the rear left motor near the ladder and casRight1 is the rear
	right motor near the ladder.*/

	public static TalonSRX casLeft1 = new TalonSRX(RobotMap.casLPort1);
	public static TalonSRX casLeft2 = new TalonSRX(RobotMap.casLPort2);
	public static TalonSRX casRight1 = new TalonSRX(RobotMap.casRPort1);
	public static TalonSRX casRight2 = new TalonSRX(RobotMap.casRPort2);
	public static DigitalInput limitSwitch = new DigitalInput(RobotMap.limSwitchPort1);
	

	// one encoder for two talon/motor.
	public static Encoder encLeft = new Encoder(RobotMap.encLPort1, RobotMap.encLPort2);
	public static Encoder encRight = new Encoder(RobotMap.encRPort1, RobotMap.encRPort2);

	// these variables is used in the alternative (Zoe)
	public double cascadeLeftLocation = 0; // indicates where on the cascade the left side of U-squish is located
	public double lastEncLeftGet = 0; // indicates the last encLeft.get() value
	public double cascadeRightLocation = 0; // indicates where on the cascade the right side of U-squish is located
	public double lastEncRightGet = 0; // indicates the last encRight.get() value
	
	public CascadeLift2() {
		encLeft.reset();
		encRight.reset();
	}
	
  // method to make the cascade go up
	public void cascadeUp(){
		 //didn't use encLeft for reason; just to get enc value on one side       
		while (cascadeLeftLocation < distance) {
			// 0.75 is the placeholder.
			casLeft1.set(ControlMode.PercentOutput, 0.75);
			casLeft2.set(ControlMode.PercentOutput, 0.75);
			
			cascadeLeftLocation += encLeft.get()- lastEncLeftGet; //the change resulted from sending the cascade more up is added to the old cascadeLeftLocation
			lastEncLeftGet = encLeft.get(); 

			if (cascadeLeftLocation <= 30) { //30 is a placeholder for the cascade limit 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(cascadeRightLocation -30)/100) * Robot.drivetrain.rightVal, (constant *(cascadeLeftLocation -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}
		}
		
		while (cascadeRightLocation < distance) {
			casRight1.set(ControlMode.PercentOutput, 0.75);
			casRight2.set(ControlMode.PercentOutput, 0.75);
			
			cascadeRightLocation += encRight.get()- lastEncRightGet; // same as cascadeLeftLocation 
			lastEncRightGet = encRight.get();
			
			if (cascadeRightLocation <= 30) { 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(cascadeRightLocation -30)/100) * Robot.drivetrain.rightVal, (constant *(cascadeRightLocation -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}
		}
	}

// 2x distance bc encoder adds value going down to the values from going up
	public void cascadeDown() {
		while (cascadeLeftLocation < distance) {
			casLeft1.set(ControlMode.PercentOutput, -0.75);
			casLeft2.set(ControlMode.PercentOutput, -0.75); 

			cascadeLeftLocation -= encLeft.get() - lastEncLeftGet; //the change resulted from sending the cascade more down is subtracted from the old cascadeLeftLocation 
			lastEncLeftGet = encLeft.get();

			//total distance (up & down) - distance travelled gets position 	
			if (cascadeLeftLocation <= 30 ) { 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(cascadeRightLocation -30)/100) * Robot.drivetrain.rightVal, (constant *(cascadeLeftLocation -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}			
		}

		while (cascadeRightLocation < distance){
			casRight1.set(ControlMode.PercentOutput, -0.75);
			casRight2.set(ControlMode.PercentOutput, -0.75);
			
			cascadeRightLocation -= encRight.get() - lastEncRightGet; // same as cascadeLeftLocation 
			lastEncRightGet = encRight.get();

			if (cascadeRightLocation <= 30 ) { 
				Robot.drivetrain.drive();
			}
			else {
				Robot.drivetrain.drive((constant*(cascadeRightLocation -30)/100) * Robot.drivetrain.rightVal, (constant *(cascadeLeftLocation -30)/100) * Robot.drivetrain.leftVal); //sets a limit to the drive
			}
		}
	}

    //resets encoder if cascade hits limit switch on bottom 
	public static void limitDown() {
		if (limitSwitch.get() == true) {
			encLeft.reset();
			encRight.reset();
		}
	}
	
	public void initDefaultCommand() {
	}
}


