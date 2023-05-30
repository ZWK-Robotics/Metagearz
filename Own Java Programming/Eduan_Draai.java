package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@TeleOp(name = "Eduan Draai", group = "Templates")
//@Disabled
public class Eduan_Draai extends LinearOpMode {

    private DcMotor FL;
    private DcMotor BL;
    private DcMotor FR;
    private DcMotor BR;


    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.get(DcMotor.class, "FL");
        BL = hardwareMap.get(DcMotor.class, "BL");
        FR = hardwareMap.get(DcMotor.class, "FR");
        BR = hardwareMap.get(DcMotor.class, "BR");
        boolean reverse = true;
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        while (true)
        {
            if ( gamepad1.a)
            {
               reverse = !reverse;
            }

            if (reverse){
                FL.setPower(gamepad1.left_trigger);
                BL.setPower(gamepad1.left_trigger);
                FR.setPower(gamepad1.left_trigger);
                BR.setPower(gamepad1.left_trigger);
            }
            else
            {
                FL.setPower(-gamepad1.left_trigger);
                BL.setPower(-gamepad1.left_trigger);
                FR.setPower(-gamepad1.left_trigger);
                BR.setPower(-gamepad1.left_trigger);
            }



        }






        }
}

