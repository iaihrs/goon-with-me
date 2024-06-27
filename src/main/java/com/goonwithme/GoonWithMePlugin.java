package com.goonwithme;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Goon with me!"
)
public class GoonWithMePlugin extends Plugin
{
	@Inject
	private Client client;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Goon with me! started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Goon with me! stopped!");
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged e) {
		if(e.getOverheadText().equals("Burn with me!")) {
			e.getActor().setOverheadText("Goon with me!");
		}
		if(e.getOverheadText().equals("I will burn with you.")) {
			e.getActor().setOverheadText("I will goon with you.");
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		MessageNode messageNode = chatMessage.getMessageNode();
		String message = messageNode.getValue();

		if(message.equals("Burn with me!")) {
			messageNode.setValue("Goon with me!");
		}

		if(message.equals("I will burn with you.")) {
			messageNode.setValue("I will goon with you.");
		}
	}
}
