package com.carlosflorencio.bomberman.entities.tile.destroyable;


import com.carlosflorencio.bomberman.entities.mob.enemy.Boss;
import com.carlosflorencio.bomberman.entities.mob.enemy.Stupid;
import com.carlosflorencio.bomberman.graphics.Screen;
import com.carlosflorencio.bomberman.graphics.Sprite;
import com.carlosflorencio.bomberman.level.Coordinates;
import com.carlosflorencio.bomberman.entities.Entity;
import com.carlosflorencio.bomberman.entities.bomb.DirectionalExplosion;
import com.carlosflorencio.bomberman.entities.mob.enemy.Kondoria;

public class BrickTile extends DestroyableTile {
	
	public BrickTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void render(Screen screen) {
		int x = Coordinates.tileToPixel(_x);
		int y = Coordinates.tileToPixel(_y);
		
		if(_destroyed) {
			_sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
			
			screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
		}
		else
			screen.renderEntity( x, y, this);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof DirectionalExplosion)
			destroy();
		
		if(e instanceof Kondoria || e instanceof Stupid || e instanceof Boss)
			return true;
			
		return false;
	}
	
	
}
