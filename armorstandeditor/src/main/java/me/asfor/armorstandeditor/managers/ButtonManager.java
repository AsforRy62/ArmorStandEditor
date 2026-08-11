package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.buttons.*;
import me.asfor.armorstandeditor.gui.HeadPoseGUI;
import me.asfor.armorstandeditor.gui.MainEditorGUI;
import me.asfor.armorstandeditor.gui.PoseGUI;
import me.asfor.armorstandeditor.gui.RotateGUI;

import java.util.HashMap;
import java.util.Map;

public class ButtonManager
{
    private final Map<Integer, Button> buttons = new HashMap<>();

    public  ButtonManager()
    {
        buttons.put(MainEditorGUI.SMALL_BUTTON, new SmallButton());
        buttons.put(MainEditorGUI.ARMS_BUTTON, new ArmsButton());
        buttons.put(MainEditorGUI.BASE_BUTTON, new BasePlateButton());
        buttons.put(MainEditorGUI.MARKER_BUTTON, new MarkerButton());
        buttons.put(MainEditorGUI.POSE_BUTTON, new PoseButton());
        buttons.put(MainEditorGUI.ROTATE_BUTTON, new RotateButton());
        buttons.put(MainEditorGUI.NAME_BUTTON, new NameButton());
        buttons.put(MainEditorGUI.GRAVITY_BUTTON, new GravityButton());
        buttons.put(MainEditorGUI.VISIBLE_BUTTON, new VisibleButton());

        buttons.put(RotateGUI.AUTO_ROTATE_BUTTON, new AutoRotateButton());
        buttons.put(RotateGUI.ROTATE_LEFT, new RotateLeftButton());
        buttons.put(RotateGUI.ROTATE_RIGHT, new RotateRightButton());
        buttons.put(RotateGUI.STEP_BUTTON, new RotationStepButton());
        buttons.put(RotateGUI.RESET_BUTTON, new RotateResetButton());
        buttons.put(RotateGUI.BACK,  new BackButton());

        buttons.put(PoseGUI.HEAD, new HeadPoseButton());
        buttons.put(HeadPoseGUI.X_PLUS, new HeadXPlusButton());
        buttons.put(HeadPoseGUI.X_MINUS, new HeadXMinusButton());
        buttons.put(HeadPoseGUI.Y_PLUS, new HeadYPlusButton());
        buttons.put(HeadPoseGUI.Y_MINUS, new HeadYMinusButton());
        buttons.put(HeadPoseGUI.Z_PLUS, new HeadZPlusButton());
        buttons.put(HeadPoseGUI.Z_MINUS, new HeadZMinusButton());
    }

    public Button getButton(int slot)
    {
        return buttons.get(slot);
    }
}
