package me.asfor.armorstandeditor.buttons.pose.head;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class HeadYPlusButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        EulerAngle pose = armorStand.getHeadPose();

        pose = pose.setY(pose.getY() + Math.toRadians(5));

        armorStand.setHeadPose(pose);
    }
}
