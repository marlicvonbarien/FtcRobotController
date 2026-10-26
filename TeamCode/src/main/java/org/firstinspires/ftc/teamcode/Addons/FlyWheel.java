package org.firstinspires.ftc.teamcode.Addons;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

/*-----------------------------------------------------------------------------------------------
 TODO:
 - [X] Get Flywheel Speed
 - [X] Set Flywheel Speed
 - [X] enable PIDF control
-----------------------------------------------------------------------------------------------*/
public class FlyWheel {
    private double lowSpeed;
    private double highSpeed;
    private double speed;
    private double curVel, error;
    double P = 0;
    double F = 0;
    private double targetSpeed = highSpeed;

    double[] stepSize = {10.0, 1.0, 0.1, 0.001, 0.0001};
    int stepIndex = 1;

    private double new_P, new_I, new_D,new_F;
    public PIDFCoefficients PIDFCo = new PIDFCoefficients(P,0.0,0.0,F);
    private DcMotorEx flywheelOne;

    public void init(HardwareMap map) {
        flywheelOne = map.get(DcMotorEx.class, "flywheelOne");
        flywheelOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheelOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelOne.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, PIDFCo);

        lowSpeed = 900;
        highSpeed = 1500;
    }

    public void setSpeed(){
        if (targetSpeed == highSpeed) {
            flywheelOne.setPower(lowSpeed);
            targetSpeed = lowSpeed;
        }
        else {
            flywheelOne.setPower(highSpeed);
            targetSpeed = highSpeed;
        }

        curVel = flywheelOne.getVelocity();
        error = targetSpeed - curVel;

        PIDFCo = new PIDFCoefficients(P,0.0,0.0,F);
        flywheelOne.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, PIDFCo);
    }

    public void setTune() {
        if (stepIndex < 5) {
            stepIndex += 1;
        }
        else {
            stepIndex = 0;
        }
    }

    public void increaseP () {
        P += stepSize[stepIndex];
    }
    public void decreaseP () {
        P -= stepSize[stepIndex];
    }

    public void increaseF() {
        F += stepSize[stepIndex];
    }

    public void decreaseF() {
        F -= stepSize[stepIndex];
    }

    public double getSpeed(){
        return curVel;
    }
    public double getTargetSpeed() {
        return targetSpeed;
    }
}
