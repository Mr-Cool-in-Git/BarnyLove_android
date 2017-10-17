package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasCS {

    TextureAtlas AtlasLookingCS,AtlasBallCS,AtlasMahatCS,AtlasZevCS;
    Animation AnimLookingCS, AnimBallCS, AnimMahatCS, AnimZevCS;
    TextureAtlas AtlasD;
    Animation AnimD;
    TextureAtlas AtlasHeart;
    Animation AnimHeart;
    TextureAtlas AtlasKick;
    Animation AnimKick;
    TextureAtlas AtlasArr;
    TextureAtlas AtlasRocket;
    Animation AnimRocket;
    Animation AnimArr;
    TextureAtlas AtlasYo;
    Animation AnimYo;
    TextureAtlas AtlasFlower;
    Animation AnimFlower;
    TextureAtlas AtlasKickR, AtlasKickL;
    Animation AnimKickR, AnimKickL;
    TextureAtlas AtlasSto;
    Animation AnimSto;
    Texture BearLoved, Obida, Smile;

    public AtlasCS() {
        AtlasLookingCS = new TextureAtlas(Gdx.files.internal("animlookcs.atlas"));
        AnimLookingCS = new Animation(1f, AtlasLookingCS.getRegions());
        AtlasBallCS = new TextureAtlas(Gdx.files.internal("ballcs.atlas"));
        AnimBallCS = new Animation(1/10f, AtlasBallCS.getRegions());
        AtlasMahatCS = new TextureAtlas(Gdx.files.internal("animmahcs.atlas"));
        AnimMahatCS = new Animation(1/50f, AtlasMahatCS.getRegions());
        AtlasZevCS = new TextureAtlas(Gdx.files.internal("animzevcs.atlas"));
        AnimZevCS = new Animation(0.1f, AtlasZevCS.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihaniecs.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheartcs.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickedcs.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghcs.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrockets.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowercs.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyocs.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrightcs.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleftcs.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        BearLoved = new Texture("lovedbearcs.png");
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstocs.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        Obida = new Texture("obidac.png");
        Smile = new Texture("smilecs.png");
    }

    public Animation getAnimLookingCS() {
        return AnimLookingCS;
    }
    public Animation getAnimZevCS() {
        return AnimZevCS;
    }
    public Animation getAnimBallCS() {
        return AnimBallCS;
    }
    public Animation getAnimMahatCS() {
        return AnimMahatCS;
    }
    public Animation getAnimD() {
        return AnimD;
    }
    public Animation getAnimHeart() {
        return AnimHeart;
    }
    public Animation getAnimFlower() {
        return AnimFlower;
    }
    public Animation getAnimKick() {
        return AnimKick;
    }
    public Animation getAnimKickR() {
        return AnimKickR;
    }
    public Animation getAnimKickL() {
        return AnimKickL;
    }
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Animation getAnimYo() {
        return AnimYo;
    }
    public Texture getBearLoved() {
        return BearLoved;
    }
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public Texture getBearObida() {
        return Obida;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public Animation getAnimSto() {
        return AnimSto;
    }
    public void dispose() {
        AtlasLookingCS.dispose();
        AtlasBallCS.dispose();
        AtlasMahatCS.dispose();
        AtlasZevCS.dispose();
        AtlasKickR.dispose();
        AtlasKickL.dispose();
        AtlasD.dispose();
        AtlasYo.dispose();
        AtlasHeart.dispose();
        AtlasKick.dispose();
        BearLoved.dispose();
        AtlasSto.dispose();
        AtlasFlower.dispose();
        AtlasRocket.dispose();
        AtlasArr.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}

