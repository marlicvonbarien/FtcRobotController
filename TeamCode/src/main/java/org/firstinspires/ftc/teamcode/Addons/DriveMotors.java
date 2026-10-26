package org.firstinspires.ftc.teamcode.Addons;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveMotors {

    private DcMotor frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;
    private double frontLeftPower, frontRightPower, backLeftPower, backRightPower;
    private double[] maxSpeed = {0.20,0.30,0.40,0.50,0.60,0.70,0.80,0.90,1};
    private int speedIndex;
    private double startPosition;
    private double endPosition;

    public void init(HardwareMap map) {

        // Ensure that max speed is starting at index 0
        speedIndex = 0;

        frontLeftDrive = map.get(DcMotor.class, "front_left");
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive = map.get(DcMotor.class, "back_left");
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive = map.get(DcMotor.class, "front_right");
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive = map.get(DcMotor.class,  "back_right");
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Set the motor direction to orientate to the correct driving direction
        frontLeftDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.REVERSE);

        startPosition = frontLeftDrive.getCurrentPosition();

    }

    // Iterate over the maxspeed indexes to allow for the kids not destroying ankles or robots
    public void setMaxSpeed(){
        if (speedIndex < 9) {
            speedIndex += 1;
        }
        else {
            speedIndex = 0;
        }
        telemetry.addData("Speed Index: ",speedIndex);
        telemetry.addData("Max Speed: ", maxSpeed[speedIndex]);
    }

    public int getSpeedIndex(){
        return this.speedIndex;
    }

    //I'm not sure why or if we will ever need to directly set the speed outside this class
    // but would rather have it than not.
    public void setSpeed(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower){
        frontLeftDrive.setPower(frontLeftPower);
        frontRightDrive.setPower(frontRightPower);
        backLeftDrive.setPower(backLeftPower);
        backRightDrive.setPower(backRightPower);
    }

    public void checkSpeed(double rightX, double leftX, double leftY) {

        double axial   = -leftY;  // Note: pushing stick forward gives negative value
        double lateral =  leftX;
        double yaw     =  rightX;

        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        frontLeftPower  = (axial + lateral + yaw) * maxSpeed[speedIndex];
        frontRightPower = (axial - lateral - yaw) * maxSpeed[speedIndex];
        backLeftPower = (axial - lateral + yaw) * maxSpeed[speedIndex];
        backRightPower  = (axial + lateral - yaw) * maxSpeed[speedIndex];

        double max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower /= max;
            frontRightPower /= max;
            backLeftPower /= max;
            backRightPower /= max;
        }

        setSpeed(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

    }
}
