package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasCSV {

    TextureAtlas AtlasLookingCSV,AtlasBallCSV,AtlasMahatCSV,AtlasZevCSV;
    Animation AnimLookingCSV, AnimBallCSV, AnimMahatCSV, AnimZevCSV;
    TextureAtlas AtlasD;
    Animation AnimD;
    TextureAtlas AtlasArr;
    Animation AnimArr;
    TextureAtlas AtlasHeart;
    Animation AnimHeart;
    TextureAtlas AtlasKick;
    TextureAtlas AtlasYo;
    Animation AnimYo;
    TextureAtlas AtlasRocket;
    Animation AnimRocket;
    Animation AnimKick;
    TextureAtlas AtlasFlower;
    Animation AnimFlower;
    TextureAtlas AtlasKickR, AtlasKickL;
    Animation AnimKickR, AnimKickL;
    TextureAtlas AtlasSto;
    Animation AnimSto;
    Texture BearLoved, Obida, Smile;

    public AtlasCSV() {
        AtlasLookingCSV = new TextureAtlas(Gdx.files.internal("animlookcsv.atlas"));
        AnimLookingCSV = new Animation(1f, AtlasLookingCSV.getRegions());
        AtlasBallCSV = new TextureAtlas(Gdx.files.internal("ballscv.atlas"));
        AnimBallCSV = new Animation(1/10f, AtlasBallCSV.getRegions());
        AtlasMahatCSV = new TextureAtlas(Gdx.files.internal("animmahcsv.atlas"));
        AnimMahatCSV = new Animation(1/50f, AtlasMahatCSV.getRegions());
        AtlasZevCSV = new TextureAtlas(Gdx.files.internal("animzevscv.atlas"));
        AnimZevCSV = new Animation(0.1f, AtlasZevCSV.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihaniecsv.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animheartcsv.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickedcsv.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghcsv.atlas"));
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrockets.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowercsv.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyocsv.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrightcsv.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkickleftcsv.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstocsv.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        BearLoved = new Texture("lovedbearcsv.png");
        Obida = new Texture("obidacv.png");
        Smile = new Texture("smilecsv.png");
    }

    public Animation getAnimLookingCSV() {
        return AnimLookingCSV;
    }
    public Animation getAnimZevCSV() {
        return AnimZevCSV;
    }
    public Animation getAnimBallCSV() {
        return AnimBallCSV;
    }
    public Animation getAnimMahatCSV() {
        return AnimMahatCSV;
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
    public Animation getAnimKickR() {
        return AnimKickR;
    }
    public Animation getAnimKickL() {
        return AnimKickL;
    }
    public Animation getAnimKick() {
        return AnimKick;
    }
    public Texture getBearLoved() {
        return BearLoved;
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
    public Texture getBearObida() {
        return Obida;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public void dispose() {
        AtlasLookingCSV.dispose();
        AtlasBallCSV.dispose();
        AtlasMahatCSV.dispose();
        AtlasYo.dispose();
        AtlasZevCSV.dispose();
        AtlasArr.dispose();
        AtlasD.dispose();
        AtlasHeart.dispose();
        AtlasFlower.dispose();
        AtlasRocket.dispose();
        AtlasSto.dispose();
        AtlasKickR.dispose();
        AtlasKickL.dispose();
        AtlasKick.dispose();
        BearLoved.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
