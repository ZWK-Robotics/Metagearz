package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gyroscope;

@Autonomous(name="JoncoAUTO")

public class JoncoAuto extends LinearOpMode{
    private DcMotor bL;
    private DcMotor bR;
    private DcMotor fL;
    private DcMotor fR;
    private DcMotor tet1;
    private DcMotor tet2;
    private Servo arm;
    
      public void runOpMode() {
        
        fL = hardwareMap.get(DcMotor.class, "FL");
        fL.setDirection(DcMotor.Direction.FORWARD);
        
        fR = hardwareMap.get(DcMotor.class, "FR");
        fR.setDirection(DcMotor.Direction.FORWARD);
        
        bL = hardwareMap.get(DcMotor.class, "BL");
        bL.setDirection(DcMotor.Direction.FORWARD);
        
        bR = hardwareMap.get(DcMotor.class, "BR");
        bR.setDirection(DcMotor.Direction.FORWARD);
        
        waitForStart();
      
        double power;
        double bLPower;
        double bRPower;
        double fLPower;
        double fRPower;
        
        DriveForward(1);
        sleep(2000);
        
        TurnRight(1);
        sleep(1000);
        
        
        
      }
        
        public void DriveForward(double power) 
        {
          fL.setPower(power);
          fR.setPower(power);
          bL.setPower(-power);
          bR.setPower(-power);
        }
       public void TurnRight(double power) 
        {
          fL.setPower(power);
          fR.setPower(power);
          bL.setPower(power);
          bR.setPower(power);
        }
      
    
}
