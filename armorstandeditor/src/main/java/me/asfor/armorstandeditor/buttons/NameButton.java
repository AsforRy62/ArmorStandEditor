package me.asfor.armorstandeditor.buttons;

import me.asfor.armorstandeditor.managers.RenameGuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class NameButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        RenameGuiManager.open(session);
    }
}
