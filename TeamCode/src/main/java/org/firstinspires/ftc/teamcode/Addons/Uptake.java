package org.firstinspires.ftc.teamcode.Addons;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Uptake {
    private DcMotorEx motorUp, motorDown;
    private double upSpeed;
    private double prevUpSpeed;
    private double downSpeed;
    private double prevDownSpeed;

    private final double STARTSPEED = 20;
    private final double INCREMENT = 10;
    private boolean stopped = false;

    public void init(HardwareMap map) {

        upSpeed = STARTSPEED;
        downSpeed = STARTSPEED;

        prevDownSpeed = STARTSPEED;
        prevUpSpeed = STARTSPEED;

        stopped = false;

        motorUp = map.get(DcMotorEx.class, "uptake_upper");
        motorUp.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorDown = map.get(DcMotorEx.class,  "uptake_down");
        motorDown.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Set the motor direction to orientate to the correct driving direction
        motorUp.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.FORWARD);
        motorDown.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.FORWARD);
    }

    // Method to start running-----------------------------------------------------------------
    public void vroom () {
        motorUp.setVelocity(upSpeed);
        motorDown.setVelocity(downSpeed);
    }
    // Method to stop running------------------------------------------------------------------
    public void stopMotor () {
        if (!stopped) {
            prevUpSpeed = upSpeed;
            prevDownSpeed = downSpeed;
            upSpeed = 0;
            downSpeed = 0;
            stopped = true;
            vroom();
        }
        else {
            upSpeed = prevUpSpeed;
            downSpeed = prevDownSpeed;
            vroom();
        }
    }
    // Method to adjust speed------------------------------------------------------------------
    public void increaseUpSpeed () {
        upSpeed +=  INCREMENT;
        vroom();
    }
    public void decreaseUpSpeed() {
        upSpeed -=  INCREMENT;
        vroom();
    }
    public void increaseDownSpeed() {
        downSpeed +=  INCREMENT;
        vroom();
    }
    public void decreaseDownSpeed() {
        downSpeed -=  INCREMENT;
        vroom();
    }
    // Method to get speed---------------------------------------------------------------------
    public double getUpSpeed() {
        return upSpeed;
    }
    public double getDownSpeed() {
        return downSpeed;
    }
}
