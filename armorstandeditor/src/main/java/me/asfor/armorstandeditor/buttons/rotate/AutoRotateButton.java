package me.asfor.armorstandeditor.buttons.rotate;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class AutoRotateButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        ArmorStandEditor.getPlugin(ArmorStandEditor.class).getRotationManager().toggleRotation(session);
    }

    /*
    private void stopRotating(EditorSession session)
    {
        int taskId = session.getAutoRotateTaskId();

        if (taskId != -1)
        {
            Bukkit.getScheduler().cancelTask(taskId);
            session.setAutoRotateTaskId(-1);
        }
    }
     */
}
