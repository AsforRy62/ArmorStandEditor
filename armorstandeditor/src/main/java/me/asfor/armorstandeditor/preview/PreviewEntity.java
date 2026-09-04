package me.asfor.armorstandeditor.preview;

import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PreviewEntity
{
    private final int entityId;
    private final UUID uuid;
    private final Location location;

    public PreviewEntity(int entityId, UUID uuid, Location location)
    {
        this.entityId = entityId;
        this.uuid = uuid;
        this.location = location.clone();
    }

    public int getEntityId()
    {
        return entityId;
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public Location getLocation()
    {
        return location.clone();
    }

    private ServerPlayer getServerPlayer(Player player)
    {
        return ((CraftPlayer) player).getHandle();
    }

    public void spawn(Player player)
    {
        ServerPlayer serverPlayer = getServerPlayer(player);

        //var armorStandType = BuiltInRegistries.ENTITY_TYPE.getValue(net.minecraft.resources.ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(), net.minecraft.resources.Identifier.withDefaultNamespace("armor_stand")));

        ClientboundAddEntityPacket packet = new ClientboundAddEntityPacket(entityId,
                                                                            uuid,
                                                                            location.getX(),
                                                                            location.getY(),
                                                                            location.getZ(),
                                                                            0.0F,
                                                                            0.0F,
                                                                            //armorStandType,
                                                                            BuiltInRegistries.ENTITY_TYPE.getValue(Identifier.withDefaultNamespace("armor_stand")),
                                                                            0,
                                                                            new net.minecraft.world.phys.Vec3(0, 0, 0),
                                                                            0.0);

        serverPlayer.connection.send(packet);
    }

    public void destroy(Player player)
    {
        ServerPlayer serverPlayer = getServerPlayer(player);

        serverPlayer.connection.send(new ClientboundRemoveEntitiesPacket(entityId));
    }
}
