package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Toets_Autonomous1", group = "Toets")
//@Disabled
public class Toets_Autonomous1 extends LinearOpMode {


    private DcMotor FL = null;
    private DcMotor FR = null;

    public void runOpMode() throws InterruptedException {

        FL=hardwareMap.get(DcMotor.class, "FL");
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FL.setDirection(DcMotor.Direction.FORWARD);
        
         FR=hardwareMap.get(DcMotor.class, "FR");
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        double spoed = 0.0;
        while (true) {

            if (spoed <1) {
            spoed += 0.01;}

            FL.setPower(spoed);
            FR.setPower(spoed);
            }

        }
    }


