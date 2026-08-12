package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.buttons.*;
import me.asfor.armorstandeditor.buttons.main.*;
import me.asfor.armorstandeditor.buttons.pose.BodyPoseButton;
import me.asfor.armorstandeditor.buttons.pose.HeadPoseButton;
import me.asfor.armorstandeditor.buttons.pose.body.BodyXPlusButton;
import me.asfor.armorstandeditor.buttons.pose.head.*;
import me.asfor.armorstandeditor.buttons.rotate.*;
import me.asfor.armorstandeditor.gui.*;
import me.asfor.armorstandeditor.sessions.PosePart;

import java.util.HashMap;
import java.util.Map;

public class ButtonManager
{
    private final Map<Integer, Button> buttons = new HashMap<>();

    private final Map<PosePart, Map<Integer, Button>> poseButtons = new HashMap<>();

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
        buttons.put(RotateGUI.BACK_BUTTON,  new RotateBackButton());

        Map<Integer, Button> headButtons = new HashMap<>();

        buttons.put(PoseGUI.HEAD, new HeadPoseButton());
        poseButtons.put(PosePart.HEAD, headButtons);
        headButtons.put(HeadPoseGUI.X_PLUS, new HeadXPlusButton());
        headButtons.put(HeadPoseGUI.X_MINUS, new HeadXMinusButton());
        headButtons.put(HeadPoseGUI.Y_PLUS, new HeadYPlusButton());
        headButtons.put(HeadPoseGUI.Y_MINUS, new HeadYMinusButton());
        headButtons.put(HeadPoseGUI.Z_PLUS, new HeadZPlusButton());
        headButtons.put(HeadPoseGUI.Z_MINUS, new HeadZMinusButton());
        headButtons.put(HeadPoseGUI.RESET, new HeadResetButton());
        headButtons.put(HeadPoseGUI.BACK,  new HeadBackButton());

        Map<Integer, Button> bodyButtons = new HashMap<>();

        buttons.put(PoseGUI.BODY, new BodyPoseButton());
        poseButtons.put(PosePart.BODY, bodyButtons);
        bodyButtons.put(BodyPoseGUI.X_PLUS, new BodyXPlusButton());
    }

    public Button getButton(int slot)
    {
        return buttons.get(slot);
    }

    public Button getPoseButton(PosePart part, int slot)
    {
        Map<Integer, Button> buttons = poseButtons.get(part);

        if (buttons == null)
        {
            return null;
        }

        return buttons.get(slot);
    }
}
