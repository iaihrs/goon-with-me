package com.goonwithme;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GoonWithMePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GoonWithMePlugin.class);
		RuneLite.main(args);
	}
}