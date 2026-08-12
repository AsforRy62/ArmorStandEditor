package me.asfor.armorstandeditor.buttons.pose.head;

import me.asfor.armorstandeditor.buttons.Button;
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
