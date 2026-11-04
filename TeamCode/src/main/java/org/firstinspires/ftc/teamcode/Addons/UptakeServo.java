package org.firstinspires.ftc.teamcode.Addons;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class UptakeServo {
    private Servo combine;
    private double newAngle;

    public void init(HardwareMap map) {
        combine = map.get(Servo.class, "combine");
        combine.setDirection(Servo.Direction.REVERSE);


        combine.setPosition(0.5);
        newAngle = 0.5;
    }

    public void runPosition(double position){
        combine.setPosition(position);
    }
    public double getAngle() {
        return combine.getPosition();
    }
    public void setAngle(){
        newAngle = 0.45;
        combine.setPosition(newAngle);
    }
}
