// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class ArmJoystickCmd extends CommandBase {
  
  private final ArmSubsystem armSubsystem;
  private final double speed;

  public ArmJoystickCmd(ArmSubsystem armSubsystem, double speed) {
    this.armSubsystem = armSubsystem;
    this.speed = speed;
    addRequirements(armSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("ArmJoystickCmd started!");
  }

  @Override
  public void execute() {
    armSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    armSubsystem.setMotor(ArmConstants.kStopSpeed);
    System.out.println("ArmJoystickCmd ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
