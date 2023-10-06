package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
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
        driveSubsystem.setMotors(0, 0.5);
    }
  
    @Override
    public void end(boolean interrupted) {
      driveSubsystem.setMotors(0, 0);
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
