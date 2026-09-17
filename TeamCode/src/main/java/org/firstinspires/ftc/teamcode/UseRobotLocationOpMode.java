package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class UseRobotLocationOpMode extends OpMode {

    RobotLocationPractice robotLocation = new RobotLocationPractice(0);

    @Override
    public void init() {
        robotLocation.setAngle(0);
        robotLocation.setX(0);
        robotLocation.setY(0);
    }

    @Override
    public void loop(){
        if (gamepad1.a) robotLocation.turnRobot(0.1);
        else if (gamepad1.b) robotLocation.turnRobot(-0.1);
        else if (gamepad1.dpad_left) robotLocation.changeX(0.1);
        else if (gamepad1.dpad_right) robotLocation.changeX(-0.1);
        else if (gamepad1.dpad_up) robotLocation.changeY(-0.1);
        else if (gamepad1.dpad_down) robotLocation.changeY(0.1);

        telemetry.addData("Heading: ", robotLocation.getHeading());
        telemetry.addData("Angle: ", robotLocation.getAngle());
        telemetry.addData("X: ", robotLocation.getX());
        telemetry.addData("Y: ", robotLocation.getY());
    }
}
