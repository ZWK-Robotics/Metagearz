package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Sommer3", group = "Basics")

public class Sukkel extends LinearOpMode {

    private DcMotor Tet1;
    public Servo arm;

    //@Override
    public void runOpMode() throws InterruptedException {
        Tet1 = hardwareMap.get(DcMotor.class, "Tet1");


        waitForStart();

        while (true){

            if (gamepad1.right_stick_y > 0){
                Tet1.setPower(0.7);
            }
            else {
                Tet1.setPower(0);
            }


            if (gamepad1.right_stick_y < 0){
                Tet1.setPower(-0.7);
            }
            else {
                Tet1.setPower(0);
            }
        }

    }
}
