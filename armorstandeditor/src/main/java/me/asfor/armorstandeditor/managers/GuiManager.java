package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.gui.*;
import me.asfor.armorstandeditor.preview.PreviewManager;
import me.asfor.armorstandeditor.sessions.EditorGuiType;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class GuiManager
{
    public static void openMain(EditorSession session)
    {
        openMain(session, false);
    }

    public static void openMain(EditorSession session, boolean switching)
    {
        Inventory inventory = MainEditorGUI.createInventory(session.getArmorStand());

        session.setSwitchingGui(switching);

        session.setCurrentGui(EditorGuiType.MAIN);
        session.setInventory(inventory);

        Player player = session.getPlayer();

        player.openInventory(inventory);

        ArmorStandEditor plugin  = JavaPlugin.getPlugin(ArmorStandEditor.class);

        PreviewManager previewManager = plugin.getPreviewManager();

        previewManager.show(player, session.getArmorStand());
    }

    public static void openRotate(EditorSession session)
    {
        Inventory inventory = RotateGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.ROTATE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openPose(EditorSession session)
    {
        Inventory inventory = PoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openHeadPose(EditorSession session)
    {
        Inventory inventory = HeadPoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.HEAD_POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openBodyPose(EditorSession session)
    {
        Inventory inventroy = BodyPoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.BODY_POSE);
        session.setInventory(inventroy);

        session.getPlayer().openInventory(inventroy);
    }

    public static void openLeftArmPose(EditorSession session)
    {
        Inventory inventory = LeftArmPoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.LEFTARM_POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openRightArmPose(EditorSession session)
    {
        Inventory inventory = RightArmPoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.RIGHTARM_POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openLeftLegPose(EditorSession session)
    {
        Inventory inventory = LeftLegPoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.LEFTLEG_POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openRightLegPose(EditorSession session)
    {
        Inventory inventory = RightLegPoseGUI.createInventory(session);

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.RIGHTLEG_POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void close(EditorSession session)
    {
        if (session.isClosing())
        {
            return;
        }

        session.setClosing(true);

        Player player = session.getPlayer();

        ArmorStandEditor plugin = JavaPlugin.getPlugin(ArmorStandEditor.class);

        plugin.getPreviewManager().hide(player);

        plugin.getSessionManager().removeSession(player.getUniqueId());

        session.setInventory(null);
    }
}
