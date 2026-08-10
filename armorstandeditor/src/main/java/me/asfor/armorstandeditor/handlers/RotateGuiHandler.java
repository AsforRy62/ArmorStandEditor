package me.asfor.armorstandeditor.handlers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class RotateGuiHandler
{
    private final ArmorStandEditor plugin;

    public RotateGuiHandler(ArmorStandEditor plugin)
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

        Button button = plugin.getButtonManager().getButton(event.getRawSlot());

        if (button == null)
        {
            return;
        }

        button.execute(session);

        RotateGUI.refresh(event.getView().getTopInventory(), session);
    }

    public void handleDrag(InventoryDragEvent event)
    {
        for (int slot : event.getRawSlots())
        {
            if (slot < RotateGUI.SIZE)
            {
                event.setCancelled(true);
                return;
            }
        }
    }
}
