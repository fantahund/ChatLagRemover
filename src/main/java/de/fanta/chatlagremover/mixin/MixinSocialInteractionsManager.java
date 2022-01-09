package de.fanta.chatlagremover.mixin;

import com.mojang.authlib.minecraft.UserApiService;
import net.minecraft.client.network.SocialInteractionsManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.UUID;

@Mixin(SocialInteractionsManager.class)
public class MixinSocialInteractionsManager {

    @Redirect(method = "isPlayerBlocked", at = @At(value = "INVOKE", target = "Lcom/mojang/authlib/minecraft/UserApiService;isBlockedPlayer(Ljava/util/UUID;)Z"))
    public boolean DisableMicrosoftCheck(UserApiService instance, UUID uuid) {
        return false;
    }
}
