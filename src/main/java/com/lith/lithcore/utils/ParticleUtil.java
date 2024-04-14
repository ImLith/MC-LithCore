package com.lith.lithcore.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import com.lith.lithcore.classes.Cords3D;

public final class ParticleUtil {
    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull Material target,
            @NotNull Particle particle, int count) {
        spawnOnBlockAroundPlayer(player, radius, target, particle, count, null);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull Material target,
            @NotNull Particle particle, int count, DustOptions dustOptions) {
        spawnOnBlockAroundPlayer(player, radius, target, particle, count, null, 1, dustOptions);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull Material target,
            @NotNull Particle particle, int count, Cords3D offset, int extra) {
        spawnOnBlockAroundPlayer(player, radius, target, particle, count, offset, extra, null);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull Material target,
            @NotNull Particle particle, int count, Cords3D offset, int extra, DustOptions dustOptions) {
        List<Material> materials = new ArrayList<>();
        materials.add(target);

        spawnOnBlockAroundPlayer(player, radius, materials, particle, count, offset, extra, dustOptions);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull List<Material> targets,
            @NotNull Particle particle, int count) {
        spawnOnBlockAroundPlayer(player, radius, targets, particle, count, null, 0, null);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull List<Material> targets,
            @NotNull Particle particle, int count, DustOptions dustOptions) {
        spawnOnBlockAroundPlayer(player, radius, targets, particle, count, null, 0, dustOptions);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull List<Material> targets,
            @NotNull Particle particle, int count, Cords3D offset, int extra) {
        spawnOnBlockAroundPlayer(player, radius, targets, particle, count, offset, extra, null);
    }

    public static void spawnOnBlockAroundPlayer(@NotNull Player player, int radius, @NotNull List<Material> targets,
            @NotNull Particle particle, int count, Cords3D offset, int extra, DustOptions dustOptions) {
        Location playerLocation = player.getLocation().clone();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) <= radius) {
                        Location blockLocation = playerLocation.clone().add(x + 0.5, y + 0.5, z + 0.5);
                        if (!targets.contains(blockLocation.getBlock().getType()))
                            continue;

                        if (offset != null) {
                            player.spawnParticle(
                                    particle,
                                    blockLocation,
                                    count,
                                    offset.x, offset.y, offset.z,
                                    extra,
                                    dustOptions);
                        } else {
                            player.spawnParticle(
                                    particle,
                                    blockLocation,
                                    count,
                                    dustOptions);
                        }
                    }
                }
            }
        }
    }
}
