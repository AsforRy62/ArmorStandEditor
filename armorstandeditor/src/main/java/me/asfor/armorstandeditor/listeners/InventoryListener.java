package me.asfor.armorstandeditor.listeners;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.handlers.*;
import me.asfor.armorstandeditor.sessions.EditorSession;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryListener implements Listener
{
    private final ArmorStandEditor plugin;

    private final MainGuiHandler mainGuiHandler;
    private final RotateGuiHandler rotateGuiHandler;
    private final PoseGuiHandler poseGuiHandler;
    private final HeadPoseGuiHandler headPoseGuiHandler;
    private final BodyPoseGuiHandler bodyPoseGuiHandler;
    private final LeftArmPoseGuiHandler leftArmPoseGuiHandler;
    private final RightArmPoseGuiHandler rightArmPoseGuiHandler;
    private final LeftLegPoseGuiHandler leftLegPoseGuiHandler;
    private final RightLegPoseGuiHandler rightLegPoseGuiHandler;

    public InventoryListener(ArmorStandEditor plugin)
    {
        this.plugin = plugin;

        this.mainGuiHandler = plugin.getMainGuiHandler();
        this.rotateGuiHandler = plugin.getRotateGuiHandler();
        this.poseGuiHandler = plugin.getPoseGuiHandler();
        this.headPoseGuiHandler = new HeadPoseGuiHandler(plugin);
        this.bodyPoseGuiHandler = new BodyPoseGuiHandler(plugin);
        this.leftArmPoseGuiHandler = new LeftArmPoseGuiHandler(plugin);
        this.rightArmPoseGuiHandler = new RightArmPoseGuiHandler(plugin);
        this.leftLegPoseGuiHandler = new LeftLegPoseGuiHandler(plugin);
        this.rightLegPoseGuiHandler = new RightLegPoseGuiHandler(plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
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

            case RIGHTARM_POSE ->
                rightArmPoseGuiHandler.handle(event, session);

            case LEFTLEG_POSE ->
                leftLegPoseGuiHandler.handle(event, session);

            case RIGHTLEG_POSE ->
                rightLegPoseGuiHandler.handle(event, session);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event)
    {
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

            case RIGHTARM_POSE ->
                rightArmPoseGuiHandler.handleDrag(event);

            case LEFTLEG_POSE ->
                leftLegPoseGuiHandler.handleDrag(event);

            case RIGHTLEG_POSE ->
                rightLegPoseGuiHandler.handleDrag(event);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
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
