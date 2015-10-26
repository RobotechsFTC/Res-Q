package com.qualcomm.ftcrobotcontroller.opmodes.MyPrograms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Basic Movement Library containing functions for moving robot chassis.
 * This version does not contain autonomous functions, because the robot
 * does not yet have encoders attached.
 *
 * @author Sauhaarda Chowdhuri
 * @version 1.00 20 Oct 2015
 */

public class BasicMoveLibrary {

    /**
     * Front left motor of robot
     *
     * @since 1.00
     */
    DcMotor flmotor;

    /**
     * Back left motor of robot
     *
     * @since 1.00
     */
    DcMotor blmotor;

    /**
     * Front right motor of robot
     *
     * @since 1.00
     */
    DcMotor frmotor;

    /**
     * Back right motor of robot
     *
     * @since 1.00
     */
    DcMotor brmotor;

    /**
     * Initialize motors, and reverse the direction of the two left motors because of their reversed position.
     *
     * @param hm Hardware map xml file from the robot controller.
     * @since 1.00
     */
    public BasicMoveLibrary(HardwareMap hm) {
        flmotor = hm.dcMotor.get("flmotor");
        blmotor = hm.dcMotor.get("blmotor");
        frmotor = hm.dcMotor.get("frmotor");
        brmotor = hm.dcMotor.get("brmotor");
        flmotor.setDirection(DcMotor.Direction.REVERSE);
        blmotor.setDirection(DcMotor.Direction.REVERSE);
    }

    /**
     * Moves wheels forward at power indefinitely.
     *
     * @param power Power of wheels when moving forward during teleop
     * @since 1.00
     */
    public void moveFwd(double power) {
        flmotor.setPower(power);
        blmotor.setPower(power);
        frmotor.setPower(power);
        brmotor.setPower(power);
    }

    /**
     * Moves wheels backward at power indefinitely.
     *
     * @param power Power of wheels when moving backward during teleop
     * @since 1.00
     */
    public void moveBwd(double power) {
        flmotor.setPower(-power);
        blmotor.setPower(-power);
        frmotor.setPower(-power);
        brmotor.setPower(-power);
    }

    /**
     * Move front wheels in opposite directions, turning the robot right indefinitely
     *
     * @param power Power of wheels when turning right during teleop
     * @since 1.00
     */
    public void turnLft(double power) {
        flmotor.setPower(power);
        blmotor.setPower(power);
        frmotor.setPower(-power);
        brmotor.setPower(-power);
    }

    /**
     * Move front wheels in opposite directions, turning the robot left indefinitely
     *
     * @param power Power of wheels when turning left during teleop
     * @since 1.00
     */
    public void turnRgt(double power) {
        flmotor.setPower(-power);
        frmotor.setPower(power);
    }

}
