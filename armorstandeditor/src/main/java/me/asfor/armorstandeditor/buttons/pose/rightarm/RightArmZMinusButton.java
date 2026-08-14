package me.asfor.armorstandeditor.buttons.pose.rightarm;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.data.PoseData;
import me.asfor.armorstandeditor.managers.PoseManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.util.EulerAngle;

public class RightArmZMinusButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStandEditor plugin = ArmorStandEditor.getPlugin(ArmorStandEditor.class);

        PoseManager poseManager = plugin.getPoseManager();

        PoseData data = poseManager.getData(session.getArmorStand());

        EulerAngle pose = data.getRightArmPose();

        double z = pose.getZ() - Math.toRadians(5);

        data.setRightArmPose(new EulerAngle(pose.getX(), pose.getY(), z));
    }
}
