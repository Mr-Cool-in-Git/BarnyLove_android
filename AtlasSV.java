package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasSV {

    TextureAtlas AtlasLookingSV,AtlasBallSV,AtlasMahatSV,AtlasZevSV;
    Animation AnimLookingSV, AnimBallSV, AnimMahatSV, AnimZevSV;
    TextureAtlas AtlasD;
    Animation AnimD;
    TextureAtlas AtlasArr;
    Animation AnimArr;
    TextureAtlas AtlasHeart;
    Animation AnimHeart;
    TextureAtlas AtlasKick;
    Animation AnimKick;
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
    Texture BearLoved, Obida, Smile;

    public AtlasSV() {
        AtlasLookingSV = new TextureAtlas(Gdx.files.internal("animlooksv.atlas"));
        AnimLookingSV = new Animation(1f, AtlasLookingSV.getRegions());
        AtlasBallSV = new TextureAtlas(Gdx.files.internal("ballsv.atlas"));
        AnimBallSV = new Animation(1/10f, AtlasBallSV.getRegions());
        AtlasMahatSV = new TextureAtlas(Gdx.files.internal("animmahsv.atlas"));
        AnimMahatSV = new Animation(1/50f, AtlasMahatSV.getRegions());
        AtlasZevSV = new TextureAtlas(Gdx.files.internal("animzevsv.atlas"));
        AnimZevSV = new Animation(0.1f, AtlasZevSV.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihaniesv.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheartsv.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickedsv.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghsv.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrockets.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowersv.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyosv.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrightsv.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleftsv.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        BearLoved = new Texture("lovedbearsv.png");
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstosv.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        Obida = new Texture("obidav.png");
        Smile = new Texture("smilesv.png");
    }

    public Animation getAnimLookingSV() {
        return AnimLookingSV;
    }
    public Animation getAnimZevSV() {
        return AnimZevSV;
    }
    public Animation getAnimBallSV() {
        return AnimBallSV;
    }
    public Animation getAnimMahatSV() {
        return AnimMahatSV;
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
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Texture getBearObida() {
        return Obida;
    }
    public Animation getAnimSto() {
        return AnimSto;
    }
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public void dispose() {
        AtlasLookingSV.dispose();
        AtlasBallSV.dispose();
        AtlasMahatSV.dispose();
        AtlasZevSV.dispose();
        AtlasD.dispose();
        AtlasFlower.dispose();
        AtlasYo.dispose();
        AtlasKickR.dispose();
        AtlasKickL.dispose();
        AtlasSto.dispose();
        AtlasHeart.dispose();
        AtlasKick.dispose();
        BearLoved.dispose();
        AtlasArr.dispose();
        AtlasRocket.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
