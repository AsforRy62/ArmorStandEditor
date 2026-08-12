package me.asfor.armorstandeditor.buttons.rotate;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class RotateResetButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        Location location = armorStand.getLocation();

        armorStand.setRotation(0F, location.getPitch());
    }
}
