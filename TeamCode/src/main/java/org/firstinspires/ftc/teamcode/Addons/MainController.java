package org.firstinspires.ftc.teamcode.Addons;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MainController {

    //Add out motors to the main control
    private DcMotor frontLeftDrive, backLeftDrive, frontRightDrive, backRightDive = null;
    public void init(HardwareMap hwMap) {
        // Add our components
    }

    //DC Motor Section
    public void setMotorSpeed(double speed) {
        //runs at from -1 to +1
        motor.setPower(speed);
    }
    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;    //Giving number of ticks per revolutions.
    }
}
