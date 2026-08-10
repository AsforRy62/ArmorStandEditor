package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.gui.RotateGUI;
import me.asfor.armorstandeditor.rotation.RotationData;
import me.asfor.armorstandeditor.sessions.EditorSession;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RotationManager
{
    private final ArmorStandEditor plugin;

    //ArmorStand UUID -> Task ID
    private final Map<UUID, RotationData> rotations = new HashMap<>();

    public RotationManager(ArmorStandEditor plugin)
    {
        this.plugin = plugin;
    }

    public boolean isRotating(ArmorStand armorStand)
    {
        return getData(armorStand).isRotating();
    }

    public void toggleRotation(EditorSession session)
    {
        ArmorStand armorStand = session.getArmorStand();

        if (isRotating(armorStand))
        {
            stopRotation(armorStand);

            session.getPlayer().sendMessage(ChatColor.RED + "Auto Rotate: OFF");
        }
        else
        {
            startRotation(session);

            session.getPlayer().sendMessage(ChatColor.GREEN + "Auto Rotate: ON");
        }

        Player player = session.getPlayer();

        if (player.getOpenInventory().getTitle().equals(RotateGUI.TITLE))
        {
            RotateGUI.refresh(player.getOpenInventory().getTopInventory(), session);
        }
    }

    private void startRotation(EditorSession session)
    {
        RotationData data = getData(session.getArmorStand());

        ArmorStand armorStand = data.getArmorStand();

        data.setRotating(true);

        int taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () ->
        {
            if (! armorStand.isValid())
            {
                stopRotation(armorStand);
                return;
            }

            Location location = armorStand.getLocation();

            location.setYaw(location.getYaw() + data.getStep());

            armorStand.teleport(location);

            Player player = session.getPlayer();

            if (player.getOpenInventory().getTitle().equals(RotateGUI.TITLE))
            {
                RotateGUI.refresh(player.getOpenInventory().getTopInventory(), session);
            }
        }, 0L, 5L);

        data.setTaskId(taskId);
    }

    public void stopRotation(ArmorStand armorStand)
    {
        RotationData data = getData(armorStand);

        if (data.getTaskId() != -1)
        {
            Bukkit.getScheduler().cancelTask(data.getTaskId());
        }

        data.setTaskId(-1);
        data.setRotating(false);
    }

    public void stopAll()
    {
        for (RotationData data : rotations.values())
        {
            Bukkit.getScheduler().cancelTask(data.getTaskId());
        }

        rotations.clear();
    }

    public RotationData getData(ArmorStand armorStand)
    {
        return rotations.computeIfAbsent(armorStand.getUniqueId(), uuid -> new RotationData(armorStand));
    }
}
