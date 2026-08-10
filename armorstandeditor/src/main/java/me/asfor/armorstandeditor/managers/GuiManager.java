package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.gui.HeadPoseGUI;
import me.asfor.armorstandeditor.gui.MainEditorGUI;
import me.asfor.armorstandeditor.gui.PoseGUI;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.sessions.EditorGuiType;
import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.sessions.PosePart;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiManager
{
    public static void openMain(EditorSession session)
    {
        Inventory inventory = MainEditorGUI.createInventory(session.getArmorStand());

        session.setSwitchingGui(true);

        session.setCurrentGui(EditorGuiType.MAIN);
        session.setInventory(inventory);

        Player player = session.getPlayer();

        player.openInventory(inventory);
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

        session.setCurrentGui(EditorGuiType.POSE);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }

    public static void openHeadPose(EditorSession session)
    {
        Inventory inventory = HeadPoseGUI.createInventory(session);

        session.setCurrentPoseGui(PosePart.HEAD);
        session.setInventory(inventory);

        session.getPlayer().openInventory(inventory);
    }
}
