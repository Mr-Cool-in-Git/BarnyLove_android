package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasS {

    TextureAtlas AtlasLookingS,AtlasBallS,AtlasMahatS ,AtlasZevS;
    Animation AnimLookingS, AnimBallS, AnimMahatS, AnimZevS;
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
    TextureAtlas AtlasSto;
    Animation AnimSto;
    TextureAtlas AtlasKickR, AtlasKickL;
    Animation AnimKickR, AnimKickL;
    Texture BearLoved, Obida, Smile;

    public AtlasS() {
        AtlasLookingS = new TextureAtlas(Gdx.files.internal("animlooks.atlas"));
        AnimLookingS = new Animation(1f, AtlasLookingS.getRegions());
        AtlasBallS = new TextureAtlas(Gdx.files.internal("balls.atlas"));
        AnimBallS = new Animation(1/10f, AtlasBallS.getRegions());
        AtlasMahatS = new TextureAtlas(Gdx.files.internal("animmahs.atlas"));
        AnimMahatS = new Animation(1/50f, AtlasMahatS.getRegions());
        AtlasZevS = new TextureAtlas(Gdx.files.internal("animzevs.atlas"));
        AnimZevS = new Animation(0.1f, AtlasZevS.getRegions());
        AtlasD = new TextureAtlas(Gdx.files.internal("dihanies.atlas"));
        AnimD = new Animation(1/3f, AtlasD.getRegions());
        AtlasHeart = new TextureAtlas(Gdx.files.internal("animhearts.atlas"));
        AnimHeart = new Animation(1/3f, AtlasHeart.getRegions());
        AtlasKick = new TextureAtlas(Gdx.files.internal("animkickeds.atlas"));
        AnimKick = new Animation(1/20f, AtlasKick.getRegions());
        AtlasArr = new TextureAtlas(Gdx.files.internal("arghs.atlas"));
        AnimArr = new Animation(1/4f, AtlasArr.getRegions());
        AtlasRocket = new TextureAtlas(Gdx.files.internal("animrockets.atlas"));
        AnimRocket = new Animation(1/8f, AtlasRocket.getRegions());
        AtlasFlower = new TextureAtlas(Gdx.files.internal("animflowers.atlas"));
        AnimFlower = new Animation(1/12f, AtlasFlower.getRegions());
        AtlasYo = new TextureAtlas(Gdx.files.internal("animyos.atlas"));
        AnimYo = new Animation(1/6f, AtlasYo.getRegions());
        AtlasKickR = new TextureAtlas(Gdx.files.internal("animkickrights.atlas"));
        AnimKickR = new Animation(1/8f, AtlasKickR.getRegions());
        AtlasKickL = new TextureAtlas(Gdx.files.internal("animkicklefts.atlas"));
        AnimKickL = new Animation(1/8f, AtlasKickL.getRegions());
        BearLoved = new Texture("lovedbears.png");
        AtlasSto = new TextureAtlas(Gdx.files.internal("animstos.atlas"));
        AnimSto = new Animation(0.2f, AtlasSto.getRegions());
        Obida = new Texture("obida.png");
        Smile = new Texture("smiles.png");
    }

    public Animation getAnimLookingS() {
        return AnimLookingS;
    }
    public Animation getAnimZevS() {
        return AnimZevS;
    }
    public Animation getAnimBallS() {
        return AnimBallS;
    }
    public Animation getAnimMahatS() {
        return AnimMahatS;
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
    public Texture getBearLoved() {
        return BearLoved;
    }
    public Animation getAnimArr() {
        return AnimArr;
    }
    public Texture getBearObida() {
        return Obida;
    }
    public Animation getAnimYo() {
        return AnimYo;
    }
    public Texture getBearSmile() {
        return Smile;
    }
    public Animation getAnimSto() {
        return AnimSto;
    }
    public Animation getAnimRocket() {
        return AnimRocket;
    }
    public void dispose() {
        AtlasLookingS.dispose();
        AtlasBallS.dispose();
        AtlasYo.dispose();
        AtlasMahatS.dispose();
        AtlasZevS.dispose();
        AtlasD.dispose();
        AtlasFlower.dispose();
        AtlasKickR.dispose();
        AtlasSto.dispose();
        AtlasKickL.dispose();
        AtlasHeart.dispose();
        AtlasArr.dispose();
        AtlasKick.dispose();
        BearLoved.dispose();
        AtlasRocket.dispose();
        Obida.dispose();
        Smile.dispose();
    }
}
