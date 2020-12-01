package com.carlosflorencio.bomberman.entities.mob.enemy;


import com.carlosflorencio.bomberman.Board;
import com.carlosflorencio.bomberman.Game;
import com.carlosflorencio.bomberman.entities.Message;
import com.carlosflorencio.bomberman.entities.mob.enemy.ai.AILow;
import com.carlosflorencio.bomberman.entities.mob.enemy.ai.AIMedium;
import com.carlosflorencio.bomberman.graphics.Sprite;

import java.awt.*;

public class Stupid extends Enemy {


    public Stupid(int x, int y, Board board) {
        super(x, y, board, Sprite.stupid_dead, Game.getPlayerSpeed() * 2 / 3, 1000);

        _sprite = Sprite.stupid_right1;

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
                    _sprite = Sprite.movingSprite(Sprite.stupid_right1, Sprite.stupid_right2, Sprite.stupid_right3, _animate, 60);
                else
                    _sprite = Sprite.stupid1;
                break;
            case 2:
            case 3:
                if(_moving)
                    _sprite = Sprite.movingSprite(Sprite.stupid1, Sprite.stupid2, Sprite.stupid3, _animate, 60);
                else
                    _sprite = Sprite.stupid1;
                break;
        }
    }

}
