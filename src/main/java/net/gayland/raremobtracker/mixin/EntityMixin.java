package net.gayland.raremobtracker.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow protected abstract boolean getFlag(int index);
    @Shadow public abstract Text getDisplayName();

    @Inject(method = "getTeamColorValue", at = @At("HEAD"), cancellable = true) private void getTeamColor(CallbackInfoReturnable<Integer> cir) {
        if(this.getFlag(5)&& this.getDisplayName().getString().contains("Rare"))
            cir.setReturnValue(0xfa4369);
    }


}
