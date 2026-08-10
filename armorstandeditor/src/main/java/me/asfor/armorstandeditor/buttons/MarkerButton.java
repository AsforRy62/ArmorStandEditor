package me.asfor.armorstandeditor.buttons;

import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;

public class MarkerButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        //armorStand.setMarker(! armorStand.isMarker());
    }
}
