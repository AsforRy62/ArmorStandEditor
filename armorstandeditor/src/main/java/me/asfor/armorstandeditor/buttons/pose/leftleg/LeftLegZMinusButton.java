package me.asfor.armorstandeditor.buttons.pose.leftleg;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.data.PoseData;
import me.asfor.armorstandeditor.managers.PoseManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.util.EulerAngle;

public class LeftLegZMinusButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStandEditor plugin = ArmorStandEditor.getPlugin(ArmorStandEditor.class);

        PoseManager poseManager = plugin.getPoseManager();

        PoseData data = poseManager.getData(session.getArmorStand());

        EulerAngle pose = data.getLeftLegPose();

        double z = pose.getZ() - Math.toRadians(5);

        data.setLeftLegPose(new EulerAngle(pose.getX(), pose.getY(), z));
    }
}
