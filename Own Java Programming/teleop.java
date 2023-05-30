package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import static java.lang.Math.abs;

@TeleOp(name = "Kompetisie_Tele_Op_Program1", group = "Basics")
public class Xander_teleOp extends LinearOpMode {

    private DcMotor FL,BL,FR,BR;
    public Servo claw;
    private DcMotor armL, armR;
     

   private NormalDriveController ndController = new NormalDriveController();

   // @Override
    public void runOpMode() throws InterruptedException {
         claw = hardwareMap.servo.get("claw");
         claw2 = hardwareMap.servo.get("claw2");
         armL = hardwareMap.get(DcMotor.class, "armL");
         armR = hardwareMap.get(DcMotor.class, "armR");


        ndController.setSpeed(0.00);
        ndController.initMotors();


        waitForStart();

            while (true){
                ndController.setSpeed(gamepad1.right_trigger);
                
                 if (gamepad2.right_bumper){
                claw.setPosition(0.6);
                claw2.setPosition(-0.6);
            }
            else {
                claw.setPosition(1);
                claw2.setPosition(-1);
            }
            
                //if (gamepad2.left_trigger){
                   // cla2w.setPosition(-0.6);
               // }
               // else {
                    claw2.setPosition(-1);
              //  }
            
                
            
             if (gamepad2.right_stick_y > 0){
                armL.setPower(0.65);
                armR.setPower(0.65);
       
      
                
      
            }
            else {
                armL.setPower(0);
                armL.setPower(0);
            }


            if (gamepad2.right_stick_y < 0){
                armL.setPower(-0.65);
                armR.setPower(-0.65);
            }
            else {
                armL.setPower(0);
                armR.setPower(0);
            }


                if (gamepad1.left_stick_y > 0){
                    ndController.moveBackwards();
                }
                if (gamepad1.left_trigger < 0.01) {
                    ndController.stop();
                }

                if (gamepad1.left_stick_y < 0){
                    ndController.moveForward();
                
            }

              if (gamepad1.left_stick_x < 0){
                ndController.turnLeft();
              }

             if (gamepad1.left_stick_x > 0){
                ndController.turnRight();
                 }

             if((gamepad1.right_stick_x == 0) && (gamepad1.left_bumper )){
                 ndController.stafeLeft();
                 }

             if((gamepad1.right_stick_x == 0) && (gamepad1.right_bumper )){
                 ndController.strafeRight();
                 }



                ndController.setSpeed(0.00);


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
            BL.setDirection(DcMotorSimple.Direction.REVERSE);
            FL.setDirection(DcMotorSimple.Direction.REVERSE);
            BR.setDirection(DcMotorSimple.Direction.FORWARD);
        }
        public void stop(){
            FL.setPower(0);
            BL.setPower(0);
            FR.setPower(0);
            BR.setPower(0);

        }

        public void moveBackwards(){
            FL.setPower(speed);
            BL.setPower(speed);
            FR.setPower(speed);
            BR.setPower(speed);
        }

        public void moveForward(){
            FL.setPower(-speed);
            BL.setPower(-speed);
            FR.setPower(-speed);
            BR.setPower(-speed);
        }

        public void turnLeft(){
            FL.setPower(speed);
            BL.setPower(speed);
            FR.setPower(-speed);
            BR.setPower(-speed);
        }

        public void turnRight(){
            FL.setPower(-speed);
            BL.setPower(-speed);
            FR.setPower(speed);
            BR.setPower(speed);
        }

        public void stafeLeft(){
            FL.setPower(speed);
            BL.setPower(-speed);
            FR.setPower(-speed);
            BR.setPower(speed);
        }

        public void strafeRight(){
            FL.setPower(-speed);
            BL.setPower(speed);
           FR.setPower(speed);
            BR.setPower(-speed);
        }









    }




}
