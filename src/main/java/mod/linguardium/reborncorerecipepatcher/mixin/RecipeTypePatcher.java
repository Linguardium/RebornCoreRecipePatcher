package mod.linguardium.reborncorerecipepatcher.mixin;

import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import reborncore.common.crafting.RebornRecipeType;

@Mixin(RebornRecipeType.class)
public class RecipeTypePatcher {
    @Redirect(method="write(Lnet/minecraft/network/PacketByteBuf;Lreborncore/common/crafting/RebornRecipe;)V",at=@At(value="INVOKE",target="Lnet/minecraft/network/PacketByteBuf;writeString(Ljava/lang/String;)Lnet/minecraft/network/PacketByteBuf;"), remap = false)
    private PacketByteBuf RebornCorePatcher$writePacket(PacketByteBuf buf, String string) {
        return buf.writeString(string,string.length());
    }

}
