package me.asfor.armorstandeditor.preview;

import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Location;
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

        Location previewLocation = player.getLocation().clone().add(player.getLocation().getDirection().normalize().multiply(2.5)).add(2, 0.5, 0);

        PreviewEntity preview = new PreviewEntity(generateEntityId(), UUID.randomUUID(), previewLocation, armorStand);

        previews.put(player.getUniqueId(), preview);

        preview.spawn(player);
    }

    public void update(Player player, ArmorStand armorStand)
    {
        PreviewEntity preview = previews.get(player.getUniqueId());

        if (preview == null)
        {
            return;
        }

        preview.updateFlags(player, armorStand);
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