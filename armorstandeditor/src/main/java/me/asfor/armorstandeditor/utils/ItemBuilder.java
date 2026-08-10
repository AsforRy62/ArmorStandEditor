package me.asfor.armorstandeditor.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder
{
    private final ItemStack item;
    private final ItemMeta meta;

    public  ItemBuilder(Material material)
    {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public ItemBuilder setName(String name)
    {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setToggleStatus(boolean enabled)
    {
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7Status: " + (enabled ? "§aON" : "§cOFF"));

        meta.setLore(lore);
        return this;
    }

    public ItemBuilder setLore(String... lines)
    {
        meta.setLore(Arrays.asList(lines));
        return this;
    }

    public ItemStack build()
    {
        item.setItemMeta(meta);
        return item;
    }
}
