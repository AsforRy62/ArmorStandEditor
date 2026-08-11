package me.asfor.armorstandeditor.buttons;

import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class HeadBackButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openPose(session);
    }
}
