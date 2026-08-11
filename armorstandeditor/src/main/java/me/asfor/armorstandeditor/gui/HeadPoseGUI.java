package me.asfor.armorstandeditor.gui;

import me.asfor.armorstandeditor.sessions.EditorGuiType;
import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class HeadPoseGUI
{
    public static final int SIZE = 54;
    public static final String TITLE = "Head Pose Editor";

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
        ItemStack glass = new ItemStack(Material.PINK_STAINED_GLASS_PANE);

        for (int i = 0; i < SIZE; i++)
        {
            inventory.setItem(i, glass);
        }
    }

    public static void createButtons(Inventory inventory, EditorSession session)
    {

        inventory.setItem(X_PLUS, new ItemBuilder(Material.ARROW).setName("Bowing (X+)").build());

        inventory.setItem(X_MINUS, new ItemBuilder(Material.ARROW).setName("Look up (X-)").build());

        inventory.setItem(Y_PLUS, new ItemBuilder(Material.ARROW).setName("Turn Right (Y+)").build());

        inventory.setItem(Y_MINUS, new ItemBuilder(Material.ARROW).setName("Turn Left (Y-)").build());

        inventory.setItem(Z_PLUS, new ItemBuilder(Material.ARROW).setName("Tilting head to the Left (Z+)").build());

        inventory.setItem(Z_MINUS, new ItemBuilder(Material.ARROW).setName("Tilting head to the Right (Z-)").build());

        inventory.setItem(RESET, new ItemBuilder(Material.ARROW).setName("Reset").build());

        refresh(inventory, session);
    }

    public static void refresh(Inventory inventory, EditorSession session)
    {
        //弧度(Radians)
        EulerAngle pose = session.getArmorStand().getHeadPose();

        //轉成角度
        inventory.setItem(INFO, new ItemBuilder(Material.PLAYER_HEAD)
                            .setName("Head Pose")
                            .setLore("",
                                     "X: " + Math.round(Math.toDegrees(pose.getX())) + "°",
                                     "Y: " + Math.round(Math.toDegrees(pose.getY())) + "°",
                                     "Z: " + Math.round(Math.toDegrees(pose.getZ())) + "°")
                            .build());
    }
}
