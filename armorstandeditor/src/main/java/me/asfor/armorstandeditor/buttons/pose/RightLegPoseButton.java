package me.asfor.armorstandeditor.buttons.pose;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;
import me.asfor.armorstandeditor.sessions.PosePart;

public class RightLegPoseButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        session.setPosePart(PosePart.RIGHT_LEG);
        GuiManager.openRightLegPose(session);
    }
}
