package frc.robot;

import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.ArmJoystickCmd;
import frc.robot.commands.ArmPIDCmd;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.IntakeSetCmd;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  private final Joystick joystick1 = new Joystick(OIConstants.kDriverJoystickPort);
  
  public RobotContainer() {
    driveSubsystem.setDefaultCommand(//
            new ArcadeDriveCmd(driveSubsystem, () -> joystick1.getRawAxis(OIConstants.kDriveSpeedAxis), () -> joystick1.getRawAxis(OIConstants.kDriveTurnAxis))//
    );
    armSubsystem.setDefaultCommand(new ArmJoystickCmd(armSubsystem, 0));
    intakeSubsystem.setDefaultCommand(new IntakeSetCmd(intakeSubsystem, 0));
    
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(joystick1, OIConstants.kArmPIDRaiseButtonIdx)//
            .whileTrue(new ArmPIDCmd(armSubsystem, ArmConstants.kRaisedPosition));
    new JoystickButton(joystick1, OIConstants.kArmPIDLowerButtonIdx)//
            .whileTrue(new ArmPIDCmd(armSubsystem, ArmConstants.kLoweredPosition));
    new JoystickButton(joystick1, OIConstants.kArmJoystickRaiseButtonIdx)//
            .whileTrue(new ArmJoystickCmd(armSubsystem, ArmConstants.kJoystickMaxSpeed));
    new JoystickButton(joystick1, OIConstants.kArmJoystickLowerButtonIdx)//
            .whileTrue(new ArmJoystickCmd(armSubsystem, ArmConstants.kJoystickMaxSpeed));
    new JoystickButton(joystick1, OIConstants.kIntakeOpenButtonIdx)//
            .whileTrue(new IntakeSetCmd(intakeSubsystem, IntakeConstants.kOpenSpeed));
    new JoystickButton(joystick1, OIConstants.kIntakeCloseButtonIdx)//
            .whileTrue(new IntakeSetCmd(intakeSubsystem, IntakeConstants.kCloseSpeed));

  }

  public Command getAutonomousCommand() {
      return new SequentialCommandGroup(//
            new DriveForwardCmd(driveSubsystem, DriveConstants.kAutoDriveForwardDistance),//
    
            new ParallelCommandGroup(//
                  new IntakeSetCmd(intakeSubsystem, IntakeConstants.kCloseSpeed), new ArmPIDCmd(armSubsystem, ArmConstants.kRaisedPosition)//
            )//
      );
  }
}
