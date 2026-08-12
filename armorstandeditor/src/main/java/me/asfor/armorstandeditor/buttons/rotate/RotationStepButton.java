package me.asfor.armorstandeditor.buttons.rotate;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.buttons.Button;
import me.asfor.armorstandeditor.managers.RotationManager;
import me.asfor.armorstandeditor.rotation.RotationData;
import me.asfor.armorstandeditor.sessions.EditorSession;

public class RotationStepButton implements Button
{
    @Override
    public void execute(EditorSession session)
    {
        RotationManager rotationManager = ArmorStandEditor.getPlugin(ArmorStandEditor.class).getRotationManager();

        RotationData data = rotationManager.getData(session.getArmorStand());

        float step = data.getStep();

        if (step == 5F)
        {
            step = 15F;
        }
        else if (step == 15F)
        {
            step = 45F;
        }
        else if (step == 45F)
        {
            step = 90F;
        }
        else
        {
            step = 5F;
        }

        data.setStep(step);

        //session.setRotationStep(step);
    }
}
