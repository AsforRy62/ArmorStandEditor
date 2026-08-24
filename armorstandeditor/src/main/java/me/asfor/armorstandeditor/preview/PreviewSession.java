package me.asfor.armorstandeditor.preview;

import java.util.UUID;

public class PreviewSession
{
    private final UUID playerUUID;

    public PreviewSession(UUID playerUUID)
    {
        this.playerUUID = playerUUID;
    }

    public UUID getPlayerUUID()
    {
        return playerUUID;
    }
}
