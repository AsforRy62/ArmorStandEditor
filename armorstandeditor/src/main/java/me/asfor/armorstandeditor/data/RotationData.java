package me.asfor.armorstandeditor.data;

import org.bukkit.entity.ArmorStand;

public class RotationData
{
    private final ArmorStand armorStand;

    private int taskId = -1;

    private float step = 15F;

    private boolean rotating = false;

    public RotationData(ArmorStand armorStand)
    {
        this.armorStand = armorStand;
    }

    public ArmorStand getArmorStand()
    {
        return armorStand;
    }

    public int getTaskId()
    {
        return taskId;
    }

    public  void setTaskId(int taskId)
    {
        this.taskId = taskId;
    }

    public float getStep()
    {
        return step;
    }

    public void setStep(float step)
    {
        this.step = step;
    }

    public boolean isRotating()
    {
        return rotating;
    }

    public void setRotating(boolean rotating)
    {
        this.rotating = rotating;
    }
}
