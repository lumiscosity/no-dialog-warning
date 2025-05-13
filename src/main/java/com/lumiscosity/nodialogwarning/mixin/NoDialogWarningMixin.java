package com.lumiscosity.nodialogwarning.mixin;

import net.minecraft.class_11473;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.widget.DirectionalLayoutWidget;
import net.minecraft.client.gui.widget.Widget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_11473.class)
public class NoDialogWarningMixin {
	@Redirect(method = "method_71872()Lnet/minecraft/client/gui/widget/Widget;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/DirectionalLayoutWidget;add(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;", ordinal = 1))
	private Widget noDialogWarningLayout(DirectionalLayoutWidget instance, Widget widget) {
		return widget;
	}

	@Redirect(method = "init()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_11473;addDrawableChild(Lnet/minecraft/client/gui/Element;)Lnet/minecraft/client/gui/Element;"))
	private Element removeDialogWarning(class_11473 instance, Element element) {
		return element;
	}
}