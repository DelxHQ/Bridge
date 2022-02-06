package me.delxhq.bridge.mixin;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin extends Screen {

	public MultiplayerScreenMixin(Text title) {
		super(title);
	}

	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		this.addDrawable(new ButtonWidget(5, 5, 150, 20, new LiteralText("Connect to Bedrock server"), (buttonWidget) -> {
		}));
	}
}
