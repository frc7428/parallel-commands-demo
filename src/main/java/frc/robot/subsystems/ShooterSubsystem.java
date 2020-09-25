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

public class ShooterSubsystem extends SubsystemBase {
  private final SpeedController mShooterMotor = new PWMVictorSPX(Constants.SHOOTER_PWM);
  /**
   * Creates a new ShooterSubsystem.
   */
  public ShooterSubsystem() {

  }

  public void shoot(boolean on) {
    if (on) {
      mShooterMotor.set(1);
    } else {
      mShooterMotor.stopMotor();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
