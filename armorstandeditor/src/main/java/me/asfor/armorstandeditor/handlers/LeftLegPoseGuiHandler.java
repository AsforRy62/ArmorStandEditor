package me.asfor.armorstandeditor.handlers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.gui.LeftArmPoseGUI;
import me.asfor.armorstandeditor.gui.LeftLegPoseGUI;
import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.sessions.PosePart;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class LeftLegPoseGuiHandler
{
    private final ArmorStandEditor plugin;

    public LeftLegPoseGuiHandler(ArmorStandEditor plugin)
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

        Button button = plugin.getButtonManager().getPosePartButton(PosePart.LEFT_LEG, event.getRawSlot());

        if (button == null)
        {
            return;
        }

        button.execute(session);

        LeftLegPoseGUI.refresh(event.getView().getTopInventory(), session);
    }

    public void handleDrag(InventoryDragEvent event)
    {
        for (int slot : event.getRawSlots())
        {
            if (slot < LeftLegPoseGUI.SIZE)
            {
                event.setCancelled(true);
                return;
            }
        }
    }
}
