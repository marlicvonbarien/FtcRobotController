package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {

    double angle;
    double x,y;

    public RobotLocationPractice (double angle){
        this.angle = angle;
        this.x = 0;
        this.y = 0;
    }

    // Use this method to normalize turn angles to keep heading between -180 and 180
    public double getHeading(){
        double angle = this.angle;

        while (angle >= 180){
            angle -= 360;
        }

        while (angle <= -180){
            angle += 360;
        }

        return angle;   //return normalized value
    }

    public void turnRobot(double angleChange) {
        this.angle += angleChange;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public double getAngle(){
        return this.angle;
    }
    public void changeX (double changeAmount) {
        this.x += changeAmount;
    }
    public double getX (){
        return this.x;
    }
    public void setX (double newX) {
        this.x = newX;
    }
    public void changeY (double changeAmount) {
        this.y += changeAmount;
    }
    public double getY (){
        return this.y;
    }
    public void setY (double newY) {
        this.x = newY;
    }
}
