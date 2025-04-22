package de.grnx.reactionroom.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.Batch
import de.grnx.reactionroom.GameLauncher


private val LOG = ktx.log.logger<MenuScreen>()
class MenuScreen(private val game:GameLauncher, private val batch: Batch) : AbstractScreen(game, batch) {

    override fun show(){
        LOG.debug( { "MenuScreen shown" } ) //use inline lambda to avoid overhead and only evaluate if needed
    }

    override fun render(delta: Float) {
        //game.setScreen<BaseScreen>()
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen<BaseScreen>()
        }
    }

}
