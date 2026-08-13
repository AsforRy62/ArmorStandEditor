package me.asfor.armorstandeditor.listeners;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.gui.HeadPoseGUI;
import me.asfor.armorstandeditor.gui.MainEditorGUI;
import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.gui.PoseGUI;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.handlers.*;
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
    private final HeadPoseGuiHandler headPoseGuiHandler;
    private final BodyPoseGuiHandler bodyPoseGuiHandler;
    private final LeftArmPoseGuiHandler leftArmPoseGuiHandler;

    public InventoryListener(ArmorStandEditor plugin)
    {
        this.plugin = plugin;

        this.mainGuiHandler = plugin.getMainGuiHandler();
        this.rotateGuiHandler = plugin.getRotateGuiHandler();
        this.poseGuiHandler = plugin.getPoseGuiHandler();
        this.headPoseGuiHandler = new HeadPoseGuiHandler(plugin);
        this.bodyPoseGuiHandler = new BodyPoseGuiHandler(plugin);
        this.leftArmPoseGuiHandler = new LeftArmPoseGuiHandler(plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        String title = event.getView().getTitle();

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

        switch(session.getCurrentGui())
        {
            case MAIN ->
                mainGuiHandler.handle(event, session);

            case ROTATE ->
                rotateGuiHandler.handle(event, session);

            case POSE ->
                poseGuiHandler.handle(event, session);

            case HEAD_POSE ->
                headPoseGuiHandler.handle(event, session);

            case BODY_POSE ->
                bodyPoseGuiHandler.handle(event, session);

            case LEFTARM_POSE ->
                leftArmPoseGuiHandler.handle(event, session);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event)
    {
        String title = event.getView() .getTitle();

        Player player = (Player) event.getWhoClicked();

        EditorSession session = plugin.getSessionManager().getSession(player.getUniqueId());

        if (session == null) {
            return;
        }

        switch(session.getCurrentGui())
        {
            case MAIN ->
                mainGuiHandler.handleDrag(event);

            case  ROTATE ->
                rotateGuiHandler.handleDrag(event);

            case POSE ->
                poseGuiHandler.handleDrag(event);

            case HEAD_POSE ->
                headPoseGuiHandler.handleDrag(event);

            case BODY_POSE ->
                bodyPoseGuiHandler.handleDrag(event);

            case LEFTARM_POSE ->
                leftArmPoseGuiHandler.handleDrag(event);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        String title = event.getView().getTitle();

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
    }
}
