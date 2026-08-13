package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.buttons.*;
import me.asfor.armorstandeditor.buttons.main.*;
import me.asfor.armorstandeditor.buttons.pose.BodyPoseButton;
import me.asfor.armorstandeditor.buttons.pose.HeadPoseButton;
import me.asfor.armorstandeditor.buttons.pose.LeftArmPoseButton;
import me.asfor.armorstandeditor.buttons.pose.body.*;
import me.asfor.armorstandeditor.buttons.pose.head.*;
import me.asfor.armorstandeditor.buttons.pose.leftarm.*;
import me.asfor.armorstandeditor.buttons.rotate.*;
import me.asfor.armorstandeditor.gui.*;
import me.asfor.armorstandeditor.sessions.PosePart;

import java.util.HashMap;
import java.util.Map;

public class ButtonManager
{
    private final Map<Integer, Button> mainButtons = new HashMap<>();

    private final Map<Integer, Button> rotateButtons = new HashMap<>();

    private final Map<Integer, Button> poseButtons = new HashMap<>();

    private final Map<PosePart, Map<Integer, Button>> posePartButtons = new HashMap<>();

    public  ButtonManager()
    {
        mainButtons.put(MainEditorGUI.SMALL_BUTTON, new SmallButton());
        mainButtons.put(MainEditorGUI.ARMS_BUTTON, new ArmsButton());
        mainButtons.put(MainEditorGUI.BASE_BUTTON, new BasePlateButton());
        mainButtons.put(MainEditorGUI.MARKER_BUTTON, new MarkerButton());
        mainButtons.put(MainEditorGUI.POSE_BUTTON, new PoseButton());
        mainButtons.put(MainEditorGUI.ROTATE_BUTTON, new RotateButton());
        mainButtons.put(MainEditorGUI.NAME_BUTTON, new NameButton());
        mainButtons.put(MainEditorGUI.GRAVITY_BUTTON, new GravityButton());
        mainButtons.put(MainEditorGUI.VISIBLE_BUTTON, new VisibleButton());

        rotateButtons.put(RotateGUI.AUTO_ROTATE_BUTTON, new AutoRotateButton());
        rotateButtons.put(RotateGUI.ROTATE_LEFT, new RotateLeftButton());
        rotateButtons.put(RotateGUI.ROTATE_RIGHT, new RotateRightButton());
        rotateButtons.put(RotateGUI.STEP_BUTTON, new RotationStepButton());
        rotateButtons.put(RotateGUI.RESET_BUTTON, new RotateResetButton());
        rotateButtons.put(RotateGUI.BACK_BUTTON,  new RotateBackButton());

        poseButtons.put(PoseGUI.HEAD, new HeadPoseButton());
        poseButtons.put(PoseGUI.BODY, new BodyPoseButton());
        poseButtons.put(PoseGUI.LEFT_ARM, new LeftArmPoseButton());

        Map<Integer, Button> headButtons = new HashMap<>();

        posePartButtons.put(PosePart.HEAD, headButtons);
        headButtons.put(HeadPoseGUI.X_PLUS, new HeadXPlusButton());
        headButtons.put(HeadPoseGUI.X_MINUS, new HeadXMinusButton());
        headButtons.put(HeadPoseGUI.Y_PLUS, new HeadYPlusButton());
        headButtons.put(HeadPoseGUI.Y_MINUS, new HeadYMinusButton());
        headButtons.put(HeadPoseGUI.Z_PLUS, new HeadZPlusButton());
        headButtons.put(HeadPoseGUI.Z_MINUS, new HeadZMinusButton());
        headButtons.put(HeadPoseGUI.RESET, new HeadResetButton());
        headButtons.put(HeadPoseGUI.BACK,  new HeadBackButton());

        Map<Integer, Button> bodyButtons = new HashMap<>();

        posePartButtons.put(PosePart.BODY, bodyButtons);
        bodyButtons.put(BodyPoseGUI.X_PLUS, new BodyXPlusButton());
        bodyButtons.put(BodyPoseGUI.X_MINUS, new BodyXMinusButton());
        bodyButtons.put(BodyPoseGUI.Y_PLUS, new BodyYPlusButton());
        bodyButtons.put(BodyPoseGUI.Y_MINUS, new BodyYMinusButton());
        bodyButtons.put(BodyPoseGUI.Z_PLUS, new BodyZPlusButton());
        bodyButtons.put(BodyPoseGUI.Z_MINUS, new BodyZMinusButton());
        bodyButtons.put(BodyPoseGUI.RESET, new BodyResetButton());
        bodyButtons.put(BodyPoseGUI.BACK,  new BodyBackButton());

        Map<Integer, Button> leftArmButtons = new HashMap<>();

        posePartButtons.put(PosePart.LEFT_ARM, leftArmButtons);
        leftArmButtons.put(LeftArmPoseGUI.X_PLUS, new LeftArmXPlusButton());
        leftArmButtons.put(LeftArmPoseGUI.X_MINUS, new LeftArmXMinusButton());
        leftArmButtons.put(LeftArmPoseGUI.Y_PLUS, new LeftArmYPlusButton());
        leftArmButtons.put(LeftArmPoseGUI.Y_MINUS, new LeftArmYMinusButton());
        leftArmButtons.put(LeftArmPoseGUI.Z_PLUS, new LeftArmZPlusButton());
        leftArmButtons.put(LeftArmPoseGUI.Z_MINUS, new LeftArmZMinusButton());
        leftArmButtons.put(LeftArmPoseGUI.RESET, new LeftArmResetButton());
        leftArmButtons.put(LeftArmPoseGUI.BACK,  new LeftArmBackButton());
    }

    public Button getMainButton(int slot)
    {
        return mainButtons.get(slot);
    }

    public Button getRotateButton(int slot)
    {
        return rotateButtons.get(slot);
    }

    public Button getPoseButton(int slot)
    {
        return poseButtons.get(slot);
    }

    public Button getPosePartButton(PosePart part, int slot)
    {
        Map<Integer, Button> buttons = posePartButtons.get(part);

        if (buttons == null)
        {
            return null;
        }

        return buttons.get(slot);
    }
}
