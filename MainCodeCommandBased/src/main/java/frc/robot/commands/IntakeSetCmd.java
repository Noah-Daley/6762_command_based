package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeSetCmd extends CommandBase {
    
    private final IntakeSubsystem intakeSubsystem;
    private final double speed;

    public IntakeSetCmd(IntakeSubsystem intakeSubsystem, double speed) {
        this.speed = speed;
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("IntakeSetCmd started!");
    }

    @Override
    public void execute() {
        intakeSubsystem.setDirection(speed);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("IntakeSetCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
