package me.asfor.armorstandeditor;

import me.asfor.armorstandeditor.handlers.MainGuiHandler;
import me.asfor.armorstandeditor.handlers.PoseGuiHandler;
import me.asfor.armorstandeditor.handlers.RotateGuiHandler;
import me.asfor.armorstandeditor.listeners.ArmorStandListener;
import me.asfor.armorstandeditor.listeners.InventoryListener;
import me.asfor.armorstandeditor.managers.ButtonManager;
import me.asfor.armorstandeditor.managers.PoseManager;
import me.asfor.armorstandeditor.managers.RotationManager;
import me.asfor.armorstandeditor.managers.SessionManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorStandEditor extends JavaPlugin
{
    private SessionManager sessionManager;
    private ButtonManager buttonManager;
    private RotationManager rotationManager;
    private PoseManager poseManager;

    private MainGuiHandler mainGuiHandler;
    private RotateGuiHandler rotateGuiHandler;
    private PoseGuiHandler poseGuiHandler;

    @Override
    public void onEnable()
    {
        sessionManager = new SessionManager();

        buttonManager = new ButtonManager();

        rotationManager = new RotationManager(this);

        poseManager = new PoseManager(this);

        mainGuiHandler = new MainGuiHandler(this);

        rotateGuiHandler = new RotateGuiHandler(this);

        poseGuiHandler = new PoseGuiHandler(this);

        getServer().getPluginManager().registerEvents(new ArmorStandListener(this), this);

        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);

        getLogger().info("ArmorStandEditor Enabled!");
    }

    @Override
    public void onDisable()
    {
        getLogger().info("ArmorStandEditor Disabled!");

        rotationManager.stopAll();
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public ButtonManager getButtonManager() {return buttonManager;}

    public RotationManager getRotationManager() {return rotationManager;}

    public PoseManager getPoseManager() {return poseManager;}

    public MainGuiHandler getMainGuiHandler() {return mainGuiHandler;}

    public RotateGuiHandler getRotateGuiHandler() {return rotateGuiHandler;}

    public PoseGuiHandler getPoseGuiHandler()
    {
        return poseGuiHandler;
    }
}