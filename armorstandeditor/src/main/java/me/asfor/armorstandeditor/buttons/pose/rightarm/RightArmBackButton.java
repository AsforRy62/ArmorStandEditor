package me.asfor.armorstandeditor.buttons.pose.rightarm;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class RightArmBackButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openRightArmPose(session);
    }
}
