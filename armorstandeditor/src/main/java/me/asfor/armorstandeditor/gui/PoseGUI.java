package me.asfor.armorstandeditor.gui;

import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PoseGUI
{
    public static final int SIZE = 54;
    public static final String TITLE = "Pose Editor";

    public static final int HEAD = 4;
    public static final int BODY = 22;
    public static final int LEFT_ARM = 11;
    public static final int RIGHT_ARM = 15;
    public static final int LEFT_LEG = 29;
    public static final int RIGHT_LEG = 33;

    public static final int BACK = 51;

    public static Inventory createInventory(EditorSession session)
    {
        Inventory inventory = Bukkit.createInventory(null, SIZE, TITLE);

        createBackground(inventory);
        createButtons(inventory, session);

        return inventory;
    }

    public static void createBackground(Inventory inventory)
    {
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        for (int i = 0; i < SIZE; i++)
        {
            inventory.setItem(i, glass);
        }
    }

    public static void createButtons(Inventory inventory, EditorSession session)
    {
        inventory.setItem(HEAD, new ItemBuilder(Material.PLAYER_HEAD).setName("Head Pose").build());

        inventory.setItem(BODY, new ItemBuilder(Material.OAK_FENCE).setName("Body Pose").build());

        inventory.setItem(LEFT_ARM, new ItemBuilder(Material.STICK).setName("Left Arm Pose").build());

        inventory.setItem(RIGHT_ARM, new ItemBuilder(Material.STICK).setName("Right Arm Pose").build());
    }
}
