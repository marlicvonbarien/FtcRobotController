package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Addons.Motor;

@TeleOp
public class MainTeleOp extends OpMode {

    Motor motors = new Motor();
    @Override
    public void init(){
        motors.init(hardwareMap);
    }
    @Override
    public void loop() {

        motors.checkSpeed(gamepad1.right_stick_x,gamepad1.left_stick_x,gamepad1.left_stick_y);

    }
}
