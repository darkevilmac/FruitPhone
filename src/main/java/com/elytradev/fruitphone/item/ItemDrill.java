/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 William Thompson (unascribed)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.elytradev.fruitphone.item;

import java.util.List;

import com.elytradev.fruitphone.FruitPhone;
import com.elytradev.fruitphone.FruitSounds;
import com.elytradev.fruitphone.capability.FruitEquipmentCapability;
import com.elytradev.fruitphone.network.EquipmentDataPacket;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemDrill extends Item {

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		if (playerIn.isSneaking()) {
			if (playerIn.hasCapability(FruitPhone.inst.CAPABILITY_EQUIPMENT, null)) {
				FruitEquipmentCapability fec = playerIn.getCapability(FruitPhone.inst.CAPABILITY_EQUIPMENT, null);
				ItemStack oldGlasses = fec.glasses;
				fec.glasses = ItemStack.EMPTY;
				if (!oldGlasses.isEmpty()) {
					playerIn.playSound(FruitSounds.DRILL, 0.33f, 0.875f+(itemRand.nextFloat()*0.25f));
					EquipmentDataPacket.forEntity(playerIn).ifPresent((m) -> m.sendToAllWatching(playerIn));
					if (!playerIn.inventory.addItemStackToInventory(oldGlasses)) {
						playerIn.dropItem(oldGlasses, false);
					}
					return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
				} else {
					return ActionResult.newResult(EnumActionResult.FAIL, itemStackIn);
				}
			}
		} else {
			FruitPhone.proxy.configureGlasses();
			return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
		}
		return ActionResult.newResult(EnumActionResult.PASS, itemStackIn);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag tooltipFlag) {
		tooltip.add("\u00A77"+I18n.format("item.fruitphone.remover.hint"));
	}
	
}
