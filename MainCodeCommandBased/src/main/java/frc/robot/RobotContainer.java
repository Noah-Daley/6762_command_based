package frc.robot;

import frc.robot.commands.ArmJoystickCmd;
import frc.robot.commands.ArmPIDCmd;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  private final Joystick joystick1 = new Joystick(0);
  
  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(joystick1, 1).whileTrue(new ArmPIDCmd(armSubsystem, 1.2));
    new JoystickButton(joystick1, 2).whileTrue(new ArmPIDCmd(armSubsystem, 0));
    new JoystickButton(joystick1, 3).whileTrue(new ArmJoystickCmd(armSubsystem, 0.5));
    new JoystickButton(joystick1, 4).whileTrue(new ArmJoystickCmd(armSubsystem, -0.5));

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
