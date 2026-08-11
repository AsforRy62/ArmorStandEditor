package me.asfor.armorstandeditor.gui;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.rotation.RotationData;
import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Location.normalizeYaw;

public class RotateGUI
{
    public static final int SIZE = 36;
    public static final String TITLE = "Rotate Editor";

    public static final int AUTO_ROTATE_BUTTON = 4;

    public static final int ROTATE_LEFT = 11;
    public static final int ROTATE_INFO = 13;
    public static final int ROTATE_RIGHT = 15;

    public static final int STEP_BUTTON = 22;
    public static final int RESET_BUTTON = 30;
    public static final int BACK_BUTTON = 32;

    public static Inventory createInventory(EditorSession session)
    {
        Inventory inventory = Bukkit.createInventory(null, SIZE, TITLE);

        createBackground(inventory);
        createButtons(inventory, session);

        return inventory;
    }

    private static void createBackground(Inventory inventory)
    {
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        for (int i = 0; i < SIZE; i++)
        {
            inventory.setItem(i, glass);
        }
    }

    private static void createButtons(Inventory inventory, EditorSession session)
    {
        inventory.setItem(AUTO_ROTATE_BUTTON, new ItemBuilder(Material.WIND_CHARGE).setName("§eAuto Rotate").build());

        inventory.setItem(ROTATE_LEFT, new ItemBuilder(Material.ARROW).setName("§eRotate Left").build());

        inventory.setItem(ROTATE_RIGHT, new ItemBuilder(Material.ARROW).setName("§eRotate Right").build());

        float yaw = session.getArmorStand().getLocation().getYaw();

        inventory.setItem(STEP_BUTTON, new ItemBuilder(Material.CLOCK).setName("Rotation Step").build());

        inventory.setItem(RESET_BUTTON, new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("Reset").build());

        inventory.setItem(BACK_BUTTON, new ItemBuilder(Material.BARRIER).setName("§cBack").build());

        refresh(inventory, session);
    }

    public static void refresh(Inventory inventory, EditorSession session)
    {
        RotationData data = ArmorStandEditor.getPlugin(ArmorStandEditor.class).getRotationManager().getData(session.getArmorStand());

        boolean rotating = data.isRotating();

        float yaw = session.getArmorStand().getLocation().getYaw();

        inventory.setItem(AUTO_ROTATE_BUTTON, new ItemBuilder(Material.WIND_CHARGE)
                .setName("Auto Rotate")
                .setToggleStatus(rotating)
                .build());

        inventory.setItem(ROTATE_INFO, new ItemBuilder(Material.COMPASS)
                .setName("§bRotation")
                .setLore("", "§7Current: §e" + Math.round(normalizeYaw(yaw)) + "°")
                .build());

        inventory.setItem(STEP_BUTTON, new ItemBuilder(Material.CLOCK)
                .setName("Rotation Step")
                .setLore("", "§7Current: §a" + (int) data.getStep() + "°", "", "§eClick to change")
                .build());
    }

    private static float normalizeYaw(float yaw)
    {
        yaw %= 360;
        if (yaw < 0)
            yaw += 360;

        return yaw;
    }
}
