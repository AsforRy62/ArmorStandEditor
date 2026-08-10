package me.asfor.armorstandeditor.handlers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.gui.MainEditorGUI;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;

public class MainGuiHandler
{
    private final ArmorStandEditor plugin;

    public MainGuiHandler(ArmorStandEditor plugin)
    {
        this.plugin = plugin;
    }

    public void handle(InventoryClickEvent event, EditorSession session)
    {
        Player player = (Player) event.getWhoClicked();

        if (event.isShiftClick())
        {
            handleShiftClick(event, player, session);
            return;
        }

        if (event.getClickedInventory() == event.getView().getBottomInventory())
        {
            return;
        }

        int slot = event.getRawSlot();

        Button button = plugin.getButtonManager().getButton(slot);

        if (button != null)
        {
            event.setCancelled(true);
            button.execute(session);
            MainEditorGUI.refreshButtons(event.getView().getTopInventory(), session.getArmorStand());
            return;
        }

        if (!isEquipmentSlot(slot))
        {
            event.setCancelled(true);
            return;
        }

        plugin.getServer().getScheduler().runTask(plugin, () -> MainEditorGUI.updateArmorStand(session));
    }

    public void handleDrag(InventoryDragEvent event)
    {
        for (int slot : event.getRawSlots())
        {
            if (slot < MainEditorGUI.SIZE)
            {
                event.setCancelled(true);
                return;
            }
        }
    }

    private void handleShiftClick(InventoryClickEvent event, Player player, EditorSession session)
    {
        if (event.getClickedInventory() == event.getView().getTopInventory())
        {
            event.setCancelled(true);

            int slot = event.getRawSlot();

            if (!isEquipmentSlot(slot))
            {
                return;
            }

            ItemStack item = event.getCurrentItem();

            if (item == null || item.getType().isAir())
            {
                return;
            }

            if (!player.getInventory().addItem(item).isEmpty())
            {
                player.sendMessage("§cBackpack is full！");
                return;
            }

            event.getView().getTopInventory().setItem(slot, null);

            plugin.getServer().getScheduler().runTask(plugin, () -> MainEditorGUI.updateArmorStand(session));

            return;
        }

        if (event.getClickedInventory() == event.getView().getBottomInventory())
        {
            event.setCancelled(true);

            ItemStack item = event.getCurrentItem();

            if (item == null || item.getType().isAir())
            {
                return;
            }

            int targetSlot = getEquipmentSlot(item);

            ItemStack targetItem = event.getView().getTopInventory().getItem(targetSlot);

            if (targetItem != null && !targetItem.getType().isAir())
            {
                player.sendMessage("This location is already equipped.");
                return;
            }

            event.getView().getTopInventory().setItem(targetSlot, item.clone());

            event.getClickedInventory().setItem(event.getSlot(), null);

            plugin.getServer().getScheduler().runTask(plugin, () -> MainEditorGUI.updateArmorStand(session));

            return;
        }
    }

    private boolean isEquipmentSlot(int slot)
    {
        return slot == MainEditorGUI.HELMET_SLOT ||
                slot == MainEditorGUI.CHESTPLATE_SLOT ||
                slot == MainEditorGUI.LEGGINGS_SLOT ||
                slot == MainEditorGUI.BOOTS_SLOT ||
                slot == MainEditorGUI.MAIN_HAND_SLOT ||
                slot == MainEditorGUI.OFF_HAND_SLOT;

    }

    private int getEquipmentSlot(ItemStack item)
    {
        Material metarial = item.getType();

        switch (metarial)
        {
            case LEATHER_HELMET:
            case CHAINMAIL_HELMET:
            case IRON_HELMET:
            case GOLDEN_HELMET:
            case DIAMOND_HELMET:
            case NETHERITE_HELMET:
            case TURTLE_HELMET:
            case CARVED_PUMPKIN:
            case PLAYER_HEAD:
            case CREEPER_HEAD:
            case ZOMBIE_HEAD:
            case SKELETON_SKULL:
            case WITHER_SKELETON_SKULL:
            case PIGLIN_HEAD:
            case DRAGON_HEAD:
                return MainEditorGUI.HELMET_SLOT;

            case LEATHER_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case IRON_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
            case NETHERITE_CHESTPLATE:
            case ELYTRA:
                return MainEditorGUI.CHESTPLATE_SLOT;

            case LEATHER_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case IRON_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case DIAMOND_LEGGINGS:
            case NETHERITE_LEGGINGS:
                return MainEditorGUI.LEGGINGS_SLOT;

            case LEATHER_BOOTS:
            case CHAINMAIL_BOOTS:
            case IRON_BOOTS:
            case GOLDEN_BOOTS:
            case DIAMOND_BOOTS:
            case NETHERITE_BOOTS:
                return MainEditorGUI.BOOTS_SLOT;

            case SHIELD:
                return MainEditorGUI.OFF_HAND_SLOT;

            default:
                return MainEditorGUI.MAIN_HAND_SLOT;
        }
    }
    
}
