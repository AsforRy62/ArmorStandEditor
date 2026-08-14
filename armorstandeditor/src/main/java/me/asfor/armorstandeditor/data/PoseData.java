package me.asfor.armorstandeditor.data;

import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class PoseData
{
    private final ArmorStand armorStand;

    private EulerAngle headPose;
    private EulerAngle bodyPose;
    private EulerAngle leftArmPose;
    private EulerAngle rightArmPose;
    private EulerAngle leftLegPose;
    private EulerAngle rightLegPose;

    public PoseData(ArmorStand armorStand)
    {
        this.armorStand = armorStand;

        this.headPose = armorStand.getHeadPose();
        this.bodyPose = armorStand.getBodyPose();
        this.leftArmPose = armorStand.getLeftArmPose();
        this.rightArmPose = armorStand.getRightArmPose();
        this.leftLegPose = armorStand.getLeftLegPose();
        this.rightLegPose = armorStand.getRightLegPose();
    }

    public ArmorStand getArmorStand()
    {
        return armorStand;
    }

    //head
    public EulerAngle getHeadPose()
    {
        return headPose;
    }

    public void setHeadPose(EulerAngle pose)
    {
        this.headPose = pose;
        armorStand.setHeadPose(pose);
    }

    //body
    public EulerAngle getBodyPose()
    {
        return bodyPose;
    }

    public void setBodyPose(EulerAngle pose)
    {
        this.bodyPose = pose;
        armorStand.setBodyPose(pose);
    }

    //left Arm
    public EulerAngle getLeftArmPose()
    {
        return leftArmPose;
    }

    public void setLeftArmPose(EulerAngle pose)
    {
        this.leftArmPose = pose;
        armorStand.setLeftArmPose(pose);
    }

    public EulerAngle getDefaultLeftArmPose()
    {
        return new EulerAngle(Math.toRadians(-10), 0, Math.toRadians(-10));
    }

    public void resetLeftArmPose()
    {
        setLeftArmPose(getDefaultLeftArmPose());
    }

    //right Arm
    public EulerAngle getRightArmPose()
    {
        return rightArmPose;
    }

    public void setRightArmPose(EulerAngle pose)
    {
        this.rightArmPose = pose;
        armorStand.setRightArmPose(pose);
    }

    public EulerAngle getDefaultRightArmPose()
    {
        return new EulerAngle(Math.toRadians(-15), 0, Math.toRadians(10));
    }

    public void resetRightArmPose()
    {
        setRightArmPose(getDefaultRightArmPose());
    }

    //left Leg
    public EulerAngle getLeftLegPose()
    {
        return leftLegPose;
    }

    public void setLeftLegPose(EulerAngle pose)
    {
        this.leftLegPose = pose;
        armorStand.setLeftLegPose(pose);
    }

    public EulerAngle getDefaultLeftLegPose()
    {
        return new EulerAngle(Math.toRadians(-1), 0, Math.toRadians(-1));
    }

    public void resetLeftLegPose()
    {
        setLeftLegPose(getDefaultLeftLegPose());
    }

    //right Leg
    public EulerAngle getRightLegPose()
    {
        return rightLegPose;
    }

    public void setRightLegPose(EulerAngle pose)
    {
        this.rightLegPose = pose;
        armorStand.setRightLegPose(pose);
    }

    public EulerAngle getDefaultRightLegPose()
    {
        return new EulerAngle(Math.toRadians(1), 0, Math.toRadians(1));
    }

    public void resetRightLegPose()
    {
        setRightLegPose(getDefaultRightLegPose());
    }
}
