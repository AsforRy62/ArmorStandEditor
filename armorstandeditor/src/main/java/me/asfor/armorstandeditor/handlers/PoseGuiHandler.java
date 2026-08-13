package me.asfor.armorstandeditor.handlers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.gui.HeadPoseGUI;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.sessions.EditorGuiType;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class PoseGuiHandler
{
    private final ArmorStandEditor plugin;

    public PoseGuiHandler(ArmorStandEditor plugin)
    {
        this.plugin = plugin;
    }

    public void handle(InventoryClickEvent event, EditorSession session)
    {
        if (event.getClickedInventory() == event.getView().getBottomInventory())
        {
            return;
        }

        event.setCancelled(true);

        Button button = plugin.getButtonManager().getPoseButton(event.getRawSlot());

        if (button == null)
        {
            return;
        }

        button.execute(session);

    }

    public void handleDrag(InventoryDragEvent event)
    {
        for (int slot : event.getRawSlots())
        {
            if (slot < HeadPoseGUI.SIZE)
            {
                event.setCancelled(true);
                return;
            }
        }
    }
}
