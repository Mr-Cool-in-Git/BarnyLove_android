package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Atlas {

    TextureAtlas AtlasLooking,AtlasBall,AtlasMahat ,AtlasZev;
    Animation AnimLooking, AnimBall, AnimMahat, AnimZev;
    TextureAtlas AtlasD;
    Animation AnimD;
    TextureAtlas AtlasHeart;
    Animation AnimHeart;
    TextureAtlas AtlasSto;
    Animation AnimSto;
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
    Texture BearLoved, Obida, Smile;

    public Atlas() {
        AtlasLooking = new TextureAtlas(Gdx.files.internal("teddylooking.atlas"));
        AnimLooking = new Animation(1f, AtlasLooking.getRegions());
        AtlasBall = new TextureAtlas(Gdx.files.internal("bearball.atlas"));
        AnimBall = new Animation(1/10f, AtlasBall.getRegions());
        AtlasMahat = new TextureAtlas(Gdx.files.internal("animmahat.atlas"));
        AnimMahat = new Animation(1/50f, AtlasMahat.getRegions());
        AtlasZev = new TextureAtlas(Gdx.files.internal("zevota.atlas"));
        AnimZev = new Animation(0.1f, AtlasZev.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("teddybearbreath.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheart.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkicked.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("argh.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrocket.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasSto = new TextureAtlas(Gdx.files.internal("animsto.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflower.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickright.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleft.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyo.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        BearLoved = new Texture("lovedbear.png");
        Obida = new Texture("obida.png");
        Smile = new Texture("smile.png");
    }

    public Animation getAnimLooking() {
        return AnimLooking;
    }
    public Animation getAnimZev() {
        return AnimZev;
    }
    public Animation getAnimBall() {
        return AnimBall;
    }
    public Animation getAnimMahat() {
        return AnimMahat;
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
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public Animation getAnimYo() {
        return AnimYo;
    }
    public Animation getAnimSto() {
        return AnimSto;
    }
    public Animation getAnimFlower() {
        return AnimFlower;
    }
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Texture getBearLoved() {
        return BearLoved;
    }
    public Texture getBearObida() {
        return Obida;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public void dispose() {
        AtlasLooking.dispose();
        AtlasBall.dispose();
        AtlasMahat.dispose();
        AtlasZev.dispose();
        AtlasD.dispose();
        AtlasYo.dispose();
        AtlasHeart.dispose();
        AtlasArr.dispose();
        AtlasFlower.dispose();
        AtlasKick.dispose();
        AtlasKickR.dispose();
        AtlasKickL.dispose();
        AtlasRocket.dispose();
        AtlasSto.dispose();
        BearLoved.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
