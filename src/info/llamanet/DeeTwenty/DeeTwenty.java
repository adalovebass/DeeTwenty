package info.llamanet.DeeTwenty;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class DeeTwenty extends JavaPlugin
{
	Logger logger = Logger.getLogger("Minecraft");

	public void onEnable()
	{		
		logger.info("DeeTwenty has been enabled.");
	} 

	public void onDisable()
	{		
		logger.info("DeeTwenty has been disabled.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args)
	{		
		if (command.getName().equalsIgnoreCase("roll"))
		{
			if (sender instanceof Player)
			{
				broadcast(((Player)sender).getName(), getRollValue());
			}
			else if (sender instanceof ConsoleCommandSender)
			{
				broadcast("Server", 21);
			}
			
			return true;
		}
		
		return super.onCommand(sender, command, label, args);
	}
	
	private int getRollValue()
	{		
		Random r = new Random();
		return r.nextInt(20) + 1;
	}
	
	private void broadcast(String name, int value)
	{
		String message = name + " rolled a " + Integer.toString(value) + ".";
		
		getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + message);
		logger.info("[DeeTwenty]: " + message);
	}
}
