package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Addons.DriveMotors;
import org.firstinspires.ftc.teamcode.Addons.FlyWheel;
import org.firstinspires.ftc.teamcode.Addons.Uptake;

@TeleOp
public class Brain extends OpMode {

    DriveMotors motors = new DriveMotors();
    FlyWheel flywheel = new FlyWheel();

    Uptake uptake = new Uptake();

    @Override
    public void init(){
        motors.init(hardwareMap);
        telemetry.addLine("Initialized");
        telemetry.addData("Speed Index: ", (motors.getSpeedIndex()+1));
        telemetry.addData("Flywheel Speed: ", flywheel.getSpeed());
    }

    @Override
    public void loop() {
        // Make the robot go! This should check what speed we should be on and eventually set it to
        // work correctly
        motors.checkSpeed(gamepad1.right_stick_x,gamepad1.left_stick_x,gamepad1.left_stick_y);
        flywheel.setSpeed();
        uptake.vroom();

        if(gamepad1.aWasPressed()){ motors.setMaxSpeed();}   //Adjust max speed on the fly

        // Need to do some flywheel magic here ------------------------
        if(gamepad1.yWasPressed()){flywheel.setTarget();}
        if(gamepad1.bWasPressed()){flywheel.setTune();}
        if (gamepad1.xWasPressed()) {
            flywheel.increaseHighSpeed();
        }
        if(gamepad1.dpadUpWasPressed()){flywheel.increaseP();}
        if(gamepad1.dpadDownWasPressed()){flywheel.decreaseP();}
        if(gamepad1.dpadRightWasPressed()){flywheel.increaseF();}
        if(gamepad1.dpadLeftWasPressed()){flywheel.decreaseF();}

        // Uptake Magic!-----------------------------------------------
        if(gamepad1.leftBumperWasPressed()){
            uptake.increaseUpSpeed();
        }
        if (gamepad1.leftTriggerWasPressed()) {
            uptake.decreaseUpSpeed();
        }
        if (gamepad1.rightBumperWasPressed()) {
            uptake.increaseDownSpeed();
        }
        if (gamepad1.rightTriggerWasPressed()) {
            uptake.decreaseDownSpeed();
        }
        if (gamepad1.leftStickButtonWasPressed()) { uptake.stopMotor(); }


        // Get ready for the info ----------------------------------

        telemetry.addLine("==============================================");
        telemetry.addLine("Hello Driver, Please see important variables");
        telemetry.addLine("==============================================");
        telemetry.addData("Speed Index: ",(motors.getSpeedIndex()+1));
        telemetry.addData("Flywheel Speed Goal: ", flywheel.getTargetSpeed());
        telemetry.addLine("==============================================");
        telemetry.addData("Flywheel Current Speed: ", flywheel.getSpeed());
        telemetry.addData("Current Error: ", flywheel.getError());
        telemetry.addLine("==============================================");
        telemetry.addData("Uptake Upper Motor: ", uptake.getUpSpeed());
        telemetry.addData("Uptake Lower Motor: ", uptake.getDownSpeed());
        telemetry.update();
    }
}