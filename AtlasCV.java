package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasCV {

    TextureAtlas AtlasLookingCV,AtlasBallCV,AtlasMahatCV,AtlasZevCV;
    Animation AnimLookingCV, AnimBallCV, AnimMahatCV, AnimZevCV;
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
    TextureAtlas AtlasYo;
    Animation AnimYo;
    TextureAtlas AtlasFlower;
    Animation AnimFlower;
    TextureAtlas AtlasKickR, AtlasKickL;
    Animation AnimKickR, AnimKickL;
    TextureAtlas AtlasSto;
    Animation AnimSto;
    Texture BearLoved, Obida, Smile;

    public AtlasCV() {
        AtlasLookingCV = new TextureAtlas(Gdx.files.internal("animlookcv.atlas"));
        AnimLookingCV = new Animation(1f, AtlasLookingCV.getRegions());
        AtlasBallCV = new TextureAtlas(Gdx.files.internal("ballcv.atlas"));
        AnimBallCV = new Animation(1/10f, AtlasBallCV.getRegions());
        AtlasMahatCV = new TextureAtlas(Gdx.files.internal("animmahcv.atlas"));
        AnimMahatCV = new Animation(1/50f, AtlasMahatCV.getRegions());
        AtlasZevCV = new TextureAtlas(Gdx.files.internal("animzevcv.atlas"));
        AnimZevCV = new Animation(0.1f, AtlasZevCV.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihaniecv.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheartcv.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickedcv.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghcv.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrocket.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowercv.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyocv.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrightcv.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleftcv.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        BearLoved = new Texture("lovedbearcv.png");
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstocv.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        Obida = new Texture("obidacv.png");
        Smile = new Texture("smilecv.png");
    }

    public Animation getAnimLookingCV() {
        return AnimLookingCV;
    }
    public Animation getAnimZevCV() {
        return AnimZevCV;
    }
    public Animation getAnimBallCV() {
        return AnimBallCV;
    }
    public Animation getAnimMahatCV() {
        return AnimMahatCV;
    }
    public Animation getAnimD() {
        return AnimD;
    }
    public Animation getAnimFlower() {
        return AnimFlower;
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
    public Texture getBearLoved() {
        return BearLoved;
    }
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public Texture getBearObida() {
        return Obida;
    }
    public Animation getAnimSto() {
        return AnimSto;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public void dispose() {
        AtlasLookingCV.dispose();
        AtlasBallCV.dispose();
        AtlasMahatCV.dispose();
        AtlasZevCV.dispose();
        AtlasD.dispose();
        AtlasKickR.dispose();
        AtlasKickL.dispose();
        AtlasSto.dispose();
        AtlasHeart.dispose();
        AtlasRocket.dispose();
        AtlasFlower.dispose();
        AtlasYo.dispose();
        AtlasKick.dispose();
        BearLoved.dispose();
        AtlasArr.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
