package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.controller.PIDController;


public class WheelDrive {
    private Talon angleMotor;
    private Talon speedMotor;
    private PIDController pidController;
    private final double MAX_VOLTS = 5.5;

    public WheelDrive (int angleMotor, int speedMotor, int encoder) {
        this.angleMotor = new Talon (angleMotor);
        this.speedMotor = new Talon (speedMotor);
        pidController = new PIDController(1, 0, 0);

        pidController.setOutputRange(-1, 1);
        pidController.setContinuous();
        pidController.enable();
    }

    public void drive (double speed, double angle) {
        speedMotor.set(speed);
        double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5);
        if(setpoint < 0) {
            setpoint = setpoint + MAX_VOLTS;
        }
        if(setpoint > 0) {
            setpoint = setpoint - MAX_VOLTS;
        }

        pidController.setSetpoint(setpoint);
    }

    

}
