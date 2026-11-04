package org.firstinspires.ftc.teamcode.Addons;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


/*-----------------------------------------------------------------------------------------------
 TODO:
 - [X] Get Flywheel Speed
 - [X] Set Flywheel Speed
 - [X] enable PIDF control
-----------------------------------------------------------------------------------------------*/
public class FlyWheel {
    private double lowSpeed;
    private double highSpeed;
    private double curVel, error;
    private double P = 0;
    private double F = 0;
    private double targetSpeed = highSpeed;
    private double ticksPerRev;

    double[] stepSize = {10.0, 1.0, 0.1, 0.001, 0.0001};
    int stepIndex = 0;

    private DcMotorEx flywheelOne;
    public PIDFCoefficients PIDFCo = new PIDFCoefficients(P,0.0,0.0,F);

    public void init(HardwareMap map) {
        curVel = 0;
        error = 0;
        flywheelOne = map.get(DcMotorEx.class, "flywheel_motor");
        flywheelOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheelOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = flywheelOne.getMotorType().getTicksPerRev();
        PIDFCo = new PIDFCoefficients(P,0.0,0.0,F);
        flywheelOne.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, PIDFCo);

        lowSpeed = 900;
        highSpeed = 1500;
    }

    public void setSpeed(){

        curVel = flywheelOne.getVelocity(AngleUnit.DEGREES);
        error = targetSpeed - curVel;

        PIDFCo.p = P;
        PIDFCo.f = F;
        flywheelOne.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, PIDFCo);
        flywheelOne.setVelocity(targetSpeed);
    }

    public void setTune() {
        if (stepIndex < stepSize.length) {
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
    public double getError(){
        return error;
    }
    public double getTargetSpeed() {
        return targetSpeed;
    }
    public double getP() {
        return P;
    }
    public double getF() {
        return F;
    }
    public double getTune(){
        return stepSize[stepIndex];
    }
    public void setTarget(){
        if (targetSpeed == highSpeed) {
            targetSpeed = lowSpeed;
            setSpeed();
        }
        else {
            targetSpeed = highSpeed;
            setSpeed();
        }

    }
    public void increaseHighSpeed() {
        highSpeed += 100;
    }
}
