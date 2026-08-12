package me.asfor.armorstandeditor.buttons.main;

import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.GuiManager;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class RotateButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        GuiManager.openRotate(session);
    }
}
