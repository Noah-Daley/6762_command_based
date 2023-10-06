package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmSubsystem extends SubsystemBase{
    //Motor5
    private CANSparkMax armMotor = new CANSparkMax(5, MotorType.kBrushless);
    private RelativeEncoder encoder;
    private final double kEncoderTick2Feet = 1;

    public double getEncoderFeet() {
        return encoder.getPosition() * kEncoderTick2Feet;
    }
    public ArmSubsystem() {

    }


    @Override
    public void periodic() {
        SmartDashboard.putNumber("arm encoder feet", getEncoderFeet());
    }

    public void setMotor(double speed) {
        armMotor.set(speed);
    }



}

