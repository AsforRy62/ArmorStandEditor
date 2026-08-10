package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.sessions.EditorSession;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RenameGuiManager
{
    public static void open(EditorSession session)
    {
        new AnvilGUI.Builder()
                .title("Rename ArmorStand")
                .text(session.getArmorStand().getCustomName() == null ? "ArmorStand" : session.getArmorStand().getCustomName())
                .itemLeft(new ItemStack(Material.NAME_TAG))
                .onClick((slot, state) ->
                {
                    if (slot != AnvilGUI.Slot.OUTPUT)
                    {
                        return java.util.List.of();
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

                    return java.util.List.of
                            (
                                    AnvilGUI.ResponseAction.close()
                                    //AnvilGUI.ResponseAction.run(() -> me.asfor.armorstandeditor.managers.GuiManager.openMain(session))
                            );
                })
                .onClose(state ->
                {
                    GuiManager.openMain(session);
                })
                .plugin(me.asfor.armorstandeditor.ArmorStandEditor.getPlugin(me.asfor.armorstandeditor.ArmorStandEditor.class))
                .open(session.getPlayer());
    }
}
