package me.asfor.armorstandeditor.gui;

import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainEditorGUI
{
    public static final int SIZE = 54;
    public static final String TITLE = "Armor Stand Editor";

    public static final int HELMET_SLOT = 4;
    public static final int CHESTPLATE_SLOT = 13;
    public static final int LEGGINGS_SLOT = 22;
    public static final int BOOTS_SLOT = 31;

    public  static final int MAIN_HAND_SLOT = 19;
    public static final int OFF_HAND_SLOT = 25;

    public static final int SMALL_BUTTON = 45;
    public static final int ARMS_BUTTON = 46;
    public static final int BASE_BUTTON = 47;
    public static final int MARKER_BUTTON = 48;
    public static final int POSE_BUTTON = 49;
    public static final int ROTATE_BUTTON = 50;
    public static final int NAME_BUTTON = 51;
    public static final int GRAVITY_BUTTON = 52;
    public static final int VISIBLE_BUTTON = 53;

    public static Inventory createInventory(ArmorStand armorStand) {
        Inventory inventory = Bukkit.createInventory(null, SIZE, TITLE);

        createBackground(inventory);

        loadEquipment(inventory, armorStand);

        createButtons(inventory, armorStand);

        refreshButtons(inventory, armorStand);

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

    private static void loadEquipment(Inventory inventory, ArmorStand armorStand)
    {
        EntityEquipment equipment = armorStand.getEquipment();

        inventory.setItem(HELMET_SLOT, equipment.getHelmet());
        inventory.setItem(CHESTPLATE_SLOT, equipment.getChestplate());
        inventory.setItem(LEGGINGS_SLOT, equipment.getLeggings());
        inventory.setItem(BOOTS_SLOT, equipment.getBoots());

        inventory.setItem(MAIN_HAND_SLOT, equipment.getItemInMainHand());
        inventory.setItem(OFF_HAND_SLOT, equipment.getItemInOffHand());
    }

    private static void createButtons(Inventory inventory, ArmorStand armorStand)
    {
        inventory.setItem(SMALL_BUTTON, createToggleButton(Material.SLIME_BALL, "§aSmall", armorStand.isSmall()));
        inventory.setItem(ARMS_BUTTON, createToggleButton(Material.STICK, "§eArms", armorStand.hasArms()));
        inventory.setItem(BASE_BUTTON, createToggleButton(Material.SMOOTH_STONE_SLAB, "§6Base Plate", armorStand.hasBasePlate()));
        inventory.setItem(MARKER_BUTTON, createToggleButton(Material.BARRIER, "§cMarker", armorStand.isMarker()));
        inventory.setItem(POSE_BUTTON, createItem(Material.ARMOR_STAND, "§bPose"));
        inventory.setItem(ROTATE_BUTTON, createItem(Material.COMPASS, "§9Rotate"));
        inventory.setItem(NAME_BUTTON, createItem(Material.NAME_TAG, "§dRename"));
        inventory.setItem(GRAVITY_BUTTON, createToggleButton(Material.ANVIL, "§4Gravity", armorStand.hasGravity()));
        inventory.setItem(VISIBLE_BUTTON, createToggleButton(Material.POTION, "§fVisible", armorStand.isVisible()));
    }

    public static void refreshButtons(Inventory inventory, ArmorStand armorStand)
    {
        createButtons(inventory, armorStand);
    }

    private static ItemStack createItem(Material material, String name)
    {
        return new ItemBuilder(material).setName(name).build();
    }

    private static ItemStack createToggleButton(Material material, String name, boolean enabled)
    {
        return new ItemBuilder(material).setName(name).setToggleStatus(enabled).build();
    }

    public static void updateArmorStand(EditorSession session)
    {
        Inventory inventory = session.getPlayer().getOpenInventory().getTopInventory();
        ArmorStand armorStand = session.getArmorStand();

        EntityEquipment equipment = armorStand.getEquipment();

        equipment.setHelmet(inventory.getItem(HELMET_SLOT));
        equipment.setChestplate(inventory.getItem(CHESTPLATE_SLOT));
        equipment.setLeggings(inventory.getItem(LEGGINGS_SLOT));
        equipment.setBoots(inventory.getItem(BOOTS_SLOT));

        equipment.setItemInMainHand(inventory.getItem(MAIN_HAND_SLOT));
        equipment.setItemInOffHand(inventory.getItem(OFF_HAND_SLOT));
    }
}
