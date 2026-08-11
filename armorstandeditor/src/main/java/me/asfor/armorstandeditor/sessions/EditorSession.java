package me.asfor.armorstandeditor.sessions;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EditorSession
{
    private final Player player;
    private ArmorStand armorStand;
    private Inventory inventory;

    private EditorGuiType currentGui;

    private int autoRotateTaskId = -1;
    //private float rotationStep = 15.0F;

    private boolean switchingGui = false;

    //Pose
    private PosePart posePart = PosePart.HEAD;

    public EditorSession(Player player, ArmorStand armorStand)
    {
        this.player = player;
        this.armorStand = armorStand;

        this.currentGui = EditorGuiType.MAIN;
    }

    public Player getPlayer()
    {
        return player;
    }

    public ArmorStand getArmorStand()
    {
        return armorStand;
    }

    public void setArmorStand(ArmorStand armorStand)
    {
        this.armorStand = armorStand;
    }

    /*
    public Inventory getInventory()
    {
        return inventory;
    }
     */
    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    public int getAutoRotateTaskId()
    {
        return autoRotateTaskId;
    }

    public void setAutoRotateTaskId(int autoRotateTaskId)
    {
        this.autoRotateTaskId = autoRotateTaskId;
    }

    public boolean isAutoRotating()
    {
        return autoRotateTaskId != -1;
    }

    public EditorGuiType getCurrentGui()
    {
        return currentGui;
    }

    public void setCurrentGui(EditorGuiType currentGui)
    {
        this.currentGui = currentGui;
    }

    public boolean isSwitchingGui()
    {
        return switchingGui;
    }

    public void setSwitchingGui(boolean switchingGui)
    {
        this.switchingGui = switchingGui;
    }

    //Pose
    public PosePart getPosePart()
    {
        return posePart;
    }

    public void setPosePart(PosePart posePart)
    {
        this.posePart = posePart;
    }
}
