package me.asfor.armorstandeditor.buttons.main;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;

public class ArmsButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        armorStand.setArms(! armorStand.hasArms());

        ArmorStandEditor plugin = JavaPlugin.getPlugin(ArmorStandEditor.class);

        plugin.getPreviewManager().update(session.getPlayer(), armorStand);
    }
}
