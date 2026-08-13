package me.asfor.armorstandeditor.buttons.rotate;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.data.RotationData;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class RotateRightButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        RotationData data = ArmorStandEditor.getPlugin(ArmorStandEditor.class).getRotationManager().getData(armorStand);

        Location location = armorStand.getLocation();

        location.setYaw(location.getYaw() + data.getStep());

        armorStand.teleport(location);
    }
}
