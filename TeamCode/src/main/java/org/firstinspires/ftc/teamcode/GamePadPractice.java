package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class GamePadPractice extends OpMode {
    public void init() {

    }

    public void loop() {

        double speedForward = -gamepad1.left_stick_y / 2.0;
        double differenceBetweenLeftRight = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double sumTriggers = gamepad1.left_trigger + gamepad1.right_trigger;

        //read gamepad sensor
        //Left Stick
        telemetry.addData("Left X:", gamepad1.left_stick_x);
        telemetry.addData("Left Y: ", speedForward);

        //buttons
        telemetry.addData( "A button" , gamepad1.a);
        telemetry.addData("B Button", gamepad1.b);

        //Right Joystick
        telemetry.addData("Right X: ", gamepad1.right_stick_x);
        telemetry.addData("Right Y: ", gamepad1.right_stick_y);

        //Math?
        telemetry.addData("Difference between Left and Right: ", differenceBetweenLeftRight);
        telemetry.addData("Sum of Triggers: ", sumTriggers);

    }
}
