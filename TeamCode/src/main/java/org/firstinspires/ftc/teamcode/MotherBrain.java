package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Addons.DriveMotors;

@Autonomous
public class MotherBrain extends OpMode {

    DriveMotors motors = new DriveMotors();
    @Override
    public void init(){
        motors.init(hardwareMap);
        telemetry.addLine("Initialized");
        telemetry.addData("Speed Index: ", (motors.getSpeedIndex()+1));
    }

    @Override
    public void loop() {
        // Make the robot go! This should check what speed we should be on and eventually set it to
        // work correctly
        motors.checkSpeed(gamepad1.right_stick_x,gamepad1.left_stick_x,gamepad1.left_stick_y);

        // Need to do some flywheel magic here ------------------------

        // Secondary Flywheel magic again!-----------------------------

        // Lets get ready for uptake ----------------------------------

        telemetry.addData("Speed Index: ",(motors.getSpeedIndex()+1));
        telemetry.update();
    }
}
