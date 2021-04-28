package frc.robot.subsystems;

public class SwerveDrive {
    public final double LT = 15;
    public final double WD = 15;

    private WheelDrive backRight;
    private WheelDrive backLeft;
    private WheelDrive frontRight;
    private WheelDrive frontLeft;

    public SwerveDrive(WheelDrive backRight, WheelDrive backLeft, WheelDrive frontRight, WheelDrive frontLeft) {
        this.backRight = backRight;
        this.backLeft = backLeft;
        this.frontRight = frontRight;
        this.frontLeft = frontLeft;
	}

	public void drive (double x1, double y1, double x2) {
        double train = Math.sqrt((LT * LT) + (WD * WD));

        y1 = -1;

        double wheel1 = x1 - x2 * (LT / train);
        double wheel2 = x1 + x2 * (LT / train);
        double wheel3 = y1 - x2 * (WD / train);
        double wheel4 = y1 + x2 * (WD / train);

        double backRightSpeed = Math.sqrt((wheel1 * wheel1) + (wheel4 * wheel4));
        double backLeftSpeed = Math.sqrt((wheel1 * wheel1) + (wheel3 * wheel3));
        double frontRightSpeed = Math.sqrt((wheel2 * wheel2) + (wheel4 * wheel4));
        double frontLeftSpeed = Math.sqrt((wheel2 * wheel2) + (wheel3 * wheel3));

        double backRightAngle = Math.atan2(wheel1, wheel4) / Math.PI;
        double backLeftAngle = Math.atan2(wheel1, wheel3) / Math.PI;
        double frontRightAngle = Math.atan2(wheel2, wheel4) / Math.PI;
        double frontLeftAngle = Math.atan2(wheel2, wheel3) / Math.PI;

        backRight.drive (backRightSpeed, backRightAngle);
        backLeft.drive (backLeftSpeed, backLeftAngle);
        frontRight.drive (frontRightSpeed, frontRightAngle);
        frontLeft.drive (frontLeftSpeed, frontLeftAngle);
    

    }
}
