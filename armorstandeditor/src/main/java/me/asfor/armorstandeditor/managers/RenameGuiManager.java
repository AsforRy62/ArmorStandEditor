package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.sessions.EditorSession;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RenameGuiManager
{
    public static void open(EditorSession session)
    {
        session.setOpeningRename(true);

        new AnvilGUI.Builder()
                .title("Rename ArmorStand")
                .text(session.getArmorStand().getCustomName() == null ? "ArmorStand" : session.getArmorStand().getCustomName())
                .itemLeft(new ItemStack(Material.NAME_TAG))
                .onClick((slot, state) ->
                {
                    if (slot != AnvilGUI.Slot.OUTPUT)
                    {
                        return List.of();
                    }

                    String name = state.getText();

                    if (name.isBlank())
                    {
                        session.getArmorStand().setCustomName(null);
                        session.getArmorStand().setCustomNameVisible(false);
                    }
                    else
                    {
                        session.getArmorStand().setCustomName(name);
                        session.getArmorStand().setCustomNameVisible(true);
                    }

                    return List.of
                            (
                                    AnvilGUI.ResponseAction.close()
                            );
                })
                .onClose(state ->
                {
                    if (! session.isOpeningRename())
                    {
                        return;
                    }

                    session.setOpeningRename(false);

                    ArmorStandEditor plugin = ArmorStandEditor.getPlugin(ArmorStandEditor.class);

                    plugin.getServer().getScheduler().runTask(plugin, () ->
                    {
                        GuiManager.openMain(session, false);
                    });
                })
                .plugin(ArmorStandEditor.getPlugin(ArmorStandEditor.class))
                .open(session.getPlayer());
    }
}
