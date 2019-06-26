package data;

/**
 * Enumeration of XBOX controller keys
 * @author John
 */
public enum JoystickComponent {
    
     /* Complete list of joystick data:
     *  ---ANALOG---
     * R_STICK_HOR ([-1] - 1)
     * R_STICK_VER ([-1] - 1)
     * L_STICK_HOR ([-1] - 1)
     * L_STICK_VER ([-1] - 1)
     * TRIGGERS (LT:0-1 RT:[-1]-0)
     * 
     * ---DIGITAL---
     * BUTTON_A
     * BUTTON_B
     * BUTTON_X
     * BUTTON_Y
     * 
     * BUTTON_RB
     * BUTTON_LB
     * 
     * BUTTON_BACK
     * BUTTON_START
     * 
     * R_STICK_BUTTON
     * L_STICK_BUTTON
     * 
     *  ---OTHER---
     * POV_SWITCH (0.25=UP 0.5=RIGHT 0.75=DOWN 1.0=LEFT) NOTE: There are middle values but they are unreliable.
     * 
     */

    R_STICK_HOR,
    R_STICK_VER,
    L_STICK_HOR,
    L_STICK_VER,
    TRIGGERS,
    BUTTON_A,
    BUTTON_B,
    BUTTON_X,
    BUTTON_Y,
    BUTTON_LB,
    BUTTON_RB,
    BUTTON_BACK,
    BUTTON_START,
    R_STICK_BUTTON,
    L_STICK_BUTTON,
    POV_SWITCH,
    UNKNOWN

}