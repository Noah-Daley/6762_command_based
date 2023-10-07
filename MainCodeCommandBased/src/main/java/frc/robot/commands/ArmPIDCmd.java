package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class ArmPIDCmd extends CommandBase{
    private final ArmSubsystem armSubsystem;
    private final PIDController pidController;

    public ArmPIDCmd(ArmSubsystem armSubsytem, double setpoint){
        this.armSubsystem = armSubsytem;
        this.pidController = new PIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD);
        pidController.setSetpoint(setpoint);
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("ArmPIDCmd started!");
        pidController.reset();

    }

    @Override 
    public void execute(){
        double speed = pidController.calculate(armSubsystem.getEncoderFeet());
        armSubsystem.setMotor(speed);
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.setMotor(ArmConstants.kStopSpeed);
        System.out.println("ArmPIDCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
