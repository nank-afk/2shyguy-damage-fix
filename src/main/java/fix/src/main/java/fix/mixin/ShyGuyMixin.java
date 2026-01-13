package fix.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.mcreator.shyguy.entity.ShyGuyEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShyGuyEntity.class)
public class ShyGuyMixin {

    @Inject(
        method = "m_6469_",
        at = @At("HEAD"),
        cancellable = true
    )
    private void allowDamageForPlayer(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Entity self = (Entity)(Object)this;

        if (self instanceof Player) {
            cir.setReturnValue(self.hurt(source, amount));
        }
    }
}
