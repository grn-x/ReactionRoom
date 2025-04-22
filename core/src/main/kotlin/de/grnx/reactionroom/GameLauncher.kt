package de.grnx.reactionroom

import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import de.grnx.reactionroom.screens.AbstractScreen
import de.grnx.reactionroom.screens.MenuScreen
import de.grnx.reactionroom.screens.BaseScreen
import ktx.app.KtxGame

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */

class GameLauncher : KtxGame<AbstractScreen>() {
    val batch: Batch = SpriteBatch() // val batch : Batch by lazy { SpriteBatch() } // todo
    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG

        addScreen(MenuScreen(this, batch))
        addScreen(BaseScreen(this, batch))
        setScreen<MenuScreen>()

    }



}
