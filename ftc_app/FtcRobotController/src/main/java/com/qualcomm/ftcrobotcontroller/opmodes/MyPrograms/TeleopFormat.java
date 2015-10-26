

package com.qualcomm.ftcrobotcontroller.opmodes.MyPrograms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Abstract Teleop Class that contains all building blocks for a
 * successful teleop program. If this is extended, programmer can
 * focus on creating controls for their robot.
 *
 * @author Sauhaarda Chowdhuri
 * @version 1.00 20 Oct 2015
 */
public abstract class TeleopFormat extends OpMode {

    /**
     * Fastest move speed
     *
     * @since 1.00
     */
    protected final double FAST_MOVE = 0.8;
    /**
     * Medium move speed
     *
     * @since 1.00
     */
    protected final double MED_MOVE = 0.5;
    /**
     * Slow move speed
     *
     * @since 1.00
     */
    protected final double SLOW_MOVE = 0.3;

    /**
     * Fastest turn speed
     *
     * @since 1.00
     */
    protected final double FAST_TURN = 0.5;
    /**
     * Medium turn speed
     *
     * @since 1.00
     */
    protected final double MED_TURN = 0.3;
    /**
     * Slow turn speed
     *
     * @since 1.00
     */
    protected final double SLOW_TURN = 0.1;

    /**
     * Sets readonly/writeonly for the dcmotors
     * @since 1.00
     */
    private DcMotorController.DeviceMode devMode;

    /**
     * Basic Movement Library containing functions for moving robot motors.
     * @since 1.00
     */
    protected BasicMoveLibrary lib;

    /**
     * Initializes Basic Move Libary with the robot hardware map xml file.
     * @since 1.00
     */
    @Override
    public void init() {
        lib = new BasicMoveLibrary(hardwareMap);
    }

    /**
     * Makes dcmotors writeonly
     * @since 1.00
     */
    @Override
    public void init_loop() {
        devMode = DcMotorController.DeviceMode.WRITE_ONLY;
    }

    /**
     * Teleop controls go here
     * @since 1.00
     */
    public abstract void teleMain();

    /**
     * Calls teleMain in a loop.
     * @since 1.00
     */
    @Override
    public void loop() {
        if (allowedToWrite()) {
            teleMain();
        }
    }

    /**
     * Ensures the dcmotors are writeonly
     * @since 1.00
     * @since 1.00
     */
    private boolean allowedToWrite() {
        return (devMode == DcMotorController.DeviceMode.WRITE_ONLY);
    }
}
