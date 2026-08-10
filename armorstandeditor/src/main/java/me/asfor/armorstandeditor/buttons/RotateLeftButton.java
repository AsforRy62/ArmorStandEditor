package me.asfor.armorstandeditor.buttons;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.rotation.RotationData;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class RotateLeftButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        RotationData data = ArmorStandEditor.getPlugin(ArmorStandEditor.class).getRotationManager().getData(armorStand);

        Location location = armorStand.getLocation();

        location.setYaw(location.getYaw() - data.getStep());

        armorStand.teleport(location);
    }
}
