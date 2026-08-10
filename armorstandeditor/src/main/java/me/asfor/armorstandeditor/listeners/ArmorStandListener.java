package me.asfor.armorstandeditor.listeners;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.gui.MainEditorGUI;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;

public class ArmorStandListener implements Listener
{
    private final ArmorStandEditor plugin;

    public  ArmorStandListener(ArmorStandEditor plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onArmorStandInteract(PlayerInteractAtEntityEvent event)
    {
        if (! (event.getRightClicked() instanceof ArmorStand armorStand))
        {
            return;
        }

        Player player = event.getPlayer();

        event.setCancelled(true);

        //Inventory inventory = MainEditorGUI.createInventory(armorStand);

        EditorSession session = plugin.getSessionManager().getSession(player.getUniqueId());

        if (session == null)
        {
            session = new EditorSession(player, armorStand);

            plugin.getSessionManager().addSession(session);
        }
        else
        {
            session.setArmorStand(armorStand);
        }

        GuiManager.openMain(session);
    }
}
