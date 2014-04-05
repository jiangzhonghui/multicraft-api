package it.multicraft.api.event.game;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

public class GamerDamageEvent extends EntityDamageEvent{

	public GamerDamageEvent(Entity damagee, DamageCause cause, double damage) {
		super(damagee, cause, damage);
	}

	
	
}
