/**
 * BukkitJUtils.java
 *
 * Created by Jonodonozym on god knows when
 * Copyright � 2017. All rights reserved.
 * 
 * Last modified on Oct 5, 2017 9:22:58 PM
 */

package jdz.BukkitJUtils.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Jono's (or Java, I don't give a damn what you think) Utilities for Bukkit to make your coding life
 * easier and less copy-pasty copy-pasty from old projects or the internet
 *
 * MUST BE INITIALIZED BY CALLING BukkitJUtils.initialize(JavaPlugin plugin, boolean trueIfYouWantToLoadSqlStuffUsingTheAutoGeneratedStuffInYourConfigFileMyGodThisIsALongStringIShouldHaveUsedSomeSpacesImSoFuckingTiredPlsSendHelpAndPizzaAndPossiblyNudes)
 * 
 * Also, include this .jar in the plugin as a resource or package it in if you're making it a runnable jar
 *
 * @author Jonodonozym
 */
public final class BukkitJUtils extends JavaPlugin{
	static JavaPlugin plugin;
	
	public static void initialize(JavaPlugin plugin, boolean loadSQL){
		BukkitJUtils.plugin = plugin;
		Vault.init();
		
		if (loadSQL){
			FileConfiguration config = Config.getConfig();
			SqlMessageQueue.init();
			SqlApi.reloadConfig(config);
		}
	}
}
