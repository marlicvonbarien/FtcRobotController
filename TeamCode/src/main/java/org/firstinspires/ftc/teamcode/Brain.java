package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Addons.DriveMotors;
import org.firstinspires.ftc.teamcode.Addons.FlyWheel;

@TeleOp
public class Brain extends OpMode {

    DriveMotors motors = new DriveMotors();
    FlyWheel flywheel = new FlyWheel();
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
        if(gamepad1.aWasPressed()){ motors.setMaxSpeed();}   //Adjust max speed on the fly

        // Need to do some flywheel magic here ------------------------
        if(gamepad1.yWasPressed()){flywheel.setSpeed();}
        if(gamepad1.bWasPressed()){flywheel.setTune();}
        if(gamepad1.dpadUpWasPressed()){flywheel.increaseP();}
        if(gamepad1.dpadDownWasPressed()){flywheel.decreaseP();}
        if(gamepad1.dpadRightWasPressed()){flywheel.increaseF();}
        if(gamepad1.dpadLeftWasPressed()){flywheel.decreaseF();}

        // Secondary Flywheel magic again!-----------------------------

        // Lets get ready for uptake ----------------------------------

        telemetry.addData("Speed Index: ",(motors.getSpeedIndex()+1));
        telemetry.addData("Flywheel Speed: ", flywheel.getSpeed());
        telemetry.update();
    }
}
