package me.asfor.armorstandeditor.gui;

import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class BodyPoseGUI
{
    public static final int SIZE = 54;
    public static final String TITLE = "Body Pose Editor";

    public static final int X_PLUS = 12;
    public static final int X_MINUS = 14;

    public static final int Y_PLUS = 21;
    public static final int Y_MINUS = 23;

    public static final int Z_PLUS = 30;
    public static final int Z_MINUS = 32;

    public static final int INFO = 4;

    public static final int RESET = 48;
    public static final int BACK = 50;

    public static Inventory createInventory(EditorSession session)
    {
        Inventory inventory = Bukkit.createInventory(null, SIZE, TITLE);

        createBackground(inventory);
        createButtons(inventory, session);

        return inventory;
    }

    public static void createBackground(Inventory inventory)
    {
        ItemStack glass = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);

        for (int i = 0; i < SIZE; i++)
        {
            inventory.setItem(i, glass);
        }
    }

    public static void createButtons(Inventory inventory, EditorSession session)
    {
        inventory.setItem(X_PLUS, new ItemBuilder(Material.ARROW).setName("(X+)").build());

        refresh(inventory, session);
    }

    public static void refresh(Inventory inventory, EditorSession session)
    {
        //弧度(Radians)
        EulerAngle pose = session.getArmorStand().getBodyPose();

        //轉成角度
        inventory.setItem(INFO, new ItemBuilder(Material.OAK_FENCE)
                .setName("Body Pose")
                .setLore("",
                        "X: " + Math.round(Math.toDegrees(pose.getX())) + "°",
                        "Y: " + Math.round(Math.toDegrees(pose.getY())) + "°",
                        "Z: " + Math.round(Math.toDegrees(pose.getZ())) + "°")
                .build());
    }
}
