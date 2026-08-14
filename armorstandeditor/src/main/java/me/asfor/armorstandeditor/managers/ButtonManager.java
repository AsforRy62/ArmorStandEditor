package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.buttons.*;
import me.asfor.armorstandeditor.buttons.main.*;
import me.asfor.armorstandeditor.buttons.pose.*;
import me.asfor.armorstandeditor.buttons.pose.body.*;
import me.asfor.armorstandeditor.buttons.pose.head.*;
import me.asfor.armorstandeditor.buttons.pose.leftarm.*;
import me.asfor.armorstandeditor.buttons.pose.leftleg.*;
import me.asfor.armorstandeditor.buttons.pose.rightarm.*;
import me.asfor.armorstandeditor.buttons.pose.rightleg.*;
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
        poseButtons.put(PoseGUI.RIGHT_ARM, new RightArmPoseButton());
        poseButtons.put(PoseGUI.LEFT_LEG, new LeftLegPoseButton());
        poseButtons.put(PoseGUI.RIGHT_LEG, new RightLegPoseButton());
        poseButtons.put(PoseGUI.BACK, new BackPoseButton());

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

        Map<Integer, Button> rightArmButtons = new HashMap<>();

        posePartButtons.put(PosePart.RIGHT_ARM, rightArmButtons);
        rightArmButtons.put(RightArmPoseGUI.X_PLUS, new RightArmXPlusButton());
        rightArmButtons.put(RightArmPoseGUI.X_MINUS, new RightArmXMinusButton());
        rightArmButtons.put(RightArmPoseGUI.Y_PLUS, new RightArmYPlusButton());
        rightArmButtons.put(RightArmPoseGUI.Y_MINUS, new RightArmYMinusButton());
        rightArmButtons.put(RightArmPoseGUI.Z_PLUS, new RightArmZPlusButton());
        rightArmButtons.put(RightArmPoseGUI.Z_MINUS, new RightArmZMinusButton());
        rightArmButtons.put(RightArmPoseGUI.RESET, new RightArmResetButton());
        rightArmButtons.put(RightArmPoseGUI.BACK,  new RightArmBackButton());

        Map<Integer, Button> leftLegButtons = new HashMap<>();

        posePartButtons.put(PosePart.LEFT_LEG, leftLegButtons);
        leftLegButtons.put(LeftLegPoseGUI.X_PLUS, new LeftLegXPlusButton());
        leftLegButtons.put(LeftLegPoseGUI.X_MINUS, new LeftLegXMinusButton());
        leftLegButtons.put(LeftLegPoseGUI.Y_PLUS, new LeftLegYPlusButton());
        leftLegButtons.put(LeftLegPoseGUI.Y_MINUS, new LeftLegYMinusButton());
        leftLegButtons.put(LeftLegPoseGUI.Z_PLUS, new LeftLegZPlusButton());
        leftLegButtons.put(LeftLegPoseGUI.Z_MINUS, new LeftLegZMinusButton());
        leftLegButtons.put(LeftLegPoseGUI.RESET, new LeftLegResetButton());
        leftLegButtons.put(LeftLegPoseGUI.BACK, new LeftLegBackButton());

        Map<Integer, Button> rightLegButtons = new HashMap<>();

        posePartButtons.put(PosePart.RIGHT_LEG, rightLegButtons);
        rightLegButtons.put(RightLegPoseGUI.X_PLUS, new RightLegXPlusButton());
        rightLegButtons.put(RightLegPoseGUI.X_MINUS, new RightLegXMinusButton());
        rightLegButtons.put(RightLegPoseGUI.Y_PLUS, new RightLegYPlusButton());
        rightLegButtons.put(RightLegPoseGUI.Y_MINUS, new RightLegYMinusButton());
        rightLegButtons.put(RightLegPoseGUI.Z_PLUS, new RightLegZPlusButton());
        rightLegButtons.put(RightLegPoseGUI.Z_MINUS, new RightLegZMinusButton());
        rightLegButtons.put(RightLegPoseGUI.RESET, new RightLegResetButton());
        rightLegButtons.put(RightLegPoseGUI.BACK, new RightLegBackButton());
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
