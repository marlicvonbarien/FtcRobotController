package org.firstinspires.ftc.teamcode.Addons;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveMotors {

    private DcMotor frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive;
    private double frontLeftPower, backLeftPower, frontRightPower, backRightPower = 0;
    private double maxSpeed = 0.25;

    public void init(HardwareMap map) {

        frontLeftDrive = map.get(DcMotor.class, "front_left");
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive = map.get(DcMotor.class, "back_left");
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive = map.get(DcMotor.class, "front_right");
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive = map.get(DcMotor.class,  "back_right");
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        frontLeftDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(com.qualcomm.robotcore.hardware.DcMotor.Direction.REVERSE);

    }

    public void setSpeed(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower){
        frontLeftDrive.setPower(frontLeftPower);
        frontRightDrive.setPower(frontRightPower);
        backLeftDrive.setPower(backLeftPower);
        backRightDrive.setPower(backRightPower);
    }

    public void checkSpeed(double rightX, double leftX, double leftY) {

        double axial   = leftY;  // Note: pushing stick forward gives negative value
        double lateral =  leftX;
        double yaw     =  rightX;

        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        frontLeftPower  = (axial + lateral + yaw) * maxSpeed;
        frontRightPower = (axial - lateral - yaw) * maxSpeed;
        backLeftPower   = (axial - lateral + yaw) * maxSpeed;
        backRightPower  = (axial + lateral - yaw) * maxSpeed;

        double max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;
        }

        setSpeed(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

    }
}
