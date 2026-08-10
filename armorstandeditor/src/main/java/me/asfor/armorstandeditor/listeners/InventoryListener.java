package me.asfor.armorstandeditor.listeners;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.gui.MainEditorGUI;
import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.gui.PoseGUI;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.handlers.MainGuiHandler;
import me.asfor.armorstandeditor.handlers.PoseGuiHandler;
import me.asfor.armorstandeditor.handlers.RotateGuiHandler;
import me.asfor.armorstandeditor.sessions.EditorGuiType;
import me.asfor.armorstandeditor.sessions.EditorSession;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener
{
    private final ArmorStandEditor plugin;

    private final MainGuiHandler mainGuiHandler;
    private final RotateGuiHandler rotateGuiHandler;
    private final PoseGuiHandler poseGuiHandler;

    public InventoryListener(ArmorStandEditor plugin)
    {
        this.plugin = plugin;

        this.mainGuiHandler = plugin.getMainGuiHandler();
        this.rotateGuiHandler = plugin.getRotateGuiHandler();
        this.poseGuiHandler = plugin.getPoseGuiHandler();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        String title = event.getView().getTitle();

        if (! title.equals(MainEditorGUI.TITLE) && ! title.equals(RotateGUI.TITLE) && ! title.equals(PoseGUI.TITLE))
        {
            return;
        }

        if (event.getClickedInventory() == null)
        {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        EditorSession session = plugin.getSessionManager().getSession(player.getUniqueId());

        if (session == null)
        {
            return;
        }

        if (title.equals(MainEditorGUI.TITLE))
        {
            mainGuiHandler.handle(event, session);
            return;
        }

        if (title.equals(RotateGUI.TITLE))
        {
            rotateGuiHandler.handle(event, session);
            return;
        }

        if (title.equals(PoseGUI.TITLE))
        {
            poseGuiHandler.handle(event, session);
            return;
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event)
    {
        String title = event.getView() .getTitle();

        if (! title.equals(MainEditorGUI.TITLE) && ! title.equals(RotateGUI.TITLE) && ! title.equals(PoseGUI.TITLE))
        {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        EditorSession session = plugin.getSessionManager().getSession(player.getUniqueId());

        if (session == null) {
            return;
        }

        if (title.equals(MainEditorGUI.TITLE))
        {
            mainGuiHandler.handleDrag(event);
            return;
        }

        if (title.equals(RotateGUI.TITLE))
        {
            rotateGuiHandler.handleDrag(event);
            return;
        }

        if (title.equals(PoseGUI.TITLE))
        {
            poseGuiHandler.handleDrag(event);
            return;
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        String title = event.getView().getTitle();

        if (! title.equals(MainEditorGUI.TITLE) && ! title.equals(RotateGUI.TITLE) && ! title.equals(PoseGUI.TITLE))
        {
            return;
        }

        Player player = (Player) event.getPlayer();

        EditorSession session = plugin.getSessionManager().getSession(player.getUniqueId());

        if (session == null)
        {
            return;
        }

        if (session.isSwitchingGui())
        {
            session.setSwitchingGui(false);
            return;
        }

        //plugin.getSessionManager().removeSession(player.getUniqueId());
    }
}
