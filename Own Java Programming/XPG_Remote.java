package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "Xpg Remote", group = "Templates")
//@Disabled
public class XPG_Remote extends LinearOpMode {


    private DcMotor FL;
    private DcMotor FR;

    public void runOpMode() throws InterruptedException {

        FL = hardwareMap.get(DcMotor.class, "FL");
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        double spoed = 0;
        waitForStart();


        while (true) {

            if (gamepad1.left_trigger >0){
                FL.setDirection(DcMotorSimple.Direction.FORWARD);
                spoed = gamepad1.left_trigger;
                FL.setPower(spoed);
            }
            else {FL.setPower(0);

            }

            if(gamepad1.right_trigger >0){
                FL.setDirection(DcMotorSimple.Direction.REVERSE);
                spoed = gamepad1.right_trigger;
                FL.setPower(spoed);

            }
            else {
                FL.setPower(0);
            }










        }
    }
}


