package de.grnx.reactionroom.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import de.grnx.reactionroom.GameLauncher

import ktx.log.logger

private val LOG = logger<BaseScreen>()
class BaseScreen(private val game: GameLauncher, private val batch: Batch) : AbstractScreen(game, batch){

    private val texture = Texture(Gdx.files.internal("debug_resources/duke_waving.png")) // Placeholder
    private val sprite: Sprite = Sprite(texture) // does not need to be disposed, since its only a reference to the texture

    override fun show() {
        //super.show() //not needed since super class is empty
        LOG.debug { "BaseScreen shown" }
        sprite.setSize(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        sprite.setPosition(0f, 0f)

    }

    override fun render(delta: Float) {
        //super.render(delta) //not needed since super class is empty
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
           game.setScreen<MenuScreen>()
        }

        batch.begin()
        sprite.draw(batch)
        batch.end()

    }

    override fun dispose(){
        super.dispose()
        batch.dispose()
        texture.dispose()
    }
}
