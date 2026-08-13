package me.asfor.armorstandeditor.managers;

import me.asfor.armorstandeditor.ArmorStandEditor;
import me.asfor.armorstandeditor.data.PoseData;
import org.bukkit.entity.ArmorStand;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PoseManager
{
    private final ArmorStandEditor plugin;

    private final Map<UUID, PoseData> poses = new HashMap<>();

    public PoseManager(ArmorStandEditor plugin)
    {
        this.plugin = plugin;
    }

    public PoseData getData(ArmorStand armorStand)
    {
        return poses.computeIfAbsent(armorStand.getUniqueId(), uuid -> new PoseData(armorStand));
    }

    public void remove(ArmorStand armorStand)
    {
        poses.remove(armorStand.getUniqueId());
    }

    public void clear()
    {
        poses.clear();
    }
}
