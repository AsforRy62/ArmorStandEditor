package me.asfor.armorstandeditor.buttons.rotate;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class RotateBackButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openMain(session);
    }
}
