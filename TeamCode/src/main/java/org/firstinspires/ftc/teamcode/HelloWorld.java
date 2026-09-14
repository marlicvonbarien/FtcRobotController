package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Disabled   //Can remove this from the list of options
            // in the robot controller
@TeleOp //Don't forget to use this. If it is not in it does not
        //show up on the driver station.
        //Use @Autonomous for autonomous mode.
public class HelloWorld extends OpMode {

    @Override   //Shows that we are overriding the initialization
    public void init() {
        int teamNumber = 0001;
        double motorSpeed = 0.75;
        boolean clawClosed = true;

        telemetry.addData("Hello ", "Tim?");
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed: ", motorSpeed);
        telemetry.addData("Claw closed: ", clawClosed);
    }
    @Override
    public void loop() {

    }
}
