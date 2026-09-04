package me.asfor.armorstandeditor.preview;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PreviewSession
{
    private final UUID playerId;
    private final PreviewEntity previewEntity;

    public PreviewSession(Player player, Location location)
    {
        this.playerId = player.getUniqueId();

        this.previewEntity = new PreviewEntity(createEntityId(), UUID.randomUUID(), location);
    }

    private int createEntityId()
    {
        return 100000 + (int) (Math.random() * 1000000);
    }

    public UUID getPlayerId()
    {
        return playerId;
    }

    public PreviewEntity getPreviewEntity()
    {
        return previewEntity;
    }

    public void spawn(Player player)
    {
        previewEntity.spawn(player);
    }

    public void destroy(Player player)
    {
        previewEntity.destroy(player);
    }
}
