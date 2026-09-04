package me.asfor.armorstandeditor.sessions;

import me.asfor.armorstandeditor.gui.LeftArmPoseGUI;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.util.EulerAngle;

public class EditorSession
{
    private final Player player;
    private ArmorStand armorStand;
    private Inventory inventory;

    private EditorGuiType currentGui;

    private int autoRotateTaskId = -1;

    private boolean switchingGui = false;

    private boolean openingRename = false;
    private boolean closing = false;

    private PosePart posePart;

    private boolean previewVisible;

    public EditorSession(Player player, ArmorStand armorStand)
    {
        this.player = player;
        this.armorStand = armorStand;

        this.currentGui = EditorGuiType.MAIN;

        this.previewVisible = false;
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


    public Inventory getInventory()
    {
        return inventory;
    }

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

    public boolean isOpeningRename()
    {
        return openingRename;
    }

    public void setOpeningRename(boolean openingRename)
    {
        this.openingRename = openingRename;
    }

    public boolean isClosing()
    {
        return closing;
    }

    public void setClosing(boolean closing)
    {
        this.closing = closing;
    }

    public PosePart getPosePart()
    {
        return posePart;
    }

    public void setPosePart(PosePart posePart)
    {
        this.posePart = posePart;
    }

    public boolean isPreviewVisible()
    {
        return previewVisible;
    }

    public void setPreviewVisible(boolean previewVisible)
    {
        this.previewVisible = previewVisible;
    }
}
