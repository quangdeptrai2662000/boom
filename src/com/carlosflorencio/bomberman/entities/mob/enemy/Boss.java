package com.carlosflorencio.bomberman.entities.mob.enemy;


import com.carlosflorencio.bomberman.Board;
import com.carlosflorencio.bomberman.Game;
import com.carlosflorencio.bomberman.entities.mob.enemy.ai.AILow;
import com.carlosflorencio.bomberman.entities.mob.enemy.ai.AIMedium;
import com.carlosflorencio.bomberman.graphics.Sprite;

public class Boss extends Enemy {


    public Boss(int x, int y, Board board) {
        super(x, y, board, Sprite.boss_dead, Game.getPlayerSpeed() * 3 / 2, 2000);

        _sprite = Sprite.boss_right1;

        _ai = new AILow();
        _direction  = _ai.calculateDirection();
    }
    /*
    |--------------------------------------------------------------------------
    | Mob Sprite
    |--------------------------------------------------------------------------
     */
    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
            case 1:
                if(_moving)
                    _sprite = Sprite.movingSprite(Sprite.boss_right1, Sprite.boss_right2, Sprite.boss_right3, _animate, 60);
                else
                    _sprite = Sprite.boss_left1;
                break;
            case 2:
            case 3:
                if(_moving)
                    _sprite = Sprite.movingSprite(Sprite.boss_left1, Sprite.boss_left2, Sprite.boss_left3, _animate, 60);
                else
                    _sprite = Sprite.boss_left1;
                break;
        }
    }
}
