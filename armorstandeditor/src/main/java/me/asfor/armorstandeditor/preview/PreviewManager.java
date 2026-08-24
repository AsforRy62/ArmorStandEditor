package me.asfor.armorstandeditor.preview;

import me.asfor.armorstandeditor.sessions.EditorSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PreviewManager
{
    private final Map<UUID, PreviewSession> previews = new HashMap<>();

    public void createPreview(EditorSession session)
    {
        UUID uuid = session.getPlayer().getUniqueId();

        PreviewSession previewSession = new PreviewSession(uuid);

        previews.put(uuid, previewSession);
    }

    public void updatePreview(EditorSession session)
    {
        UUID uuid = session.getPlayer().getUniqueId();

        PreviewSession preview =  new PreviewSession(uuid);

        if (preview == null)
        {
            return;
        }
    }

    public void removePreview(EditorSession session)
    {
        UUID uuid = session.getPlayer().getUniqueId();

        previews.remove(uuid);
    }
}