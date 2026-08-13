package me.asfor.armorstandeditor.buttons.pose.body;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class BodyZPlusButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        EulerAngle pose = armorStand.getBodyPose();

        pose = pose.setZ(pose.getZ() + Math.toRadians(5));

        armorStand.setBodyPose(pose);
    }
}
