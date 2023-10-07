// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  
  private CANSparkMax Motor1 = new CANSparkMax(DriveConstants.kRightMotorPort, MotorType.kBrushless);
  private CANSparkMax Motor2 = new CANSparkMax(DriveConstants.kLeftMotorPort, MotorType.kBrushless);
  //private CANSparkMax Motor3 = new CANSparkMax(3, MotorType.kBrushless);
  //private CANSparkMax Motor4 = new CANSparkMax(4, MotorType.kBrushless);
  
  private MotorControllerGroup Left = new MotorControllerGroup(Motor2);
  private MotorControllerGroup Right = new MotorControllerGroup(Motor1);
  DifferentialDrive RobotDrive = new DifferentialDrive(Left, Right);
 
  private RelativeEncoder m1_Encoder;
  private RelativeEncoder m2_Encoder;
  
  public double getEncoderFeet() {
    double leftPosition = m1_Encoder.getPosition() * DriveConstants.kEncoderTick2Feet;
    double rightPosition = m2_Encoder.getPosition() * DriveConstants.kEncoderTick2Feet;
    
    double distance = (leftPosition + rightPosition) / 2;
    return (distance);
  }
  
  public DriveSubsystem() {
    Motor1.restoreFactoryDefaults();
    Motor2.restoreFactoryDefaults();
    //Motor3.restoreFactoryDefaults();
    //Motor4.restoreFactoryDefaults();

    Motor2.setInverted(true);
    Motor2.burnFlash();
  }

  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive Encoder Feet", getEncoderFeet());
  }

  public void setMotors(double rotation, double speed) {
    RobotDrive.arcadeDrive(rotation, speed);
  }
}
