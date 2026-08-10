package me.asfor.armorstandeditor.managers;

import jdk.jshell.spi.ExecutionControl;
import me.asfor.armorstandeditor.sessions.EditorSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager
{
    private final Map<UUID, EditorSession> sessions = new HashMap<>();

    public void addSession(EditorSession session)
    {
        sessions.put(session.getPlayer().getUniqueId(), session);
    }

    public EditorSession getSession(UUID uuid)
    {
        return sessions.get(uuid);
    }

    public void removeSession(UUID uuid)
    {
        sessions.remove(uuid);
    }

    public boolean hasSession(UUID uuid)
    {
        return sessions.containsKey(uuid);
    }
}
