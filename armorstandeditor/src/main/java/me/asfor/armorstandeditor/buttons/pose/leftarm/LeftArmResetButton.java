package me.asfor.armorstandeditor.buttons.pose.leftarm;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.data.PoseData;
import me.asfor.armorstandeditor.gui.LeftArmPoseGUI;
import me.asfor.armorstandeditor.managers.PoseManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class LeftArmResetButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStandEditor plugin = ArmorStandEditor.getPlugin(ArmorStandEditor.class);

        PoseManager poseManager = plugin.getPoseManager();

        PoseData data = poseManager.getData(session.getArmorStand());

        data.resetLeftArmPose();
    } 
}
