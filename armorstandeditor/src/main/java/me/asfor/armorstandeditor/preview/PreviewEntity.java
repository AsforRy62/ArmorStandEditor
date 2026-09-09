package me.asfor.armorstandeditor.preview;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.decoration.ArmorStand;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class PreviewEntity
{
    private final int entityId;
    private final UUID uuid;
    private final Location location;

    private final boolean small;
    private final boolean showArms;
    private final boolean noBasePlate;
    private final boolean marker;

    public PreviewEntity(int entityId, UUID uuid, Location location, org.bukkit.entity.ArmorStand armorStand)
    {
        this.entityId = entityId;
        this.uuid = uuid;
        this.location = location.clone();

        this.small = armorStand.isSmall();
        this.showArms = armorStand.hasArms();
        this.noBasePlate = ! armorStand.hasBasePlate();
        this.marker = armorStand.isMarker();
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
        var armorStandType = BuiltInRegistries.ENTITY_TYPE.getValue(net.minecraft.resources.Identifier.withDefaultNamespace("armor_stand"));

        ClientboundAddEntityPacket packet = new ClientboundAddEntityPacket(entityId,
                                                                            uuid,
                                                                            location.getX(),
                                                                            location.getY(),
                                                                            location.getZ(),
                                                                            0.0F,
                                                                            0.0F,
                                                                            armorStandType,
                                                                            //BuiltInRegistries.ENTITY_TYPE.getValue(Identifier.withDefaultNamespace("armor_stand")),
                                                                            0,
                                                                            new net.minecraft.world.phys.Vec3(0, 0, 0),
                                                                            0.0);

        serverPlayer.connection.send(packet);

        byte flags = 0;

        if (small)
        {
            flags |= ArmorStand.CLIENT_FLAG_SMALL;
        }

        if (showArms)
        {
            flags = ArmorStand.CLIENT_FLAG_SHOW_ARMS;
        }

        if (noBasePlate)
        {
            flags = ArmorStand.CLIENT_FLAG_NO_BASEPLATE;
        }

        if (marker)
        {
            flags = ArmorStand.CLIENT_FLAG_MARKER;
        }

        SynchedEntityData.DataValue<Byte> data = SynchedEntityData.DataValue.create(ArmorStand.DATA_CLIENT_FLAGS, flags);

        serverPlayer.connection.send(new ClientboundSetEntityDataPacket(entityId, List.of(data)));
    }

    public void destroy(Player player)
    {
        ServerPlayer serverPlayer = getServerPlayer(player);

        serverPlayer.connection.send(new ClientboundRemoveEntitiesPacket(entityId));
    }

    public void updateFlags(Player player, org.bukkit.entity.ArmorStand armorStand)
    {
        ServerPlayer serverPlayer = getServerPlayer (player);

        byte flags = 0;

        if (armorStand.isSmall())
        {
            flags |= ArmorStand.CLIENT_FLAG_SMALL;
        }

        if (armorStand.hasArms())
        {
            flags |= ArmorStand.CLIENT_FLAG_SHOW_ARMS;
        }

        if (! armorStand.hasBasePlate())
        {
            flags |= ArmorStand.CLIENT_FLAG_NO_BASEPLATE;
        }

        if (armorStand.isMarker())
        {
            flags |= ArmorStand.CLIENT_FLAG_MARKER;
        }

        SynchedEntityData.DataValue<Byte> data = SynchedEntityData.DataValue.create(ArmorStand.DATA_CLIENT_FLAGS, flags);

        serverPlayer.connection.send(new ClientboundSetEntityDataPacket(entityId, List.of(data)));
    }
}
