package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import static java.lang.Math.abs;

@TeleOp(name = "Genoration_Innovation_25_Feb", group = "Basics")
public class Xander_teleOp extends LinearOpMode {

    private DcMotor FL, BL, FR, BR;
    public Servo clawL;
    public Servo clawR;
    public Servo rocket;

    private DcMotor armL;
    private DcMotor armR;


    private NormalDriveController ndController = new NormalDriveController();

    // @Override
    public void runOpMode() throws InterruptedException {
        clawR = hardwareMap.servo.get("clawR");   //servo claw
        clawL = hardwareMap.servo.get("clawL");
        rocket = hardwareMap.servo.get("rocket");


        armL = hardwareMap.get(DcMotor.class, "armL");
        armR = hardwareMap.get(DcMotor.class, "armR");


        ndController.setSpeed(0.00);
        ndController.initMotors();


        waitForStart();

        while (true) {
            ndController.setSpeed(gamepad1.right_trigger);

            if (gamepad2.right_bumper) {
                clawL.setPosition(0.6);
                clawR.setPosition(-0.6);
            } else {
                clawL.setPosition(1);
                clawR.setPosition(-1);

            }

            if (gamepad2.left_bumper) {
                rocket.setPosition(0.6);
            } else {

                rocket.setPosition(1);

            }


            if (gamepad2.right_stick_y > 0) {
                armL.setPower(20);
                armR.setPower(20);


            } else {
                armL.setPower(0);
                armR.setPower(0);
            }


            if (gamepad2.right_stick_y < 0) {
                armL.setPower(-20);
                armR.setPower(-20);
            } else {
                armL.setPower(0);
                armR.setPower(0);
            }


            if (gamepad1.left_stick_y < 0) {
                ndController.moveBackwards();
            }
            if (gamepad1.left_trigger < 0.01) {
                ndController.stop();
            }

            if (gamepad1.left_stick_y > 0) {
                ndController.moveForward();

            }

            if (gamepad1.left_stick_x < 0) {
                ndController.turnLeft();
            }

            if (gamepad1.left_stick_x > 0) {
                ndController.turnRight();
            }

            if ((gamepad1.right_stick_x == 0) && (gamepad1.left_bumper)) {
                ndController.stafeLeft();
            }

            if ((gamepad1.right_stick_x == 0) && (gamepad1.right_bumper)) {
                ndController.strafeRight();
            }


            ndController.setSpeed(0.00);


        }


    }


    public class NormalDriveController {
        public double speed;

        public void setSpeed(double Value) {
            speed = abs(Value * 0.9);
        }


        public void initMotors() {
            FL = hardwareMap.get(DcMotor.class, "FL");
            BL = hardwareMap.get(DcMotor.class, "BL");
            FR = hardwareMap.get(DcMotor.class, "FR");
            BR = hardwareMap.get(DcMotor.class, "BR");
            FL.setDirection(DcMotorSimple.Direction.FORWARD);
            BR.setDirection(DcMotorSimple.Direction.REVERSE);
            FR.setDirection(DcMotorSimple.Direction.REVERSE);
            BL.setDirection(DcMotorSimple.Direction.FORWARD);
        }

        public void stop() {
            FL.setPower(0);
            BL.setPower(0);
            FR.setPower(0);
            BR.setPower(0);

        }

        public void moveForward() {
            FL.setPower(-speed);
            BL.setPower(speed);
            FR.setPower(speed);
            BR.setPower(-speed);
        }

        public void moveBackwards() {
            FL.setPower(speed);
            BL.setPower(-speed);
            FR.setPower(-speed);
            BR.setPower(speed);
        }

        public void turnLeft() {
            FL.setPower(speed);
            BL.setPower(speed);
            FR.setPower(-speed);
            BR.setPower(-speed);
        }

        public void turnRight() {
            FL.setPower(-speed);
            BL.setPower(-speed);
            FR.setPower(speed);
            BR.setPower(speed);
        }

        public void stafeLeft() {
            FL.setPower(speed);
            BL.setPower(-speed);
            FR.setPower(-speed);
            BR.setPower(speed);
        }

        public void strafeRight() {
            FL.setPower(-speed);
            BL.setPower(speed);
            FR.setPower(speed);
            BR.setPower(-speed);
        }


    }


}
