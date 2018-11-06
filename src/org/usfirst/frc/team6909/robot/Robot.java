/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6909.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.XboxController;



public class Robot extends IterativeRobot {

	private XboxController driver;
	private PWMTalonSRX m_leftArm, m_rightArm;

	Robot() {
		driver = new XboxController(0);

		m_leftArm = new PWMTalonSRX(5);
		m_rightArm = new PWMTalonSRX(6);

	}

	public void teleopPeriodic() {

		double value=0;

		boolean is_leftTriggerOn = 0.2 < driver.getTriggerAxis(Hand.kLeft),
				 is_rightTriggerOn =  0.2 < driver.getTriggerAxis(Hand.kRight);

		if( is_leftTriggerOn && is_rightTriggerOn ) {
			value = 0;
		}else {
			value = is_leftTriggerOn ? 1.0 : 0;
			value = is_rightTriggerOn ? -1.0 : 0;
		}

		m_leftArm.set(value);
		m_rightArm.set(-value);

	}

}
