package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardCmd extends CommandBase{
    
    private final DriveSubsystem driveSubsystem;
    private final double distance;
    private double encoderSetpoint;

    public DriveForwardCmd(DriveSubsystem driveSubsystem, double distance) {
        this.driveSubsystem = driveSubsystem;
        this.distance = distance;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("DriveForwardCmd started!");
        encoderSetpoint = driveSubsystem.getEncoderFeet() * distance;
    }
  
    @Override
    public void execute() {
        driveSubsystem.setMotors(DriveConstants.kAutoDriveForwardRotation, DriveConstants.kAutoDriveForwardSpeed);
    }
  
    @Override
    public void end(boolean interrupted) {
      driveSubsystem.setMotors(DriveConstants.kStopRotationSpeed, DriveConstants.kStopDriveSpeed);
      System.out.println("DriveForwardCmd ended!");
    }
  
    @Override
    public boolean isFinished() {
        if (driveSubsystem.getEncoderFeet() > encoderSetpoint) {
            return true;
        } else {
            return false;
        }
    }
}
