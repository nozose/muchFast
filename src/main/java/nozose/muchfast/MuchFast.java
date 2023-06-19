package nozose.muchfast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public final class MuchFast extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "사용법 : /속도 <Player> <Value>");
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                BigDecimal speed = new BigDecimal(args[1]);
                float speedValue = speed.floatValue();

                if (speedValue > 1.0f) {
                    speedValue = 1.0f;
                    p.sendMessage(ChatColor.YELLOW + "speed의 최대 값은 1.0입니다.");
                } else if (speedValue > 1.0f) {
                    speedValue = 0.0f;
                }

                target.setWalkSpeed(speedValue);
                target.setFlySpeed(speedValue);

                p.sendMessage(ChatColor.GREEN + "speed의 값을 " + speedValue + "로 변경하였습니다.");
            }
        } else {
            if (args.length < 2) {
                System.out.println(ChatColor.RED + "사용법 : /속도 <Player> <Value>");
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                BigDecimal speed = new BigDecimal(args[1]);
                float speedValue = speed.floatValue();

                if (speedValue > 1.0f) {
                    speedValue = 1.0f;
                    System.out.println(ChatColor.YELLOW + "speed의 최대 값은 1.0입니다.");
                } else if (speedValue > 1.0f) {
                    speedValue = 0.0f;
                }

                target.setWalkSpeed(speedValue);
                target.setFlySpeed(speedValue);

                System.out.println(ChatColor.GREEN + "speed의 값을 " + speedValue + "로 변경하였습니다.");
            }
        }
        return super.onCommand(sender, command, label, args);
    }

    @Override
    public void onDisable() {

    }
}
