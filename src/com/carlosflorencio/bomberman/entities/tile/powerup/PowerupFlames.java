package com.carlosflorencio.bomberman.entities.tile.powerup;

import com.carlosflorencio.bomberman.Game;
import com.carlosflorencio.bomberman.graphics.Sprite;
import com.carlosflorencio.bomberman.entities.Entity;
import com.carlosflorencio.bomberman.entities.mob.Player;

public class PowerupFlames extends Powerup {

	public PowerupFlames(int x, int y, int level, Sprite sprite) {
		super(x, y, level, sprite);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player) {
			((Player) e).addPowerup(this);
			remove();
			return true;
		}
		
		return false;
	}
	
	@Override
	public void setValues() {
		playSound("powerup.wav");
		_active = true;
		Game.addBombRadius(1);
	}
	


}
