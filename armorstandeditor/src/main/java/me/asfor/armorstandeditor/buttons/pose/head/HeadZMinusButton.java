package me.asfor.armorstandeditor.buttons.pose.head;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class HeadZMinusButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        EulerAngle pose = armorStand.getHeadPose();

        pose = pose.setZ(pose.getZ() - Math.toRadians(5));

        armorStand.setHeadPose(pose);
    }
}
