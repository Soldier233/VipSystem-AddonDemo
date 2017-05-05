package me.zhanshi123.Demo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.zhanshi123.VipSystem.DataBase;

public class Main extends JavaPlugin implements Listener
{
	DataBase db=null;
	public void onEnable()
	{
		Bukkit.getPluginManager().registerEvents(this, this);
		getLogger().info("VipSystem 开发者API Demo成功加载");
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		db=me.zhanshi123.VipSystem.Main.getDataBase();
		Player p=e.getPlayer();
		if(db.exists(p.getName()))
		{
			p.sendMessage("欢迎来到XXX服务器，尊敬的"+db.getGroup(p.getName()));
		}
		else
		{
			p.sendMessage("欢迎来到XXX服务器，你还不是VIP哦，赶快氪金买一个吧");
		}
	}
}
