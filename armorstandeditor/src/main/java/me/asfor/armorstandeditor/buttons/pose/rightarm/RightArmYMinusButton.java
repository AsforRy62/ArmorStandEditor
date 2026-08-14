package me.asfor.armorstandeditor.buttons.pose.rightarm;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.data.PoseData;
import me.asfor.armorstandeditor.managers.PoseManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.util.EulerAngle;

public class RightArmYMinusButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStandEditor plugin = ArmorStandEditor.getPlugin(ArmorStandEditor.class);

        PoseManager poseManager = plugin.getPoseManager();

        PoseData data = poseManager.getData(session.getArmorStand());

        EulerAngle pose = data.getRightArmPose();

        double y = pose.getY() - Math.toRadians(5);

        data.setRightArmPose(new EulerAngle(pose.getX(), y, pose.getZ()));
    }
}
