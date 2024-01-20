package ToetsCode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


public class ColorToets extends LinearOpMode{

    private ColorSensor color;
    private DcMotor frontLeft;
    double Drive;
    
    public void runOpMode() {
        
        color = hardwareMap.get(ColorSensor.class, "Color");
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        
        waitForStart();
        
        while (opModeIsActive()) {
            
            
            frontLeft.setPower(Drive);
            
            if (color.red() < 200) {
                Drive = 1;
            } 
        }
    }
    
}
