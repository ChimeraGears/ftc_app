package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class teleOp3 extends OpMode{
    public DcMotor leftFrontDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightBackDrive = null;

    public void init(){
        //names of motors her emust match their names in the phone
        leftFrontDrive = hardwareMap.get(DcMotor.class,"front left");
        rightFrontDrive = hardwareMap.get(DcMotor.class,"front right");
        leftBackDrive = hardwareMap.get(DcMotor.class,"back left");
        rightBackDrive = hardwareMap.get(DcMotor.class,"back right");
        //this is the part determining directions!
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop(){
        double leftFrontPower;
        double rightFrontPower;
        double leftBackPower;
        double rightBackPower;

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        leftFrontPower = Range.clip(drive+turn,-1.0,1.0);
        leftBackPower = Range.clip(drive+turn,-1.0,1.0);
        rightFrontPower = Range.clip(drive-turn,-1.0,1.0);
        rightBackPower = Range.clip(drive-turn,-1.0,1.0);

        leftFrontDrive.setPower(leftFrontPower);
        rightFrontDrive.setPower(rightFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightBackDrive.setPower(rightBackPower);

        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftFrontPower, rightFrontPower, leftBackPower, rightBackPower);
    }
}