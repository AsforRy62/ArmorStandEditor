package me.asfor.armorstandeditor.buttons;

import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.sessions.PosePart;

public class HeadPoseButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        session.setPosePart(PosePart.HEAD);
        GuiManager.openHeadPose(session);
    }
}
