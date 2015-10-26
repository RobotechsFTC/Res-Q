package com.qualcomm.ftcrobotcontroller.opmodes.MyPrograms.CustomFiles;

import com.qualcomm.ftcrobotcontroller.opmodes.MyPrograms.TeleopFormat;

/**
 * Example of a teleop class using libraries and parent classes created.
 *
 * @author Sauhaarda Chowdhuri
 * @version 1.00 20 Oct 2015
 */
public class TeleopExample extends TeleopFormat {

    /**
     * Main teleop program that takes input from gamepads and calls functions to make robot move.
     */
    public void teleMain() {
        double curTurnSpeed;
        double curMoveSpeed;
        if (gamepad1.right_bumper) {
            curTurnSpeed = FAST_TURN;
            curMoveSpeed = FAST_MOVE;
        } else if (gamepad1.left_bumper) {
            curTurnSpeed = SLOW_TURN;
            curMoveSpeed = SLOW_MOVE;
        } else {
            curTurnSpeed = MED_TURN;
            curMoveSpeed = MED_MOVE;
        }
        if (gamepad1.dpad_up)
            lib.moveFwd(curMoveSpeed);
        if (gamepad1.dpad_down)
            lib.moveBwd(curMoveSpeed);
        if (gamepad1.dpad_left)
            lib.turnLft(curTurnSpeed);
        if (gamepad1.dpad_right)
            lib.turnRgt(curTurnSpeed);
    }
}
