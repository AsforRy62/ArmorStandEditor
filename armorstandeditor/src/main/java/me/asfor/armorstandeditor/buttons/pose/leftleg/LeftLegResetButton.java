package me.asfor.armorstandeditor.buttons.pose.leftleg;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.data.PoseData;
import me.asfor.armorstandeditor.managers.PoseManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class LeftLegResetButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStandEditor plugin = ArmorStandEditor.getPlugin(ArmorStandEditor.class);

        PoseManager poseManager = plugin.getPoseManager();

        PoseData data = poseManager.getData(session.getArmorStand());

        data.resetLeftLegPose();
    }
}
