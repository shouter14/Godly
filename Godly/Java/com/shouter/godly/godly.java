package com.shouter.godly;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import com.shouter.godly.blocks.Blockinfusioncauldron;
import com.shouter.godly.blocks.Blockgodlyore;
import com.shouter.godly.help.reference;
import com.shouter.godly.help.registerhelper;
import com.shouter.godly.items.Itemgodlygem;
import com.shouter.godly.items.Iteminfusioncauldron;
import com.shouter.godly.items.Itemlevelbook;
import com.shouter.godly.tools.Itemgodlyaxe;
import com.shouter.godly.tools.Itemgodlypickaxe;
import com.shouter.godly.tools.Itemgodlyspade;
import com.shouter.godly.tools.Itemgodlysword;

@Mod(modid = reference.MODID, version = reference.VERSION)
public class godly 
{
	int RenderId;

	//Blocks
	public static Block godlyore;
	public static Block infusioncauldron;
	
	//Items
	public static Item godlygem;
    public static Item infusioncauldronitem;
    public static Item levelbook;
		
	//Tools
	public static Item godlypickaxe;
	public static Item godlysword;
	public static Item godlyspade;
	public static Item godlyaxe;
	//Test
	//Materials
	static ToolMaterial godlyMaterial = EnumHelper.addToolMaterial("godlygem", 3, 2000, 14.0F, 6.0F, 30);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Blocks
		godlyore = new Blockgodlyore();
		registerhelper.registerBlock(godlyore);
		
		infusioncauldron = new Blockinfusioncauldron();
		registerhelper.registerBlock(infusioncauldron);

		//Items
		godlygem = new Itemgodlygem();
		registerhelper.registerItem(godlygem);
		
		infusioncauldronitem = new Iteminfusioncauldron();
		registerhelper.registerItem(infusioncauldronitem);
		
		levelbook = new Itemlevelbook();
		registerhelper.registerItem(levelbook);
		
		//Tools
		godlypickaxe = new Itemgodlypickaxe(godlyMaterial);
		registerhelper.registerItem(godlypickaxe);
		
		godlysword = new Itemgodlysword(godlyMaterial);
		registerhelper.registerItem(godlysword);
		
		godlyspade = new Itemgodlyspade(godlyMaterial);
		registerhelper.registerItem(godlyspade);
		
		godlyaxe = new Itemgodlyaxe(godlyMaterial);
		registerhelper.registerItem(godlyaxe);
		
		//Crafting
		GameRegistry.addRecipe(new ItemStack(godlypickaxe), new Object[]
		{
			"GGG",
			" S ",
		    " S ",
		    'G', godlygem, 'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(godlyspade), new Object[]
		{
			" G ",
			" S ",
			" S ",
			'G', godlygem, 'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(godlyaxe), new Object[]
		{
			"GG ",
			"GS ",
			" S ",
			'G', godlygem, 'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(godlysword), new Object[]
		{
			" G ",
			" G ",
			" S ",
			'G', godlygem, 'S', Items.stick
		});
	}
	
	public void Init(FMLInitializationEvent event)
	{
	
	}
}
