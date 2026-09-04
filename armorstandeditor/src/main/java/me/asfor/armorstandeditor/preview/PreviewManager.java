package me.asfor.armorstandeditor.preview;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PreviewManager
{
    private final Map<UUID, PreviewEntity> previews = new HashMap<>();

    public void show(Player player, ArmorStand armorStand)
    {
        if (previews.containsKey(player.getUniqueId()))
        {
            return;
        }

        PreviewEntity preview = new PreviewEntity(generateEntityId(), UUID.randomUUID(), player.getLocation());

        previews.put(player.getUniqueId(), preview);

        preview.spawn(player);
    }

    public void hide(Player player)
    {
        PreviewEntity preview = previews.remove(player.getUniqueId());

        if (preview != null)
        {
            preview.destroy(player);
        }
    }

    private int generateEntityId()
    {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}