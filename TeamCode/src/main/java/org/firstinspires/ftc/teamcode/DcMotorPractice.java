package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DcMotorPractice extends OpMode {

    TestBench bench = new TestBench();
    HardwareMap hardwareMap = new HardwareMap;
    @Override
    public void init() {
        bench.init(hardwareMap);
    }
    @Override
    public void loop() {
        bench.setMotorSpeed(0.5);
        double motorSpeed = gamepad1.left_stick_y;
        telemetry.addData("Motor Revs: ", bench.getMotorRevs());
    }
}
