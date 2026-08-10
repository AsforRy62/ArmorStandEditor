package me.asfor.armorstandeditor.buttons;

import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

import java.awt.event.ActionListener;

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
