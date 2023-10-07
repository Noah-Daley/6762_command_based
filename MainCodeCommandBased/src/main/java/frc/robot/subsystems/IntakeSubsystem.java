package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.CANSparkMax.IdleMode;

public class IntakeSubsystem extends SubsystemBase{
    //Motor6
    private CANSparkMax intakeMotor = new CANSparkMax(IntakeConstants.kMotorPort, MotorType.kBrushed);

    public IntakeSubsystem() {
        intakeMotor.setIdleMode(IdleMode.kBrake);
    }

    public void setDirection(double speed) {
       intakeMotor.set(speed);       
    }


}
