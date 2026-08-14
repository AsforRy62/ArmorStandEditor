package me.asfor.armorstandeditor.buttons.pose.rightleg;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class RightLegBackButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openPose(session);
    }
}
