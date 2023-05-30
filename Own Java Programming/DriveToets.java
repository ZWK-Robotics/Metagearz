package ToetsCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="DriveToets1", group="Jonco_DriveToets")
//@Disabled
public class DriveToets extends LinearOpMode{

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontleft;
    private DcMotor frontright;
    private DcMotor backleft;
    private DcMotor backright;
    private boolean currentA;
   

    //@Override
    public void runOpMode() {

        currentA = gamepad1.x;
        
        frontleft = hardwareMap.get(DcMotor.class, "FL");
        frontright = hardwareMap.get(DcMotor.class, "FR");
        backleft = hardwareMap.get(DcMotor.class, "BL");
        backright = hardwareMap.get(DcMotor.class, "BR");


        frontleft.setDirection(DcMotor.Direction.FORWARD);
        frontright.setDirection(DcMotor.Direction.FORWARD);
        backleft.setDirection(DcMotor.Direction.FORWARD);
        backright.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();


        while (opModeIsActive()) {

            double power;
            double leftPower;
            double rightPower;

            //telemetry.addData(">", "Drive mode? %s\n", DriveToets.latestA() ? "Yes" : "No");

            if (currentA = false) {

                power = gamepad1.left_stick_y;

                frontleft.setPower(power);
                frontright.setPower(power);
                backleft.setPower(power);
                backright.setPower(power);


            }
            else if (currentA = true) {

                leftPower = gamepad1.left_stick_y;
                rightPower = gamepad1.right_stick_y;

                frontleft.setPower(leftPower);
                frontright.setPower(-rightPower);
                backleft.setPower(leftPower);
                backright.setPower(-rightPower);

            }
        }
    }
}
