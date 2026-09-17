package org.firstinspires.ftc.teamcode.mechanisms;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DcMotor motor;
    private double ticksPerRev;

    public void init(HardwareMap hwMap) {
        //DC Motor Section
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);   //Using encoder keeps multiple motors
                                                            //running at the same speed as close as
                                                            //possible. good for drive motors.
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior,BRAKE);
        //motor.setDirection(DcMotor.Direction.REVERSE);
    }

    //DC Motor Section
    public void setMotorSpeed(double speed) {
        //runs at from -1 to +1
        motor.setPower(speed);
    }
    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;    //Giving number of ticks per revolutions.
    }
}
