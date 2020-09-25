/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeAndShootCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ShooterSubsystem mShooter = new ShooterSubsystem();
  private final IntakeSubsystem mIntaker = new IntakeSubsystem();

  private final ShootCommand mShoot = new ShootCommand(mShooter, true);
  private final ShootCommand mStopShoot = new ShootCommand(mShooter, false);
  private final IntakeCommand mIntake = new IntakeCommand(mIntaker, true);
  private final IntakeCommand mStopIntake = new IntakeCommand(mIntaker, false);
  private final IntakeAndShootCommand mIntakeAndShoot = new IntakeAndShootCommand(mIntaker, mShooter, true);
  private final IntakeAndShootCommand mStopBoth = new IntakeAndShootCommand(mIntaker, mShooter, false);

  private final Joystick mJoystick = new Joystick(Constants.MECHANISM_JOYSTICK_USB);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Sometimes you want one subsystem to do something WHILE another subsystem is doing something else.
    // You can achieve this with PARALLEL commands. The sections below perform the same actions.
    // The first uses a new Command class while the second one combines existing commands inline.

    // Be careful - parallel commands only work with DIFFERENT subsystems.
    // If you want one subsystem to do multiple things at once, that will require a new command
    // and that command CANNOT be a parallel command.

    // This isn't an issue for sequential commands because they work one after the other.
    // With parallel commands, we don't allow any single subsystem to do more than one thing at a time.

    JoystickButton classParallel = new JoystickButton(mJoystick, Constants.INTAKE_AND_SHOOT_CLASS_BUTTON);
    classParallel.whileHeld(mIntakeAndShoot);
    classParallel.whenReleased(mStopBoth);

    JoystickButton inlineParallel = new JoystickButton(mJoystick, Constants.INTAKE_AND_SHOOT_INLINE_BUTTON);
    inlineParallel.whileHeld(mIntake.alongWith(mShoot));
    inlineParallel.whenReleased(mStopIntake.alongWith(mStopShoot));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
