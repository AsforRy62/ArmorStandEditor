package me.asfor.armorstandeditor.buttons.pose.leftleg;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class LeftLegBackButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openPose(session);
    }
}
