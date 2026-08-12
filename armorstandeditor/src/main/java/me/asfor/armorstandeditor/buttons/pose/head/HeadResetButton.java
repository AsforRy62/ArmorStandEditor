package me.asfor.armorstandeditor.buttons.pose.head;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class HeadResetButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        armorStand.setHeadPose(new EulerAngle(0, 0, 0));
    }
}
