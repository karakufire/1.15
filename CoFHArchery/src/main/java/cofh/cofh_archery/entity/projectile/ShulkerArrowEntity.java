package cofh.cofh_archery.entity.projectile;

import cofh.lib.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

import static cofh.cofh_archery.init.ModReferences.SHULKER_ARROW_ENTITY;
import static cofh.cofh_archery.init.ModReferences.SHULKER_ARROW_ITEM;

public class ShulkerArrowEntity extends AbstractArrowEntity {

    private static final DataParameter<Integer> TARGET = EntityDataManager.createKey(ShulkerArrowEntity.class, DataSerializers.VARINT);
    private static int ID_NO_TARGET = -1;

    private static float MAX_VELOCITY = 3.0F;
    private static final double SEEK_DISTANCE = 5.0;
    private static final double SEEK_FACTOR = 0.2;
    private static final double SEEK_ANGLE = Math.PI / 6.0;
    private static final double SEEK_THRESHOLD = 0.5;

    public ShulkerArrowEntity(EntityType<? extends ShulkerArrowEntity> entityIn, World worldIn) {

        super(entityIn, worldIn);
    }

    public ShulkerArrowEntity(World worldIn, LivingEntity shooter) {

        super(SHULKER_ARROW_ENTITY, shooter, worldIn);
    }

    public ShulkerArrowEntity(World worldIn, double x, double y, double z) {

        super(SHULKER_ARROW_ENTITY, x, y, z, worldIn);
    }

    @Override
    protected void registerData() {

        super.registerData();
        this.getDataManager().register(TARGET, ID_NO_TARGET);
    }

    @Override
    protected ItemStack getArrowStack() {

        return new ItemStack(SHULKER_ARROW_ITEM);
    }

    @Override
    public void setFire(int seconds) {

    }

    @Override
    public void tick() {

        if (!inGround) {
            if (Utils.isServerWorld(world)) {
                updateTarget();
            }
            Entity target = getTarget();
            if (target != null) {
                Vec3d targetVec = getVectorToTarget(target).scale(SEEK_FACTOR);
                Vec3d courseVec = getMotion();

                double courseLen = courseVec.length();
                double targetLen = targetVec.length();
                double totalLen = Math.sqrt(courseLen * courseLen + targetLen * targetLen);
                double dotProduct = courseVec.dotProduct(targetVec) / (courseLen * targetLen);

                if (dotProduct > SEEK_THRESHOLD) {
                    Vec3d newMotion = (courseVec.scale(courseLen / totalLen).add(targetVec.scale(targetLen / totalLen))).normalize().scale(MAX_VELOCITY);
                    this.setMotion(newMotion.x, newMotion.y + 0.05F, newMotion.z);
                } else if (Utils.isServerWorld(world)) {
                    setTarget(null);
                }
                if (Utils.isClientWorld(world)) {
                    Vec3d vec3d = this.getMotion().scale(0.25D);
                    double d1 = vec3d.x;
                    double d2 = vec3d.y;
                    double d0 = vec3d.z;
                    this.world.addParticle(ParticleTypes.END_ROD, this.posX + d1, this.posY + d2, this.posZ + d0, -d1, -d2 + 0.2D, -d0);
                }
            }
        }
        super.tick();
    }

    @Override
    public IPacket<?> createSpawnPacket() {

        return NetworkHooks.getEntitySpawningPacket(this);
    }

    // region HELPERS
    private void updateTarget() {

        if (isInWater() || isInLava()) {
            setTarget(null);
            return;
        }
        Entity target = getTarget();
        if (target != null && !target.isAlive()) {
            setTarget(target = null);
        }
        if (target == null) {
            AxisAlignedBB positionBB = new AxisAlignedBB(posX, posY, posZ, posX, posY, posZ);
            AxisAlignedBB targetBB = positionBB;

            Vec3d courseVec = getMotion().scale(SEEK_DISTANCE).rotateYaw((float) SEEK_ANGLE);
            targetBB = targetBB.union(positionBB.offset(courseVec));

            courseVec = getMotion().scale(SEEK_DISTANCE).rotateYaw((float) -SEEK_ANGLE);
            targetBB = targetBB.union(positionBB.offset(courseVec));
            targetBB = targetBB.grow(0, SEEK_DISTANCE * 0.5, 0);

            double closestDot = -1.0;
            Entity closestTarget = null;

            for (LivingEntity living : this.world.getEntitiesWithinAABB(LivingEntity.class, targetBB)) {
                if (living instanceof PlayerEntity) {
                    continue;
                }
                Vec3d motionVec = getMotion().normalize();
                Vec3d targetVec = getVectorToTarget(living).normalize();

                double dot = motionVec.dotProduct(targetVec);
                if (dot > Math.max(closestDot, SEEK_THRESHOLD)) {
                    closestDot = dot;
                    closestTarget = living;
                }
            }
            if (closestTarget != null) {
                setTarget(closestTarget);
            }
        }
    }

    private Vec3d getVectorToTarget(Entity target) {

        return new Vec3d(target.posX - this.posX, (target.posY + (double) target.getEyeHeight()) - this.posY, target.posZ - this.posZ);
    }

    @Nullable
    private Entity getTarget() {

        return world.getEntityByID(dataManager.get(TARGET));
    }

    private void setTarget(@Nullable Entity e) {

        dataManager.set(TARGET, e == null ? ID_NO_TARGET : e.getEntityId());
    }
    // endregion
}