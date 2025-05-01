package de.grnx.reactionroom.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import de.grnx.reactionroom.GameLauncher
import ktx.log.logger


private val LOG = logger<BaseScreen>()
class BaseScreen(private val game: GameLauncher, private val batch: Batch) : AbstractScreen(game, batch){
    private val WORLD_TO_SCREEN = 1f / 100f
    private val BACKGROUND_COLOR: Color = Color(0.39f, 0.58f,0.92f, 1.0f)

    private val SCENE_WIDTH = 12.80f
    private val SCENE_HEIGHT = 7.20f

    private var camera: OrthographicCamera? = null
    private var viewport: Viewport? = null

    private val texture = Texture(Gdx.files.internal("debug_resources/duke_waving.png")) // Placeholder
    private val sprite: Sprite = Sprite(texture) // does not need to be disposed, since its only a reference to the texture


    override fun show() {
        //super.show() //not needed since super class is empty

        camera = OrthographicCamera()
        viewport = FitViewport(SCENE_WIDTH, SCENE_HEIGHT, camera)
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest)



        LOG.debug { "BaseScreen shown" }
        sprite.setSize(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        sprite.setPosition(0f, 0f)

    }

    override fun render(delta: Float) {
        //super.render(delta) //not needed since super class is empty


        Gdx.gl.glClearColor(BACKGROUND_COLOR.r, BACKGROUND_COLOR.g, BACKGROUND_COLOR.b, BACKGROUND_COLOR.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        //batch.projectionMatrix = camera?.combined?: throw IllegalStateException("Camera not initialized")
        batch.projectionMatrix = camera!!.combined

        val width = texture.width
        val height = texture.height
        val originX = width * 0.5f
        val originY = height * 0.5f


        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
           game.setScreen<MenuScreen>()
        }

        batch.begin()
        //sprite.draw(batch)
        batch.draw(texture, -originX, -originY, originX, originY, width*1f, height.toFloat(), WORLD_TO_SCREEN, WORLD_TO_SCREEN, 0f, 0, 0, width, height, false, false)
        batch.end()

    }

    override fun dispose(){
        super.dispose()
        batch.dispose()
        texture.dispose()

        /*viewport?.apply { needs testing + explanation
            this.camera = null
            this.update(0, 0)
        }*/

    }
}
