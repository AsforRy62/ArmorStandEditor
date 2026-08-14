package me.asfor.armorstandeditor.buttons.pose;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class BackPoseButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openMain(session);
    }
}
