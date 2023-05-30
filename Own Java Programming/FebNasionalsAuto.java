package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "25_Feb_Nasionals_Auto")

public class FebNasionalsAuto extends LinearOpMode{
    private DcMotor FL;
    private DcMotor BL;
    private DcMotor FR;
    private DcMotor BR;
    
    private DcMotor armL;
    private  DcMotor armR;
    private DcMotor armH;
    
    private Servo claw;

    
    @Override
    public void runOpMode() {
        FL = hardwareMap.get(DcMotor.class, "FL");
        BL = hardwareMap.get(DcMotor.class, "BL");
        FR = hardwareMap.get(DcMotor.class, "FR");
        BR = hardwareMap.get(DcMotor.class, "BR");
         armL = hardwareMap.get(DcMotor.class, "armL");
        armR = hardwareMap.get(DcMotor.class, "armR");
        armH = hardwareMap.get(DcMotor.class, "armH");
        claw = hardwareMap.get(Servo.class, "claw");

        FL.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        
        armR.setDirection(DcMotorSimple.Direction.REVERSE);
        armL.setDirection(DcMotorSimple.Direction.REVERSE);    
        armH.setDirection(DcMotorSimple.Direction.REVERSE);
        
        claw.setDirection(Servo.Direction.REVERSE);
        
        waitForStart();
        claw.scaleRange(0.2, 0.8);
        if (opModeIsActive()) {
            // Pull up arm && grab
            claw.setPosition(-0.4);
            //armR.SetPower(1);
            //armL.SetPower(1);
            sleep(1000);
            // Reguit voor
            FL.setPower(0.5);
            FR.setPower(0.5);
            BL.setPower(0.5);
            BR.setPower(0.5);
            sleep(1000);
            for (int count = 0; count < 1; count++) {
                FL.setPower(0);
                BL.setPower(0);
                FR.setPower(0);
                BR.setPower(0);
                sleep(1000);
            }
        }
    }
}
