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
    public static final int LEFT_ARM = 12;
    public static final int RIGHT_ARM = 14;
    public static final int LEFT_LEG = 30;
    public static final int RIGHT_LEG = 32;

    public static final int BACK = 49;

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
        inventory.setItem(HEAD, new ItemBuilder(Material.PLAYER_HEAD).setName("§dHead Pose").build());

        inventory.setItem(BODY, new ItemBuilder(Material.OAK_FENCE).setName("§6Body Pose").build());

        inventory.setItem(LEFT_ARM, new ItemBuilder(Material.STICK).setName("§eLeft Arm Pose").build());

        inventory.setItem(RIGHT_ARM, new ItemBuilder(Material.STICK).setName("§aRight Arm Pose").build());

        inventory.setItem(LEFT_LEG, new ItemBuilder(Material.STICK).setName("§9Left Leg Pose").build());

        inventory.setItem(RIGHT_LEG, new ItemBuilder(Material.STICK).setName("§5Right Leg Pose").build());

        inventory.setItem(BACK, new ItemBuilder(Material.BARRIER).setName("§cBack").build());
    }
}
