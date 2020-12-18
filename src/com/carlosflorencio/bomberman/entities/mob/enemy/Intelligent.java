package com.carlosflorencio.bomberman.entities.mob.enemy;


import com.carlosflorencio.bomberman.Board;
import com.carlosflorencio.bomberman.Game;
import com.carlosflorencio.bomberman.entities.mob.enemy.ai.AIMedium;
import com.carlosflorencio.bomberman.graphics.Sprite;

public class Intelligent extends Enemy {


    public Intelligent(int x, int y, Board board) {
        super(x, y, board, Sprite.intelligent_dead, Game.getPlayerSpeed() / 2, 1500);

        _sprite = Sprite.intelligent_right1;

        _ai = new AIMedium(_board.getPlayer(), this); //TODO: implement AIHigh
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
                    _sprite = Sprite.movingSprite(Sprite.intelligent_right1, Sprite.intelligent_right2, Sprite.intelligent_right3, _animate, 60);
                else
                    _sprite = Sprite.intelligent_left1;
                break;
            case 2:
            case 3:
                if(_moving)
                    _sprite = Sprite.movingSprite(Sprite.intelligent_left1, Sprite.intelligent_left2, Sprite.intelligent_left3, _animate, 60);
                else
                    _sprite = Sprite.intelligent_left1;
                break;
        }
    }
}
