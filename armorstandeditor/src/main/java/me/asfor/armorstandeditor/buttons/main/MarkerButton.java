package me.asfor.armorstandeditor.buttons.main;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;

public class MarkerButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        //armorStand.setMarker(! armorStand.isMarker());

        ArmorStandEditor plugin = JavaPlugin.getPlugin(ArmorStandEditor.class);

        plugin.getPreviewManager().update(session.getPlayer(), armorStand);
    }
}
