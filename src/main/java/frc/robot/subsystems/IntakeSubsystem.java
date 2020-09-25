/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final SpeedController mIntakeMotor = new PWMVictorSPX(Constants.INTAKE_PWM);
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {

  }

  public void intake(boolean on) {
    if (on) {
      mIntakeMotor.set(1);
    } else {
      mIntakeMotor.stopMotor();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
