package frc.robot;

public final class Constants {

    public static final class DriveConstants {
      public static final int kRightMotorPort = 1;
      public static final int kLeftMotorPort = 2;
      public static final double kEncoderTick2Feet = (1 / 42) * 4 * (6 * Math.PI) * (1 / 12);
      public static final double kAutoDriveForwardSpeed = 0.5;
      public static final double kAutoDriveForwardDistance = 1.5;
      public static final double kAutoDriveForwardRotation = 0;
      public static final double kStopDriveSpeed = 0;
      public static final double kStopRotationSpeed = 0;
    }

    public static final class ArmConstants {
      public static final int kMotorPort = 5;
      public static final double kEncoderTick2Feet = (1.0 / 42) * /*gear ratio*/1 * Math.PI * (1 / 12);
      public static final double kP = 0;
      public static final double kI = 0;
      public static final double kD = 0;

      public static final double kRaisedPosition = 1.2;
      public static final double kLoweredPosition = 0;
      public static final double kJoystickMaxSpeed = 0.5;
      public static final double kStopSpeed = 0;
    }

    public static final class IntakeConstants {
      public static final int kMotorPort = 6;
      public static final double kOpenSpeed = 0.5;
      public static final double kCloseSpeed = -0.5;
    }

    public static final class OIConstants {
      public static final int kDriverJoystickPort = 0;

      public static final int kDriveSpeedAxis = 1;
      public static final int kDriveTurnAxis = 3;

      public static final int kArmPIDRaiseButtonIdx = 1;
      public static final int kArmPIDLowerButtonIdx = 2;
      public static final int kArmJoystickRaiseButtonIdx = 3;
      public static final int kArmJoystickLowerButtonIdx = 4;
      public static final int kIntakeCloseButtonIdx = 5;
      public static final int kIntakeOpenButtonIdx =6;
    }

}
