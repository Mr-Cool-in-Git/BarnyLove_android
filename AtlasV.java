package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasV {

    TextureAtlas AtlasLookingV,AtlasBallV,AtlasMahatV ,AtlasZevV, AtlasBreath;
    Animation AnimLookingV, AnimBallV, AnimMahatV, AnimZevV, AnimBreath;
    TextureAtlas AtlasD;
    Animation AnimD;
    TextureAtlas AtlasArr;
    Animation AnimArr;
    TextureAtlas AtlasHeart;
    Animation AnimHeart;
    TextureAtlas AtlasKick;
    Animation AnimKick;
    TextureAtlas AtlasRocket;
    TextureAtlas AtlasYo;
    Animation AnimYo;
    Animation AnimRocket;
    TextureAtlas AtlasFlower;
    Animation AnimFlower;
    TextureAtlas AtlasKickR, AtlasKickL;
    Animation AnimKickR, AnimKickL;
    TextureAtlas AtlasSto;
    Animation AnimSto;
    Texture BearLoved , Obida, Smile;

    public AtlasV() {
        AtlasLookingV = new TextureAtlas(Gdx.files.internal("animlookv.atlas"));
        AnimLookingV = new Animation(1f, AtlasLookingV.getRegions());
        AtlasBallV = new TextureAtlas(Gdx.files.internal("ballv.atlas"));
        AnimBallV = new Animation(1/10f, AtlasBallV.getRegions());
        AtlasMahatV = new TextureAtlas(Gdx.files.internal("animmahv.atlas"));
        AnimMahatV = new Animation(1/50f, AtlasMahatV.getRegions());
        AtlasZevV = new TextureAtlas(Gdx.files.internal("animzevv.atlas"));
        AnimZevV = new Animation(0.1f, AtlasZevV.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihaniev.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheartv.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickedv.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghv.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrocket.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowerv.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyov.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrightv.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleftv.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        BearLoved = new Texture("lovedbearv.png");
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstov.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        Obida = new Texture("obidav.png");
        Smile = new Texture("smilev.png");
    }

    public Animation getAnimLookingV() {
        return AnimLookingV;
    }
    public Animation getAnimZevV() {
        return AnimZevV;
    }
    public Animation getAnimBallV() {
        return AnimBallV;
    }
    public Animation getAnimMahatV() {
        return AnimMahatV;
    }
    public Animation getAnimD() {
        return AnimD;
    }
    public Animation getAnimFlower() {
        return AnimFlower;
    }
    public Animation getAnimYo() {
        return AnimYo;
    }
    public Animation getAnimHeart() {
        return AnimHeart;
    }
    public Animation getAnimSto() {
        return AnimSto;
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
    public Texture getBearLoved() {
        return BearLoved;
    }
    public Texture getBearObida() {
        return Obida;
    }
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public void dispose() {
        AtlasLookingV.dispose();
        AtlasBallV.dispose();
        AtlasMahatV.dispose();
        AtlasZevV.dispose();
        AtlasArr.dispose();
        AtlasYo.dispose();
        AtlasD.dispose();
        AtlasHeart.dispose();
        AtlasKickR.dispose();
        AtlasSto.dispose();
        AtlasKickL.dispose();
        AtlasFlower.dispose();
        AtlasKick.dispose();
        BearLoved.dispose();
        AtlasRocket.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
