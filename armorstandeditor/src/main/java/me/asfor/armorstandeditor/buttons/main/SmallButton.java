package me.asfor.armorstandeditor.buttons.main;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;

public class SmallButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        armorStand.setSmall(! armorStand.isSmall());
    }
}
