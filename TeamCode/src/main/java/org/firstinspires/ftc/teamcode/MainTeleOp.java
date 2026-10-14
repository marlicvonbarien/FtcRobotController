package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Addons.DriveMotors;

@TeleOp
public class MainTeleOp extends OpMode {

    DriveMotors motors = new DriveMotors();
    @Override
    public void init(){
        motors.init(hardwareMap);
    }
    @Override
    public void loop() {

        // Make the robot go! This should check what speed we should be on and eventually set it to
        // work correctly
        motors.checkSpeed(gamepad1.right_stick_x,gamepad1.left_stick_x,gamepad1.left_stick_y);
        if(gamepad1.aWasPressed()){ motors.setMaxSpeed();}   //Adjust max speed on the fly

        // Need to do some flywheel magic here ------------------------

        // Secondary Flywheel magic again!-----------------------------

        // Lets get ready for uptake ----------------------------------
    }
}
