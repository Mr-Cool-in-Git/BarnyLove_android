package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasC {

    TextureAtlas AtlasLookingC,AtlasBallC,AtlasMahatC ,AtlasZevC;
    Animation AnimLookingC, AnimBallC, AnimMahatC, AnimZevC;
    TextureAtlas AtlasD;
    Animation AnimD;
    TextureAtlas AtlasHeart;
    Animation AnimHeart;
    TextureAtlas AtlasKick;
    Animation AnimKick;
    TextureAtlas AtlasArr;
    Animation AnimArr;
    TextureAtlas AtlasRocket;
    Animation AnimRocket;
    TextureAtlas AtlasFlower;
    Animation AnimFlower;
    TextureAtlas AtlasYo;
    Animation AnimYo;
    TextureAtlas AtlasKickR, AtlasKickL;
    Animation AnimKickR, AnimKickL;
    TextureAtlas AtlasSto;
    Animation AnimSto;
    Texture BearLoved , Obida, Smile;

    public AtlasC() {
        AtlasLookingC = new TextureAtlas(Gdx.files.internal("animlookc.atlas"));
        AnimLookingC = new Animation(1f, AtlasLookingC.getRegions());
        AtlasBallC = new TextureAtlas(Gdx.files.internal("ballc.atlas"));
        AnimBallC = new Animation(1/10f, AtlasBallC.getRegions());
        AtlasMahatC = new TextureAtlas(Gdx.files.internal("animmahc.atlas"));
        AnimMahatC = new Animation(1/50f, AtlasMahatC.getRegions());
        AtlasZevC = new TextureAtlas(Gdx.files.internal("animzevc.atlas"));
        AnimZevC = new Animation(0.1f, AtlasZevC.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihaniec.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheartc.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickedc.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghc.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrocket.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowerc.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyoc.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrightc.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleftc.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        BearLoved = new Texture("lovedbearc.png");
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstoc.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        Obida = new Texture("obidac.png");
        Smile = new Texture("smilec.png");
    }

    public Animation getAnimLookingC() {
        return AnimLookingC;
    }
    public Animation getAnimZevC() {
        return AnimZevC;
    }
    public Animation getAnimBallC() {
        return AnimBallC;
    }
    public Animation getAnimMahatC() {
        return AnimMahatC;
    }
    public Animation getAnimD() {
        return AnimD;
    }
    public Animation getAnimHeart() {
        return AnimHeart;
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
    public Animation getAnimYo() {
        return AnimYo;
    }
    public Animation getAnimSto() {
        return AnimSto;
    }
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Animation getAnimFlower() {
        return AnimFlower;
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
    public void dispose() {
        AtlasLookingC.dispose();
        AtlasBallC.dispose();
        AtlasMahatC.dispose();
        AtlasZevC.dispose();
        AtlasD.dispose();
        AtlasHeart.dispose();
        AtlasRocket.dispose();
        AtlasKickR.dispose();
        AtlasKickL.dispose();
        AtlasYo.dispose();
        AtlasFlower.dispose();
        AtlasKick.dispose();
        AtlasSto.dispose();
        AtlasArr.dispose();
        BearLoved.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
