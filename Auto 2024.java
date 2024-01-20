package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import static java.lang.Math.abs;

@Autonomous(name="Auto 2024")
public class MarluAuto extends LinearOpMode{
    private DcMotor BR;
    private DcMotor BL;
    private DcMotor FL;
    private DcMotor FR;
    private DcMotor clawArm;
    private DcMotor armL;
    private DcMotor armR;
    private Servo rocket;
    private Servo clawL;
    private Servo clawR;

      public void runOpMode() {

          clawL = hardwareMap.servo.get("clawL");
          clawR = hardwareMap.servo.get("clawR");
          rocket = hardwareMap.servo.get("rocket");
          armL = hardwareMap.get(DcMotor.class, "armL");
          armR = hardwareMap.get(DcMotor.class, "armR");
          clawArm = hardwareMap.get(DcMotor.class, "clawArm");

        waitForStart();

          if (opModeIsActive()) {


              FL.setPower(-0.39);
              FR.setPower(0.39);
              BL.setPower(0.39);
              BR.setPower(-0.39);
              sleep(1000);
              for (int count = 0; count < 1; count++) {
                  FL.setPower(0);
                  BL.setPower(0);
                  FR.setPower(0);
                  BR.setPower(0);
                  sleep(1000);
              }
          }

          public class NormalDriveController{
              public double speed;

              public void setSpeed(double Value){
                  speed = abs(Value * 0.9);
              }


              public void initMotors(){
                  FL = hardwareMap.get(DcMotor.class, "FL");
                  BL = hardwareMap.get(DcMotor.class, "BL");
                  FR = hardwareMap.get(DcMotor.class, "FR");
                  BR = hardwareMap.get(DcMotor.class, "BR");
                  FL.setDirection(DcMotorSimple.Direction.FORWARD);
                  BR.setDirection(DcMotorSimple.Direction.REVERSE);
                  FR.setDirection(DcMotorSimple.Direction.REVERSE);
                  BL.setDirection(DcMotorSimple.Direction.FORWARD);
              }
              public void stop(){
                  FL.setPower(0);
                  BL.setPower(0);
                  FR.setPower(0);
                  BR.setPower(0);
              }

              public void moveForward(){
                  FL.setPower(-speed);
                  BL.setPower(speed);
                  FR.setPower(speed);
                  BR.setPower(-speed);
              }

              public void moveBackwards(){
                  FL.setPower(speed);
                  BL.setPower(-speed);
                  FR.setPower(-speed);
                  BR.setPower(speed);
              }

              public void turnLeft(){
                  FL.setPower(-speed);
                  BL.setPower(speed);
                  FR.setPower(-speed);
                  BR.setPower(speed);
              }

              public void turnRight(){
                  FL.setPower(speed);
                  BL.setPower(-speed);
                  FR.setPower(speed);
                  BR.setPower(-speed);
              }

              public void stafeLeft(){
                  FL.setPower(speed);
                  BL.setPower(speed);
                  FR.setPower(-speed);
                  BR.setPower(-speed);
              }

              public void strafeRight(){
                  FL.setPower(-speed);
                  BL.setPower(-speed);
                  FR.setPower(speed);
                  BR.setPower(speed);
              }
          }