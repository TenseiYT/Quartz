package dev.tenseiyt.quartz.features;

import dev.tenseiyt.quartz.Main;
import dev.tenseiyt.quartz.config.QuartzOneConfig;
import dev.tenseiyt.quartz.utils.utils;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;

public class AutoSell {

    private static final boolean tradeOpen = false;

    public static List<Integer> getCropIndexes() {
        List<Integer> cropSlots = new ArrayList<>();

        ItemStack[] inventory = Main.mcPlayer.inventory.mainInventory;


        for (int i = 0; i <= inventory.length - 1; i++) {
            ItemStack itemStack = inventory[i];
            if (itemStack != null) {
                String displayName = utils.stripColor(itemStack.getDisplayName());
                if (displayName.contains("Mutant Nether") || displayName.contains("Enchanted Sugar Cane")) {
                    cropSlots.add(i);
                }
            }
        }
        return cropSlots;
    }

    @SubscribeEvent
    public void autoSellCrops(@NotNull TickEvent event) {
        if (Main.mcPlayer != null && Main.mcWorld != null && Main.mc.currentScreen == null && getCropIndexes().size() >= QuartzOneConfig.num) {
            int currentItem = Main.mcPlayer.inventory.currentItem;
            Main.mcPlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(8));
            Main.mc.playerController.sendUseItem(Main.mcPlayer, Main.mcWorld, Main.mcPlayer.inventory.getStackInSlot(8));
            Main.mcPlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(currentItem));
        }
    }

    @SubscribeEvent
    public void onGuiOpen(@NotNull GuiScreenEvent event) {
        if (Main.mcPlayer != null && Main.mcWorld != null && Main.mc.currentScreen == null && getCropIndexes().size() >= QuartzOneConfig.num) {
            if (event.gui instanceof GuiChest) {
                IInventory chest = ((ContainerChest) (((GuiChest)  event.gui).inventorySlots)).getLowerChestInventory();

                String chestName = chest.getDisplayName().getUnformattedText();

                if (chestName.contains("Skyblock Menu")) {
                    Main.mc.playerController.windowClick(Main.mcPlayer.openContainer.windowId, 22, 0, 0, Main.mcPlayer);
                } else if (chestName.contains("Trades")) {
                    for (int index : getCropIndexes()) {
                        Main.mc.playerController.windowClick(Main.mcPlayer.inventoryContainer.windowId, index, 0, 0, Main.mcPlayer);
                    }
                }

            }
        }
    }
}
